package cn._51even.efast.security_sso_server.controller;

import cn._51even.efast.core.base.bean.response.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "页面跳转",tags = "page")
@RestController
@RequestMapping("/json")
@Validated
public class JsonController {

    @GetMapping("/login")
    public ResponseResult auth(){
        return ResponseResult.errorMsg("未登录或登录已过期,请重新登录");
    }
}
