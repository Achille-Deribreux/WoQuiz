package com.woquiz.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.woquiz.word.model.Word;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @Column(name = "ID")
    private Integer id;

    @OneToOne(mappedBy = "id")
    private Word word;

    @Column(name = "ANSWER")
    private String answer;

    @Column(name = "RESULT")
    private boolean result;

    @Column(name = "USER_ID")
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
