package model;

import java.time.LocalDate;

public class Påfyldning {

    private LocalDate paafyldningsDato;
    private Destillation destillation;
    private int liter;

    public Påfyldning(LocalDate paafyldningsDato, int liter, Destillation destillation) {
        this.paafyldningsDato = paafyldningsDato;
        this.destillation = destillation;
        this.liter = liter;
    }

    public LocalDate getPaafyldningsDato() {
        return paafyldningsDato;
    }

    public int getLiter() {
        return liter;
    }

    public Destillation getDestillation() {
        return destillation;
    }

    @Override
    public String toString() {
        return "Påfyldning af " + getLiter()
                + " liter d. " + getPaafyldningsDato();
    }
}