package com.woquiz.quiz.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.woquiz.exception.model.NoSuchElementException;
import com.woquiz.quiz.model.Word;
import com.woquiz.quiz.repository.WordRepository;

@SpringBootTest
public class WordServiceUTest {

    @Mock
    WordRepository wordRepository;

    @InjectMocks
    WordService wordService;

    @Test
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
    void getByIdExceptionTest() {
        //Given
        Integer id = 123;
        //When & Then
        Assertions.assertThrows(NoSuchElementException.class,() -> wordService.getById(id));
    }
}
