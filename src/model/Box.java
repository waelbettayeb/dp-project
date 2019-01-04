package model;

public abstract class Box {
    private static int MAX_ATTEMPTS_NUMBER = 1;
    private static int UNIT_SCORE = 1;
    private int remainingAttemptCounter;
    private char expectedAnswer;
    private char actualAnswer;

    public Box(char expectedAnswer) {
        this.expectedAnswer = expectedAnswer;
    }

    public int getScore() {
        if(isPassed())
            return UNIT_SCORE;
        else
            return 0;
    }
    public boolean setActualAnswer(char actualAnswer) {
        if((!isPassed())&&(!isMissed())){
            remainingAttemptCounter--;
            return (remainingAttemptCounter >= 0)? this.setActualAnswer(actualAnswer) : false;
        }
        return false;
    }
    public char getExpectedAnswer() {
        return expectedAnswer;
    }

    public final boolean isPassed() {
        return (expectedAnswer == actualAnswer);
    }
    public boolean isMissed(){
        return (( remainingAttemptCounter <= 0 )
                && (!this.isPassed()));
    }

    public static int getMaxAttemptsNumber() {
        return MAX_ATTEMPTS_NUMBER;
    }

    public int getRemainingAttemptCounter() {
        return this.remainingAttemptCounter;
    }
}
