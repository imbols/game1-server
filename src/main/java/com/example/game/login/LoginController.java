package com.example.game.login;

import com.example.game.common.Result;
import com.example.game.login.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class LoginController {
    private final LoginApp loginApp;

    public LoginController(LoginApp loginApp) {
        this.loginApp = loginApp;
    }

    @GetMapping
    public Result<User> login(String username, String password) {
        return this.loginApp.login(username, password);
    }

    @PostMapping
    public Result<User> register(String username, String password) {
        return this.loginApp.register(username, password);
    }
}
