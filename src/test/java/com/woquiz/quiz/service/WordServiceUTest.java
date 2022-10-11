package com.woquiz.quiz.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

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

        //When

        //Then
    }
}
