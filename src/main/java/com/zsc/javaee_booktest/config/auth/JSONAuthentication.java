package com.zsc.javaee_booktest.config.auth;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zsc.javaee_booktest.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName JSONAuthentication
 * @Description 封装输出JSON格式的类
 * @Author Kami
 * @Date 2020/6/30 19:46
 * @Version 1.0
 **/
public class JSONAuthentication {
    @Autowired
    JsonResult jsonResult;

    protected void writeJSON(HttpServletRequest request,
                             HttpServletResponse response,
                             JsonResult result) throws IOException, ServletException {
        //这里很重要，否则页面获取不到正常的JSON数据集
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Method", "POST,GET");
        //输出JSON
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(result));
        out.flush();
        out.close();
    }
}
