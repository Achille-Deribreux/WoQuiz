package com.woquiz.quiz.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.woquiz.quiz.dto.AnswerBody;
import com.woquiz.quiz.dto.QuizCriteria;
import com.woquiz.quiz.model.Answer;
import com.woquiz.quiz.model.Quiz;
import com.woquiz.quiz.repository.QuizRepository;
import com.woquiz.user.User;
import com.woquiz.user.service.UserService;
import com.woquiz.word.dto.WordCriteria;
import com.woquiz.word.model.Word;
import com.woquiz.word.model.WordHistory;
import com.woquiz.word.repository.WordHistoryRepository;
import com.woquiz.word.service.WordService;

@Service
public class QuizService {

    private final Logger logger = LoggerFactory.getLogger(QuizService.class);

    private final QuizRepository quizRepository;

    private final WordService wordService;

    private final WordHistoryRepository wordHistoryRepository;

    private final UserService userService;

    private final Random random = new Random();

    public QuizService(QuizRepository quizRepository, WordService wordService, WordHistoryRepository wordHistoryRepository,UserService userService) {
        this.quizRepository = quizRepository;
        this.wordService = wordService;
        this.wordHistoryRepository = wordHistoryRepository;
        this.userService = userService;
    }

    /*
    CRUD METHODS
     */

    /**
     * Method which search a quiz by ID
     * @param quizId id of the quiz you search for
     * @return quiz
     */
    public Quiz findById (Integer quizId){
        logger.info("search in repository for quiz with id : {}" , quizId);
        return quizRepository.findById(quizId).orElseThrow(() -> new NoSuchElementException("quiz with following id not found : " + quizId));
    }

    /**
     * Method which search for quiz based on criteria
     * @param quizCriteria criteria you want to base your research
     * @return list of quiz that match the criteria
     */
    public List<Quiz> getAllByCriteria(QuizCriteria quizCriteria){
        logger.info("search in repository to find quiz by criteria");
        return quizRepository.findByCriteria(quizCriteria);
    }



    /*
        METHODS FOR QUIZ CREATION
     */

    /**
     * Method which create a quiz
     * @param nrOfWords nr of questions you want
     * @param wordLevelList level of the quiz
     * @return a created quiz, with the nr of words you want & without answers
     */
    public Quiz takeQuiz(Integer nrOfWords, List<Word.WordLevel> wordLevelList){
        logger.info("create quiz with : {} questions, and levels : {} ", nrOfWords, wordLevelList.toString());
        List<Word> possibleWords = findQuizWords(wordLevelList);
        List<Word> wordList = pickRandomWord(nrOfWords,possibleWords);
        Quiz quiz =  new Quiz()
                .words(wordList)
                .user(userService.getByUsername("a"));//TODO: get current userId
        return quizRepository.save(quiz);
    }

    /**
     * Method which search for wordss which may fit for the quiz
     * @param wordLevelList List of wordLevel you want to include in the quiz
     * @return List of words who can fit for the quiz
     */
    private List<Word> findQuizWords(List<Word.WordLevel> wordLevelList){
        if(!wordLevelList.contains(Word.WordLevel.NEW))
            wordLevelList.add(Word.WordLevel.NEW);
        WordCriteria wordCriteria = new WordCriteria()
                .status(Collections.singletonList(Word.WordStatus.ACITVE))
                .level(wordLevelList)
                .userId(1);//TODO: get current userId
        return  wordService.getAllByCriteria(wordCriteria);
    }

    /**
     * Method which pick up random words from a list of words
     * @param nrOfWords nr of words you want
     * @param possibleWords list of words which may fit, list where the words will be picked
     * @return list of random words from the list
     */
    private List<Word> pickRandomWord(Integer nrOfWords, List<Word> possibleWords){
        List<Word> wordList = new ArrayList<>();
        for(int i = 0 ; i < nrOfWords ; i++){
            int randomIndex = random.nextInt(possibleWords.size());
            wordList.add(possibleWords.get(randomIndex));
            possibleWords.remove(randomIndex);
        }
        return wordList;
    }


    /*
        METHODS FOR ANSWER QUIZ
     */

    /**
     * Method which submit a quiz
     * @param quizId id of the quiz you answer
     * @param answerDtoList list of answers
     * @return filled quiz with result
     */
    public Quiz submitQuiz(Integer quizId, List<AnswerBody> answerDtoList){
        logger.info("submit quiz with id : {}", quizId);
        Quiz quiz = findById(quizId);
        if(quiz.getWords().size() != answerDtoList.size()){
            logger.error("the nr of answers do not correspond to the nr of questions");
            throw new RuntimeException();//TODO custom exception
        }
        List<Answer> answerList = new ArrayList<>();
        int correctCounter = 0;

        for(AnswerBody answerDto : answerDtoList){
            Word word = quiz.getWords()
                    .stream()
                    .filter(w -> w.getBasicWord().equals(answerDto.getBasicWord()))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("basic word not found in quiz"));

            Answer answer = new Answer()
                    .answer(answerDto.getAnswer())
                    .word(word)
                    .userId(1);//TODO: get current userId

            if(word.getTranslation().equals(answerDto.getAnswer())){
                correctCounter++;
                answer.result(true);
            }
            answerList.add(answer);
            createWordHistory(quiz,answer);
        }
        return quiz.answers(answerList).score(correctCounter).attemptDate(LocalDate.now());
    }

    /**
     * Method which create a word history
     * @param quiz where the word was asked
     * @param answer provided answer
     */
    private void createWordHistory(Quiz quiz, Answer answer){
        WordHistory wordHistory = new WordHistory().quiz(quiz).answer(answer);
        wordHistoryRepository.save(wordHistory);
    }

    public void updateWordLevel(){
        User currentUser = userService.getByUsername("");//TODO: get current
        QuizCriteria quizCriteria = new QuizCriteria()
                .attemptDateAfter(currentUser.getLastWordLevelUpdate())
                .userId(currentUser.getId());
        List<Quiz> quizzes = getAllByCriteria(quizCriteria);
        //TODO TBC
    }

}
