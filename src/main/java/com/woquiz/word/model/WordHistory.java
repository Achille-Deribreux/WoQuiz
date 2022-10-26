package com.woquiz.word.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.woquiz.quiz.model.Answer;
import com.woquiz.quiz.model.Quiz;

@Entity
@Table(name = "WORD_HISTORY")
public class WordHistory {

    @Id
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "QUIZ_ID")
    private Quiz quiz;

    @OneToOne
    @JoinColumn(name = "ANSWER_ID")
    private Answer answer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
