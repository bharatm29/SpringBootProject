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
public class Definition {
    private String definition, example;
    private List<String> synonyms, antonyms;
}
