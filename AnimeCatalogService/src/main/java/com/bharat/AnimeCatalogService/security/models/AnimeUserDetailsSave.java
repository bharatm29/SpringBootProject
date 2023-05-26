package com.bharat.AnimeCatalogService.security.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimeUserDetailsSave {
    private String username, email, password;
}
