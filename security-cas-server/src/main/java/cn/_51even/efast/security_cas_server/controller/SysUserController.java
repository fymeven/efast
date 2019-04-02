package cn._51even.efast.security_cas_server.controller;

import cn._51even.efast.core.system.ResponseResult;
import cn._51even.efast.core.util.RequestUtils;
import cn._51even.efast.security_cas_server.bean.request.sysUser.InsertSysUserReq;
import cn._51even.efast.security_cas_server.service.api.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api(description = "系统用户接口",tags = "sysUser")
@RestController
@RequestMapping("/sysUser")
@Validated
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @ApiOperation(value = "注册用户")
    @PostMapping("/register")
    public ResponseResult register(@Valid InsertSysUserReq insertSysUserReq){
        return sysUserService.register(insertSysUserReq);
    }

    @ApiOperation(value = "测试")
    @GetMapping("/test")
    public ResponseResult test(){
        return ResponseResult.successMsg("this service from"+RequestUtils.getRequest().getServerPort());
    }
}
