package com.bharat.AnimeAPI.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AnimeTopAiring {
    private String animeId, animeTitle, animeImg, latestEp, animeUrl;
    private List<String> genres;
}
