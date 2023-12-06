package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Whisky {
    private LocalDate aftapningsDato;
    private int counter = 0;
    private double antalLiter;
    private double alkoholProcent;
    private String navn;
    private String beskrivelse;
    private String type;
    private boolean fortyndet;



    public Whisky(LocalDate aftapningsDato, double antalLiter, double alkoholProcent) {
        this.aftapningsDato = aftapningsDato;
        this.antalLiter = antalLiter;
        this.alkoholProcent = alkoholProcent;

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







}
