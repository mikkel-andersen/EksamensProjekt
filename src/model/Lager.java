package model;

import java.util.ArrayList;
import java.util.List;

public class Lager {
    private int id;
    private int kapacitet;
    private int antalFad = 0;
    private String navn;
    private List<Fad> fadliste;

    public Lager(int id, int kapacitet, String navn) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.navn = navn;
        fadliste = new ArrayList<>();
    }

    /*
       Add metode til lagerets fadliste
       mangler måske en condition, så der ikke kan være den samme tønde på flere lagere
       Kan evt. løses med en instans variabel.
     */

    public void addFad(Fad fad) {
        for(Fad nuværendeFad : fadliste){
            if(nuværendeFad.equals(fad)){
                throw new IllegalArgumentException("Tønden er allerede tilstede på dette lager");
            }
        }
        fadliste.add(fad);
        fad.setLager(this);
        antalFad++;
    }

    public void removeFad(Fad fad) {
        fadliste.remove(fad);
    }
}
