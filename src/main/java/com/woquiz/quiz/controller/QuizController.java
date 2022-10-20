package com.woquiz.quiz.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.woquiz.quiz.dto.AnswerBody;
import com.woquiz.quiz.dto.QuizCorrectionDto;
import com.woquiz.quiz.dto.TakeQuizDto;
import com.woquiz.quiz.model.Quiz;
import com.woquiz.quiz.service.QuizService;
import com.woquiz.quiz.util.QuizConverter;
import com.woquiz.word.model.Word;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final Logger logger = LoggerFactory.getLogger(QuizController.class);

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    /**
     * Method which respond at /quiz/takeQuiz and create a new quiz
     * @param nrOfWords you want in the quiz
     * @param wordLevelList level of the words you want to include in the quiz
     * @return create quiz with chosen words to ask
     */
    @GetMapping("/takeQuiz")
    public ResponseEntity<TakeQuizDto> takeQuiz(
            @RequestParam Integer nrOfWords,
            @RequestParam List<Word.WordLevel> wordLevelList
            ){
        logger.info("get request received at /quiz/takeQuiz");
        Quiz quiz = quizService.takeQuiz(nrOfWords,wordLevelList);
        return new ResponseEntity<>(QuizConverter.convertToTakeQuizDto(quiz), HttpStatus.CREATED);
    }


    /**
     * Method which respond at /quiz/submitQuiz and submit a quizz that has been taken
     * @param quizId id of the quiz you submit
     * @param answerBodyList your answers
     * @return corrected quiz
     */
    @PostMapping("/submitQuiz")
    public ResponseEntity<QuizCorrectionDto> submitQuiz(
            @RequestParam Integer quizId,
            @RequestBody List<AnswerBody> answerBodyList
    ){
        logger.info("post request received at /quiz/submitQuiz");
        Quiz quiz = quizService.submitQuiz(quizId,answerBodyList);
        return new ResponseEntity<>(QuizConverter.convertToQuizCorrectionDto(quiz), HttpStatus.OK);
    }


    /**
     * Method which respond at /quiz/findById and search a quiz based on it's ID
     * @param quizId id of the quiz you want
     * @return wanted quiz with correction
     */
    @GetMapping("/getById")
    public ResponseEntity<QuizCorrectionDto> getQuizById(
            @RequestParam Integer quizId
    ){
        logger.info("get request received at /quiz/findById");
        Quiz quiz = quizService.findById(quizId);
        return new ResponseEntity<>(QuizConverter.convertToQuizCorrectionDto(quiz), HttpStatus.OK);
    }
}
