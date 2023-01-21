package com.woquiz.quiz.service;

import java.time.LocalDate;
import java.util.NoSuchElementException;
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
import com.woquiz.quiz.dto.QuizCriteria;
import com.woquiz.quiz.model.Quiz;
import com.woquiz.quiz.repository.QuizRepository;
import com.woquiz.user.service.DefaultUserService;
import com.woquiz.word.repository.WordHistoryRepository;
import com.woquiz.word.service.DefaultWordService;

@SpringBootTest
public class QuizServiceUTest {

    @Mock
    QuizRepository quizRepository;

    @Mock
    DefaultWordService wordService;

    @Mock
    WordHistoryRepository wordHistoryRepository;

    @Mock
    DefaultUserService defaultUserService;

    @InjectMocks
    QuizService quizService;

    @Test
    @Tag("quiz")
    @DisplayName("test to find a quiz based on its id")
    void findByIdTest() {
        //Given
        Quiz quiz = EntityBuilder.getQuiz();
        //When
        Mockito.when(quizRepository.findById(1)).thenReturn(Optional.of(quiz));
        quizService.findById(1);
        //Then
        Mockito.verify(quizRepository,Mockito.times(1)).findById(1);
    }

    @Test
    @Tag("quiz")
    @DisplayName("test to find a quiz that not exists based on it's id")
    void findByIdExceptionTest() {
        Assertions.assertThrows(NoSuchElementException.class,()->quizService.findById(3));
    }

    @Test
    @Tag("quiz")
    @DisplayName("test to find quizzes based on a criteria")
    void getAllByCriteriaTest() {
        //Given
        QuizCriteria criteria = new QuizCriteria()
                .userId(1)
                .attemptDateAfter(LocalDate.now());
        //When
        quizService.getAllByCriteria(criteria);
        //Then
        Mockito.verify(quizRepository,Mockito.times(1)).findByCriteria(criteria);
    }


}
