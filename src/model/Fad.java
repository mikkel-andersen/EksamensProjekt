package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fad {
    private Lager lager = null;
    private String oprindelsesLand;
    private ArrayList<String> historik;
    private ArrayList<Destillation> destillater;
    private List<Påfyldning> påfyldninger;
    private int kapacitetILiter;
    private int id;
    private double antalLiterPaafyldt;

    public Fad(String oprindelsesLand, ArrayList<String> historik, int kapacitet, int id) {
        this.oprindelsesLand = oprindelsesLand;
        this.historik = historik;
        this.kapacitetILiter = kapacitet;
        this.id = id;
        this.antalLiterPaafyldt = 0;
        this.destillater = new ArrayList<>();
        this.påfyldninger = new ArrayList<>();
    }

    public void setLager(Lager lager) {
        this.lager = lager;
    }

    public List<Destillation> getDestillater() {
        return new ArrayList<>(destillater);
    }

    public List<String> getHistorik() {
        return new ArrayList<>(historik);
    }

    public void addHistorik(String historik) {
        this.historik.add(historik);
    }

    public int getKapacitetILiter() {
        return kapacitetILiter;
    }

    public int getId() {
        return id;
    }

    public List<Påfyldning> getPåfyldninger() {
        return påfyldninger;
    }

    public Påfyldning opretPåfyldning(LocalDate dato, int antalLiter, Destillation destillation) { //TJEK EFTER
        if (antalLiter > kapacitetILiter) {
            throw new IllegalArgumentException("Antal liter er større end fadets størrelse");
        } else if (dato == null || antalLiter == 0) {
            throw new IllegalArgumentException("En eller flere parametre null eller 0");
        } else if (antalLiter + antalLiterPaafyldt > kapacitetILiter) {
            throw new IllegalArgumentException("Antal liter overstiger fadets størrelse");
        } else {
            Påfyldning påfyldning = new Påfyldning(dato, antalLiter, destillation);
            antalLiterPaafyldt += antalLiter;

            historik.add(påfyldning.toString());
            påfyldninger.add(påfyldning);
            return påfyldning;
        }
    }




}