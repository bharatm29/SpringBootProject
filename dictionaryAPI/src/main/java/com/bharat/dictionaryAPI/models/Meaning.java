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
public class Meaning {
    private String partOfSpeech;
    private List<Definition> definitions;
    private List<String> synonyms, antonyms;
}
