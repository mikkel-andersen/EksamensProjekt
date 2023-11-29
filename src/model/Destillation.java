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

    public LocalDate getStartDato() {
        return startDato;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    public String getMaltBatch() {
        return maltBatch;
    }

    public void setMaltBatch(String maltBatch) {
        this.maltBatch = maltBatch;
    }

    public String getKornSort() {
        return kornSort;
    }

    public void setKornSort(String kornSort) {
        this.kornSort = kornSort;
    }

    public double getVaeskeILiter() {
        return vaeskeILiter;
    }

    public void setVaeskeILiter(double vaeskeILiter) {
        this.vaeskeILiter = vaeskeILiter;
    }

    public double getAlkoholProcent() {
        return alkoholProcent;
    }

    public void setAlkoholProcent(double alkoholProcent) {
        this.alkoholProcent = alkoholProcent;
    }

    public Medarbejder getMedarbejder() {
        return medarbejder;
    }

    public void setMedarbejder(Medarbejder medarbejder) {
        this.medarbejder = medarbejder;
    }
}
