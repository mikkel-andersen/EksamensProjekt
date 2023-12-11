package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Whisky {
    private String navn;
    private LocalDate aftapningsDato;
    private ArrayList<Påfyldning> påfyldninger = new ArrayList<>();
    private double antalLiter;
    private double alkoholProcent;
    private String type;
    private boolean fortyndet = false;




    public Whisky(String navn, LocalDate aftapningsDato, double antalLiter, double alkoholProcent) {
        this.navn = navn;
        this.aftapningsDato = aftapningsDato;
        this.antalLiter = antalLiter;
        this.alkoholProcent = alkoholProcent;

    }

    public double getAntalLiter() {
        return antalLiter;
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
        this.alkoholProcent = (alkoholProcent / totalMængde) * 100;
    }

    public void addPåfyldning(Påfyldning påfyldning) {
        if (påfyldning.erWhisky(aftapningsDato) && !påfyldninger.contains(påfyldning)) {
            påfyldninger.add(påfyldning);
            setType();
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
        } else if (påfyldninger.size() > 1 && isSammeKornsort()) {
            type = "Single Malt";
        }
        else{
            type = "Blended";
        }
    }

    public boolean isSammeKornsort() {
        if (påfyldninger.isEmpty() || påfyldninger.get(0).getDestillationer().isEmpty()) {
            return false; // Assuming empty lists mean not the same KornSort
        }
        String firstKornsort = påfyldninger.get(0).getDestillationer().get(0).getKornSort();
        for (Påfyldning p : påfyldninger) {
            for (Destillation d : p.getDestillationer()) {
                if (!d.getKornSort().equals(firstKornsort)) {
                    return false; // Found a different KornSort, return false immediately
                }
            }
        }
        return true; // All KornSort values were the same
    }
    public String getType() {
        return type;
    }

    public ArrayList<Påfyldning> getPåfyldninger() {
        return påfyldninger;
    }

    public void fortyndWhisky(double ønsketAlkoholProcent) {
        antalLiter += ((alkoholProcent * antalLiter) - (ønsketAlkoholProcent * antalLiter)) / (ønsketAlkoholProcent);
        alkoholProcent = ønsketAlkoholProcent;
        this.fortyndet = true;
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

        }
        return label;
    }

    public String getNavn() {
        return navn;
    }
}
