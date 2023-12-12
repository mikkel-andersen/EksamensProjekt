package storage;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Destillation> destillationer;
    private List<Fad> fadListe;
    private List<Lager> lager;
    private List<Whisky> whisky;
    private List<Påfyldning> påfyldninger;

    public Storage() {
        destillationer = new ArrayList<>();
        fadListe = new ArrayList<>();
        lager = new ArrayList<>();
        whisky = new ArrayList<>();
        påfyldninger = new ArrayList<>();
    }

    public List<Destillation> getDestillationer() {
        return new ArrayList<>(destillationer);
    }

    public void addDestillation(Destillation destillation) {
        if (!destillationer.contains(destillation)) {
            destillationer.add(destillation);
        }
    }

    public void removeDestillation(Destillation destillation) {
        destillationer.remove(destillation);
    }

    public List<Fad> getFadListe() {
        return new ArrayList<>(fadListe);
    }

    public void addFad(Fad fad) {
        if (!fadListe.contains(fad)) {
            fadListe.add(fad);
        }
    }

    public void removeFad(Fad fad) {
        fadListe.remove(fad);
    }

    public List<Lager> getLager() {
        return new ArrayList<>(lager);
    }

    public void addLager(Lager lager) {
        if (!this.lager.contains(lager)) {
            this.lager.add(lager);
        }
    }

    public void addWhisky(Whisky whisky) {
        if (!this.whisky.contains(whisky)) {
            this.whisky.add(whisky);
        }
    }

    public void addPåfyldning(Påfyldning påfyldning) {
        if (!påfyldninger.contains(påfyldning)) {
            påfyldninger.add(påfyldning);
        }
    }

    public List<Påfyldning> getPåfyldninger() {
        return new ArrayList<>(påfyldninger);
    }

    public List<Whisky> getWhisky() {
        return new ArrayList<>(whisky);
    }
    

    public void removeLager(Lager lager) {
        this.lager.remove(lager);
    }

    public void reset() {
        destillationer.clear();
        fadListe.clear();
        lager.clear();
    }
}
