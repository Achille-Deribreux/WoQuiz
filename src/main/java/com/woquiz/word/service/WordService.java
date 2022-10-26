package com.woquiz.word.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.woquiz.exception.model.NoSuchElementException;
import com.woquiz.word.UpdateWordHelper;
import com.woquiz.word.dto.WordCriteria;
import com.woquiz.word.model.Word;
import com.woquiz.word.repository.WordRepository;

@Service
public class WordService {

    private final Logger logger = LoggerFactory.getLogger(WordService.class);

    private final WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    /**
     * Method which search a Word based on its id
     * @param id of the word you are searching for
     * @return wanted word, based on the given id
     */
    public Word getById(Integer id){
        logger.info("search in repository to find word with id: {}",id);
        return wordRepository.findById(id).orElseThrow(() -> new NoSuchElementException("word with following id not found : " + id));
    }

    /**
     * Method which search for words based on criteria
     * @param wordCriteria criteria you want to base your research
     * @return list of words that match the criteria
     */
    public List<Word> getAllByCriteria(WordCriteria wordCriteria){
        logger.info("search in repository to find words by criteria");
        return wordRepository.findByCriteria(wordCriteria);
    }

    /**
     * Method which creates a word
     * @param word you want to create
     * @return created word with id
     */
    public Word createWord(Word word){
        logger.info("create Word with basic Word {}" , word.getBasicWord());
        return wordRepository.save(word);
    }

    /**
     * Method which updates a word
     * @param id of the original word
     * @param word body (with the fields you want to update only)
     * @return updated Word
     */
    public Word updateWord(Integer id, Word word){
        logger.info("update word with id : {}" , id);
        UpdateWordHelper helper = UpdateWordHelper.of(getById(id));
        Word wordReadyToUpdate = helper.build(word);
        return wordRepository.save(wordReadyToUpdate);
    }

    /**
     * Method which deletes a given word
     * @param word you want to delete
     */
    public void deleteWord(Word word){
        logger.info("delete word with basic word {}" , word.getBasicWord());
        wordRepository.delete(word);
    }

    /**
     * Method wich updates the level of a word based on how many times it was asked/good answered
     * @param word word to update
     */
    public void updateWordLevel(Word word){
        logger.info("try to update level for word : {}, asked : {}",word.getId(),word.getNrAsked());
        if(word.getNrAsked() > 5) {
            logger.info("update level of word : {}", word.getId());
            float ratio = (float) word.getNrGoodAnswers() / (float) word.getNrAsked();
            if (ratio < 0.4)
                word.setLevel(Word.WordLevel.HARD);
            else if (ratio < 0.7)
                word.setLevel(Word.WordLevel.MEDIUM);
            else
                word.setLevel(Word.WordLevel.EASY);
            wordRepository.save(word);
        }
    }
}
