package model;

public class Medarbejder {
    private String navn;

    public Medarbejder(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
