package com.woquiz.word.model;

import java.util.List;

import com.woquiz.quiz.model.Quiz;
import com.woquiz.common.BaseEntity;
import com.woquiz.user.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "word")
public class Word extends BaseEntity {

    @Column(name = "BASIC_WORD")
    private String basicWord;

    @Column(name = "TRANSLATION")
    private String translation;

    @Column(name = "STATUS")
    private WordStatus status;

    @Column(name = "LEVEL")
    private WordLevel level;

    @Column(name = "NR_ASKED")
    private Integer nrAsked = 0;

    @Column(name = "NR_GOOD_ANSWERS")
    private Integer nrGoodAnswers = 0;

    @ManyToMany
    private List<Quiz> quizzes;

    public enum WordStatus {
        ACITVE, INACTIVE
    }

    public enum WordLevel {
        NEW, EASY, MEDIUM, HARD
    }

    public Word id(Integer id){
        setId(id);
        return this;
    }

    public String getBasicWord() {
        return basicWord;
    }

    public void setBasicWord(String basicWord) {
        this.basicWord = basicWord;
    }

    public Word basicWord(String basicWord){
        setBasicWord(basicWord);
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public Word translation(String translation){
        setTranslation(translation);
        return this;
    }

    public WordStatus getStatus() {
        return status;
    }

    public void setStatus(WordStatus status) {
        this.status = status;
    }

    public Word wordStatus(WordStatus status){
        setStatus(status);
        return this;
    }

    public WordLevel getLevel() {
        return level;
    }

    public void setLevel(WordLevel level) {
        this.level = level;
    }

    public Word level(WordLevel level){
        setLevel(level);
        return this;
    }

    public Integer getNrAsked() {
        return nrAsked;
    }

    public void increaseNrAsked() {
        this.nrAsked ++;
    }

    public Word nrAsked(Integer nrAsked){
        this.nrAsked = nrAsked;
        return this;
    }

    public Integer getNrGoodAnswers() {
        return nrGoodAnswers;
    }

    public void increaseGoodAnswers() {
        this.nrGoodAnswers ++;
    }

    public Word nrGoodAnswers(Integer nrGoodAnswers){
        this.nrGoodAnswers = nrGoodAnswers;
        return this;
    }

    public Word user (User user){
        setUser(user);
        return this;
    }
}
