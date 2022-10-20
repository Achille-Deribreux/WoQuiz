package com.woquiz.quiz.repository;

import java.util.List;

import com.woquiz.quiz.dto.QuizCriteria;
import com.woquiz.quiz.model.Quiz;

public interface CustomQuizRepository {

    List<Quiz> findByCriteria(QuizCriteria quizCriteria);
}
