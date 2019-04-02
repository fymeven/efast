package cn._51even.efast.security_cas_server.service.api;

import cn._51even.efast.security_cas_server.bean.entity.SysRoleEntity;

import java.util.Set;

public interface SysRoleService{
    Set<SysRoleEntity> getRolesByUserId(Integer userId);
}
