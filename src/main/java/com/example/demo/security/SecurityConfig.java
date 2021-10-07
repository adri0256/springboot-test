package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/user/all").permitAll()
                .antMatchers(HttpMethod.GET, "/user/find/**").permitAll()
                .antMatchers(HttpMethod.POST, "/user/add").permitAll()
                .antMatchers(HttpMethod.PUT, "/user/update").permitAll()
                .antMatchers(HttpMethod.DELETE, "/user/delete/**").permitAll().and()
                .cors().and()
                .csrf().ignoringAntMatchers("/user/**");
    }
}
