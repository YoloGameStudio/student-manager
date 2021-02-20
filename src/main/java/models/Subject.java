package models;

import configs.Constants;

public class Subject {
    private String name;
    private float score;

    public Subject(String name, String scoreStr) {
        this.name = name;
        boolean isScoreNumber = scoreStr.matches(Constants.NUMBER_REGEX);
        if (isScoreNumber) {
            try {
                this.score = Float.parseFloat(scoreStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name + " = " + score;
    }
}
