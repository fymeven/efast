package cn._51even.efast.security_cas_server.config;

import cn._51even.efast.security_cas_server.handler.*;
import cn._51even.efast.security_cas_server.realm.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsUtils;

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
    private AuthValidProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.httpBasic();
        http.csrf().disable();
        http.authorizeRequests()
                // 跨域预检请求
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
               /**************/
                .antMatchers("/sysUser/**").permitAll()
                /***********/
                // 登录URL
                .antMatchers("/login").permitAll()
                //授权端点
                .antMatchers("/oauth/**").permitAll()
                //静态文件
                .antMatchers("/static/**","/templates/**","/favicon.ico").permitAll()
                // swagger
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
                .antMatchers("/actuator/**").hasAuthority("admin")
                // 其他所有请求需要身份认证
                .antMatchers("/**").authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().loginProcessingUrl("/oauth/login").successHandler(successHandler).failureHandler(failureHandler).permitAll()
                .and()
                //注销登录
                .logout().logoutUrl("/oauth/logout").logoutSuccessHandler(logOutSuccessHandler).permitAll()
                .and()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).accessDeniedHandler(accessDeniedHandler)
        ;
            http
                .headers()
                .cacheControl();
    }

    /**
     * 用户验证
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
        auth.authenticationProvider(authenticationProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new Md5PasswordEncoder();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }


}
