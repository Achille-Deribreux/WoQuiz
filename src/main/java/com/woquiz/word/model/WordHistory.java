package com.woquiz.word.model;

import com.woquiz.quiz.model.Answer;
import com.woquiz.quiz.model.Quiz;
import com.woquiz.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "WORD_HISTORY")
public class WordHistory extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "QUIZ_ID")
    private Quiz quiz;

    @OneToOne
    @JoinColumn(name = "ANSWER_ID")
    private Answer answer;

    public WordHistory id(Integer id){
        setId(id);
        return this;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public WordHistory quiz(Quiz quiz){
        setQuiz(quiz);
        return this;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public WordHistory answer(Answer answer){
        setAnswer(answer);
        return this;
    }
}
