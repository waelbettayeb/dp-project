package model;

public class ZeroChanceBox extends Box {
    private static final int MAX_ATTEMPTS_NUMBER = 1;

    private static int UNIT_SCORE = 3;
    public ZeroChanceBox(char hiddenAnswer) {
        super(hiddenAnswer);
    }

}
