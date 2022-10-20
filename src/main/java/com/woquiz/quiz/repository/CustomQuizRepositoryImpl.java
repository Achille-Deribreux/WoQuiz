package com.woquiz.quiz.repository;

import java.util.List;

import com.woquiz.quiz.dto.QuizCriteria;
import com.woquiz.quiz.model.Quiz;

public class CustomQuizRepositoryImpl implements CustomQuizRepository{

    @Override
    public List<Quiz> findByCriteria(QuizCriteria quizCriteria) {
        return null;
    }
}
