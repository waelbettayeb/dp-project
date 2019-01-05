package model;

import java.util.ArrayList;

public class WordBuilder {
    static int SUM_NUMBER_ZERO_PROPOSITION_BOX = 3;

    public static Word wordFromString(String string, Hint hint) {

        int length = string.length();
        int sum = randomWithRange(0, Math.min(SUM_NUMBER_ZERO_PROPOSITION_BOX, length));
        int numberOfPropositionBox = randomWithRange(0, sum);
        int numberOfZeroChanceBox =  sum - numberOfPropositionBox;

        ArrayList<Box> boxes = new ArrayList<Box>();
        for (int i = 0; i < (length - sum); i++) {
            boxes.add(new MultiChanceBox(string.charAt(i)));
        }
        for (int i = 0; i < numberOfPropositionBox; i++) {
            boxes.add(new PropositionBox(string.charAt(length - sum + i)));
        }
        for (int i = 0; i < numberOfZeroChanceBox; i++) {
            boxes.add(new ZeroChanceBox(string.charAt(length - numberOfZeroChanceBox + i)));
        }

        return new Word(boxes, hint);
    }




    static int randomWithRange(int min, int max)
    {
        int range = Math.abs(max - min) + 1;
        return (int)(Math.random() * range) + (min <= max ? min : max);
    }
}
