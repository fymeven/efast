package cn._51even.efast.security_sso_server.service.api;

import cn._51even.efast.core.base.bean.response.ResponseResult;
import cn._51even.efast.security_sso_server.bean.entity.SysResourceEntity;
import cn._51even.efast.security_sso_server.bean.request.sysResource.InsertSysResourceReq;

import java.util.Set;

public interface SysResourceService{

    Set<SysResourceEntity> getResourcesByUserId(Integer userId);

    ResponseResult save(InsertSysResourceReq insertSysResourceReq);
}
