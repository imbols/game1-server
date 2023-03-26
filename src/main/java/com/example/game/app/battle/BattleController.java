package com.example.game.app.battle;

import com.example.game.app.battle.bean.BattleReport;
import com.example.game.app.role.entity.Role;
import com.example.game.common.FeedbackEnum;
import com.example.game.common.Result;
import com.example.game.login.LoginApp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/battle")
public class BattleController {
    private final LoginApp loginApp;

    public BattleController(LoginApp loginApp) {
        this.loginApp = loginApp;
    }

    @GetMapping
    public Result<BattleReport> battle(String token) {
        Role role = this.loginApp.getRole(token);
        if (role == null) {
            return Result.of(FeedbackEnum.USER_MISSING);
        }
        BattleReport battleReport = new BattleReport();
        battleReport.setState(1);
        battleReport.setRecordList(Collections.singletonList(role.getRoleName() + "发起攻击"));
        return Result.of(FeedbackEnum.SUCCESS, battleReport);
    }
}
