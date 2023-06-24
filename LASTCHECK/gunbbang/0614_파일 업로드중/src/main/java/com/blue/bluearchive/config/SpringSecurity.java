package com.blue.bluearchive.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurity  {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                // ...
//                .headers()
//                .frameOptions()
//                .sameOrigin()
//                .and();
//        // ...
//    }
}
