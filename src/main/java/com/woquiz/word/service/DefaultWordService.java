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
public class DefaultWordService implements WordService{

    private final Logger logger = LoggerFactory.getLogger(DefaultWordService.class);

    private final WordRepository wordRepository;

    public DefaultWordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public Word getById(Integer id){
        logger.info("search in repository to find word with id: {}",id);
        return wordRepository.findById(id).orElseThrow(() -> new NoSuchElementException("word with following id not found : " + id));
    }

    @Override
    public List<Word> getAllByCriteria(WordCriteria wordCriteria){
        logger.info("search in repository to find words by criteria");
        return wordRepository.findByCriteria(wordCriteria);
    }

    @Override
    public Word createWord(Word word){
        logger.info("create Word with basic Word {}" , word.getBasicWord());
        return wordRepository.save(word);
    }

    @Override
    public Word updateWord(Integer id, Word word){
        logger.info("update word with id : {}" , id);
        UpdateWordHelper helper = UpdateWordHelper.of(getById(id));
        Word wordReadyToUpdate = helper.build(word);
        return wordRepository.save(wordReadyToUpdate);
    }

    @Override
    public void deleteWord(Word word){
        logger.info("delete word with basic word {}" , word.getBasicWord());
        wordRepository.delete(word);
    }

    @Override
    public Word updateWordLevel(Word word) {
        logger.info("try to update level for word : {}, asked : {}", word.getId(), word.getNrAsked());
        if (word.getNrAsked() < 5) {
            logger.info("not enough nrAsked for word : {}", word.getId());
            return word;
        }
        logger.info("update level of word : {}", word.getId());
        float ratio = (float) word.getNrGoodAnswers() / (float) word.getNrAsked();
        if (ratio < 0.4)
            word.setLevel(Word.WordLevel.HARD);
        else if (ratio < 0.7)
            word.setLevel(Word.WordLevel.MEDIUM);
        else
            word.setLevel(Word.WordLevel.EASY);
        return wordRepository.save(word);
    }
}
