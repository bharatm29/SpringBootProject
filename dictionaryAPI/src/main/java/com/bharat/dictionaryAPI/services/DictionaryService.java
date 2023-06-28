package com.bharat.dictionaryAPI.services;

import com.bharat.dictionaryAPI.models.Dictionary;
import com.bharat.dictionaryAPI.models.WordMeaning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DictionaryService {
    @Value("${api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    public Dictionary getWordMeaning(String word){
        String url = apiUrl + "/" + word;
        ResponseEntity<List<WordMeaning>> meaningResponse = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<WordMeaning>>() {}
        );
        return Dictionary.builder()
                .wordMeanings(meaningResponse.getBody())
                .build();
    }
}
