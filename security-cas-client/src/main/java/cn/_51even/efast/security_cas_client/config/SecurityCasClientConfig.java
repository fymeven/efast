//package cn._51even.efast.security_cas_client.config;
//
//import cn._51even.efast.security_cas_client.bean.model.OauthClientRegister;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.client.OAuth2ClientContext;
//import org.springframework.security.oauth2.client.OAuth2RestTemplate;
//import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
//import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
//
//import javax.annotation.Resource;
//import javax.servlet.Filter;
//
//@Configuration
//public class SecurityCasClientConfig {
//
//    @Resource
//    private OAuth2ClientContext oauth2ClientContext;
//
//    @Bean
//    public FilterRegistrationBean oauth2ClientFilterRegistration() {
//        OAuth2ClientContextFilter filter = new OAuth2ClientContextFilter();
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(filter);
//        registration.setOrder(-100);
//        return registration;
//    }
//
//    private Filter oauthConfig(OauthClientRegister register, String path) {
//        OAuth2ClientAuthenticationProcessingFilter oAuth2ClientAuthenticationFilter = new OAuth2ClientAuthenticationProcessingFilter(path);
//        OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(register.getClient(), oauth2ClientContext);
//        oAuth2ClientAuthenticationFilter.setRestTemplate(oAuth2RestTemplate);
//        UserInfoTokenServices tokenServices = new UserInfoTokenServices(register.getResource().getUserInfoUri(),register.getClient().getClientId());
//        tokenServices.setRestTemplate(oAuth2RestTemplate);
//        oAuth2ClientAuthenticationFilter.setTokenServices(tokenServices);
//        return oAuth2ClientAuthenticationFilter;
//    }
//
//}
