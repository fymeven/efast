package cn._51even.efast.security_cas_server.service.business;

import cn._51even.efast.core.base.BaseService;
import cn._51even.efast.security_cas_server.bean.entity.SysRoleEntity;
import cn._51even.efast.security_cas_server.bean.enums.SysRoleEnums;
import cn._51even.efast.security_cas_server.bean.enums.SysUserEnums;
import cn._51even.efast.security_cas_server.service.api.SysRoleService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("sysRoleService")
public class SysRoleServiceImpl extends BaseService<SysRoleEntity,Integer> implements SysRoleService {

    @Override
    public Set<SysRoleEntity> getRolesByUserId(Integer userId) {
        Example example = new Example(SysRoleEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status",SysRoleEnums.status.LOCK.getCode());
        StringBuilder sql = new StringBuilder();
        sql.append("EXISTS(SELECT 1 FROM sys_role r LEFT JOIN sys_user_role ur ON ur.role_id=r.id");
        sql.append(" LEFT JOIN sys_user u ON u.id=ur.user_id WHERE ur.user_id="+userId+" AND u.status="+SysUserEnums.status.ACTIVE.getCode() +")");
        criteria.andCondition(sql.toString());
        List<SysRoleEntity> sysRoleEntities = select(example);
        return new HashSet<>(sysRoleEntities);
    }
}
