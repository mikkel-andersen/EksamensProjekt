package gui2;

import controller.Controller;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import model.Påfyldning;
import controller.Controller;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.Fad;

import java.awt.*;

public class OpretPåfyldningDialogPane extends Dialog<Påfyldning> {


    private ComboBox fadListeField = new ComboBox();
    private DatePicker påfyldningsDatoField = new DatePicker();
    private ComboBox lagerField = new ComboBox();
    private Controller controller;



    public OpretPåfyldningDialogPane(Controller controller){
        this.setTitle("Create Påfyldning");
        this.setHeaderText("Enter Påfyldning Information");

        this.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        fadListeField.getItems().setAll(controller.getFadListe());

        lagerField.getItems().setAll(controller.getLager());

        grid.add(new Label("Fad:"), 0, 0);
        grid.add(new Label("PåfyldningsDato:"), 0, 1);
        grid.add(new Label("Lager:"), 0, 2);
        grid.add(fadListeField, 1, 0);
        grid.add(påfyldningsDatoField, 1, 1);
        grid.add(lagerField, 1, 2);

        this.getDialogPane().setContent(grid);

        this.setResultConverter((ButtonType button) -> {
            if (button == ButtonType.OK) {
                Påfyldning påfyldning = new Påfyldning();
                påfyldning.påfyldFad(påfyldningsDatoField.getValue(), (Fad) fadListeField.getValue(), (model.Lager) lagerField.getValue());
                return påfyldning;
            }
            return null;
        });

    }
}