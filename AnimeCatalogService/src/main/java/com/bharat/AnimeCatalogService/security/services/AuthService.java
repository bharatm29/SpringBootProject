package com.bharat.AnimeCatalogService.security.services;

import com.bharat.AnimeCatalogService.security.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authManager;

    public AuthResponse register(UserRegister userRegister){
        if (userService.getUserDetails(userRegister.getEmail()) != null){
            return AuthResponse.builder().JWT("User already register. Please consider authenticating").build();
        }

        AnimeUserDetails userDetails = AnimeUserDetails.builder()
                                        .email(userRegister.getEmail())
                                        .password(userRegister.getPassword())
                                        .username(userRegister.getUsername())
                                        .build();

        userService.addUser(userDetails);

        String jwt = jwtService.generateToken(userDetails);

        return AuthResponse.builder().JWT(jwt).build();
    }

    public AuthResponse authenticate(UserAuthenticate userAuthenticate){
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userAuthenticate.getEmail(),
                        userAuthenticate.getPassword()
                )
        );

        AnimeUserDetailsSave animeUserDetails = userService.getUserDetails(userAuthenticate.getEmail());
        AnimeUserDetails userDetails =  AnimeUserDetails.builder()
                                            .username(animeUserDetails.getUsername())
                                            .password(animeUserDetails.getPassword())
                                            .email(animeUserDetails.getEmail())
                                            .build();

        String jwt = jwtService.generateToken(userDetails);

        return AuthResponse.builder().JWT(jwt).build();
    }
}
