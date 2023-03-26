package com.example.game.login.dao;

import com.example.game.login.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDao {
    private final UserRepository userRepository;

    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User get(String username) {
        Optional<User> optional = this.userRepository.findById(username);
        return optional.orElse(null);
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }
}
