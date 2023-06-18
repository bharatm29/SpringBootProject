package com.bharat.weatherapi.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityService {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        UrlBasedCorsConfigurationSource corsConfig = new UrlBasedCorsConfigurationSource();
        corsConfig.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        http
                .cors(corsConfigurer -> corsConfigurer.configurationSource(corsConfig))
                .csrf().disable()
                .authorizeHttpRequests().anyRequest().permitAll();

        return http.build();
    }
}
