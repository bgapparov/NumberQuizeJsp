package model;

public class Question {
    private String question;
    private String hint;
    private String correctAnswer;

    public Question(String question, String hint, String correctAnswer) {
        this.question = question;
        this.hint = hint;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getHint() {
        return hint;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
