package model;

import java.util.ArrayList;
import java.util.Random;

public class PropositionBox extends Box implements IMalus {
    private static int UNIT_SCORE = 2;
    private static int MALUS= 1;
    private static int MAX_LETTREPROPOSE = 4;
    private char[] proposedChars;


    public PropositionBox(char expectedAnswer) {
        super(expectedAnswer);
        this.generatePropositionBoxes();
    }

    @Override
    public int getMalus() {
        return (isMissed())? MALUS : 0;
    }

    private void generatePropositionBoxes(){

        char[] lettrePropose = new char[MAX_LETTREPROPOSE];
        Random randomGenerator = new Random();
        int lettreIndex = randomGenerator.nextInt(MAX_LETTREPROPOSE);
        for(int i = 0; i < MAX_LETTREPROPOSE; i++ ) {

            if(i == lettreIndex)
                lettrePropose[i] = this.getExpectedAnswer();
            else
                lettrePropose[i] = (char) (randomGenerator.nextInt(26)+ (int) 'a') ;
        }
        this.proposedChars = lettrePropose;
    }

    public char[] getProposedChars() {
        return proposedChars;
    }
}
