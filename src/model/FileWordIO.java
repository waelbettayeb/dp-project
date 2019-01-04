package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class FileWordIO implements IWordIO{
    @Override
    public ArrayList<Word> getWords() {
        String[] a;
        int cpt=0;
        String line = null;
        ArrayList<Word> words = new ArrayList<>();

        try {
            RandomAccessFile f = new RandomAccessFile("mots.txt", "r");
            while ((line !=null) && (cpt<10)) {
                line = f.readLine();
                a = line.split(";");
                words.add(WordBuilder.wordFromString(a[2],new Hint(a[1], HintType.valueOf(a[0]))));
                cpt=cpt+1;
            }
        }
        catch (FileNotFoundException ex) {
        }
        catch (IOException ex) {
        }

        return words;
    }
}
