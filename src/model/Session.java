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
        return words.get(this.index % 10);
    }
    public Word getNextWord(){
        this.incIndex();
        return words.get(this.index %10);
    }

    public int getIndex() {
        return index;
    }

    public boolean endSession() {
        var ref = new Object() {
            int i = 0;
        };
        words.forEach(word -> {
            if(word.isMissed())
                ref.i++;
        });
        return ((index > 9)||(ref.i>5));
    }
    public boolean isWin(){
        var ref = new Object() {
            int i = 0;
        };
        words.forEach(word -> {
            if(word.isMissed())
                ref.i++;
        });
        return ((endSession()) && (ref.i < 6));
    }

    public Player getPlayer() {
        return player;
    }

    public void incIndex() {
        this.index++;
    }
}
