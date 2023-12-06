package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PåfyldningTest {

    // Arrange er lavet i setUp().

    private Fad fad;
    private Destillation destillation;
    private Medarbejder medarbejder;
    private Lager lager;
    private ArrayList<Mængde> mængder;

    @BeforeEach
    void setUp(){

        medarbejder = new Medarbejder("Jens");
        destillation = medarbejder.opretDestillation(LocalDate.of(2023,11,30), LocalDate.of(2023,12,1), "Fire", "Byg", 100, 57.5);
        destillation = medarbejder.opretDestillation(LocalDate.of(2023,11,30), LocalDate.of(2023,12,2), "Fire", "Byg", 40, 53.5);
        fad = new Fad("Spanien", "Bourbon", 140,1);
        lager = new Lager(1, 100, "Lager1");
        mængder = new ArrayList<>(List.of(new Mængde(100, destillation), new Mængde(40, destillation)));
        Påfyldning påfyldning = new Påfyldning(LocalDate.of(2017,12,1), fad, lager, mængder);


    }



    @Test
    void opretPåfyldning_test_korrekte_inputs() {
        // Act
        Påfyldning påfyldning = new Påfyldning(LocalDate.of(2017,12,1), fad, lager, mængder);

        // Assert
        assertEquals(2, påfyldning.getDestillationer().size());
        assertEquals(140, påfyldning.getLiter());
        assertEquals(1, fad.getCounter());
        assertEquals(lager, fad.getLager());
        assertEquals(1, fad.getLager().getFadliste().size());



    }

    @Test
    void udregnAlkoholProcent() {
    }

    @Test
    void aftapFad() {
    }
}