package com.zsc.javaee_booktest.config.auth;

import com.alibaba.fastjson.JSON;
import com.zsc.javaee_booktest.utils.ResultUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName LogoutSuccessHandler
 * @Description 退出登录处理器
 * @Author Kami
 * @Date 2020/6/29 17:51
 * @Version 1.0
 **/
@Component
public class MyLogoutSuccessHandler extends JSONAuthentication implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        jsonResult = ResultUtils.success();
        this.writeJSON(httpServletRequest, httpServletResponse, jsonResult);
    }
}
