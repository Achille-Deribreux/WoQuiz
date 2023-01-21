package com.woquiz;

import java.time.LocalDate;
import java.util.List;

import com.woquiz.quiz.model.Answer;
import com.woquiz.quiz.model.Quiz;
import com.woquiz.user.model.User;
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

    public static Answer getAnswer(Word word, String answer, boolean correct){
        return new Answer()
                .answer(answer)
                .word(word)
                .user(getUser())
                .result(correct);
    }

    public static Quiz getQuiz(){
        return new Quiz()
                .id(1)
                .words(List.of(getWord(),getAnotherWord()))
                .answers(List.of(
                            getAnswer(getWord(), getWord().getTranslation(), true),
                            getAnswer(getAnotherWord(),"ABC", false)
                        )
                )
                .user(new User())
                .attemptDate(LocalDate.now())
                .score(1);

    }
}
