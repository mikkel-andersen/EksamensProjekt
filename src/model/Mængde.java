package model;

public class Mængde {

   private double mængde;
   private Destillation destillation;

    public Mængde(double mængde, Destillation destillation) {
        this.mængde = mængde;
        this.destillation = destillation;
        destillation.setVaeskeILiter(destillation.getVaeskeILiter() - mængde);
    }

    public double getMængde() {
        return mængde;
    }

    public void setMængde(double mængde) {
        this.mængde = mængde;
    }

    public Destillation getDestillation() {
        return destillation;
    }
}
