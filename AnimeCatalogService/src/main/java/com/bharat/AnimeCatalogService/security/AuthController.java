package com.bharat.AnimeCatalogService.security;

import com.bharat.AnimeCatalogService.security.models.AuthResponse;
import com.bharat.AnimeCatalogService.security.models.UserAuthenticate;
import com.bharat.AnimeCatalogService.security.models.UserRegister;
import com.bharat.AnimeCatalogService.security.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public @ResponseBody AuthResponse registerUser(@RequestBody UserRegister userRegister){
        return authService.register(userRegister);
    }

    @PostMapping("/authenticate")
    public @ResponseBody AuthResponse authenticateUser(@RequestBody UserAuthenticate userAuth){
        return authService.authenticate(userAuth);
    }
}
