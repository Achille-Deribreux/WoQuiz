package com.woquiz.word.model;

import com.woquiz.quiz.model.Answer;
import com.woquiz.quiz.model.Quiz;

public class WordHistory {

    private Integer id;
    private Quiz quiz;
    private Answer answer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public WordHistory id(Integer id){
        setId(id);
        return this;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public WordHistory quiz(Quiz quiz){
        setQuiz(quiz);
        return this;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public WordHistory answer(Answer answer){
        setAnswer(answer);
        return this;
    }
}
