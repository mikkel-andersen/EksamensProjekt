package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class Påfyldning {

    private LocalDate paafyldningsDato;
    private Whisky whisky = null;
    private ArrayList<Mængde> mængder = new ArrayList<>();
    private Fad fad;

    public Påfyldning() {
        //Tom constructor, da der først skal tilføjes mængder
        //Datoen tilføjes når et fad påfyldes
    }

    public void påfyldFad(LocalDate paafyldningsDato, Fad fad, Lager lager) {
        if (fad.getCounter() >= 3) {
            throw new IllegalArgumentException("Fadet kan ikke bruges længere");
        }
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

    public void setWhisky(Whisky whisky) {
        if (this.whisky == null) {
            this.whisky = whisky;
        } else {
            throw new IllegalArgumentException("Whisky er allerede oprettet med denne påfyldning");
        }

    }

    public void setPaafyldningsDato(LocalDate paafyldningsDato) {
        this.paafyldningsDato = paafyldningsDato;
    }

    public ArrayList<Mængde> getMængder() {
        return mængder;
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

    public boolean erWhisky() {
        fad.erWhisky();
        return fad.isWhisky();
    }



    public Whisky aftapFad(LocalDate dato) {
        double alkoholProcent = udregnAlkoholProcent();
        double antalLiter = getLiter();
        LocalDate aftapningsDato = dato;

        if (erWhisky()) {
            Whisky whisky;
            whisky = new Whisky(aftapningsDato, antalLiter, alkoholProcent);
            setWhisky(whisky);
            whisky.addPåfyldning(this);
        } else {
            throw new IllegalArgumentException("Fadet er ikke gammelt nok til at blive til whisky");
        }
            return whisky;
    }

    public Fad getFad() {
        return fad;
    }
}

    public void setLiter(int liter) {
        this.liter = liter;
    }
}