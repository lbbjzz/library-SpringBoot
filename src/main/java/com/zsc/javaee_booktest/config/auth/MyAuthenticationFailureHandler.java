package com.zsc.javaee_booktest.config.auth;

import com.alibaba.fastjson.JSON;
import com.zsc.javaee_booktest.utils.ResultCode;
import com.zsc.javaee_booktest.utils.ResultUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName AuthenticationFailureHandler
 * @Description 登录失败处理器
 * @Author Kami
 * @Date 2020/6/29 17:45
 * @Version 1.0
 **/
@Component
public class MyAuthenticationFailureHandler extends JSONAuthentication implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        jsonResult = null;
        if(e instanceof InternalAuthenticationServiceException){
            jsonResult = ResultUtils.fail(ResultCode.USER_ACCOUNT_NOT_EXIST);
        } else if (e instanceof BadCredentialsException){
            jsonResult = ResultUtils.fail(ResultCode.USER_CREDENTIALS_ERROR);
        } else {
            jsonResult = ResultUtils.fail(ResultCode.COMMON_FAIL);
        }
        this.writeJSON(httpServletRequest, httpServletResponse, jsonResult);
    }
}
