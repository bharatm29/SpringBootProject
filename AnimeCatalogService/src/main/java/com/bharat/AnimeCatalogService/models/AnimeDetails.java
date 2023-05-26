package com.bharat.AnimeCatalogService.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AnimeDetails {
    private String animeTitle, type, synopsis, releasedDate, status, animeImg;
    private List<String> genres;

    private String episodesAvaliable;

    private List<AnimeEpisode> episodesList;
}
