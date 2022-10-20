package com.woquiz.quiz.dto;

import java.util.List;

public class TakeQuizDto {

    private Integer quizId;
    private List<String> wordList;

    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public TakeQuizDto quizId(Integer quizId){
        setQuizId(quizId);
        return this;
    }

    public List<String> getWordList() {
        return wordList;
    }

    public void setWordList(List<String> wordList) {
        this.wordList = wordList;
    }

    public TakeQuizDto wordList(List<String> wordList){
        setWordList(wordList);
        return this;
    }
}
