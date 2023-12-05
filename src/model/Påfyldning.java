package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Påfyldning {

    private LocalDate paafyldningsDato;
    private ArrayList<Mængde> mængder;
    private Fad fad;

    public Påfyldning(LocalDate paafyldningsDato, ArrayList<Mængde> mængder, Fad fad) {
        this.paafyldningsDato = paafyldningsDato;
        this.mængder = mængder;
        this.fad = fad;
    }



    public LocalDate getPaafyldningsDato() {
        return paafyldningsDato;
    }


    @Override
    public String toString() {
                return "liter d. " + getPaafyldningsDato();
    }

    public void setPaafyldningsDato(LocalDate paafyldningsDato) {
        this.paafyldningsDato = paafyldningsDato;
    }

    public double udregnAlkoholProcent() {
        double alkoholProcent = 0.0;
        double totalMængde = 0.0;
        for (Mængde mængde : mængder) {
            alkoholProcent += mængde.getMængde() * (mængde.getDestillation().getAlkoholProcent() / 100);
            totalMængde += mængde.getMængde();
        }
        alkoholProcent = alkoholProcent / totalMængde;
        return alkoholProcent;
    }


}