package model;

import java.util.ArrayList;

public class Word {
    private ArrayList<Box> boxes;
    private Hint Hint;

    public Word(ArrayList<Box> boxes, Hint hint) {
        this.boxes = boxes;
        Hint = hint;
    }
    public int getScore(){
        var ref = new Object() {
            int score = 0;
        };
        boxes.forEach(box -> {
            ref.score += box.getScore();
            if(box instanceof IMalus)
                ref.score -= ((IMalus) box).getMalus();
        });
        return ref.score;
    }
    public boolean isMissed(){
        var ref = new Object() {
            boolean b = false;
        };
        boxes.forEach(box -> {
            if(box.isMissed()){
                ref.b = true;
            }
        });
        return ref.b;
    }
    public boolean isPassed(){
        var ref = new Object() {
            boolean b = true;
        };
        boxes.forEach(box -> {
            if(!box.isPassed()){
                ref.b = false;
            }
        });
        return ref.b;
    }
    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public model.Hint getHint() {
        return Hint;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boxes.forEach(box -> {
            sb.append(box.getExpectedAnswer());
        });
        return sb.toString();
    }
}
