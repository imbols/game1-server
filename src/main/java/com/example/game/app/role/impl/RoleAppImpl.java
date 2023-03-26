package com.example.game.app.role.impl;

import com.example.game.app.role.RoleApp;
import com.example.game.app.role.dao.RoleDao;
import com.example.game.app.role.entity.Role;
import com.example.game.common.FeedbackEnum;
import com.example.game.common.Result;
import com.example.game.login.LoginApp;
import org.springframework.stereotype.Service;

@Service
public class RoleAppImpl implements RoleApp {
    private final LoginApp loginApp;
    private final RoleDao roleDao;

    public RoleAppImpl(LoginApp loginApp, RoleDao roleDao) {
        this.loginApp = loginApp;
        this.roleDao = roleDao;
    }

    @Override
    public Result<Role> create(String token, String roleName) {
        Role role = new Role();
        role.setRoleName(roleName);
        role.setLevel(1);
        this.roleDao.save(role);
        this.loginApp.onCreateRole(token, role.getRoleId());
        return Result.of(FeedbackEnum.SUCCESS, role);
    }
}
