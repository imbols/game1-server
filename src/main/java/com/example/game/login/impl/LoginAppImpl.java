package com.example.game.login.impl;

import com.example.game.common.FeedbackEnum;
import com.example.game.common.Result;
import com.example.game.login.LoginApp;
import com.example.game.login.entity.User;
import org.springframework.stereotype.Service;

@Service
public class LoginAppImpl implements LoginApp {
    @Override
    public Result<User> login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return Result.of(FeedbackEnum.SUCCESS, user);
    }
}
