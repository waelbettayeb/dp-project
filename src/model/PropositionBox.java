package model;

import java.util.ArrayList;

public class PropositionBox extends Box implements IMalus {
    private static int UNIT_SCORE = 2;
    private static int MALUS= 1;
    private static ArrayList<Character> propositionBoxes;

    public PropositionBox(char expectedAnswer) {
        super(expectedAnswer);
    }

    @Override
    public int getMalus() {
        return (isMissed())? MALUS : 0;
    }

    private void generatePropositionBoxes(){
        char lCase = this.getExpectedAnswer();

    }
}
