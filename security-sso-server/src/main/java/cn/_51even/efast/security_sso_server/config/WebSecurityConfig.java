package cn._51even.efast.security_sso_server.config;

import cn._51even.efast.security_sso_server.handler.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private FailureHandler failureHandler;

    @Resource
    private AccessDeniedHandler accessDeniedHandler;

    @Resource
    private SuccessHandler successHandler;

    @Resource
    private LogOutSuccessHandler logOutSuccessHandler;

    @Resource
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Resource
    private UserDetailsService userDetailService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.sessionManagement().maximumSessions(1)
//      .sessionRegistry(sessionRegistry)
        .expiredUrl("/sso/logout?expired");
        // 禁用headers缓存
        http.headers().cacheControl();
        // 禁用csrf
        http.csrf().disable();
        http
                .authorizeRequests()
                // 跨域预检请求
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/sso/**").permitAll()
                // 静态文件
                .antMatchers("/static/**","/templates/**","/favicon.ico").permitAll()
                // swagger
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
                //其他请求都需要认证
                .anyRequest().fullyAuthenticated()
                //认证处理
                .and().formLogin().successHandler(successHandler).failureHandler(failureHandler).permitAll()
                //注销登录
                .and().logout().logoutUrl("/sso/logout").logoutSuccessHandler(logOutSuccessHandler).permitAll()
                //错误处理
                .and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).accessDeniedHandler(accessDeniedHandler)
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
        auth.eraseCredentials(false);
    }

}
