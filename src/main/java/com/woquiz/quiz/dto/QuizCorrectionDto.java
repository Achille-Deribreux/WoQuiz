package com.woquiz.quiz.dto;

import java.util.List;

public class QuizCorrectionDto {

    private Integer goodAnswers;
    private Integer askedQuestions;
    private List<AnswerCorrectionDto> answerCorrectionDtoList;

    public Integer getGoodAnswers() {
        return goodAnswers;
    }

    public void setGoodAnswers(Integer goodAnswers) {
        this.goodAnswers = goodAnswers;
    }

    public QuizCorrectionDto goodAnswers(Integer goodAnswers){
        setGoodAnswers(goodAnswers);
        return this;
    }

    public Integer getAskedQuestions() {
        return askedQuestions;
    }

    public void setAskedQuestions(Integer askedQuestions) {
        this.askedQuestions = askedQuestions;
    }

    public QuizCorrectionDto askedQuestions(Integer askedQuestions){
        setAskedQuestions(askedQuestions);
        return this;
    }

    public List<AnswerCorrectionDto> getAnswerCorrectionDtoList() {
        return answerCorrectionDtoList;
    }

    public void setAnswerCorrectionDtoList(List<AnswerCorrectionDto> answerCorrectionDtoList) {
        this.answerCorrectionDtoList = answerCorrectionDtoList;
    }

    public QuizCorrectionDto answerCorrectionList(List<AnswerCorrectionDto> answerCorrectionDtoList){
        setAnswerCorrectionDtoList(answerCorrectionDtoList);
        return this;
    }
}
