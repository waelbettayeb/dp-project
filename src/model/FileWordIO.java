package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class FileWordIO implements IWordIO{
    @Override
    public ArrayList<Word> getWords() {
        String[] a;
        int cpt = 0;
        String line = null;
        ArrayList<Word> words = new ArrayList<>();

        try {
            RandomAccessFile f = new RandomAccessFile("./mots.txt", "r");
            line = f.readLine();
            while ((line !=null) && (cpt<10)) {
                a = line.split(";");
//                System.out.println(a[0]+";"+a[1]+";"+a[2]);
                words.add(WordBuilder.wordFromString(a[2],new Hint(a[1], HintType.valueOf(a[0]))));
                cpt=cpt+1;
                line = f.readLine();
            }
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return words;
    }
}
