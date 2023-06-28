package com.bharat.dictionaryAPI.resources;

import com.bharat.dictionaryAPI.models.Dictionary;
import com.bharat.dictionaryAPI.services.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/wordmeaning/{word}")
    public Dictionary getWorkMeaning(@PathVariable String word) {
        return dictionaryService.getWordMeaning(word);
    }
}
