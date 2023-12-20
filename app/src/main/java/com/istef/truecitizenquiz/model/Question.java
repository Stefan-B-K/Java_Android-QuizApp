package com.istef.truecitizenquiz.model;

public class Question {
    private int textId;
    private boolean isCorrect;

    public Question(int textId, boolean isCorrect) {
        this.textId = textId;
        this.isCorrect = isCorrect;
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

}
