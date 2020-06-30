package com.zsc.javaee_booktest.config.auth;

import com.alibaba.fastjson.JSON;
import com.zsc.javaee_booktest.utils.JsonResult;
import com.zsc.javaee_booktest.utils.ResultUtils;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName LogoutSuccessHandler
 * @Description TODO
 * @Author Kami
 * @Date 2020/6/29 17:51
 * @Version 1.0
 **/
@Component
public class LogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        JsonResult result = ResultUtils.success();
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
