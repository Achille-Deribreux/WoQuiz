package com.woquiz;

import com.woquiz.user.User;
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
                .user(getUser());
    }

    public static Word getAnotherWord(){
        return new Word()
                .id(2)
                .basicWord("Hello World, I'm John Doe")
                .translation("Bonjour, je suis John Doe")
                .wordStatus(Word.WordStatus.INACTIVE)
                .level(Word.WordLevel.EASY)
                .user(getAnotherUser());
    }

    public static User getUser(){
        return new User()
                .id(1)
                .username("username1")
                .password("xxx")
                .email("user@1.be");
    }

    public static User getAnotherUser(){
        return new User()
                .id(2)
                .username("username2")
                .password("yyy")
                .email("user@2.be");
    }
}
