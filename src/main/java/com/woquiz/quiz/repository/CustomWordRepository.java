package com.woquiz.quiz.repository;

import java.util.List;

import com.woquiz.quiz.dto.WordCriteria;
import com.woquiz.quiz.model.Word;

public interface CustomWordRepository {

    List<Word> findByCriteria(WordCriteria wordCriteria);
}
