package com.example.game.common;

import lombok.Getter;

@Getter
public enum FeedbackEnum {
    SUCCESS(1000),

    USER_MISSING(2001, "用户不存在"),
    PASSWORD_ERROR(2002, "密码错误"),
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
