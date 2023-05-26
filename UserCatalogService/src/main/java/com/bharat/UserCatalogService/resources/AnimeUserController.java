package com.bharat.UserCatalogService.resources;

import com.bharat.UserCatalogService.models.AnimeUser;
import com.bharat.UserCatalogService.services.AnimeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/anime")
public class AnimeUserController {
    @Autowired
    private AnimeUserService animeUserService;

    @PostMapping("/add")
    public @ResponseBody String addAnimeUser(@RequestBody AnimeUser animeUser){
        animeUserService.addUser(animeUser);
        return "added the user";
    }

    @PutMapping("/update/{email}")
    public @ResponseBody String updateAnimeUser(@PathVariable String email, @RequestBody AnimeUser animeUser){
        animeUserService.updateUser(animeUser);
        return "updated the user";
    }

    @GetMapping("/user/{email}")
    public @ResponseBody AnimeUser getUser(@PathVariable String email){
        return animeUserService.getUser(email);
    }

    @DeleteMapping("/delete/{email}")
    public @ResponseBody String deleteUser(@PathVariable String email){
        animeUserService.deleteUser(email);
        return "deleted the user";
    }
}
