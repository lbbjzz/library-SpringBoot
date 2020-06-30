package com.zsc.javaee_booktest.config.auth;

import com.alibaba.fastjson.JSON;
import com.zsc.javaee_booktest.utils.JsonResult;
import com.zsc.javaee_booktest.utils.ResultCode;
import com.zsc.javaee_booktest.utils.ResultUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName AuthenticationFailureHandler
 * @Description TODO
 * @Author Kami
 * @Date 2020/6/29 17:45
 * @Version 1.0
 **/
@Component
public class AuthenticationFailureHandler implements org.springframework.security.web.authentication.AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        JsonResult result = null;
        if(e instanceof BadCredentialsException){
            result = ResultUtils.fail(ResultCode.USER_CREDENTIALS_ERROR);
        } else if (e instanceof InternalAuthenticationServiceException){
            result = ResultUtils.fail(ResultCode.USER_ACCOUNT_NOT_EXIST);
        } else {
            result = ResultUtils.fail(ResultCode.COMMON_FAIL);
        }
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
