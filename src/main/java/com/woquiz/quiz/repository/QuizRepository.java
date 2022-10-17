package com.woquiz.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.woquiz.quiz.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
