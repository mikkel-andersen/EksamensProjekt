package model;

import java.time.LocalDate;

public class Destillation {
    private LocalDate startDato;
    private LocalDate slutDato;
    private String maltBatch;
    private String kornSort;
    private double vaeskeILiter;
    private double alkoholProcent;
    private Medarbejder medarbejder;

    public Destillation(LocalDate startDato, LocalDate slutDato, String maltBatch,
                        String kornSort, double vaeskeILiter, double alkoholProcent, Medarbejder medarbejder) {
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.maltBatch = maltBatch;
        this.kornSort = kornSort;
        this.vaeskeILiter = vaeskeILiter;
        this.alkoholProcent = alkoholProcent;
        this.medarbejder = medarbejder;
    }
}
