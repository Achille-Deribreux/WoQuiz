package com.woquiz.word.repository;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import com.woquiz.EntityBuilder;
import com.woquiz.user.model.User;
import com.woquiz.user.repository.UserRepository;
import com.woquiz.word.dto.WordCriteria;
import com.woquiz.word.model.Word;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class WordRepositoryUTest {

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private UserRepository userRepository;

    Word wordOne;
    Word wordTwo;
    User userOne;
    User userTwo;

    @BeforeEach
    void setUp() {
        userOne = userRepository.save(EntityBuilder.getUser());
        userTwo = userRepository.save(EntityBuilder.getAnotherUser());
        wordOne = wordRepository.save(EntityBuilder.getWord());
        wordTwo = wordRepository.save(EntityBuilder.getAnotherWord());
    }

    @Test
    @Tag("word")
    @DisplayName("test to find a word by basic word contains")
    void findByCriteriaTestCase1() {
        //Given
        WordCriteria criteria = new WordCriteria().basicWordContains("John Doe");
        //When
        List<Word> wordList = wordRepository.findByCriteria(criteria);
        //Then
        Assertions.assertEquals(wordTwo.getBasicWord(),wordList.get(0).getBasicWord());
    }

    @Test
    @Tag("word")
    @DisplayName("test to find a word by status")
    void findByCriteriaTestCase2() {
        //Given
        WordCriteria criteria = new WordCriteria().status(Collections.singletonList(Word.WordStatus.INACTIVE));
        //When
        List<Word> wordList = wordRepository.findByCriteria(criteria);
        //Then
        Assertions.assertEquals(wordTwo.getStatus(),wordList.get(0).getStatus());
        Assertions.assertEquals(wordTwo.getBasicWord(),wordList.get(0).getBasicWord());
    }

    @Test
    @Tag("word")
    @DisplayName("test to find a word by level")
    void findByCriteriaTestCase3() {
        //Given
        WordCriteria criteria = new WordCriteria().level(Collections.singletonList(Word.WordLevel.EASY));
        //When
        List<Word> wordList = wordRepository.findByCriteria(criteria);
        //Then
        Assertions.assertEquals(wordTwo.getLevel(),wordList.get(0).getLevel());
        Assertions.assertEquals(wordTwo.getBasicWord(),wordList.get(0).getBasicWord());
    }

    @Test
    @Tag("word")
    @DisplayName("test to find a word by translation contains")
    void findByCriteriaTestCase4() {
        //Given
        WordCriteria criteria = new WordCriteria().translationContains("John Doe");
        //When
        List<Word> wordList = wordRepository.findByCriteria(criteria);
        //Then
        Assertions.assertEquals(wordTwo.getTranslation(),wordList.get(0).getTranslation());
        Assertions.assertEquals(wordTwo.getBasicWord(),wordList.get(0).getBasicWord());
    }

    @Test
    @Tag("word")
    @DisplayName("test to find a word by user id")
    void findByCriteriaTestCase5() {
        //Given
        WordCriteria criteria = new WordCriteria().userId(2);
        //When
        List<Word> wordList = wordRepository.findByCriteria(criteria);
        //Then
        Assertions.assertEquals(wordTwo.getUser().getId(),wordList.get(0).getUser().getId());
        Assertions.assertEquals(wordTwo.getBasicWord(),wordList.get(0).getBasicWord());
    }
}
