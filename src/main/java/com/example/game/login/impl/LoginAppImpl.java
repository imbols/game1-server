package com.example.game.login.impl;

import com.example.game.app.role.dao.RoleDao;
import com.example.game.app.role.entity.Role;
import com.example.game.common.FeedbackEnum;
import com.example.game.common.Result;
import com.example.game.login.LoginApp;
import com.example.game.login.dao.UserDao;
import com.example.game.login.entity.User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LoginAppImpl implements LoginApp {
    private final UserDao userDao;
    private final RoleDao roleDao;
    private final Map<String, User> onlineMap = new ConcurrentHashMap<>();

    public LoginAppImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
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
        String token = UUID.randomUUID().toString();
        user.setToken(token);
        this.userDao.save(user);
        this.onlineMap.put(token, user);
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

    @Override
    public Role getRole(String token) {
        User user = this.onlineMap.get(token);
        if (user == null) {
            return null;
        }
        if (user.getRoleId() <= 0) {
            return null;
        }
        return this.roleDao.get(user.getRoleId());
    }

    @Override
    public void onCreateRole(String token, Integer roleId) {
        User user = this.onlineMap.get(token);
        if (user == null) {
            return;
        }
        user.setRoleId(roleId);
        this.userDao.save(user);
    }
}
