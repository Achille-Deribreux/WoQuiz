package com.woquiz.quiz.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.woquiz.word.model.Word;

public class  Quiz {

    @Id
    @Column(name = "ID")
    private Integer id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Word> words;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Answer> answers;

    @Column(name = "SCORE")
    private Integer score;

    @Column(name = "USER_ID")
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Quiz id(Integer id){
        setId(id);
        return this;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public Quiz words(List<Word> wordList){
        setWords(wordList);
        return this;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Quiz answers(List<Answer> answers){
        setAnswers(answers);
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Quiz score (Integer score){
        setScore(score);
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Quiz userId(Integer userId){
        setUserId(userId);
        return this;
    }
}
