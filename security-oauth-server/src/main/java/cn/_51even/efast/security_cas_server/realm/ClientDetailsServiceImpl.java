package cn._51even.efast.security_sso_server.realm;

import cn._51even.efast.security_sso_server.bean.entity.SysClientEntity;
import cn._51even.efast.security_sso_server.config.CasServerConfig;
import cn._51even.efast.security_sso_server.service.api.SysClientService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

import javax.annotation.Resource;
import java.util.*;

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
        if (StringUtils.isNotBlank(sysClientEntity.getGrantType())){
            String[] split = sysClientEntity.getGrantType().split(",");
            clientDetailsBean.setAuthorizedGrantTypes(new HashSet(Arrays.asList(split)));
        }
        if (StringUtils.isNotBlank(sysClientEntity.getScopes())){
            String[] split = sysClientEntity.getScopes().split(",");
            clientDetailsBean.setScope(new HashSet(Arrays.asList(split)));
        }
        if (StringUtils.isNotBlank(sysClientEntity.getClientRedirectUrl())){
            String[] split = sysClientEntity.getClientRedirectUrl().split(",");
            clientDetailsBean.setRegisteredRedirectUri(new HashSet(Arrays.asList(split)));
        }
        clientDetailsBean.setAccessTokenValiditySeconds(casServerConfig.getAccessTokenValiditySeconds());
        clientDetailsBean.setRefreshTokenValiditySeconds(casServerConfig.getRefreshTokenValiditySeconds());
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("READ"));
        authorities.add(new SimpleGrantedAuthority("WRITE"));
        clientDetailsBean.setAuthorities(authorities);
        return clientDetailsBean;
    }
}
