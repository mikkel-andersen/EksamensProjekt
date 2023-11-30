package model;

import org.junit.jupiter.api.BeforeEach;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LagerTest {
    private Lager lager;
    private Lager lager2;
    ArrayList<String> historik = new ArrayList<>();
    private Fad fad;
    private Fad fad2;
    private Destillation destillation;
    Medarbejder medarbejder;
    Påfyldning påfyldning;
    Påfyldning påfyldning2;
    @BeforeEach
    void setUp() {
        lager = new Lager(1, 20, "Sall Lager");
        lager2 = new Lager(2, 1, "Sall Lager2");
        medarbejder = new Medarbejder("Jens");
        destillation = medarbejder.opretDestillation(LocalDate.of(2023,11,30), LocalDate.of(2023,12,1), "Fire", "Byg", 300, 10);
        fad = new Fad("Spanien", historik,150,1);
        fad2 = new Fad("Italien", historik,150,2);
        påfyldning = fad.opretPåfyldning(LocalDate.of(2023,11,30), 150, destillation);
        påfyldning2 = fad2.opretPåfyldning(LocalDate.of(2023,11,30), 150, destillation);
    }

    @org.junit.jupiter.api.Test
    void test_addFad() {
        //Act & Assert
        lager.addFad(fad);
        assertEquals(1, lager.getFadliste().size());
        assertEquals(fad, lager.getFadliste().get(0));
    }

    @org.junit.jupiter.api.Test
    void test_addFlereFad() {
        //Act & Assert
        lager.addFad(fad);
        lager.addFad(fad2);
        assertEquals(2, lager.getFadliste().size());
        assertEquals(fad, lager.getFadliste().get(0));
        assertEquals(fad2, lager.getFadliste().get(1));
    }

    @org.junit.jupiter.api.Test
    void test_addFad_overskrider_kapacitet() {
        //Act & Assert
        lager2.addFad(fad);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            lager2.addFad(fad2);
        });
        assertEquals("Lageret er fyldt", exception.getMessage());
        assertEquals(1, lager2.getFadliste().size());
        assertEquals(fad, lager2.getFadliste().get(0));
    }

    @org.junit.jupiter.api.Test
    void test_Tilføj_Samme_Fad() {
        //Act & Assert
        lager.addFad(fad);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            lager.addFad(fad);
        });
        assertEquals("Fadet er allerede på lageret", exception.getMessage());
        assertEquals(1, lager.getFadliste().size());
        assertEquals(fad, lager.getFadliste().get(0));
    }

    @org.junit.jupiter.api.Test
    void test_Fad_På_Flere_Lagere() {
        //Act & Assert
        lager.addFad(fad);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            lager2.addFad(fad);
        });
        assertEquals("Fadet er allerede på et andet lager", exception.getMessage());
        assertEquals(1, lager.getFadliste().size());
        assertEquals(0, lager2.getFadliste().size());
        assertEquals(fad, lager.getFadliste().get(0));
    }




}
