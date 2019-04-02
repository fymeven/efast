package cn._51even.efast.security_cas_server.server;

import cn._51even.efast.security_cas_server.config.CasServerConfig;
import cn._51even.efast.security_cas_server.config.JWTTokenEnhancer;
import cn._51even.efast.security_cas_server.realm.ClientDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * 授权服务器
 */
@Order(4)
@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;
    @Resource
    private CasServerConfig casServerConfig;


    @Bean // 声明TokenStore实现
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }
    /**
     * 配置自定义客户端服务
     * @return
     */
    @Bean
    public ClientDetailsService clientDetailsService(){
        return new ClientDetailsServiceImpl();
    }

    /**
     * JWT配置
     * @return
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(casServerConfig.getJwtSigningKey());
        return converter;
    }

    @Bean
    public TokenEnhancer tokenEnhancer(){
        return new JWTTokenEnhancer();
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices(){
        // 配置TokenServices参数
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore());
        tokenServices.setSupportRefreshToken(false);
        tokenServices.setClientDetailsService(clientDetailsService());
        tokenServices.setTokenEnhancer(tokenEnhancer());
        tokenServices.setAccessTokenValiditySeconds( (int) TimeUnit.DAYS.toSeconds(30)); // 30天
        return tokenServices;
    }

    /**
     * 配置自定义客户端服务
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        //允许所有资源服务器访问公钥端点（/oauth/token_key）
        //只允许验证用户访问令牌解析端点（/oauth/check_token）
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
        // 允许客户端发送表单来进行权限认证来获取令牌
        oauthServer.allowFormAuthenticationForClients();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore())
                .userDetailsService(userDetailsService)
                .authenticationManager(authenticationManager)
                .tokenServices(tokenServices())
        ;
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> enhancerList = new ArrayList();
        enhancerList.add(tokenEnhancer());
        enhancerList.add(jwtAccessTokenConverter());
        tokenEnhancerChain.setTokenEnhancers(enhancerList);
        endpoints.tokenEnhancer(tokenEnhancerChain).accessTokenConverter(jwtAccessTokenConverter());
    }


}
