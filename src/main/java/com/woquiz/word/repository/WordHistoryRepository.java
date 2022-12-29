package com.woquiz.word.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.woquiz.word.model.WordHistory;

@Repository
public interface WordHistoryRepository extends JpaRepository<WordHistory, Integer> {
}
