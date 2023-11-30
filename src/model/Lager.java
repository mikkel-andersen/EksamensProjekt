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
        if(antalFad >= kapacitet){
            throw new IllegalArgumentException("Lageret er fyldt");
        } else if (fad.getLager() != null && fad.getLager() != this) {
            throw new IllegalArgumentException("Fadet er allerede på et andet lager");
        }
        for(Fad nuværendeFad : fadliste){
            if(nuværendeFad.equals(fad)){
                throw new IllegalArgumentException("Fadet er allerede på lageret");
            }
        }
        fadliste.add(fad);
        fad.setLager(this);
        antalFad++;
    }

    public void removeFad(Fad fad) {
        fadliste.remove(fad);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public int getAntalFad() {
        return antalFad;
    }

    public void setAntalFad(int antalFad) {
        this.antalFad = antalFad;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public List<Fad> getFadliste() {
        return fadliste;
    }

    public void setFadliste(List<Fad> fadliste) {
        this.fadliste = fadliste;
    }
}
