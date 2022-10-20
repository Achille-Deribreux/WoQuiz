package com.woquiz.quiz.util;

import java.util.stream.Collectors;

import com.woquiz.quiz.dto.AnswerCorrectionDto;
import com.woquiz.quiz.dto.QuizCorrectionDto;
import com.woquiz.quiz.dto.TakeQuizDto;
import com.woquiz.quiz.model.Answer;
import com.woquiz.quiz.model.Quiz;
import com.woquiz.word.model.Word;

public class QuizConverter {

    private QuizConverter() {
    }

    public static TakeQuizDto convertToTakeQuizDto(Quiz quiz){
        return new TakeQuizDto()
                .quizId(quiz.getId())
                .wordList(quiz.getWords().stream().map(Word::getBasicWord).collect(Collectors.toList()));
    }

    public static QuizCorrectionDto convertToQuizCorrectionDto(Quiz quiz){
        return new QuizCorrectionDto()
                .answerCorrectionList(quiz.getAnswers().stream().map(QuizConverter::convertToAnswerCorrectionDto).collect(Collectors.toList()))
                .askedQuestions(quiz.getWords().size())
                .goodAnswers(quiz.getScore());
    }

    private static AnswerCorrectionDto convertToAnswerCorrectionDto(Answer answer){
        return new AnswerCorrectionDto()
                .answer(answer.getAnswer())
                .correct(answer.isResult())
                .basicWord(answer.getWord().getBasicWord())
                .goodAnswer(answer.getWord().getTranslation());
    }
}
