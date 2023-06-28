package com.bharat.dictionaryAPI.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WordMeaning {
    private String word;
    private List<Phonetic> phonetics;
    private List<Meaning> meanings;
    private List<String> sourceUrls;
}
