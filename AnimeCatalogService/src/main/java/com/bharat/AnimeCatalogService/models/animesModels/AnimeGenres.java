package com.bharat.AnimeCatalogService.models.animesModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AnimeGenres {
    private String animeId, animeTitle, animeImg, releasedDate, animeUrl;
}
