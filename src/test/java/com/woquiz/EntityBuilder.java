package com.woquiz;

import com.woquiz.quiz.model.Word;

public class EntityBuilder {
    private EntityBuilder() {
    }

    public static Word getWord(){
        return new Word()
                .id(1)
                .basicWord("bonjour")
                .translation("hello")
                .wordStatus(Word.WordStatus.ACITVE)
                .level(Word.WordLevel.NEW)
                .userId(1);

    }
}
