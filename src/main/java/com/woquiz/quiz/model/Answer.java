package com.woquiz.quiz.model;

import com.woquiz.user.BaseEntity;
import com.woquiz.user.User;
import com.woquiz.word.model.Word;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ANSWER")
public class Answer extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "WORD_ID")
    private Word word;

    @Column(name = "ANSWER")
    private String answer;

    @Column(name = "RESULT")
    private boolean result = false;

    @ManyToOne
    @JoinColumn( name="QUIZ_ID", nullable=false )
    private Quiz quiz;

    public Answer id(Integer id){
        setId(id);
        return this;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public Answer word (Word word){
        setWord(word);
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Answer answer(String answer){
        setAnswer(answer);
        return this;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Answer result(boolean result){
        setResult(result);
        return this;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Answer user(User user){
        setUser(user);
        return this;
    }
}
