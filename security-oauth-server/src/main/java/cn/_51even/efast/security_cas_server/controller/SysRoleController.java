package cn._51even.efast.security_sso_server.controller;

import cn._51even.efast.core.base.bean.response.ResponseResult;
import cn._51even.efast.security_sso_server.service.api.SysRoleService;
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

@Api(value = "系统角色接口",tags = "sysRole")
@RestController
@RequestMapping("/sysRole")
@Validated
public class SysRoleController {

    @Resource
    private SysRoleService sysRoleService;


    @ApiOperation(value = "根据用户id获取角色信息")
    @ApiImplicitParams(
            @ApiImplicitParam(value = "用户id",name = "userId",required = true)
    )
    @GetMapping("/getRolesByUserId")
    public ResponseResult getRolesByUserId(@NotNull(message = "用户id不能为空")
                                                @RequestParam(required = false) Integer userId){
        Set<String> sysRoleInfo = sysRoleService.getRolesByUserId(userId);
        return ResponseResult.successData(sysRoleInfo);
    }

}
