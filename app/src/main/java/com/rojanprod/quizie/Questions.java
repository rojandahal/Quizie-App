package com.rojanprod.quizie;

public class Questions {
    private int questionId;
    private boolean answerID;

    public Questions(int questionID, boolean answerID) {
        this.answerID = answerID;
        this.questionId = questionID;
    }

    public int getQuestionId() {
        return questionId;
    }

    public boolean getAnswerID() {
        return answerID;
    }
}
