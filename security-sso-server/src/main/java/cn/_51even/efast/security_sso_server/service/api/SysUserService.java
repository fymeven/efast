package cn._51even.efast.security_sso_server.service.api;

import cn._51even.efast.core.base.bean.response.ResponseResult;
import cn._51even.efast.security_sso_server.bean.request.sysUser.InsertSysUserReq;
import cn._51even.efast.security_sso_server.bean.response.SysUser.SSOUserInfo;

public interface SysUserService {

    SSOUserInfo getUserByLoginAccount(String loginAccount);

    ResponseResult register(InsertSysUserReq insertSysUserReq);
}
