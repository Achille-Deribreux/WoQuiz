package com.woquiz.word;

import com.woquiz.word.model.Word;

public final class UpdateWordHelper {
    private final Word word;

    private UpdateWordHelper(Word word) {
        this.word = word;
    }

    public static UpdateWordHelper of(Word word) {
        return new UpdateWordHelper(word);
    }

    public UpdateWordHelper id(Integer id) {
        if(id != null && !id.equals(word.getId())){
            word.setId(id);
        }
        return this;
    }

    public UpdateWordHelper basicWord(String basicWord) {
        if(basicWord != null && !basicWord.equals(word.getBasicWord())){
            word.setBasicWord(basicWord);
        }
        return this;
    }

    public UpdateWordHelper translation(String translation) {
        if(translation != null && !translation.equals(word.getTranslation())){
            word.setTranslation(translation);
        }
        return this;
    }

    public UpdateWordHelper status(Word.WordStatus status) {
        if(status != null && !status.equals(word.getStatus())){
            word.setStatus(status);
        }
        return this;
    }

    public UpdateWordHelper level(Word.WordLevel level) {
        if(level != null && !level.equals(word.getLevel())){
            word.setLevel(level);
        }
        return this;
    }

    public UpdateWordHelper userId(Integer userId) {
        if(userId != null && !userId.equals(word.getUserId())){
            word.setUserId(userId);
        }
        return this;
    }

    public Word build(Word wordBody) {
       this
           .basicWord(wordBody.getBasicWord())
           .translation(wordBody.getTranslation())
           .status(wordBody.getStatus())
           .level(wordBody.getLevel())
           .userId(wordBody.getUserId());
       return word;
    }
}
