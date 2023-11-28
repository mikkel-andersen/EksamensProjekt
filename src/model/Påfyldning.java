package model;

import java.time.LocalDate;

public class Påfyldning {

    private LocalDate paafyldningsDato;
    private int liter;

    public Påfyldning(LocalDate paafyldningsDato, int liter) {
        this.paafyldningsDato = paafyldningsDato;
        this.liter = liter;
    }
}
