package model;

public class Quiz {

    private int correctAnswersCount = 0;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private int currentMistakeCount = 0;
    private Question[] questions = new Question[0];

    public Quiz() {
        this.questions = new Question[]{
                new Question("[3, 1, 4, 1, 5, ?]", "PI", "9"),
                new Question("[1, 1, 2, 3, 5, ?]", "Fibonacci", "8"),
                new Question("[1, 4, 9, 16, 25, ?]", "self multiply", "36"),
                new Question("[2, 3, 5, 7, 11, ?]", "Prime", "13"),
                new Question("[1, 2, 4, 8, 16, ?]", "n x 2", "32"),
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

    public String getGrade() {
        if (score >= 45) {
            return "A";
        } else if (score >= 35) {
            return "B";
        } else if (score >= 25) {
            return "C";
        }
        return "NC";
    }

    public int getNumCorrect(){
        return correctAnswersCount;
    }

    public String pu(){
        return questions[currentQuestionIndex].getQuestion();
    }

    public String getHint(){
        return questions[currentQuestionIndex].getHint();
    }

    public boolean hasQuestion(){
        return currentQuestionIndex < questions.length;
    }

    public boolean isCorrect(String answer){
        boolean result = questions[currentQuestionIndex].getCorrectAnswer().equalsIgnoreCase(answer);
        return result || currentMistakeCount > 2;
    }

    public int getNumQuestion(){
        return questions.length;
    }

    public void scoreAnswer(){
        correctAnswersCount++;
        currentQuestionIndex++;
        switch (currentMistakeCount){
            case 0:
                score+=10;
                break;
            case 1:
                score+=5;
                break;
            case 2:
                score+=2;
                break;
        }
        currentMistakeCount=0;
    }

    public void wrongAnswer(){
        currentMistakeCount++;
    }

    public int getCurrentQuestionIndex(){
        return currentQuestionIndex;
    }

    public String getAnswerIfDidMoreMistake(){
        return currentMistakeCount>2 ? questions[currentQuestionIndex].getCorrectAnswer():"";
    }

}
