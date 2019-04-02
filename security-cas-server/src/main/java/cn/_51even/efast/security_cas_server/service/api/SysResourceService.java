package cn._51even.efast.security_cas_server.service.api;

import cn._51even.efast.core.system.ResponseResult;
import cn._51even.efast.security_cas_server.bean.entity.SysResourceEntity;
import cn._51even.efast.security_cas_server.bean.request.sysResource.InsertSysResourceReq;

import java.util.Set;

public interface SysResourceService{

    Set<SysResourceEntity> getResourcesByUserId(Integer userId);

    ResponseResult save(InsertSysResourceReq insertSysResourceReq);
}
