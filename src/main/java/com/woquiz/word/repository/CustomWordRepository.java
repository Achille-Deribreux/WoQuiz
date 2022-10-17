package com.woquiz.word.repository;

import java.util.List;

import com.woquiz.word.dto.WordCriteria;
import com.woquiz.word.model.Word;

public interface CustomWordRepository {

    List<Word> findByCriteria(WordCriteria wordCriteria);
}
