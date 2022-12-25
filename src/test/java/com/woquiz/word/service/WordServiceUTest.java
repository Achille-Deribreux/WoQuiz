package com.woquiz.word.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.woquiz.EntityBuilder;
import com.woquiz.exception.model.NoSuchElementException;
import com.woquiz.word.dto.WordCriteria;
import com.woquiz.word.model.Word;
import com.woquiz.word.repository.WordRepository;

@SpringBootTest
public class WordServiceUTest {

    @Mock
    WordRepository wordRepository;

    @InjectMocks
    WordService wordService;

    @Test
    @Tag("word")
    @DisplayName("test to find a word by id")
    void getByIdTest() {
        //Given
        Integer id = 123;
        //When
        Mockito.when(wordRepository.findById(id)).thenReturn(Optional.of(new Word()));
        wordService.getById(id);
        // Then
        Mockito.verify(wordRepository,Mockito.times(1)).findById(id);
    }

    @Test
    @Tag("word")
    @DisplayName("test to find a word by id that is not present in DB")
    void getByIdExceptionTest() {
        //Given
        Integer id = 123;
        //When & Then
        Assertions.assertThrows(NoSuchElementException.class,() -> wordService.getById(id));
    }

    @Test
    @Tag("word")
    @DisplayName("test to find a list of word based on criterias")
    void getAllByCriteriaTest() {
        //Given
        WordCriteria wordCriteria = new WordCriteria();
        //When
        wordService.getAllByCriteria(wordCriteria);
        //Then
        Mockito.verify(wordRepository,Mockito.times(1)).findByCriteria(wordCriteria);
    }

    @Test
    @Tag("word")
    @DisplayName("test to create a new word")
    void createWordTest() {
        //Given
        Word word = EntityBuilder.getWord();
        //When
        wordService.createWord(word);
        //Then
        Mockito.verify(wordRepository,Mockito.times(1)).save(word);
    }

    @Test
    @Tag("word")
    @DisplayName("test to update a word")
    void updateWordTest() {
        //Given
        Word initialWord = EntityBuilder.getWord();
        Word body = new Word()
                .basicWord("updated basicWord")
                .translation("updated translation")
                .wordStatus(Word.WordStatus.INACTIVE)
                .level(Word.WordLevel.HARD);

        //When
        Mockito.when(wordRepository.findById(initialWord.getId())).thenReturn(Optional.ofNullable(initialWord));
        Mockito.when(wordRepository.save(Mockito.any())).thenAnswer(i -> i.getArguments()[0]);
        Word result = wordService.updateWord(initialWord.getId(), body);
        //Then
        Assertions.assertEquals(initialWord.getId(),result.getId());
        Assertions.assertEquals(body.getBasicWord(),result.getBasicWord());
        Assertions.assertEquals(body.getTranslation(),result.getTranslation());
        Assertions.assertEquals(body.getLevel(),result.getLevel());
        Assertions.assertEquals(body.getStatus(),result.getStatus());

    }

    @Test
    @Tag("word")
    @DisplayName("test to delete a word")
    void deleteWordTest() {
        //Given
        Word word = EntityBuilder.getWord();
        //When
        wordService.deleteWord(word);
        //Then
        Mockito.verify(wordRepository,Mockito.times(1)).delete(word);
    }

    @Test
    @Tag("word")
    @DisplayName("test to update a wordLevel, with a word that never has been asked")
    void updateWordLevelNoUpdateTest() {
        //Given
        Word word = EntityBuilder.getWord();
        //When
        wordService.updateWordLevel(word);
        //Then
        Mockito.verifyNoInteractions(wordRepository);
    }

    @Test
    @Tag("word")
    @DisplayName("test to update a wordLevel with a word that should have HARD level")
    void updateWordLevelHardTest() {
        //Given
        Word word = EntityBuilder.getWord()
                .nrAsked(10)
                .nrGoodAnswers(2)
                .level(Word.WordLevel.NEW);
        //When
        Mockito.when(wordRepository.save(Mockito.any())).thenAnswer(i -> i.getArguments()[0]);
        Word result = wordService.updateWordLevel(word);
        //Then
        Assertions.assertEquals(Word.WordLevel.HARD,result.getLevel());
    }

    @Test
    @Tag("word")
    @DisplayName("test to update a wordLevel with a word that should have Medium level")
    void updateWordLevelMediumTest() {
        //Given
        Word word = EntityBuilder.getWord()
                .nrAsked(10)
                .nrGoodAnswers(6)
                .level(Word.WordLevel.NEW);
        //When
        Mockito.when(wordRepository.save(Mockito.any())).thenAnswer(i -> i.getArguments()[0]);
        Word result = wordService.updateWordLevel(word);
        //Then
        Assertions.assertEquals(Word.WordLevel.MEDIUM,result.getLevel());
    }

    @Test
    @Tag("word")
    @DisplayName("test to update a wordLevel with a word that should have Easy level")
    void updateWordLevelEasyTest() {
        //Given
        Word word = EntityBuilder.getWord()
                .nrAsked(10)
                .nrGoodAnswers(8)
                .level(Word.WordLevel.NEW);
        //When
        Mockito.when(wordRepository.save(Mockito.any())).thenAnswer(i -> i.getArguments()[0]);
        Word result = wordService.updateWordLevel(word);
        //Then
        Assertions.assertEquals(Word.WordLevel.EASY,result.getLevel());
    }
}
