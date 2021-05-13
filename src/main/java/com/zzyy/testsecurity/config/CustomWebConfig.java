package com.zzyy.testsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zhouy262
 * @date 2021/5/8 17:08
 **/
public class CustomWebConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //开启登录配置
        http.authorizeRequests()
                // echo接口需要admin权限才能访问
                .antMatchers("/echo/*").hasRole("admin")
                //其他接口登录就可以
                .anyRequest().authenticated()
                .and()
                .csrf().disable();


        super.configure(http);
    }

    /**
     * 权限配置
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        String encode = passwordEncoder.encode("123");
        System.out.println(encode);

        auth.inMemoryAuthentication().withUser("zzyy").roles("admin").password("123456");

        super.configure(auth);
    }


}
