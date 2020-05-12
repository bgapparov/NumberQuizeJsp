package model;

public class Quiz {

    private int correctAnswersCount = 0;
    private int correctQuestionIndex = 0;
    private int score = 0;
    private int currentMistakeCount = 0;
    private Question[] questions = new Question[0];

    public Quiz(){
        this.questions = new Question[]{
                new Question("[3, 1, 4, 1, 5, ?]","PI", "9"),
                new Question("[1, 1, 2, 3, 5, ?]", "Fibonacci", "8"),
                new Question("[1, 4, 9, 16, 25, ?]", "self multiply", "36"),
                new Question("[2, 3, 5, 7, 11, ?]","Prime", "13"),
                new Question("[1, 2, 4, 8, 16, ?]","n x 2", "32"),
        };
    }

    public int getCurrentMistakeCount() {
        return currentMistakeCount;
    }

    public int getScore() {
        return score;
    }

    /*
A if score is between 45 and 50 inclusive
B if score is between 35 and 44 inclusive
C if score is between 25 and 34 inclusive
NC if the score is less than 25
    * */
}
