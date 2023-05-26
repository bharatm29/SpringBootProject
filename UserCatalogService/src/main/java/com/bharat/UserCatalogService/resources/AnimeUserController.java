package com.bharat.UserCatalogService.resources;

import com.bharat.UserCatalogService.models.AnimeResponse;
import com.bharat.UserCatalogService.models.AnimeUser;
import com.bharat.UserCatalogService.services.AnimeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/anime/user")
public class AnimeUserController {
    @Autowired
    private AnimeUserService animeUserService;

    @PostMapping("/add")
    public @ResponseBody AnimeResponse addAnimeUser(@RequestBody AnimeUser animeUser){
        animeUserService.addUser(animeUser);
        return AnimeResponse.builder().message("Added the user").build();
    }

    @PatchMapping("/{email}")
    public @ResponseBody AnimeResponse updateAnimeUser(@PathVariable String email, @RequestBody AnimeUser animeUser){
        animeUserService.updateUser(animeUser);
        return AnimeResponse.builder().message("Updated the user").build();
    }

    @GetMapping("/{email}")
    public @ResponseBody AnimeUser getUser(@PathVariable String email){
        return animeUserService.getUser(email);
    }

    @DeleteMapping("/delete/{email}")
    public @ResponseBody AnimeResponse deleteUser(@PathVariable String email){
        animeUserService.deleteUser(email);
        return AnimeResponse.builder().message("deleted the user").build();
    }
}
