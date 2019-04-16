package cn._51even.efast.controller;

import cn._51even.efast.core.util.HttpUtils;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

@Api(value = "oauth授权接口",tags = "oauth")
@RestController
@RequestMapping("/login/oauth")
@Validated
public class OauthController {

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

//    private static final String oauthKey="efast-oauthKey";

//    private String accessTokenUrl="http://127.0.0.1:8801/security-cas-server/oauth/token";
//
//    private String clientId="client1";
//
//    private String clientSecret="9da7eb6595df00b4f1a252bc91a391cf";

//    @RequestMapping(value = "/token")
//    public String token(@RequestParam("code")String code,@RequestParam("state") String state){
//        JSONObject param = new JSONObject();
//        param.put("grant_type","authorization_code");
//        param.put("code",code);
//        param.put("redirect_uri","http://127.0.0.1:8088/efast-web");
////        param.put("client_id",clientId);
////        param.put("client_secret",clientSecret);
//        String accessToken = HttpUtils.doPost(accessTokenUrl, param, String.class);
////        OAuth2RestTemplate oAuth2RestTemplate = oauthClientConfig.getOauthOAuth2RestTemplate(efast);
////        OAuth2AccessToken accessToken = oAuth2RestTemplate.getAccessToken();
////        ResponseEntity<String> accessToken = oAuth2RestTemplate.getForEntity(accessTokenUrl, String.class, param);
//        System.out.println("accessToken="+accessToken);
//        return accessToken;
//    }

//    @RequestMapping(value = "/code/efast")
//    public String token(@RequestParam("code")String code,@RequestParam("state") String state){
//        JSONObject param = new JSONObject();
//        param.put("grant_type","authorization_code");
//        param.put("code",code);
//        param.put("redirect_uri","http://127.0.0.1:8088/efast-web");
//        String accessToken = HttpUtils.doPost(accessTokenUrl, param, String.class);
//        System.out.println("accessToken="+accessToken);
//        return accessToken;
//    }

//    @RequestMapping(value = "/code/github")
//    public String token(@RequestParam("code")String code,@RequestParam("state") String state){
//        JSONObject param = new JSONObject();
//        param.put("grant_type","authorization_code");
//        param.put("code",code);
//        param.put("redirect_uri","http://127.0.0.1:8088/efast-web");
//        String accessToken = HttpUtils.doPost(accessTokenUrl, param, String.class);
//        System.out.println("accessToken="+accessToken);
//        return accessToken;
//    }

    @RequestMapping("/accessToken")
    public OAuth2AccessToken userinfo(OAuth2AuthenticationToken authentication) {
        OAuth2AuthorizedClient authorizedClient =
                this.authorizedClientService.loadAuthorizedClient(
                        authentication.getAuthorizedClientRegistrationId(),
                        authentication.getName());
        OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
        return accessToken;
    }
}
