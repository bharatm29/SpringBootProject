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
public class AnimeDetails {
    private String animeTitle, type, releasedDate, status, synopsis, animeImg, episodesAvaliable;
    private List<String> genres;

    private List<AnimeEpisode> episodesList;
}
