package com.woquiz.word.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "word")
public class Word {

    @Id
    @Column(name="ID")
    private Integer id;

    @Column(name="BASIC_WORD")
    private String basicWord;

    @Column(name="TRANSLATION")
    private String translation;

    @Column(name="STATUS")
    private WordStatus status;

    @Column(name="LEVEL")
    private WordLevel level;

    @Column(name="USER_ID")
    private Integer userId;

    public enum WordStatus {
        ACITVE, INACTIVE
    }

    public enum WordLevel {
        NEW, EASY, MEDIUM, HARD
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Word userId(Integer userId){
        setUserId(userId);
        return this;
    }
}
