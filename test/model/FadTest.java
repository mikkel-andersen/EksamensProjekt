package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class FadTest {

    // Arrange er lavet i setUp().

    private Fad fad;
    private Destillation destillation;
    private Medarbejder medarbejder;

    @BeforeEach
    void setUp(){
        ArrayList<String> historik = new ArrayList<>();
        medarbejder = new Medarbejder("Jens");
        destillation = medarbejder.opretDestillation(LocalDate.of(2023,11,30), LocalDate.of(2023,12,1), "Fire", "Byg", 300, 10);
        fad = new Fad("Spanien", historik, "Bourbon", 300,1);

    }



    @Test
    void opretPåfyldning_test_korrekte_inputs() {
        //Act & Assert
        Påfyldning faktiskResultat = fad.opretPåfyldning(LocalDate.of(2023,11,30), 300, destillation);
        assertEquals(300, faktiskResultat.getLiter()); // Tjekker om antal liter er blevet tilføjet til påfyldningen
        assertEquals(LocalDate.of(2023,11,30), faktiskResultat.getPaafyldningsDato()); // Tjekker om datoen er blevet tilføjet til påfyldningen
        assertEquals(destillation, faktiskResultat.getDestillation()); // Tjekker om destillationen er blevet tilføjet til påfyldningen
        assertEquals(fad.getPåfyldninger().get(0), faktiskResultat); // Tjekker om påfyldningen er blevet tilføjet til fadets påfyldningsliste
        assertEquals(fad.getHistorik().get(0), faktiskResultat.toString()); // Tjekker om påfyldningen er blevet tilføjet til historikken
        assertEquals(0, destillation.getVaeskeILiter()); // Tjekker om destillationens væske er blevet trukket fra
    }

    @Test
    void test_OpretPåfyldning_Med_For_Stort_Antal_Liter(){

        //Arrange
        // Act & Assert - fejlhåndtering af for stort antal liter
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            fad.opretPåfyldning(LocalDate.now(), 400, destillation);});
        assertEquals("Antal liter er større end fadets størrelse", exception.getMessage()); // Tjekker om fejlbeskeden er korrekt
        assertEquals(0, fad.getPåfyldninger().size()); // Tjekker om påfyldningen er blevet tilføjet til fadets påfyldningsliste
    }
}

