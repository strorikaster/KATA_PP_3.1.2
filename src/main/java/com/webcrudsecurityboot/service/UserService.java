package com.webcrudsecurityboot.service;

import com.webcrudsecurityboot.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    List<User> fetchUserList();
    User show(Long id);
    //Optional<User> findById(Long id);
    void saveUser(User user);
    void update(User updatedUser/*, Long id*/);
    void delete(Long id);
    UserDetails loadUserByUsername(String name);
}
