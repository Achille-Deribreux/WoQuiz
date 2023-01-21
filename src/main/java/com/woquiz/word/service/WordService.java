package com.woquiz.word.service;

import java.util.List;

import com.woquiz.word.dto.WordCriteria;
import com.woquiz.word.model.Word;

public interface WordService {

    /**
     * Method which search a Word based on its id
     * @param id of the word you are searching for
     * @return wanted word, based on the given id
     */
     Word getById(Integer id);

    /**
     * Method which search for words based on criteria
     * @param wordCriteria criteria you want to base your research
     * @return list of words that match the criteria
     */
    List<Word> getAllByCriteria(WordCriteria wordCriteria);

    /**
     * Method which creates a word
     * @param word you want to create
     * @return created word with id
     */
    Word createWord(Word word);

    /**
     * Method which updates a word
     * @param id of the original word
     * @param word body (with the fields you want to update only)
     * @return updated Word
     */
    Word updateWord(Integer id, Word word);

    /**
     * Method which deletes a given word
     * @param word you want to delete
     */
    void deleteWord(Word word);

    /**
     * Method wich updates the level of a word based on how many times it was asked/good answered
     * @param word word to update
     */
    Word updateWordLevel(Word word);
}
