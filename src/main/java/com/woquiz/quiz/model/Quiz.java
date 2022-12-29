package com.woquiz.quiz.model;

import java.time.LocalDate;
import java.util.List;

import com.woquiz.user.BaseEntity;
import com.woquiz.user.User;
import com.woquiz.word.model.Word;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "QUIZ")
public class Quiz extends BaseEntity {

    @Column(name = "SCORE")
    private Integer score;

    @Column(name = "ATTEMPT_DATE")
    private LocalDate attemptDate;

    @ManyToMany(mappedBy = "quizzes")
    private List<Word> words;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quiz")
    private List<Answer> answers;

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
