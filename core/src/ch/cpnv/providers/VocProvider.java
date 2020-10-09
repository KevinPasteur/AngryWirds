package ch.cpnv.providers;

import java.util.ArrayList;

import ch.cpnv.kevangrywirds.KevAngryWirds;
import ch.cpnv.models.data.Vocabulary;
import ch.cpnv.models.data.Word;

public class VocProvider {

    private static VocProvider single_instance = null;

    public ArrayList<Vocabulary> vocs;

    private VocProvider(){
        vocs = new ArrayList<Vocabulary>();
        Word w;
        Vocabulary voc = new Vocabulary("L'argent");
        w = new Word("La banque", "The bank"); voc.addWord(w);
        w = new Word("L'argent liquide", "cash"); voc.addWord(w);
        w = new Word("Le paiement", "payment"); voc.addWord(w);
        w = new Word("Carnet de chèques", "checkbook"); voc.addWord(w);
        vocs.add(voc);

        voc= new Vocabulary("Les meubles");
        w = new Word("une table", "a table"); voc.addWord(w);
        w = new Word("une chaise", "a chair"); voc.addWord(w);
        w = new Word("une bibliothèque", "a bookcase"); voc.addWord(w);
        w = new Word("une table basse", "a coffee table"); voc.addWord(w);
        vocs.add(voc);
    }

    public static VocProvider getInstance(){
        if (single_instance==null)
            single_instance = new VocProvider();
        return single_instance;
    }

    public Vocabulary pickAVoc(){ return vocs.get(KevAngryWirds.alea.nextInt(vocs.size())); }

}
