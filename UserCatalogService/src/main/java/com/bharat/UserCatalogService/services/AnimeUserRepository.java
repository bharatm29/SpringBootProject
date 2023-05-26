package com.bharat.UserCatalogService.services;

import com.bharat.UserCatalogService.models.AnimeUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AnimeUserRepository extends MongoRepository<AnimeUser, String> {

}
