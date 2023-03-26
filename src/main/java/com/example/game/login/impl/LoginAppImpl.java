package com.example.game.login.impl;

import com.example.game.common.FeedbackEnum;
import com.example.game.common.Result;
import com.example.game.login.LoginApp;
import com.example.game.login.dao.UserDao;
import com.example.game.login.entity.User;
import org.springframework.stereotype.Service;

@Service
public class LoginAppImpl implements LoginApp {
    private final UserDao userDao;

    public LoginAppImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result<User> login(String username, String password) {
        User user = this.userDao.get(username);
        if (user == null) {
            return Result.of(FeedbackEnum.USER_MISSING);
        }
        if (password == null || "".equals(password.trim())) {
            return Result.of(FeedbackEnum.PASSWORD_EMPTY);
        }
        if (!password.equals(user.getPassword())) {
            return Result.of(FeedbackEnum.PASSWORD_ERROR);
        }
        return Result.of(FeedbackEnum.SUCCESS, user);
    }

    @Override
    public Result<User> register(String username, String password) {
        User user = this.userDao.get(username);
        if (user != null) {
            return Result.of(FeedbackEnum.USER_REPEAT);
        }
        if (password == null || "".equals(password.trim())) {
            return Result.of(FeedbackEnum.PASSWORD_EMPTY);
        }
        user = new User();
        user.setUsername(username);
        user.setPassword(password);
        this.userDao.save(user);
        return Result.of(FeedbackEnum.SUCCESS, user);
    }
}
