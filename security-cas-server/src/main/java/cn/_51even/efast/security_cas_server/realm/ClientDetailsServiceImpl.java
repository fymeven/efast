package cn._51even.efast.security_cas_server.realm;

import cn._51even.efast.security_cas_server.bean.entity.SysClientEntity;
import cn._51even.efast.security_cas_server.bean.enums.GrantTypeEnum;
import cn._51even.efast.security_cas_server.config.CasServerConfig;
import cn._51even.efast.security_cas_server.service.api.SysClientService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ClientDetailsServiceImpl implements ClientDetailsService {

    @Resource
    private SysClientService sysClientService;
    @Resource
    private CasServerConfig casServerConfig;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ClientDetailsBean clientDetailsBean = new ClientDetailsBean();
        SysClientEntity sysClientEntity = sysClientService.selectByClientId(clientId);
        clientDetailsBean.setClientId(clientId);
        clientDetailsBean.setClientSecret(sysClientEntity.getClientSecret());
        String scopes = sysClientEntity.getScopes();
        HashSet<String> redirectUri = new HashSet<>();
        redirectUri.add(sysClientEntity.getClientRedirectUrl());
        clientDetailsBean.setRegisteredRedirectUri(redirectUri);
        if (StringUtils.isNotBlank(sysClientEntity.getGrantType())){
            HashSet<String> grantTypes = new HashSet<>();
            grantTypes.add(sysClientEntity.getGrantType());
            clientDetailsBean.setAuthorizedGrantTypes(grantTypes);
        }
        if (StringUtils.isNotBlank(scopes)){
            String[] split = scopes.split(",");
            clientDetailsBean.setScope(new HashSet(Arrays.asList(split)));
            clientDetailsBean.setScoped(true);
        }
        clientDetailsBean.setAccessTokenValiditySeconds(casServerConfig.getAccessTokenValiditySeconds());
        clientDetailsBean.setRefreshTokenValiditySeconds(casServerConfig.getRefreshTokenValiditySeconds());
        if (clientDetailsBean.getAuthorizedGrantTypes() == null){
            Set grantType= new HashSet<>();
            GrantTypeEnum.grantType[] values = GrantTypeEnum.grantType.values();
            for (GrantTypeEnum.grantType value : values) {
                grantType.add(value.getCode());
            }
            clientDetailsBean.setAuthorizedGrantTypes(grantType);
        }
        return clientDetailsBean;
    }
}
