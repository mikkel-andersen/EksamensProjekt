package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Storage storage;
    private static Controller controller = null;

    private Controller() {
        storage = new Storage();
    }

    public static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public Storage getStorage() {
        return storage;
    }

    public Destillation opretDestillation(LocalDate startDato, LocalDate slutDato, String maltBatch, String kornSort,
                                          double vaeskeILiter, double alkoholProcent, Medarbejder medarbejder) {
        Destillation ds = medarbejder.opretDestillation(startDato, slutDato, maltBatch, kornSort, vaeskeILiter, alkoholProcent);
        storage.addDestillation(ds);
        return ds;
    }

    public Lager opretLager(String navn, int stoerrelse) {
        int nytID = storage.getLager().size() + 1;
        Lager lager = new Lager(nytID, stoerrelse, navn);
        storage.addLager(lager);
        return lager;
    }

    public Påfyldning opretPåfyldning(LocalDate paafyldningsDato, Fad fad, Lager lager, ArrayList<Mængde> mængder) {
        Påfyldning påfyldning = new Påfyldning(paafyldningsDato, fad, lager, mængder);
        return påfyldning;
    }

    public Mængde opretMængde(double mængde, Destillation destillation) {
        Mængde m = new Mængde(mængde, destillation);
        return m;
    }

    public Fad opretFad(String oprindelsesLand, String fadType, int kapacitet) {
        int nytID = storage.getFadListe().size() + 1;
        Fad fad = new Fad(oprindelsesLand, fadType, kapacitet, nytID);
        storage.addFad(fad);

        return fad;
    }



    public List<Destillation> getDestillationer() {
        return storage.getDestillationer();
    }

    public List<Fad> getFadListe() {
        return storage.getFadListe();
    }

    public List<Lager> getLager() {
        return storage.getLager();
    }

    /*public void createSomeObjects() {
//        Medarbejder m1 = new Medarbejder("Hans");
//
//        Destillation d1 = m1.opretDestillation(LocalDate.of(2020,11,30), LocalDate.of(2020,12,1), "NP77", "Byg", 100, 57.5);
//
//        Lager l1 = opretLager("Sall Lager", 100);
//
//        Fad f1 = opretFad("Spanien", "Bourbon", 100);
//
//        ArrayList<Mængde> mængder = new ArrayList<>(List.of(new Mængde(100, d1)));
//
//        Påfyldning p1 = opretPåfyldning(LocalDate.of(2020,12,1), f1, l1, mængder);
//
//        Whisky whisky = p1.aftapFad(LocalDate.of(2023,12,1));

    }*/

    public void reset() {
        storage.reset();
    }
}