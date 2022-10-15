package com.woquiz.quiz.service;

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
import com.woquiz.quiz.dto.WordCriteria;
import com.woquiz.quiz.model.Word;
import com.woquiz.quiz.repository.WordRepository;

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
    @DisplayName("test to delete a word")
    void deleteWordTest() {
        //Given
        Word word = EntityBuilder.getWord();
        //When
        wordService.deleteWord(word);
        //Then
        Mockito.verify(wordRepository,Mockito.times(1)).delete(word);
    }
}
