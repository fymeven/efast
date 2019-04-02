package cn._51even.efast.message.controller;

import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "系统用户接口",tags = "sysUser")
@RestController
@RequestMapping("/sysUser")
@Validated
public class SysUserController {


}
