package model;

public class MultiChanceBox extends Box implements IMalus{
    private static int MAX_ATTEMPTS_NUMBER = 3;
    private static int MALUS= 2;
    private static int UNIT_SCORE = 1;

    public MultiChanceBox(char expectedAnswer) {
        super(expectedAnswer);
    }

    @Override
    public int getMalus() {
        return (MAX_ATTEMPTS_NUMBER -
                getRemainingAttemptCounter())*MALUS;
    }
}
