package model;

import java.util.ArrayList;

public class Session {

    private Player player;
    private ArrayList<Word> words;

    private int index = 0;

    public Session(Player player, ArrayList<Word> words) {
        this.player = player;
        this.words = words;
    }
    public int getScore(){
        var ref = new Object() {
            int score = 0;
        };
        words.forEach(word -> {
            ref.score += word.getScore();
        });
        return ref.score;
    }
    public boolean setChar(char aChar, int index){
        Box box = words.get(this.index).getBoxes().get(index);
        return box.setActualAnswer(aChar);
    }
    public Word getCurrentWord(){
        return words.get(this.index);
    }

}
