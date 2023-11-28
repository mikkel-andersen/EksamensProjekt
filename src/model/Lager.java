package model;

import java.util.ArrayList;

public class Lager {
    private int id;
    private int størrelse;
    private String navn;
    private ArrayList<Fad> fadliste;

    public Lager(int id, int størrelse, String navn) {
        this.id = id;
        this.størrelse = størrelse;
        this.navn = navn;
        fadliste = new ArrayList<>();
    }

    /*
       Add metode til lagerets fadliste
       mangler måske en condition, så der ikke kan være den samme tønde på flere lagere
       Kan evt. løses med en instans variabel.
     */

    public void addFad(Fad fad) {
        fadliste.add(fad);
    }

    public void removeFad(Fad fad) {
        fadliste.remove(fad);
    }
}
