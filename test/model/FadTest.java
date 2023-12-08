package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FadTest {

    @Test
    void getAntalDage() {
// Arrange
        Fad fad = new Fad("Spanien", "Bourbon", 100,1);
        Medarbejder medarbejder = new Medarbejder("Hans");
        Destillation destillation = medarbejder.opretDestillation(LocalDate.of(2020,11,30), LocalDate.of(2020,12,1), "Fire", "Byg", 100, 57.5);
        ArrayList<Mængde> mængder = new ArrayList<>(List.of(new Mængde(100, destillation)));
        Lager lager = new Lager(1, 100, "Lager1");
        Påfyldning påfyldning = new Påfyldning(LocalDate.of(2021,12,1), fad, lager, mængder);

        // Act
        int faktiskResultat = fad.getAntalDage();
        int forventetResultat = (int) ChronoUnit.DAYS.between(påfyldning.getPaafyldningsDato(), LocalDate.now());
        // Assert
        assertEquals(forventetResultat, faktiskResultat);

    }
}