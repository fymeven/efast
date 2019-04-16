package cn._51even.efast.security_cas_server.service.business;

import cn._51even.efast.core.base.service.BaseService;
import cn._51even.efast.core.system.ResponseResult;
import cn._51even.efast.security_cas_server.bean.entity.SysClientEntity;
import cn._51even.efast.security_cas_server.bean.request.sysClient.InsertSysClientReq;
import cn._51even.efast.security_cas_server.service.api.SysClientService;
import org.springframework.stereotype.Service;

@Service("sysClientService")
public class SysClientServiceImpl extends BaseService<SysClientEntity,Integer> implements SysClientService {
    @Override
    public SysClientEntity selectByClientId(String clientId) {
        SysClientEntity sysClientEntity = new SysClientEntity();
        sysClientEntity.setClientId(clientId);
        return selectOne(sysClientEntity);
    }

    @Override
    public ResponseResult registerClient(InsertSysClientReq insertSysClientReq) {
        return null;
    }
}
