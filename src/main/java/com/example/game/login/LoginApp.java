package com.example.game.login;

import com.example.game.app.role.entity.Role;
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

    /**
     * 根据Token查询角色
     * @param token
     * @return
     */
    Role getRole(String token);

    /**
     * 创建角色时把roleId存到用户上
     * @param token
     * @param roleId
     */
    void onCreateRole(String token, Integer roleId);
}
