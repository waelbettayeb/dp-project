package model;

public class Hint {
    private String string;
    private HintType ht;

    public Hint(String string, HintType ht) {
        this.string = string;
        this.ht = ht;
    }

    @Override
    public String toString() {
        return "["+ ht.name() + "] "+this.string;
    }

    public String getString() {
        return string;
    }

    public HintType getHintType() {
        return ht;
    }
}
