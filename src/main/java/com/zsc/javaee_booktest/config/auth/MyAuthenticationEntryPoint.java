package com.zsc.javaee_booktest.config.auth;

import com.alibaba.fastjson.JSON;
import com.zsc.javaee_booktest.utils.JsonResult;
import com.zsc.javaee_booktest.utils.ResultCode;
import com.zsc.javaee_booktest.utils.ResultUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName AuthenticationEntryPoint
 * @Description 无权限访问处理器
 * @Author Kami
 * @Date 2020/6/29 16:54
 * @Version 1.0
 **/
@Component
public class MyAuthenticationEntryPoint extends JSONAuthentication implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        jsonResult = ResultUtils.fail(ResultCode.USER_NOT_LOGIN);
        System.out.println("sadasd");
        this.writeJSON(httpServletRequest, httpServletResponse, jsonResult);
    }
}
