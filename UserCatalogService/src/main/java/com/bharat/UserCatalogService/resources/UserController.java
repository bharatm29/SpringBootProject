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
    public String addUser(@RequestBody User user){
        userService.addUser(user);
        return "Added the user";
    }

    @GetMapping("/{email}")
    public @ResponseBody User getUser(@PathVariable String email){
        User user =  userService.findUser(email);
        return user;
    }

    @DeleteMapping("/{email}")
    public @ResponseBody String deleteUser(@PathVariable String email){
        userService.deleteUser(email);
        return "deleted the user";
    }
}
