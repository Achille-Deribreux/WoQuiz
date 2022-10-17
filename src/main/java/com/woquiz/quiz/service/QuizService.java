package com.woquiz.quiz.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.woquiz.quiz.model.Quiz;
import com.woquiz.quiz.repository.QuizRepository;
import com.woquiz.word.dto.WordCriteria;
import com.woquiz.word.model.Word;
import com.woquiz.word.service.WordService;

@Service
public class QuizService {

    private final Logger logger = LoggerFactory.getLogger(QuizService.class);

    private final QuizRepository quizRepository;

    private final WordService wordService;

    public QuizService(QuizRepository quizRepository, WordService wordService) {
        this.quizRepository = quizRepository;
        this.wordService = wordService;
    }

    public Quiz takeQuiz(Integer nrOfWords, List<Word.WordLevel> wordLevelList){
        //TODO REFACTOR with 2 sub methods
        Random random = new Random();
        if(!wordLevelList.contains(Word.WordLevel.NEW))
            wordLevelList.add(Word.WordLevel.NEW);
        WordCriteria wordCriteria = new WordCriteria()
                .status(Collections.singletonList(Word.WordStatus.ACITVE))
                .level(wordLevelList)
                .userId(1);//TODO: get current userId
        List<Word> possibleWords = wordService.getAllByCriteria(wordCriteria);

        List<Word> wordList = new ArrayList<>();
        for(int i = 0 ; i < nrOfWords ; i++){
            int randomIndex = random.nextInt(possibleWords.size());
            wordList.add(possibleWords.get(randomIndex));
            possibleWords.remove(randomIndex);
        }

        Quiz quiz =  new Quiz()
                .words(wordList)
                .userId(1);//TODO: get current userId
        return quizRepository.save(quiz);
    }
}
