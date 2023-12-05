package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Fad {
    private Lager lager = null;
    private String oprindelsesLand;
    private String fadType;
    private ArrayList<String> historik = new ArrayList<>();
    private ArrayList<Destillation> destillater = new ArrayList<>();
    private List<Påfyldning> påfyldninger = new ArrayList<>();
    private int kapacitetILiter;
    private int id;
    private boolean whisky;



    private double antalLiterPaafyldt;

    public Fad(String oprindelsesLand, ArrayList<String> historik, String fadType, int kapacitet, int id) {
        this.oprindelsesLand = oprindelsesLand;
        this.fadType = fadType;
        this.kapacitetILiter = kapacitet;
        this.id = id;
        this.antalLiterPaafyldt = 0;
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

    public void erWhisky() {
        if (ChronoUnit.YEARS.between(LocalDate.now(), påfyldninger.get(0).getPaafyldningsDato()) >= 3) {
            whisky = true;
        } else {
            whisky = false;
        }
    }

    public boolean isWhisky() {
        return whisky;
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

    public Whisky aftapFad() {
        if (antalLiterPaafyldt == 0) {
            throw new IllegalArgumentException("Der er ikke påfyldt noget på fadet");
        } else if (isWhisky()) {
            throw new IllegalArgumentException("Fadet er ikke gammelt nok til at blive til whisky");
        } else {
            Whisky whisky = new Whisky(LocalDate.now(), (int) antalLiterPaafyldt, 57.5, "Whisky", "Whisky på " + oprindelsesLand + " ", "Whisky");
            antalLiterPaafyldt = 0;
            historik.add(whisky.toString());
            return whisky;
        }
    }

    public Lager getLager() {
        return lager;
    }

    public String getOprindelsesLand() {
        return oprindelsesLand;
    }

    public void setOprindelsesLand(String oprindelsesLand) {
        this.oprindelsesLand = oprindelsesLand;
    }

    public void setHistorik(ArrayList<String> historik) {
        this.historik = historik;
    }

    public void setDestillater(ArrayList<Destillation> destillater) {
        this.destillater = destillater;
    }

    public void setPåfyldninger(List<Påfyldning> påfyldninger) {
        this.påfyldninger = påfyldninger;
    }

    public void setKapacitetILiter(int kapacitetILiter) {
        this.kapacitetILiter = kapacitetILiter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAntalLiterPaafyldt() {
        return antalLiterPaafyldt;
    }

    public void setAntalLiterPaafyldt(double antalLiterPaafyldt) {
        this.antalLiterPaafyldt = antalLiterPaafyldt;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fad ID: ").append(id)
                .append("\nOprindelsesland: ").append(oprindelsesLand)
                .append("\nFadtype: ").append(fadType)
                .append("\nKapacitet i liter: ").append(kapacitetILiter)
                .append("\nAntal liter påfyldt: ").append(antalLiterPaafyldt)
                .append("\nEr Whisky: ").append(whisky)
                .append("\nHistorik:\n");

        for (String history : historik) {
            stringBuilder.append("  - ").append(history).append("\n");
        }

        stringBuilder.append("Påfyldninger:\n");
        for (Påfyldning påfyldning : påfyldninger) {
            stringBuilder.append("  - ").append(påfyldning.toString()).append("\n");
        }

        stringBuilder.append("Destillater:\n");
        for (Destillation destillation : destillater) {
            stringBuilder.append("  - ").append(destillation.toString()).append("\n");
        }

        return stringBuilder.toString();
    }
}