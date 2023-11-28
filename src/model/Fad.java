package model;

import java.util.ArrayList;

public class Fad {
    private String oprindelsesLand;
    private ArrayList<String> historik;
    private int stoerrelse;
    private int id;
    private double antalLiterPaafyldt;

    public Fad(String oprindelsesLand, ArrayList<String> historik, int stoerrelse, int id, double antalLiterPaafyldt) {
        this.oprindelsesLand = oprindelsesLand;
        this.historik = historik;
        this.stoerrelse = stoerrelse;
        this.id = id;
        this.antalLiterPaafyldt = antalLiterPaafyldt;
    }
}
