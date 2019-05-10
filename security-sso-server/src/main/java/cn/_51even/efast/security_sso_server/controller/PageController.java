package cn._51even.efast.security_sso_server.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "页面跳转",tags = "page")
@Controller
@RequestMapping("/page")
@Validated
public class PageController {

    @GetMapping("/login")
    public String auth(){
        return "login";
    }
}
