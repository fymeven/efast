package cn._51even.efast.security_sso_server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sso")
@PropertySource(value = "classpath:config/ssoServer.properties")
public class SsoServerConfig {

    private Integer maximumSessions;

    public Integer getMaximumSessions() {
        return maximumSessions;
    }

    public void setMaximumSessions(Integer maximumSessions) {
        this.maximumSessions = maximumSessions;
    }
}
