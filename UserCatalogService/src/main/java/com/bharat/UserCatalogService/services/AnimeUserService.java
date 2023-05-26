package com.bharat.UserCatalogService.services;

import com.bharat.UserCatalogService.models.AnimeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimeUserService {
    @Autowired
    private AnimeUserRepository animeUserRepository;

    public void addUser(AnimeUser animeUser){
        animeUserRepository.save(animeUser);
    }

    public void updateUser(AnimeUser animeUser){
        animeUserRepository.save(animeUser);
    }

    public AnimeUser getUser(String email){
        return animeUserRepository.findById(email).orElse(
                AnimeUser.builder().email("Not found").build()
        );
    }

    public void deleteUser(String email){
        animeUserRepository.deleteById(email);
    }
}
