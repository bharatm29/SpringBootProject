package com.bharat.dictionaryAPI.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        UrlBasedCorsConfigurationSource corsConfig = new UrlBasedCorsConfigurationSource();
        corsConfig.registerCorsConfiguration("*",
                new CorsConfiguration().applyPermitDefaultValues()
        );
        http.csrf().disable()
                .cors(corsConfigurer -> corsConfigurer.configurationSource(corsConfig))
                .authorizeHttpRequests().anyRequest().permitAll();

        return http.build();
    }
}
