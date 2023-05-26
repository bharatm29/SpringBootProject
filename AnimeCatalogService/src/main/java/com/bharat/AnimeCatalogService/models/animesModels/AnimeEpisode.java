package com.bharat.AnimeCatalogService.models.animesModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AnimeEpisode {
    String episodeId, episodeNum, episodeUrl;
}
