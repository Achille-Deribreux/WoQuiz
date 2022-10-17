package com.woquiz.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.woquiz.quiz.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
