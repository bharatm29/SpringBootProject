package com.bharat.UserCatalogService.services;

import com.bharat.UserCatalogService.models.AnimeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimeUserService {
    @Autowired
    private AnimeUserRepository animeUserRepository;

    public void addUser(AnimeUser animeUser){
        AnimeUser saveUser = animeUserRepository.findById(animeUser.getEmail()).orElse(null);

        if(saveUser != null){
            List<String> ids = List.copyOf(saveUser.getAnimeIds());
            animeUser.getAnimeIds().addAll(ids);
        }

        animeUserRepository.save(animeUser);
    }

    public void updateUser(AnimeUser animeUser){
        AnimeUser saveUser = animeUserRepository.findById(animeUser.getEmail()).orElse(null);

        if(saveUser != null){
            saveUser.getAnimeIds().forEach(animeId -> {
                animeUser.getAnimeIds().add(0, animeId);
            });
        }

        animeUserRepository.save(animeUser);
    }

    public AnimeUser getUser(String email){
        return animeUserRepository.findById(email).orElse(
                AnimeUser.builder().email("Not found").animeIds(List.of("No animeIds available")).build()
        );
    }

    public void deleteUser(String email){
        animeUserRepository.deleteById(email);
    }
}
