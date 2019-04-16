package cn._51even.efast.security_cas_server.config;

import cn._51even.efast.security_cas_server.handler.*;
import cn._51even.efast.security_cas_server.realm.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
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

    @Value("${server.servlet.session.cookie.name}")
    private String cookieName;

    @Resource
    private CasServerConfig casServerConfig;

    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.sessionManagement().maximumSessions(1)
//      .sessionRegistry(sessionRegistry)
        .expiredUrl("/oauth/logout?type=expired");
        // 禁用headers缓存
        http.headers().cacheControl();
        // 禁用csrf
        http.csrf().disable();
        // rememberMe自动登录
        http.rememberMe();
        // 使用httpBasic
        http.httpBasic();
        http
                //认证处理
                .formLogin().successHandler(successHandler).failureHandler(failureHandler).permitAll()
                //注销登录
                .and().logout().deleteCookies(cookieName).logoutUrl("/oauth/logout").logoutSuccessHandler(logOutSuccessHandler).permitAll()
                .and().authorizeRequests()
                // 跨域预检请求
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/oauth/authorize","/oauth/token").permitAll()
                // 静态文件
                .antMatchers("/static/**","/templates/**","/favicon.ico").permitAll()
                // swagger
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
//                .antMatchers("/actuator/**").hasAuthority("admin")
                //其他请求都需要认证
                .antMatchers("/pay/**").fullyAuthenticated()
                .anyRequest().authenticated()
                //错误处理
                .and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).accessDeniedHandler(accessDeniedHandler)
        ;
    }

	@Bean
	public UserDetailsService userDetailsService(){
		return new UserDetailsServiceImpl();
	}

	@Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
