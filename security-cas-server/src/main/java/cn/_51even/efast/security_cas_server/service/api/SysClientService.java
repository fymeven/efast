package cn._51even.efast.security_cas_server.service.api;

import cn._51even.efast.core.system.ResponseResult;
import cn._51even.efast.security_cas_server.bean.entity.SysClientEntity;
import cn._51even.efast.security_cas_server.bean.request.sysClient.InsertSysClientReq;

public interface SysClientService {

    SysClientEntity selectByClientId(String clientId);

    ResponseResult registerClient(InsertSysClientReq insertSysClientReq);
}
