package com.example.game.login.dao;

import com.example.game.login.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserDao {
    private final Map<String, User> userMap = new ConcurrentHashMap<>();

    public User get(String username) {
        return this.userMap.get(username);
    }

    public User save(User user) {
        return this.userMap.put(user.getUsername(), user);
    }
}
