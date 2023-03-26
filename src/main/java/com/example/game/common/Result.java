package com.example.game.common;

import lombok.Data;

@Data
public class Result<T> {
    private int feedback;
    private String msg;
    private T data;

    public static Result<Void> of(FeedbackEnum feedbackEnum) {
        Result<Void> result = new Result<>();
        result.setFeedback(feedbackEnum.getFeedback());
        result.setMsg(feedbackEnum.getMsg());
        return result;
    }

    public static <T> Result<T> of(FeedbackEnum feedbackEnum, T data) {
        Result<T> result = new Result<>();
        result.setFeedback(feedbackEnum.getFeedback());
        result.setMsg(feedbackEnum.getMsg());
        result.setData(data);
        return result;
    }
}
