package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Fad {

    private String oprindelsesLand;
    private String fadType;
    private Påfyldning[] påfyldninger = new Påfyldning[3];
    private Lager lager = null;
    private int kapacitetILiter;
    //TODO: Find ud af hvordan vi opdaterer counteren
    private int counter = 0;
    private int id;
    private boolean whisky;


    public Fad(String oprindelsesLand, String fadType, int kapacitet, int id) {
        this.oprindelsesLand = oprindelsesLand;
        this.fadType = fadType;
        this.kapacitetILiter = kapacitet;
        this.id = id;
    }

    public String getFadType() {
        return fadType;
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

    public void erWhisky(LocalDate dato) {
        if (ChronoUnit.YEARS.between(påfyldninger[this.counter].getPaafyldningsDato(), dato) >= 3) {
            this.whisky = true;
        } else {
            this.whisky = false;
        }
    }

    public boolean getIsWhisky() {
        return whisky;
    }

    public Påfyldning[] getPåfyldninger() {
        return påfyldninger;
    }

    public Lager getLager() {
        return lager;
    }

    public String getOprindelsesLand() {
        return oprindelsesLand;
    }


    public void setCounter(int counter) {
        this.counter = counter;
    }
    public int getCounter() {
        return counter;
    }
    public void addPåfyldning(Påfyldning påfyldning) {
        påfyldninger[counter] = påfyldning;
    }


    @Override
    public String toString() {
        return "Fad ID: " + getId() + ", OprindelsesLand: " + getOprindelsesLand() + ", Fad Type: " + getFadType();
    }
}