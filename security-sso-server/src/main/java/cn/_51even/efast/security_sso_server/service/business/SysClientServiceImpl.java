package cn._51even.efast.security_sso_server.service.business;

import cn._51even.efast.core.base.bean.response.ResponseResult;
import cn._51even.efast.core.base.service.BaseService;
import cn._51even.efast.security_sso_server.bean.entity.SysClientEntity;
import cn._51even.efast.security_sso_server.bean.request.sysClient.InsertSysClientReq;
import cn._51even.efast.security_sso_server.service.api.SysClientService;
import org.springframework.stereotype.Service;

@Service("sysClientService")
public class SysClientServiceImpl extends BaseService<SysClientEntity,Integer> implements SysClientService {
    @Override
    public SysClientEntity selectById(Integer id) {
        return selectByPrimaryKey(id);
    }

    @Override
    public ResponseResult registerClient(InsertSysClientReq insertSysClientReq) {
        return null;
    }
}
