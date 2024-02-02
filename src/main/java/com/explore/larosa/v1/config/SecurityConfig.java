package com.explore.larosa.v1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/", "/home","/secured","/api/users/register","/api/users/login").permitAll();
            auth.anyRequest().authenticated();
        }).oauth2Login(oauth2Login -> oauth2Login
                // .loginPage("/login")
                .failureUrl("/login?error=true")
        )
        .exceptionHandling()
            .authenticationEntryPoint(authenticationEntryPoint()) // Specify the custom entry point
        .and().build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, authException) -> {
            response.sendRedirect("/login"); // Redirect to the login page in case of authentication failure
        };
    }
}

