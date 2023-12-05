package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Fad {
    private Lager lager = null;
    private String oprindelsesLand;
    private String fadType;
    private List<Påfyldning> påfyldninger = new ArrayList<>();
    private int kapacitetILiter;
    private int id;
    private boolean whisky;
    private double antalLiterPaafyldt;

    public Fad(String oprindelsesLand, String fadType, int kapacitet, int id) {
        this.oprindelsesLand = oprindelsesLand;
        this.fadType = fadType;
        this.kapacitetILiter = kapacitet;
        this.id = id;
        this.antalLiterPaafyldt = 0;
    }

    public String getFadType() {
        return fadType;
    }

    public void setFadType(String fadType) {
        this.fadType = fadType;
    }

    public void setWhisky(boolean whisky) {
        this.whisky = whisky;
    }
    public void setLager(Lager lager) {
        this.lager = lager;
    }


    public int getKapacitetILiter() {
        return kapacitetILiter;
    }

    public int getId() {
        return id;
    }

    public void erWhisky() {
        if (ChronoUnit.YEARS.between(LocalDate.now(), påfyldninger.get(0).getPaafyldningsDato()) >= 3) {
            whisky = true;
        } else {
            whisky = false;
        }
    }

    public boolean isWhisky() {
        return whisky;
    }

    public List<Påfyldning> getPåfyldninger() {
        return påfyldninger;
    }

    public Påfyldning opretPåfyldning(LocalDate dato, ArrayList<Mængde> mængder, Fad fad) {
        double antalLiter = 0;
        for (Mængde mængde : mængder) {
            antalLiter += mængde.getMængde();
        }
        if (antalLiter > kapacitetILiter) {
            throw new IllegalArgumentException("Antal liter er større end fadets størrelse");
        } else if (dato == null || antalLiter == 0) {
            throw new IllegalArgumentException("En eller flere parametre null eller 0");
        } else if (antalLiter + antalLiterPaafyldt > kapacitetILiter) {
            throw new IllegalArgumentException("Antal liter overstiger fadets størrelse");
        } else {
            Påfyldning påfyldning = new Påfyldning(dato, mængder, fad);
            påfyldninger.add(påfyldning);
            return påfyldning;
        }
    }


    public Lager getLager() {
        return lager;
    }

    public String getOprindelsesLand() {
        return oprindelsesLand;
    }

    public void setOprindelsesLand(String oprindelsesLand) {
        this.oprindelsesLand = oprindelsesLand;
    }


    public void setPåfyldninger(List<Påfyldning> påfyldninger) {
        this.påfyldninger = påfyldninger;
    }

    public void setKapacitetILiter(int kapacitetILiter) {
        this.kapacitetILiter = kapacitetILiter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAntalLiterPaafyldt() {
        return antalLiterPaafyldt;
    }

    public void setAntalLiterPaafyldt(double antalLiterPaafyldt) {
        this.antalLiterPaafyldt = antalLiterPaafyldt;
    }


    @Override
    public String toString() {
        return "Fad ID: " + getId() + ", OprindelsesLand: " + getOprindelsesLand() + ", Fad Type: " + getFadType();
    }
}