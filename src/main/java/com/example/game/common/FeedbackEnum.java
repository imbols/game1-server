package com.example.game.common;

import lombok.Getter;

@Getter
public enum FeedbackEnum {
    SUCCESS(1000),

    USER_MISSING(2001, "用户不存在"),
    USER_REPEAT(2002,"用户重复"),
    PASSWORD_ERROR(2003, "密码错误"),
    PASSWORD_EMPTY(2004,"密码为空"),
    ;

    private final int feedback;
    private String msg;

    FeedbackEnum(int feedback) {
        this.feedback = feedback;
    }

    FeedbackEnum(int feedback, String msg) {
        this.feedback = feedback;
        this.msg = msg;
    }
}
