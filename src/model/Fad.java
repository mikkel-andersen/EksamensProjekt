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
        if (ChronoUnit.YEARS.between(LocalDate.now(), påfyldninger[counter].getPaafyldningsDato()) >= 3) {
            whisky = true;
        } else {
            whisky = false;
        }
    }

    public boolean isWhisky() {
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

    public void setId(int id) {
        this.id = id;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }
    public int getCounter() {
        return counter;
    }


    @Override
    public String toString() {
        return "Fad ID: " + getId() + ", OprindelsesLand: " + getOprindelsesLand() + ", Fad Type: " + getFadType();
    }
}