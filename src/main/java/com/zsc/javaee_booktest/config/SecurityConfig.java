package com.zsc.javaee_booktest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import javax.annotation.Resource;
import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    UserDetailsService userDetailsService;

    //实现用户身份认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置url的访问权限
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login/**").permitAll()
                .anyRequest().authenticated();
        //关闭csrf保护功能
        http.csrf().disable();
        //使用自定义的登录窗口
        http.formLogin()
                .loginPage("/userLogin").permitAll()
                .usernameParameter("username").passwordParameter("password")
                .defaultSuccessUrl("/")
                .failureForwardUrl("/userLogin?error");
        //实现注销
       http.logout()
                .logoutUrl("/userlogout")
                .logoutSuccessUrl("/userLogin");

        //记住我
        http.rememberMe()
                .rememberMeParameter("rememberme").tokenValiditySeconds(200)
                .tokenRepository(tokenRepository());
    }

    @Autowired
    private DataSource dataSource;

    //持久化token存储
    @Bean
    public JdbcTokenRepositoryImpl tokenRepository() {
        JdbcTokenRepositoryImpl jr = new JdbcTokenRepositoryImpl();
        jr.setDataSource(dataSource);
        return jr;
    }
}
