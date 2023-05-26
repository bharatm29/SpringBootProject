package com.bharat.AnimeCatalogService.models.animesModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AnimeSearch {
    private List<Anime> animes;
}
