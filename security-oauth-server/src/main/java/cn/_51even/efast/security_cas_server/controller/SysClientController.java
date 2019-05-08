package cn._51even.efast.security_sso_server.controller;

import cn._51even.efast.core.base.bean.response.ResponseResult;
import cn._51even.efast.security_sso_server.bean.request.sysClient.InsertSysClientReq;
import cn._51even.efast.security_sso_server.service.api.SysClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api(description = "系统资源接口",tags = "sysResource")
@RestController
@RequestMapping("/sysResource")
@Validated
public class SysClientController {

    @Resource
    private SysClientService sysClientService;


    @ApiOperation(value = "根据用户id获取资源信息")
    @ApiImplicitParams(
            @ApiImplicitParam(value = "用户id",name = "userId",required = true)
    )
    @PostMapping("/registerClient")
    public ResponseResult registerClient(@Valid InsertSysClientReq insertSysClientReq){
        return sysClientService.registerClient(insertSysClientReq);
    }
}
