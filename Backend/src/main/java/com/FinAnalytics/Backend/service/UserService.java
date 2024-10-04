package com.FinAnalytics.Backend.service;

import com.FinAnalytics.Backend.models.User;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    Optional<User> getUserById(Long userId);
    Optional<User> getUserByEmail(String email);
    // Additional methods as needed
}