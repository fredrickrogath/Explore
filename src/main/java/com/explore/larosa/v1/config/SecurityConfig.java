package com.explore.larosa.v1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/", "/home").permitAll();
            auth.anyRequest().authenticated();
        }).oauth2Login(oauth2Login -> oauth2Login
                // .loginPage("/login")
                .failureUrl("/login?error=true")
        ).build();

        // http
		// 	.authorizeHttpRequests(authorize -> authorize
		// 		.anyRequest().permitAll()
		// 	)
		// 	.oauth2Login(oauth2Login -> oauth2Login
        //             // .loginPage("/login")
        //             .failureUrl("/login?error=true"));
		// return http.build();
    }
}
