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
        if (!startDato.isBefore(slutDato)) {
            throw new IllegalArgumentException("Startdato er efter slutdato");
        } else if (startDato == null || slutDato == null || maltBatch == null || vaeskeILiter == 0) {
            throw new IllegalArgumentException("En eller flere parametre null eller 0");
        } else {
            return new Destillation(startDato, slutDato, maltBatch, kornSort, vaeskeILiter, alkoholProcent, this);
        }
    }
}
