package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Whisky {
    private LocalDate aftapningsDato;
    private ArrayList<Påfyldning> påfyldninger = new ArrayList<>();
    private double antalLiter;
    private double alkoholProcent;
    private String type;




    public Whisky(LocalDate aftapningsDato, double antalLiter, double alkoholProcent) {
        this.aftapningsDato = aftapningsDato;
        this.antalLiter = antalLiter;
        this.alkoholProcent = alkoholProcent;

    }

    public LocalDate getAftapningsDato() {
        return aftapningsDato;
    }
    public double getAlkoholProcent() {
        return alkoholProcent;
    }

    public void opdaterAlkoholProcent() {
        double alkoholProcent = 0.0;
        double totalMængde = 0.0;
        for (Påfyldning p : påfyldninger) {
            for (Mængde m : p.getMængder()) {
                alkoholProcent += m.getMængde() * (m.getDestillation().getAlkoholProcent() / 100);
                totalMængde += m.getMængde();
            }
        }
        this.alkoholProcent = alkoholProcent / totalMængde;
    }

    public void addPåfyldning(Påfyldning påfyldning) {
        if (påfyldning.erWhisky() && !påfyldninger.contains(påfyldning)) {
            påfyldninger.add(påfyldning);
        } else {
            throw new IllegalArgumentException("Påfyldning er ikke whisky eller er allerede tilføjet");
        }

        double liter = 0;
        for (Påfyldning p : påfyldninger) {
            liter += p.getLiter();
        }
        this.antalLiter = liter;
        opdaterAlkoholProcent();
    }

    public int udregnAntalFlasker() {
        int antalFlasker = 0;
        antalFlasker = (int) (antalLiter / 0.7);
        return antalFlasker;
    }

    public void setType() {
        if (påfyldninger.size() == 1) {
            type = "Single Cask";
        } else if (påfyldninger.size() > 1){
            type = "Single Malt";
        }
    }

    public String whiskyLabel() {

        String label = "";
        if (påfyldninger.size() == 1) {
            label += "Flaske x af: " + udregnAntalFlasker() + "\n";
            label += type + "\n";
            label += "Aftappet d. " + getAftapningsDato() + "\n";
            label += "Fadtype: " + påfyldninger.get(0).getFad().getFadType() + "\n";
            label += "Oprindelsesland: " + påfyldninger.get(0).getFad().getOprindelsesLand() + "\n";
            label += "Maltbatch: " + påfyldninger.get(0).getDestillationer().get(0).getMaltBatch() + "\n";
            label += "Kornsort: " + påfyldninger.get(0).getDestillationer().get(0).getKornSort() + "\n";
            label += "Alkoholprocent: " + getAlkoholProcent() + "% - 70 cl \n";
            label += "Destilleret af: " + påfyldninger.get(0).getDestillationer().get(0).getMedarbejder().getNavn() + "\n";
        } else if (påfyldninger.size() > 1) {
            label += "Flaske x af: " + udregnAntalFlasker() + "\n";
            label += type + "\n";
            label += "Aftappet d. " + getAftapningsDato() + "\n";

            label += "Har: " + påfyldninger.get(0).getFad().getFadType() + "\n";
        }
        return label;
    }







}
