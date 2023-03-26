package com.example.game.app.battle.bean;

import lombok.Data;

import java.util.List;

@Data
public class BattleReport {
    private int state;
    private List<String> recordList;
}
