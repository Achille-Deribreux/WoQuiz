package com.woquiz.quiz.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.woquiz.quiz.dto.WordCriteria;
import com.woquiz.quiz.model.Word;
import com.woquiz.quiz.repository.WordRepository;

@Service
public class WordService {

    private Logger LOGGER = LoggerFactory.getLogger(WordService.class);

    private WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    /**
     * Method which search a Word based on its id
     * @param id of the word you are searching for
     * @return wanted word, based on the given id
     */
    public Word getById(Integer id){
        LOGGER.info("calling repository to find word with id: {}",id);
        return wordRepository.findById(id).orElseThrow(() -> new NoSuchElementException("word with following id not found : " + id));
    }

    /**
     * Method which search for words based on criteria
     * @param wordCriteria criteria you want to base your research
     * @return list of words that match the criteria
     */
    public List<Word> getAllByCriteria(WordCriteria wordCriteria){
        return null;
    }

    /**
     * Method which creates a word
     * @param word you want to create
     * @return created word with id
     */
    public Word createWord(Word word){
        return null;
    }

    /**
     * Method which updates a word
     * @param id of the original word
     * @param word body (with the fields you want to update only)
     * @return updated Word
     */
    public Word updateWord(Integer id, Word word){
        return null;
    }

    /**
     * Method which deletes a given word
     * @param word you want to delete
     */
    public void deleteWord(Word word){

    }
}
