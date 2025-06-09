package com.nimisha.SpringSecEx.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configurable
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain springSecurityFilterChain(HttpSecurity http) throws Exception {
       return http
                .csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request->request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();

    }

}
