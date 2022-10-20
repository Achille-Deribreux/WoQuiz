package com.woquiz.quiz.dto;

public class QuizCriteria {

    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public QuizCriteria userId(Integer userId){
        setUserId(userId);
        return this;
    }
}
