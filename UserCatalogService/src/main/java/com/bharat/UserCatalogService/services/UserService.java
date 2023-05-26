package com.bharat.UserCatalogService.services;

import com.bharat.UserCatalogService.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

    public void updateUser(User user){
        userRepository.save(user);
    }

    public User findUser(String email){
        return userRepository.findByEmail(email);
    }

    public void deleteUser(String email){
        userRepository.deleteByEmail(email);
    }
}
