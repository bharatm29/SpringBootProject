package com.bharat.UserCatalogService.resources;

import com.bharat.UserCatalogService.models.User;
import com.bharat.UserCatalogService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public @ResponseBody String addUser(@RequestBody User user){
        userService.addUser(user);
        return "added the user";
    }
}
