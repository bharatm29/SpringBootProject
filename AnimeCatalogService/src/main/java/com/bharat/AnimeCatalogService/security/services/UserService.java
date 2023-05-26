package com.bharat.AnimeCatalogService.security.services;

import com.bharat.AnimeCatalogService.security.models.AnimeUserDetails;
import com.bharat.AnimeCatalogService.security.models.AnimeUserDetailsSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;

    final String USER_URI = "http://USERSERVICE/user/";

    public AnimeUserDetailsSave getUserDetails(String email){
        return restTemplate.getForObject(USER_URI + email, AnimeUserDetailsSave.class);
    }

    public void addUser(AnimeUserDetails userDetails){
        AnimeUserDetailsSave saveUserDetails = AnimeUserDetailsSave.builder()
                .username(userDetails.getRealUsername())
                .password(userDetails.getPassword())
                .email(userDetails.getUsername())
                .build();
        RequestEntity<AnimeUserDetailsSave> requestEntity = RequestEntity.post(USER_URI + "add").contentType(MediaType.APPLICATION_JSON).body(saveUserDetails);
        restTemplate.exchange(USER_URI + "add", HttpMethod.POST, requestEntity, String.class);
    }
}
