package controller;

import model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void getController() {
        // Arrange
        Controller controller = Controller.getController();
        // Act
        Controller faktiskResultat = Controller.getController();
        // Assert
        assertEquals(controller, faktiskResultat);
    }



    @Test
    void opretDestillation() {
        // Arrange
        Controller controller = Controller.getController();
        Medarbejder medarbejder = new Medarbejder("Hans");
        // Act
        Destillation destillation = controller.opretDestillation(LocalDate.of(2023, 11,22),
                LocalDate.of(2023,11,29), "NP77", "Byg", 100, 57.5, medarbejder);
        // Assert
        assertEquals(destillation.getMedarbejder(), medarbejder); // Tjekker om medarbejderen er blevet tilføjet til destillationen
        assertEquals(57.5, destillation.getAlkoholProcent()); // Tjekker om alkoholprocenten er blevet tilføjet til destillationen
        assertEquals(100, destillation.getVaeskeILiter()); // Tjekker om væsken er blevet tilføjet til destillationen
        assertEquals("Byg", destillation.getKornSort()); // Tjekker om kornsorten er blevet tilføjet til destillationen
        assertEquals("NP77", destillation.getMaltBatch()); // Tjekker om maltbatchen er blevet tilføjet til destillationen
        assertEquals(LocalDate.of(2023,11,29), destillation.getSlutDato()); // Tjekker om slutdatoen er blevet tilføjet til destillationen
        assertEquals(LocalDate.of(2023,11,22), destillation.getStartDato()); // Tjekker om startdatoen er blevet tilføjet til destillationen
        assertEquals(1, Controller.getController().getDestillationer().size()); // Tjekker om destillationen er blevet tilføjet til listen af destillationer
        assertEquals(destillation, Controller.getController().getDestillationer().get(0)); // Tjekker om destillationen er blevet tilføjet til listen af destillationer

    }

    @Test
    void opretLager() {
        // Arrange
        Controller controller = Controller.getController();
        // Act
        Lager lager = controller.opretLager("Lager",100);
        // Assert
        assertEquals("Lager", lager.getNavn()); // Tjekker om navnet er blevet tilføjet til lageret
        assertEquals(100, lager.getKapacitet()); // Tjekker om kapaciteten er blevet tilføjet til lageret
        assertEquals(1, Controller.getController().getLager().size()); // Tjekker om lageret er blevet tilføjet til listen af lagre
        assertEquals(lager, Controller.getController().getLager().get(0)); // Tjekker om lageret er blevet tilføjet til listen af lagre

    }

    @Test
    void opretPåfyldning() {
        // Arrange
        Controller controller = Controller.getController();
        Medarbejder medarbejder = new Medarbejder("Hans");
        Destillation destillation = controller.opretDestillation(LocalDate.of(2023, 11,22),
                LocalDate.of(2023,11,29), "NP77", "Byg", 100, 57.50, medarbejder);
        Lager lager = controller.opretLager("Lager",100);
        Fad fad = controller.opretFad("Spanien", "Bourbon", 100);
        ArrayList<Mængde> mængder = new ArrayList<>(List.of(new Mængde(100, destillation)));
        // Act
        Påfyldning påfyldning = controller.opretPåfyldning(LocalDate.of(2023,11,29), fad, lager, mængder);
        // Assert
        assertEquals(1, påfyldning.getDestillationer().size()); // Tjekker om destillationen er blevet tilføjet til påfyldningen
        assertEquals(100, påfyldning.getLiter()); // Tjekker om literen er blevet tilføjet til påfyldningen
        assertEquals(0, fad.getCounter()); // Tjekker om counteren er blevet tilføjet til fadet
        assertEquals(lager, fad.getLager()); // Tjekker om lageret er blevet tilføjet til fadet
        assertEquals(1, fad.getLager().getFadliste().size()); // Tjekker om fadet er blevet tilføjet til listen af fad
        assertEquals(57.49999999999999, påfyldning.udregnAlkoholProcent()); // Tjekker om alkoholprocenten er blevet udregnet korrekt

    }

    @Test
    void opretMængde() {
        // Arrange
        Controller controller = Controller.getController();
        Medarbejder medarbejder = new Medarbejder("Hans");
        Destillation destillation = controller.opretDestillation(LocalDate.of(2023, 11,22),
                LocalDate.of(2023,11,29), "NP77", "Byg", 100, 57.50, medarbejder);
        Påfyldning påfyldning = controller.opretPåfyldning(LocalDate.of(2023,11,29), new Fad("Spanien", "Bourbon", 100,1), new Lager(1, 100, "Lager1"), new ArrayList<>());
        // Act
        Mængde mængde = controller.opretMængde(100, destillation);
        påfyldning.addMængde(mængde);
        // Assert
        assertEquals(100, mængde.getMængde()); // Tjekker om mængden er blevet tilføjet til mængden
        assertEquals(destillation, mængde.getDestillation()); // Tjekker om destillationen er blevet tilføjet til mængden
        assertEquals(1, påfyldning.getDestillationer().size()); // Tjekker om destillationen er blevet tilføjet til påfyldningen
        assertEquals(100, påfyldning.getLiter()); // Tjekker om literen er blevet tilføjet til påfyldningen
        assertEquals(mængde, påfyldning.getMængder().get(0)); // Tjekker om påfyldningen er blevet tilføjet til mængden


    }

    @Test
    void opretFad() {
        // Arrange
        Controller controller = Controller.getController();
        // Act
        Fad fad = controller.opretFad("Spanien", "Bourbon", 100);
        // Assert
        assertEquals("Spanien", fad.getOprindelsesLand()); // Tjekker om oprindelseslandet er blevet tilføjet til fadet
        assertEquals("Bourbon", fad.getFadType()); // Tjekker om fadtypen er blevet tilføjet til fadet
        assertEquals(100, fad.getKapacitetILiter()); // Tjekker om kapaciteten er blevet tilføjet til fadet
        assertEquals(1, Controller.getController().getFadListe().size()); // Tjekker om fadet er blevet tilføjet til listen af fad
        assertEquals(fad, Controller.getController().getFadListe().get(0)); // Tjekker om fadet er blevet tilføjet til listen af fad
    }


}