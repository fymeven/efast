package cn._51even.efast.security_sso_server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Api(value = "oauth接口",tags = "oauth")
@RestController
@RequestMapping("/oauth")
@Validated
public class OauthController {


    @ApiOperation(value = "用户信息")
    @GetMapping("/user")
    public Principal user(Principal principal){
        return principal;
    }
}
