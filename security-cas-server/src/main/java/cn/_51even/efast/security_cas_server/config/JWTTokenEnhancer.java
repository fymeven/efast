package cn._51even.efast.security_cas_server.config;

import cn._51even.efast.security_cas_server.realm.UserDetailsBean;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JWTTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        final Map<String, Object> additionalInfo = new HashMap<>();
        Object principal1 = oAuth2Authentication.getPrincipal();
        if (principal1 instanceof UserDetailsBean){
            UserDetailsBean userDetailsBean = (UserDetailsBean)principal1;
            additionalInfo.put("userInfo",userDetailsBean);
        }
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
        return oAuth2AccessToken;
    }
}
