package com.woquiz.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.woquiz.quiz.model.Word;

@Repository
public interface WordRepository extends JpaRepository<Word, Integer> {
}
