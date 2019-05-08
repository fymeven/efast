package cn._51even.efast.security_sso_server.service.api;

import cn._51even.efast.security_sso_server.bean.entity.SysRoleEntity;

import java.util.Set;

public interface SysRoleService{
    Set<String> getRolesByUserId(Integer userId);
}
