//package cn._51even.efast.security_cas_client.filter;
//
//import cn._51even.efast.security_cas_client.bean.model.OauthClientRegister;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.oauth2.client.OAuth2ClientContext;
//import org.springframework.security.oauth2.client.OAuth2RestTemplate;
//import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
//import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
//import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
//import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Component
//public class OauthClientConfig {
//
//    private OAuth2ClientContext oauth2ClientContext;
//
//    public OauthClientConfig(OAuth2ClientContext oauth2ClientContext) {
//        this.oauth2ClientContext = oauth2ClientContext;
//    }
//
//    public OAuth2ClientAuthenticationProcessingFilter oAuth2ClientAuthenticationProcessingFilter(OauthClientRegister register, String path) {
//        OAuth2ClientAuthenticationProcessingFilter oAuth2ClientAuthenticationFilter = new OAuth2ClientAuthenticationProcessingFilter(path);
//        OAuth2RestTemplate oauthOAuth2RestTemplate = getOauthOAuth2RestTemplate(register);
//        oAuth2ClientAuthenticationFilter.setRestTemplate(oauthOAuth2RestTemplate);
//        UserInfoTokenServices tokenServices = new UserInfoTokenServices(register.getResource().getUserInfoUri(),register.getClient().getClientId());
//        tokenServices.setRestTemplate(oauthOAuth2RestTemplate);
//        oAuth2ClientAuthenticationFilter.setTokenServices(tokenServices);
//        return oAuth2ClientAuthenticationFilter;
//    }
//
//    public OAuth2RestTemplate getOauthOAuth2RestTemplate(OauthClientRegister register){
//        OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(register.getClient(), oauth2ClientContext);
//        oAuth2RestTemplate.setAccessTokenProvider(new AuthorizationCodeAccessTokenProvider());
//        return oAuth2RestTemplate;
//    }
//
//    @Bean
//    public FilterRegistrationBean oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(filter);
//        registration.setOrder(-100);
//        return registration;
//    }
//}
