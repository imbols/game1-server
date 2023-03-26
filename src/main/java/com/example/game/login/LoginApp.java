package com.example.game.login;

import com.example.game.common.Result;
import com.example.game.login.entity.User;

public interface LoginApp {
    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    Result<User> login(String username, String password);

    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    Result<User> register(String username, String password);
}
