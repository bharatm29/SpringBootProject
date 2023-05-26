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
        System.out.println(user);
        userService.addUser(user);
        return "Added the user";
    }

    @GetMapping("/{email}")
    public @ResponseBody User getUser(@PathVariable String email){
        return userService.findUser(email);
    }

    @DeleteMapping("/{email}")
    public @ResponseBody String deleteUser(@PathVariable String email){
        userService.deleteUser(email);
        return "deleted the user";
    }
}
