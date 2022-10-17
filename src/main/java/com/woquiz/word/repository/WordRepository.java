package com.woquiz.word.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.woquiz.word.model.Word;

@Repository
public interface WordRepository extends JpaRepository<Word, Integer>, CustomWordRepository {
}
