package model;

import java.util.ArrayList;

public class Fad {
    private Lager lager = null;
    private String oprindelsesLand;
    private ArrayList<String> historik;
    private ArrayList<Destillation> destillater;
    private int stoerrelse;
    private int id;
    private double antalLiterPaafyldt;

    public Fad(String oprindelsesLand, ArrayList<String> historik, int stoerrelse, int id) {
        this.oprindelsesLand = oprindelsesLand;
        this.historik = historik;
        this.stoerrelse = stoerrelse;
        this.id = id;
        this.antalLiterPaafyldt = 0;
        this.destillater = new ArrayList<>();
    }


}
