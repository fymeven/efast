package cn._51even.efast.security_cas_server.service.business;

import cn._51even.efast.core.base.service.BaseService;
import cn._51even.efast.core.system.ResponseResult;
import cn._51even.efast.core.util.BeanCopyUtil;
import cn._51even.efast.security_cas_server.bean.entity.SysResourceEntity;
import cn._51even.efast.security_cas_server.bean.enums.SysResourceEnums;
import cn._51even.efast.security_cas_server.bean.enums.SysRoleEnums;
import cn._51even.efast.security_cas_server.bean.enums.SysUserEnums;
import cn._51even.efast.security_cas_server.bean.request.sysResource.InsertSysResourceReq;
import cn._51even.efast.security_cas_server.service.api.SysResourceService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("sysResourceService")
public class SysResourceServiceImpl extends BaseService<SysResourceEntity,Integer> implements SysResourceService {

    @Override
    public Set<SysResourceEntity> getResourcesByUserId(Integer userId) {
        Example example = new Example(SysResourceEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status",SysResourceEnums.status.LOCK.getCode());
        StringBuilder sql = new StringBuilder();
        sql.append("EXISTS(SELECT 1 FROM sys_resource res LEFT JOIN sys_role_resource rr ON rr.resource_id=res.id");
        sql.append(" LEFT JOIN sys_role r ON r.id=rr.role_id LEFT JOIN sys_user_role ur ON ur.role_id=rr.role_id");
        sql.append(" LEFT JOIN sys_user u ON u.id=rr.role_id WHERE ur.user_id="+userId+"");
        sql.append(" AND u.status="+SysUserEnums.status.ACTIVE.getCode() +" AND r.status="+SysRoleEnums.status.ACTIVE.getCode() +")");
        criteria.andCondition(sql.toString());
        List<SysResourceEntity> sysResourceEntities = select(example);
        return new HashSet<>(sysResourceEntities);
    }

    @Override
    public ResponseResult save(InsertSysResourceReq insertSysResourceReq) {
        SysResourceEntity sysResourceEntity = new SysResourceEntity();
        BeanCopyUtil.copyProperties(sysResourceEntity,insertSysResourceReq);
        sysResourceEntity.setCreateTime(new Date());
        sysResourceEntity.setUpdateTime(new Date());
        boolean save = save(sysResourceEntity);
        return save ? ResponseResult.SUCCESS : ResponseResult.ERROR;
    }


}
