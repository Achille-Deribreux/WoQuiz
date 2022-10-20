package com.woquiz.word.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.woquiz.word.dto.WordBody;
import com.woquiz.word.dto.WordCriteria;
import com.woquiz.word.dto.WordDto;
import com.woquiz.word.model.Word;
import com.woquiz.word.service.WordService;
import com.woquiz.word.util.WordConverter;

@RestController
@RequestMapping("/word")
public class WordController {

    private final Logger logger = LoggerFactory.getLogger(WordController.class);

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    /**
     * Method which respond at /word/getById and search for a word based on it's ID
     * @param wordId id of the word you want
     * @return wanted word and code 200
     */
    @GetMapping("/getById")
    public ResponseEntity<WordDto> getById(
        @RequestParam Integer wordId
    ){
        logger.info("get request received at /word/getById for wordId : {}", wordId);
        Word word = wordService.getById(wordId);
        return new ResponseEntity<>(WordConverter.convertToWordDto(word),HttpStatus.OK);
    }

    /**
     * Method which respond at /word/getAll
     * @param basicWordContains string that basic word must contain
     * @param translationContains string that translation must contain
     * @param pageNr page number
     * @param pageSize page size
     * @param status of words you want to include
     * @param level level of words you want to include
     * @return list of words that match the criterias and code 200
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<WordDto>> getAll(
            @RequestParam String basicWordContains,
            @RequestParam String translationContains,
            @RequestParam Integer pageNr,
            @RequestParam Integer pageSize,
            @RequestParam List<Word.WordStatus> status,
            @RequestParam List<Word.WordLevel> level
    ){
        logger.info("get request received at /word/getAll");
        WordCriteria wordCriteria = new WordCriteria()
                .userId(2)//TODO : current userId
                .level(level)
                .status(status)
                .translationContains(translationContains)
                .basicWordContains(basicWordContains)
                .pageNr(pageNr)
                .pageSize(pageSize);
        List<Word> wordList = wordService.getAllByCriteria(wordCriteria);
        return new ResponseEntity<>(WordConverter.convertToWordDto(wordList),HttpStatus.OK);
    }

    /**
     * Method wich respond at /word/add and create a new word
     * @param wordBody word you want to add
     * @return added word and code 201
     */
    @PostMapping("/add")
    public ResponseEntity<WordDto> addWord(
            @RequestBody WordBody wordBody
    ){
        logger.info("post request received at /word/add");
        Word word = wordService.createWord(WordConverter.convertToWord(wordBody));
        return new ResponseEntity<>(WordConverter.convertToWordDto(word),HttpStatus.CREATED);

    }

    /**
     * Method which respond at /word/update and update a word
     * @param wordId id of the word you want to update
     * @param wordBody with fields you want to update
     * @return updated word and code 200
      */
    @PutMapping("/update")
    public ResponseEntity<WordDto> updateWord(
        @RequestParam Integer wordId,
        @RequestBody WordBody wordBody
    ){
        logger.info("put request received at /word/update for wordId : {}", wordId);
        Word word = wordService.updateWord(wordId,WordConverter.convertToWord(wordBody));
        return new ResponseEntity<>(WordConverter.convertToWordDto(word),HttpStatus.OK);
    }

    /**
     * Method which respond at /word/delete and delete a word
     * @param wordId id of the word you want to delete
     * @return string with code 200
     */
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteWord(
        @RequestParam Integer wordId
    ){
        logger.info("delete request received at /word/delete for wordId : {}", wordId);
        wordService.deleteWord(wordService.getById(wordId));
        return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
    }
}
