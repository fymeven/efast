package cn._51even.efast.security_sso_server.service.api;

import java.util.Set;

public interface SysRoleService{
    Set<String> getRolesByUserId(Integer userId);
}
