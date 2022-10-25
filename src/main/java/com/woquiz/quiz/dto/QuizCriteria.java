package com.woquiz.quiz.dto;

import java.time.LocalDate;

public class QuizCriteria {

    private Integer userId;
    private LocalDate attemptDateAfter;

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

    public LocalDate getAttemptDateAfter() {
        return attemptDateAfter;
    }

    public void setAttemptDateAfter(LocalDate attemptDateAfter) {
        this.attemptDateAfter = attemptDateAfter;
    }

    public QuizCriteria attemptDateAfter(LocalDate attemptDateAfter){
        setAttemptDateAfter(attemptDateAfter);
        return this;
    }
}
