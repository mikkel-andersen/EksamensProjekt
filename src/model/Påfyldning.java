package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

// se de fade der er på et bestemt lager
// se de fade der er på et bestemt lager, der er ældre end 3 år
// se alle fade

public class Påfyldning {

    private LocalDate paafyldningsDato;
    private Whisky whisky = null;
    private ArrayList<Mængde> mængder = new ArrayList<>();
    private Fad fad;

    public Påfyldning(LocalDate paafyldningsDato, Fad fad, Lager lager, ArrayList<Mængde> mængder) {
        this.mængder = mængder;
        if (fad.getCounter() >= 3) {
            throw new IllegalArgumentException("Fadet kan ikke bruges længere");
        } else if (getLiter() > fad.getKapacitetILiter()) {
            throw new IllegalArgumentException("Der kan ikke fyldes så meget på fadet");
        } else if (fad.getLager() != null && fad.getLager() != lager) {
            throw new IllegalArgumentException("Fadet er allerede på et andet lager");

        } else if (fad.getLager() == lager && fad.getLager() != null) {
            System.out.println("fad.getLager(): " + fad.getLager());
            System.out.println("lager: " + lager);

            throw new IllegalArgumentException("Fadet er allerede på dette lager");
        }
        this.paafyldningsDato = paafyldningsDato;
        this.fad = fad;
        fad.setPåfyldning(this); // Sætter påfyldningen på fadet
        fad.addPåfyldning(this); // Tilføjer påfyldningen til fadets historik
        lager.addFad(fad);
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


    public void setWhisky(Whisky whisky) {
        if (this.whisky == null) {
            this.whisky = whisky;
        } else {
            throw new IllegalArgumentException("Whisky er allerede oprettet med denne påfyldning");
        }

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
        return alkoholProcent * 100;
    }

    public boolean erWhisky(LocalDate dato) {
        fad.erWhisky(dato);
        return fad.getIsWhisky();
    }


    public Whisky aftapFad(LocalDate dato) {
        double alkoholProcent = udregnAlkoholProcent();
        double antalLiter = getLiter();
        LocalDate aftapningsDato = dato;

        if (erWhisky(aftapningsDato)) {
            Whisky whisky;
            whisky = new Whisky(aftapningsDato, antalLiter, alkoholProcent);
            setWhisky(whisky);
            whisky.addPåfyldning(this);
            fad.setPåfyldning(null);
            fad.setCounter(fad.getCounter() + 1);
        } else {
            throw new IllegalArgumentException("Fadet er ikke gammelt nok til at blive til whisky");
        }
        return whisky;
    }

    public Fad getFad() {
        return fad;
    }

    public void addMængde(Mængde mængde) {
        mængder.add(mængde);
    }



}