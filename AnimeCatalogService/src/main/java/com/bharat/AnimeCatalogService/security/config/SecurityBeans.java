package com.bharat.AnimeCatalogService.security.config;

import com.bharat.AnimeCatalogService.security.models.AnimeUserDetails;
import com.bharat.AnimeCatalogService.security.models.AnimeUserDetailsSave;
import com.bharat.AnimeCatalogService.security.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityBeans {
    @Bean
    public UserDetailsService getUserDetails(PasswordEncoder passwordEncoder, UserService userService){
        return username -> {
            AnimeUserDetailsSave animeUserDetails = userService.getUserDetails(username);
            System.out.println(animeUserDetails);

            return AnimeUserDetails.builder()
                    .username(animeUserDetails.getUsername())
                    .password(passwordEncoder.encode(animeUserDetails.getPassword()))
                    .email(animeUserDetails.getEmail())
                    .build();
        };
    }

    @Bean
    public AuthenticationManager getAuthManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider getAuthProvider(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setPasswordEncoder(passwordEncoder);
        authProvider.setUserDetailsService(userDetailsService);

        return authProvider;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
