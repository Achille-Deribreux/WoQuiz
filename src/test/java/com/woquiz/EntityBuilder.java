package com.woquiz;

import com.woquiz.word.model.Word;

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

    public static Word getAnotherWord(){
        return new Word()
                .id(2)
                .basicWord("Hello World, I'm John Doe")
                .translation("Bonjour, je suis John Doe")
                .wordStatus(Word.WordStatus.INACTIVE)
                .level(Word.WordLevel.EASY)
                .userId(2);
    }
}
