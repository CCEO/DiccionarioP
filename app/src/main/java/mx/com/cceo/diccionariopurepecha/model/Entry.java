package mx.com.cceo.diccionariopurepecha.model;

/**
 * Created by Hugo on 9/24/2015.
 */
public class Entry {
    public int getIdEntry() {
        return idEntry;
    }

    public void setIdEntry(int idEntry) {
        this.idEntry = idEntry;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public Entry(int idEntry, String word, String translation) {
        this.idEntry = idEntry;
        this.word = word;
        this.translation = translation;
    }

    private int idEntry;
    private String translation;
    private String word;
}
