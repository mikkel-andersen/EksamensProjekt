package gui2;

import controller.Controller;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.*;
import controller.Controller;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.util.ArrayList;

public class OpretPåfyldningDialogPane extends Dialog<Påfyldning> {

    OpretFadOgDestillationerPane opretFadOgDestillationerPane;
    private ComboBox fadListeField = new ComboBox();
    private DatePicker påfyldningsDatoField = new DatePicker();
    private ComboBox lagerField = new ComboBox();
    private ComboBox destillationField = new ComboBox();
    private TextField mængdeField = new TextField();
    private Controller controller;



    public OpretPåfyldningDialogPane(Controller controller){
        this.setTitle("Create Påfyldning");
        this.setHeaderText("Enter Påfyldning Information");

        this.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        fadListeField.getItems().setAll(controller.getFadListe());
        destillationField.getItems().setAll(controller.getDestillationer());
        lagerField.getItems().setAll(controller.getLager());

        grid.add(new Label("Fad:"), 0, 0);
        grid.add(new Label("PåfyldningsDato:"), 0, 1);
        grid.add(new Label("Lager:"), 0, 2);
        grid.add(new Label ("Destillation:"), 0, 3);
        grid.add(new Label ("Mængde i liter"), 0, 4);
        grid.add(fadListeField, 1, 0);
        grid.add(påfyldningsDatoField, 1, 1);
        grid.add(lagerField, 1, 2);
        grid.add(destillationField, 1, 3);
        grid.add(mængdeField, 1, 4);

        this.getDialogPane().setContent(grid);

        this.setResultConverter((ButtonType button) -> {
            if (button == ButtonType.OK) {

                double mængdeValue = Double.parseDouble(mængdeField.getText());

                Destillation destillation = (Destillation) destillationField.getSelectionModel().getSelectedItem();

                ArrayList<Mængde> mængdeListe = new ArrayList<>();
                mængdeListe.add(new Mængde(mængdeValue, destillation));

                return controller.opretPåfyldning(påfyldningsDatoField.getValue(),
                (Fad) fadListeField.getSelectionModel().getSelectedItem(), (model.Lager) lagerField.getSelectionModel().getSelectedItem(), mængdeListe);
            }
            return null;
        });

    }

    public Fad selectedFad(){
        return (Fad) fadListeField.getSelectionModel().getSelectedItem();
    }

    public Lager selectedLager(){
        return (Lager) lagerField.getSelectionModel().getSelectedItem();
    }
}