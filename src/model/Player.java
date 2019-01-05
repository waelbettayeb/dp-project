package model;

import java.util.TreeSet;

public class Player implements java.io.Serializable {
    private String pseudo;
    private TreeSet<Integer> scores;
    public Player(String pseudo) {
        this.pseudo = pseudo;
        scores = new TreeSet<>();
//        scores.add(0);
    }

    public Player(String pseudo, TreeSet<Integer> scores) {
        this.pseudo = pseudo;
        this.scores = scores;
    }

    public String getPseudo() {
        return this.pseudo;
    }
    public void addNewScore(int score) {
        this.scores.add(score);
    }

    @Override
    public String toString() {
        if(scores.isEmpty())
            return this.pseudo + " <0>";
        return this.pseudo + " <" + scores.first() + ">";
    }
}
