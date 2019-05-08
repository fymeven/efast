package cn._51even.efast.security_sso_server.service.api;

import cn._51even.efast.core.base.bean.response.ResponseResult;
import cn._51even.efast.security_sso_server.bean.entity.SysClientEntity;
import cn._51even.efast.security_sso_server.bean.request.sysClient.InsertSysClientReq;

public interface SysClientService {

    SysClientEntity selectById(Integer id);

    ResponseResult registerClient(InsertSysClientReq insertSysClientReq);
}
