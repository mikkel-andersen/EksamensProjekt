package model;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MedarbejderTest {

    @org.junit.jupiter.api.Test
    void opretDestillation_test_1() {
        //Arrange
        Medarbejder medarbejder = new Medarbejder("Hans");
        Destillation destillation = new Destillation(LocalDate.of(2023, 11,29), LocalDate.of(2026,11,29), "Fire", "Byg", 300, 10, medarbejder);
        //Act
        Destillation faktiskResultat = medarbejder.opretDestillation(LocalDate.of(2023, 11,29), LocalDate.of(2026,11,29), "Fire", "Byg", 300, 10);
        //Assert
        assertEquals(destillation.getMedarbejder(), faktiskResultat.getMedarbejder());
        assertEquals(destillation.getAlkoholProcent(), faktiskResultat.getAlkoholProcent());
        assertEquals(destillation.getVaeskeILiter(), faktiskResultat.getVaeskeILiter());
        assertEquals(destillation.getKornSort(), faktiskResultat.getKornSort());
        assertEquals(destillation.getMaltBatch(), faktiskResultat.getMaltBatch());
        assertEquals(destillation.getSlutDato(), faktiskResultat.getSlutDato());
        assertEquals(destillation.getStartDato(), faktiskResultat.getStartDato());
    }

    @org.junit.jupiter.api.Test
    void opretDestillation_test_2() {
        //Arrange
        Medarbejder medarbejder = new Medarbejder("Hans");
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                    medarbejder.opretDestillation(LocalDate.of(2026, 11, 29), LocalDate.of(2026, 11, 23), "Fire", "Byg", 300, 10);});
            //Assert
        assertEquals("Startdato er efter slutdato", exception.getMessage());
    }
}