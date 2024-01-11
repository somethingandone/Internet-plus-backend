package cn.edu.nju.utils;

import cn.edu.nju.model.User;
import cn.edu.nju.model.VO.UserStatus;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import cn.edu.nju.core.ServiceException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static cn.edu.nju.core.ProjectConstant.LOGIN_USR_TTL;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {


    @Autowired
    private RedisCache redisCache;

    /**
     * 一级过滤器，拦截所有含token的请求
     * 允许register和sign in通过
     * 如果token有效则刷新一次token
     * @param request
     * @param response
     * @param filterChain
     * @author haofeng.Yu
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        if(!StringUtils.hasText(authorization)){
            //放行
            filterChain.doFilter(request, response);
            return;
        }
        String token = authorization.split(" ")[0];//从请求头获取token
        //解析token
        String id;
        try{
            Claims claims = JwtUtil.parseJWT(token);
            id = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("token非法");
        }
        String redisKey = "login:"+id;
        JSONObject cache = redisCache.getCacheObject(redisKey);

        if(Objects.isNull(cache)){
            throw new ServiceException("用户未登录");
        }
        //刷新token
        redisCache.expire(redisKey,LOGIN_USR_TTL, TimeUnit.SECONDS);

        User user =JSONObject.toJavaObject(cache.getJSONObject("user"), User.class);
        JSONArray perms = cache.getJSONArray("permissions");
        List<String> permissions = perms.toJavaList(String.class);
        UserStatus userStatus = new UserStatus(user,permissions);



        //把authentication对象存入SecurityContextHolder
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userStatus, null, userStatus.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        //放行
        filterChain.doFilter(request,response);
    }


}
