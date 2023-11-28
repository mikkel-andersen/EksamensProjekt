package model;

import java.time.LocalDate;

public class Medarbejder {
    private String navn;

    public Medarbejder(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Destillation opretDestillation(LocalDate startDato, LocalDate slutDato, String maltBatch, String kornSort,
                                          double vaeskeILiter, double alkoholProcent) {
        return new Destillation(startDato, slutDato, maltBatch, kornSort, vaeskeILiter, alkoholProcent, this);
    }
}
