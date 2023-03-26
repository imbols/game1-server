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
            return Result.of(FeedbackEnum.USER_MISSING);
        }
        if (!password.equals(user.getPassword())) {
            return Result.of(FeedbackEnum.USER_MISSING);
        }
        return Result.of(FeedbackEnum.SUCCESS, user);
    }
}
