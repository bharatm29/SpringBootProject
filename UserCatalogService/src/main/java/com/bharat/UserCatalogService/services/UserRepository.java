package com.bharat.UserCatalogService.services;

import com.bharat.UserCatalogService.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
    public User findByEmail(String email);

    @Transactional
    public void deleteByEmail(String email);
}
