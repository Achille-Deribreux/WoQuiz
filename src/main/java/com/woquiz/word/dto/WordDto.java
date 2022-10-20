package com.woquiz.word.dto;

import com.woquiz.word.model.Word;

public class WordDto {

    private Integer id;

    private String basicWord;

    private String translation;

    private Word.WordStatus status;

    private Word.WordLevel level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public WordDto id(Integer id){
        setId(id);
        return this;
    }

    public String getBasicWord() {
        return basicWord;
    }

    public void setBasicWord(String basicWord) {
        this.basicWord = basicWord;
    }

    public WordDto basicWord(String basicWord){
        setBasicWord(basicWord);
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public WordDto translation(String translation){
        setTranslation(translation);
        return this;
    }

    public Word.WordStatus getStatus() {
        return status;
    }

    public void setStatus(Word.WordStatus status) {
        this.status = status;
    }

    public WordDto wordStatus(Word.WordStatus status){
        setStatus(status);
        return this;
    }

    public Word.WordLevel getLevel() {
        return level;
    }

    public void setLevel(Word.WordLevel level) {
        this.level = level;
    }

    public WordDto level(Word.WordLevel level){
        setLevel(level);
        return this;
    }
}
