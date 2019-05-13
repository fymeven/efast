package cn._51even.efast.security_sso_server.config;

import cn._51even.efast.security_sso_server.handler.*;
import cn._51even.efast.security_sso_server.realm.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;


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
    private SsoServerConfig ssoServerConfig;

    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.sessionManagement().invalidSessionUrl("/sso/logout?expired")
//      .sessionRegistry(sessionRegistry)
        .maximumSessions(ssoServerConfig.getMaximumSessions()).expiredUrl("/sso/logout?otherLogin");
        http.csrf().disable();
        http
                .authorizeRequests()
                // 跨域预检请求
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/page/**","/sso/**").permitAll()
                // 静态文件
                .antMatchers("/static/**","/templates/**","/favicon.ico").permitAll()
                // swagger
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
                //其他请求都需要认证
                .anyRequest().authenticated()
                //认证处理
                .and().formLogin().loginPage("/page/login").loginProcessingUrl("/sso/login").usernameParameter("loginAccount").passwordParameter("loginPwd")
                .successHandler(successHandler).failureHandler(failureHandler).permitAll()
                //注销登录
                .and().logout().logoutUrl("/sso/logout?exit").logoutSuccessHandler(logOutSuccessHandler).permitAll()
                //错误处理
                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler)
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new Md5PasswordEncoder();
    }
}
