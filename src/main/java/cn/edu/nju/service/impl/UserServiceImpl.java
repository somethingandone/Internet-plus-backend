package cn.edu.nju.service.impl;

import cn.edu.nju.core.ResultGenerator;
import cn.edu.nju.model.User;
import cn.edu.nju.core.Result;
import cn.edu.nju.core.ServiceException;
import cn.edu.nju.dao.UserMapper;
import cn.edu.nju.model.VO.UserStatus;
import cn.edu.nju.model.VO.UserVO;
import cn.edu.nju.service.UserService;
import cn.edu.nju.core.AbstractService;
import cn.edu.nju.utils.JwtUtil;
import cn.edu.nju.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static cn.edu.nju.core.ProjectConstant.GENERAL_EXPIRED_TIME;
import static cn.edu.nju.core.ProjectConstant.LOGIN_USR_TTL;


/**
 * Created by CodeGenerator on 2023/02/28.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Resource
    private UserMapper userMapper;

    /**
     * 注册的业务逻辑
     * @param userVO 传入的用户VO对象
     * @return void
     * @author haofeng.Yu
     */
    @Override
    public void register(UserVO userVO, HttpServletRequest request){
        User user = findUserByName(userVO.getName());
        if(user!=null){ //检查用户是否存在
            throw new ServiceException("用户已经存在");
        }
        User userPO = User.builder()
                .name(userVO.getName())
                .passwordHash(passwordEncoder.encode(userVO.getPassword()))
                .email(userVO.getEmail())
                .createdAt(new Date())
                .ipAddr(getIpAddress(request))
                .build();
        userMapper.createUser(userPO);
    }

    /**
     * 登录的业务逻辑，通过SpringSecurity的AuthenticationManager中的authenticate进行认证
     * @param userVO description
     * @return com.wanted.project.ResponseResult
     * @author haofeng.Yu
     */
    @Override
    public Result signIn(UserVO userVO) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userVO.getName(),userVO.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        if(Objects.isNull(authentication)){
            throw new ServiceException("登录失败");
        }

        UserStatus userStatus = (UserStatus) authentication.getPrincipal();
        String id = userStatus.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(id, GENERAL_EXPIRED_TIME);
        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);
//        if(redisCache.getCacheObject("login:"+id)!=null){
//            return ResultGenerator.genFailResult("请勿重复登录");
//        }
        redisCache.setCacheObject("login:"+id,userStatus,LOGIN_USR_TTL, TimeUnit.SECONDS);

        return ResultGenerator.genSuccessResult("登录成功", map);
    }

    /**
     * 退出登录
     * @return com.wanted.project.ResponseResult
     * @author haofeng.Yu
     */
    @Override
    public Result signOut() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserStatus userStatus = (UserStatus) authentication.getPrincipal();
        long id = userStatus.getUser().getId();

        redisCache.deleteObject("login:"+id);

        return ResultGenerator.genSuccessResult("注销成功");
    }

    /**
     * findUserByName
     * @param name 用户名
     * @return com.wanted.project.model.User
     * @author haofeng.Yu
     */
    @Override
    public User findUserByName(String name){
        return userMapper.findUserByName(name);
    }

    /**
     * 获取请求方的IP地址
     * @param request request
     * @return java.lang.String
     * @author haofeng.Yu
     */
    private String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 如果是多级代理，那么取第一个ip为客户端ip
        if (ip != null && ip.indexOf(",") != -1) {
            ip = ip.substring(0, ip.indexOf(",")).trim();
        }

        return ip;
    }
}
