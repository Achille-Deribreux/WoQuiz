package com.woquiz.word.dto;

import java.util.List;

import com.woquiz.word.model.Word;

public class WordCriteria {

    private String basicWordContains;
    private String translationContains;
    private List<Word.WordStatus> status;
    private List<Word.WordLevel> level;
    private Integer userId;
    private Integer pageNr;
    private Integer pageSize;

    public String getBasicWordContains() {
        return basicWordContains;
    }

    public void setBasicWordContains(String basicWordContains) {
        this.basicWordContains = basicWordContains;
    }

    public WordCriteria basicWordContains(String basicWordContains){
        setBasicWordContains(basicWordContains);
        return this;
    }

    public String getTranslationContains() {
        return translationContains;
    }

    public void setTranslationContains(String translationContains) {
        this.translationContains = translationContains;
    }

    public WordCriteria translationContains(String translationContains){
        setTranslationContains(translationContains);
        return this;
    }

    public List<Word.WordStatus> getStatus() {
        return status;
    }

    public void setStatus(List<Word.WordStatus> status) {
        this.status = status;
    }

    public WordCriteria status(List<Word.WordStatus> status){
        setStatus(status);
        return this;
    }

    public List<Word.WordLevel> getLevel() {
        return level;
    }

    public void setLevel(List<Word.WordLevel> level) {
        this.level = level;
    }

    public WordCriteria level(List<Word.WordLevel> level){
        setLevel(level);
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public WordCriteria userId(Integer userId){
        setUserId(userId);
        return this;
    }

    public Integer getPageNr() {
        return pageNr;
    }

    public void setPageNr(Integer pageNr) {
        this.pageNr = pageNr;
    }

    public WordCriteria pageNr(Integer pageNr){
        setPageNr(pageNr);
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public WordCriteria pageSize(Integer pageSize){
        setPageSize(pageSize);
        return this;
    }
}
