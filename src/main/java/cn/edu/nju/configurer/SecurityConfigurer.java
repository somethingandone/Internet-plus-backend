package cn.edu.nju.configurer;

import cn.edu.nju.utils.CORSFilter;
import cn.edu.nju.utils.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    CORSFilter corsFilter;
    /**
     * 创建密码加密的Bean
     * @return org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
     * @author haofeng.Yu
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置http安全相关
     * @param http description
     * @return void
     * @author haofeng.Yu
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
                .antMatchers("/user/sign_in").anonymous()
                .antMatchers("/user/register").permitAll()
                .anyRequest().authenticated();
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class).addFilterBefore(corsFilter, JwtAuthenticationTokenFilter.class);
    }

    /**
     * 注入AuthenticationManager
     * @return org.springframework.security.authentication.AuthenticationManager
     * @author haofeng.Yu
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
