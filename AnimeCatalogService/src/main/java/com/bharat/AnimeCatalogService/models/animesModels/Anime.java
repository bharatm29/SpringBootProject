package com.bharat.AnimeCatalogService.models.animesModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Anime {
    private String animeId, animeTitle, animeUrl, animeImg, status;
}
