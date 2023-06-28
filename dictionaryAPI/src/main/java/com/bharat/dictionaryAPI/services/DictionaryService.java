package com.bharat.dictionaryAPI.services;

import com.bharat.dictionaryAPI.models.Dictionary;
import com.bharat.dictionaryAPI.models.WordMeaning;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ExecutorService;

@Service
public class DictionaryService {
    @Value("${api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "wordMeaning-cb", fallbackMethod = "getWordMeaningFallback")
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

    public Dictionary getWordMeaningFallback(String word, Exception e){
        WordMeaning wordMeaning = WordMeaning.builder()
                .word("Not found")
                .build();
        return Dictionary.builder()
                .wordMeanings(
                        List.of(wordMeaning)
                )
                .build();
    }
}
