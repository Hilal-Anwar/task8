package org.helal_anwar;
import java.util.List;

public class Question {
    private String question;
    private List<String> correctAnswers;
    private List<String> options;

    public Question(String question, List<String> correctAnswers, List<String> options) {
        this.question = question;
        this.correctAnswers = correctAnswers;
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isMultipleAnswer() {
        return correctAnswers.size() > 1;
    }
}