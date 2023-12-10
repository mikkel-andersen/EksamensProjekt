package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WhiskyTest {

    private Destillation destillation;
    private Destillation destillation2;
    private Medarbejder medarbejder;
    ArrayList<Mængde> mængder;
    private Fad fad;
    private Fad fad2;
    private Lager lager;
    private Påfyldning påfyldning;
    private Påfyldning påfyldning2;
    private Whisky whisky;

    @BeforeEach
    void setUp() {
        medarbejder = new Medarbejder("Jens");
        destillation = medarbejder.opretDestillation(LocalDate.of(2019,1,1), LocalDate.of(2019,1,3), "NP77", "Byg", 100, 57.5);
        destillation2 = medarbejder.opretDestillation(LocalDate.of(2019,1,2), LocalDate.of(2019,1,4), "NP76", "Byg", 40, 53.5);
        mængder = new ArrayList<>(List.of(new Mængde(100, destillation)));
        ArrayList<Mængde> mængder2 = new ArrayList<>(List.of(new Mængde(40, destillation2)));

        fad = new Fad("Spanien", "Bourbon", 100,1);
        fad2 = new Fad("Italien", "Sherry", 40,2);

        lager = new Lager(1, 100, "Lager1");

        påfyldning = new Påfyldning(LocalDate.of(2019,1,5), fad, lager, mængder);
        påfyldning2 = new Påfyldning(LocalDate.of(2019,1,6), fad2, lager, mængder2);
        whisky = påfyldning.aftapFad("Whisky Test", LocalDate.of(2023,1,5));



    }

    @Test
    void addPåfyldning() {
        // Act
        whisky.addPåfyldning(påfyldning2);
        // Assert
        assertEquals(2, whisky.getPåfyldninger().size());
        assertEquals(140, whisky.getAntalLiter());
        assertEquals("Single Malt", whisky.getType());

    }

    @Test
    void fortyndWhisky() {
        // Act & Assert
        whisky.addPåfyldning(påfyldning2);
        assertEquals(140, whisky.getAntalLiter());
        assertEquals(56.35, whisky.getAlkoholProcent(), 0.01);
        whisky.fortyndWhisky(40);
        assertEquals(197.25, whisky.getAntalLiter(), 0.01);
        assertEquals(40, whisky.getAlkoholProcent());

    }
}