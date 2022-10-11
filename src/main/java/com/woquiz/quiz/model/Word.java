package com.woquiz.quiz.model;


public class Word {

    private Integer id;
    private String basicWord;
    private String translation;
    private WordStatus status;
    private WordLevel level;
    private Integer userId;

    public enum WordStatus {
        ACITVE, INACTIVE
    }

    public enum WordLevel {
        NEW, EASY, MEDIUM, HARD
    }
}
