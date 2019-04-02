package cn._51even.efast.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableOAuth2Client
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
        // 跨域预检请求
        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
        .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
        // 登录URL
        .antMatchers("/login").permitAll()
        //静态文件
        .antMatchers("/static/**","/templates/**","/favicon.ico").permitAll()
        // swagger
        .antMatchers("/swagger-ui.html").permitAll()
        .antMatchers("/swagger-resources").permitAll()
        .antMatchers("/v2/api-docs").permitAll()
        .antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
        .anyRequest().authenticated()
        ;
    }

}
