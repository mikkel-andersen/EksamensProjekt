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

    public Påfyldning opretPåfyldning(LocalDate dato, int antalLiter, Destillation destillation, Fad fad) {
        Påfyldning påfyldning = fad.opretPåfyldning(dato, antalLiter, destillation);
        return påfyldning;
    }

    public Fad opretFad(String oprindelsesLand, ArrayList<String> historik, String fadType, int kapacitet) {
        int nytID = storage.getFadListe().size() + 1;
        Fad fad = new Fad(oprindelsesLand, historik, fadType, kapacitet, nytID);
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

    public void createSomeObjects() {
        Medarbejder m1 = new Medarbejder("Hans");

}
}