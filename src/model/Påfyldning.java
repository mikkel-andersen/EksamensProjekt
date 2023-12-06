package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("NonAsciiCharacters")
public class Påfyldning {

    private LocalDate paafyldningsDato;
    private ArrayList<Mængde> mængder = new ArrayList<>();
    private Fad fad;

    public Påfyldning(LocalDate paafyldningsDato, Fad fad, Lager lager) {
        this.paafyldningsDato = paafyldningsDato;
        this.fad = fad;
        fad.setCounter(fad.getCounter() + 1);
        fad.setLager(lager);
    }

    public Mængde opretMængde(double mængde, Destillation destillation) {
        Mængde m = new Mængde(mængde, destillation);
        destillation.setVaeskeILiter(destillation.getVaeskeILiter() - mængde);
        mængder.add(m);
        return m;
    }


    public LocalDate getPaafyldningsDato() {
        return paafyldningsDato;
    }

    public int getLiter() {
        int liter = 0;
        for (Mængde mængde : mængder) {
            liter += mængde.getMængde();
        }
        return liter;
    }

    public ArrayList<Destillation> getDestillationer() {
        ArrayList<Destillation> destillationer = new ArrayList<>();
        for (Mængde mængde : mængder) {
            destillationer.add(mængde.getDestillation());
        }
        return destillationer;
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

    public void setDestillation(Destillation destillation) {
        this.destillation = destillation;
    }
}

    public void setLiter(int liter) {
        this.liter = liter;
    }
}