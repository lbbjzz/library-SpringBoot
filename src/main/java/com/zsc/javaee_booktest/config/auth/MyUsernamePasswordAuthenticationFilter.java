package com.zsc.javaee_booktest.config.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @ClassName UsernamePasswordAuthenticationFilter
 * @Description TODO
 * @Author Kami
 * @Date 2020/6/30 15:20
 * @Version 1.0
 **/
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        if (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)
            || request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)){
            ObjectMapper mapper = new ObjectMapper();

            Map<String, String> authenticationBean = null;
            try (InputStream is = request.getInputStream()){
                authenticationBean = mapper.readValue(is, Map.class);
            } catch (IOException e){
                e.printStackTrace();
            }
            try {
                if (!authenticationBean.isEmpty()){
                    String username = authenticationBean.get(SPRING_SECURITY_FORM_USERNAME_KEY);
                    String password = authenticationBean.get(SPRING_SECURITY_FORM_PASSWORD_KEY);
                    System.out.println("username:" + username);
                    System.out.println("password:" + password);

                    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
                    setDetails(request, authRequest);
                    return this.getAuthenticationManager().authenticate(authRequest);
                }
            } catch (Exception e){
                throw e;
            }
            return null;
        } else{
            return super.attemptAuthentication(request, response);
        }
    }
}
