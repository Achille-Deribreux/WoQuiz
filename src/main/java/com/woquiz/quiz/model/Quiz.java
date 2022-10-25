package com.woquiz.quiz.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.woquiz.user.User;
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

    @ManyToOne
    @JoinColumn(name="USER_ID", nullable=false)
    private User user;

    @Column(name = "ATTEMPT_DATE")
    private LocalDate attemptDate;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quiz user(User user){
        setUser(user);
        return this;
    }

    public LocalDate getAttemptDate() {
        return attemptDate;
    }

    public void setAttemptDate(LocalDate attemptDate) {
        this.attemptDate = attemptDate;
    }

    public Quiz attemptDate(LocalDate attemptDate){
        setAttemptDate(attemptDate);
        return this;
    }
}
