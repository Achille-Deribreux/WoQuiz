package com.woquiz.quiz.dto;

public class AnswerCorrectionDto {

    private String basicWord;
    private String answer;
    private String goodAnswer;
    private Boolean correct;

    public String getBasicWord() {
        return basicWord;
    }

    public void setBasicWord(String basicWord) {
        this.basicWord = basicWord;
    }

    public AnswerCorrectionDto basicWord(String basicWord){
        setBasicWord(basicWord);
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public AnswerCorrectionDto answer(String answer){
        setAnswer(answer);
        return this;
    }

    public String getGoodAnswer() {
        return goodAnswer;
    }

    public void setGoodAnswer(String goodAnswer) {
        this.goodAnswer = goodAnswer;
    }

    public AnswerCorrectionDto goodAnswer(String goodAnswer){
        setGoodAnswer(goodAnswer);
        return this;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public AnswerCorrectionDto correct(Boolean correct){
        setCorrect(correct);
        return this;
    }
}
