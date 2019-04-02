package cn._51even.efast.controller;

import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "测试接口",tags = "test")
@RestController
@RequestMapping("/test")
@Validated
public class TestController {

    @GetMapping("/auth")
    public String auth(){
        return "this is a auth url!";
    }

    @GetMapping("/test")
    public Object test(){
        return "just for test";
    }
}
