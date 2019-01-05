package model;

import java.util.ArrayList;
import java.util.Random;

public class PropositionBox extends Box implements IMalus {
    private static int UNIT_SCORE = 2;
    private static int MALUS= 1;
    private static int MAX_LETTREPROPOSE = 4;
    private ArrayList<Character> proposedChars;


    public PropositionBox(char expectedAnswer) {
        super(expectedAnswer);
        this.generatePropositionBoxes();
    }

    @Override
    public int getMalus() {
        return (isMissed())? MALUS : 0;
    }

    private void generatePropositionBoxes(){

        ArrayList<Character> lettrePropose = new ArrayList<Character>();
        Random randomGenerator = new Random();
        int lettreIndex = randomGenerator.nextInt(MAX_LETTREPROPOSE);
        for(int i = 0; i < MAX_LETTREPROPOSE; i++ ) {

            if(i == lettreIndex)
                lettrePropose.add( this.getExpectedAnswer());
            else
                lettrePropose.add((char) (randomGenerator.nextInt(26)+ (int) 'a') );
        }
        this.proposedChars = lettrePropose;
    }

    public ArrayList<Character> getProposedChars() {
        return proposedChars;
    }
}
