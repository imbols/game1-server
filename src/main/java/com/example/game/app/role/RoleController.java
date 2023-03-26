package com.example.game.app.role;

import com.example.game.app.role.entity.Role;
import com.example.game.common.FeedbackEnum;
import com.example.game.common.Result;
import com.example.game.login.LoginApp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    private final LoginApp loginApp;
    private final RoleApp roleApp;

    public RoleController(LoginApp loginApp, RoleApp roleApp) {
        this.loginApp = loginApp;
        this.roleApp = roleApp;
    }

    @PostMapping
    public Result<Role> create(String token, String roleName) {
        return this.roleApp.create(token, roleName);
    }

    @PostMapping("/level")
    public Result<Role> levelUp(String token) {
        Role role = this.loginApp.getRole(token);
        role.setLevel(role.getLevel() + 1);
        return Result.of(FeedbackEnum.SUCCESS, role);
    }
}
