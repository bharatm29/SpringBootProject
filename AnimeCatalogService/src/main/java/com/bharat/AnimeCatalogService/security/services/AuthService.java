package com.bharat.AnimeCatalogService.security.services;

import com.bharat.AnimeCatalogService.security.models.AnimeUserDetails;
import com.bharat.AnimeCatalogService.security.models.AnimeUserDetailsSave;
import com.bharat.AnimeCatalogService.security.models.UserAuthenticate;
import com.bharat.AnimeCatalogService.security.models.UserRegister;
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

    public String register(UserRegister userRegister){
        AnimeUserDetails userDetails = AnimeUserDetails.builder()
                .email(userRegister.getEmail())
                .password(userRegister.getPassword())
                .username(userRegister.getUsername())
                .build();

        userService.addUser(userDetails);

        return jwtService.generateToken(userDetails);
    }

    public String authenticate(UserAuthenticate userAuthenticate){
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userAuthenticate.getEmail(),
                        userAuthenticate.getPassword()
                )
        );

        AnimeUserDetailsSave animeUserDetails = userService.getUserDetails(userAuthenticate.getEmail());
        return jwtService.generateToken(
                AnimeUserDetails.builder()
                        .username(animeUserDetails.getUsername())
                        .password(animeUserDetails.getPassword())
                        .email(animeUserDetails.getEmail())
                        .build()
        );
    }
}
