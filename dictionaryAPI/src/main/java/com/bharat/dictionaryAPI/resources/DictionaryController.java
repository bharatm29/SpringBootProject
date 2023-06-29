package com.bharat.dictionaryAPI.resources;

import com.bharat.dictionaryAPI.models.Dictionary;
import com.bharat.dictionaryAPI.services.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://192.168.0.102:4001")
@RequestMapping("/api")
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/wordmeaning/{word}")
    public Dictionary getWorkMeaning(@PathVariable String word) {
        return dictionaryService.getWordMeaning(word);
    }
}
