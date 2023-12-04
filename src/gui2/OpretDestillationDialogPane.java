package gui2;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.Destillation;

import java.awt.*;
import java.time.LocalDate;

import javafx.scene.layout.GridPane;
import model.Destillation;
import controller.Controller;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Destillation;
import model.Medarbejder;


public class OpretDestillationDialogPane extends Dialog<Destillation> {

        private DatePicker startDatoField = new DatePicker();
        private DatePicker slutDatoField = new DatePicker();
        private TextField maltBatchField = new TextField();
        private TextField kornSortField = new TextField();
        private TextField vaeskeILiterField = new TextField();
        private TextField alkoholProcentField = new TextField();
        private TextField medarbejderField = new TextField();

        private Controller controller;

        public OpretDestillationDialogPane(Controller controller){

            this.setTitle("Create Destillation");
            this.setHeaderText("Enter Destillation Information");

            this.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);

            grid.add(new Label("StartDato:"), 0, 0);
            grid.add(startDatoField, 1, 0);
            grid.add(new Label("SlutDato:"), 0, 1);
            grid.add(slutDatoField, 1, 1);
            grid.add(new Label("MaltBatch:"), 0, 2);
            grid.add(maltBatchField, 1, 2);
            grid.add(new Label("KornSort:"), 0, 3);
            grid.add(kornSortField, 1, 3);
            grid.add(new Label("VaeskeILiter:"), 0, 4);
            grid.add(vaeskeILiterField, 1, 4);
            grid.add(new Label("AlkoholProcent:"), 0, 5);
            grid.add(alkoholProcentField, 1, 5);
            grid.add(new Label("Medarbejder:"), 0, 6);
            grid.add(medarbejderField, 1, 6);


            this.getDialogPane().setContent(grid);

            this.setResultConverter(dialogButton -> {
                if(dialogButton == ButtonType.OK){
                    LocalDate startDato = startDatoField.getValue();
                    LocalDate slutDato = slutDatoField.getValue();
                    String maltBatch = maltBatchField.getText();
                    String kornSort = kornSortField.getText();
                    double vaeskeILiter = Double.parseDouble(vaeskeILiterField.getText());
                    double alkoholProcent = Double.parseDouble(alkoholProcentField.getText());
                    String medarbejderObject = medarbejderField.getText();
                    Medarbejder medarbejder = new Medarbejder(medarbejderObject);

                    Destillation createdDestillation = controller.opretDestillation(startDato, slutDato, maltBatch, kornSort, vaeskeILiter, alkoholProcent, medarbejder);

                    return createdDestillation;
                }
                return null;
            });
        }
}