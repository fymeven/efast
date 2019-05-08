package cn._51even.efast.security_sso_server.controller;

import cn._51even.efast.core.base.bean.response.ResponseResult;
import cn._51even.efast.security_sso_server.bean.entity.SysResourceEntity;
import cn._51even.efast.security_sso_server.service.api.SysResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Api(description = "系统资源接口",tags = "sysResource")
@RestController
@RequestMapping("/sysResource")
@Validated
public class SysResourceController {

    @Resource
    private SysResourceService sysResourceService;


    @ApiOperation(value = "根据用户id获取资源信息")
    @ApiImplicitParams(
            @ApiImplicitParam(value = "用户id",name = "userId",required = true)
    )
    @GetMapping("/getResourcesByUserId")
    public ResponseResult getResourcesByUserId(@NotNull(message = "用户id不能为空")
                                                   @RequestParam(required = false) Integer userId){
        Set<SysResourceEntity> sysResourceInfo = sysResourceService.getResourcesByUserId(userId);
        return ResponseResult.successData(sysResourceInfo);
    }
}
