package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Whisky {
    private LocalDate aftapningsDato;
    private double antalLiter;
    private double alkoholProcent;
    private String navn;
    private String beskrivelse;
    private String type;
    private boolean fortyndet;
    private ArrayList<Fad> fadListe = new ArrayList<>();


    public Whisky(LocalDate aftapningsDato, double antalLiter, double alkoholProcent, ArrayList<Fad> fadListe) {
        this.aftapningsDato = aftapningsDato;
        this.antalLiter = antalLiter;
        this.alkoholProcent = alkoholProcent;
        this.fadListe = fadListe;
    }

    public LocalDate getAftapningsDato() {
        return aftapningsDato;
    }

    public void setAftapningsDato(LocalDate aftapningsDato) {
        this.aftapningsDato = aftapningsDato;
    }

    public double getAntalLiter() {
        return antalLiter;
    }

    public void setAntalLiter(int antalLiter) {
        this.antalLiter = antalLiter;
    }

    public double getAlkoholProcent() {
        return alkoholProcent;
    }

    public void setAlkoholProcent(double alkoholProcent) {
        this.alkoholProcent = alkoholProcent;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if(fortyndet == false){
            this.type += "Cask Strength";
        }
        if(fadListe.size() == 1){
            this.type += "Single Cask";
        }
        else {
            this.type += "Single malt";
            }
    }

    public ArrayList<Fad> getFadListe() {
        return fadListe;
    }

    public void addFad(Fad fad){
        fadListe.add(fad);
    }





}
