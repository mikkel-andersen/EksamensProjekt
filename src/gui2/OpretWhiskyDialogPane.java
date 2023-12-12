package gui2;

import controller.Controller;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
import model.Påfyldning;
import model.Whisky;

import java.time.LocalDate;

public class OpretWhiskyDialogPane extends Dialog<Whisky> {

    private Controller controller;
    private TextField navnField = new TextField();
    private DatePicker aftapningsDatoField = new DatePicker();
    private TextField antalLiterField = new TextField();
    private ComboBox<Påfyldning> påfyldningComboBox = new ComboBox<>();

    private Påfyldning påfyldning;

    public OpretWhiskyDialogPane(Controller controller) {
        this.setTitle("Opret Whisky");
        this.setHeaderText("Indtast Whisky Information");

        this.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        påfyldningComboBox.getItems().setAll(controller.getPåfyldninger());

        grid.add(new Label("Navn"), 0, 0);
        grid.add(new Label("Aftapningsdato"), 0, 1);
        grid.add(new Label("Antal Liter"), 0, 2);
        grid.add(new Label("Påfyldning"), 0, 3);

        grid.add(navnField, 1, 0);
        grid.add(aftapningsDatoField, 1, 1);
        grid.add(antalLiterField, 1, 2);
        grid.add(påfyldningComboBox, 1, 3);

        this.getDialogPane().setContent(grid);

        this.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                String navn = navnField.getText();
                LocalDate aftapningsDato = aftapningsDatoField.getValue();
                Påfyldning påfyldning = påfyldningComboBox.getValue();

                Whisky createdWhisky = controller.opretWhisky(påfyldning, navn, aftapningsDato);

                return createdWhisky;
            }
            return null;
        });


    }
}