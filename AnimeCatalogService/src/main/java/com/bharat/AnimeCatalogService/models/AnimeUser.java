package com.bharat.AnimeCatalogService.models;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AnimeUser {
    private String email;
    private List<String> animeIds;
}
