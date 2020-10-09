package ch.cpnv.models.data;
import java.util.ArrayList;

import ch.cpnv.kevangrywirds.KevAngryWirds;

public class Vocabulary {
    private String vocName;
    private ArrayList<Word> words;

    public Vocabulary(String vocName){
        this.vocName = vocName;
        this.words = new ArrayList<Word>();
    }

    public void addWord(Word w){
        words.add(w);
    }

    public Word pickAWord(){
        return words.get(KevAngryWirds.alea.nextInt(words.size()));
    }


}
