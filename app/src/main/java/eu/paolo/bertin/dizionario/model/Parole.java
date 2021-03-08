package eu.paolo.bertin.dizionario.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parole {

    final private List<String> elenco;

    public Parole() {

        elenco = new ArrayList<>();
    }

    public void addParola(String parola) {

        elenco.add(parola);
    }

    public List<String> getElenco() {

        Collections.sort(elenco);
        return elenco;
    }

    public void reset() {

        elenco.clear();
    }

    public boolean removeWord(String word) {

        return elenco.remove(word);
    }
}
