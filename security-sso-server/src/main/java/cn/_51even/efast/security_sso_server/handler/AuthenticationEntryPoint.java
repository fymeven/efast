package cn._51even.efast.security_sso_server.handler;

import cn._51even.efast.core.base.bean.response.ResponseResult;
import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPoint implements org.springframework.security.web.AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8"); // 响应类型
        httpServletResponse.getWriter().print(JSONObject.toJSON(ResponseResult.errorMsg(e.getMessage())));
    }
}
