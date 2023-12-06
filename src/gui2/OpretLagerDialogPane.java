package gui2;

import com.sun.source.doctree.TextTree;
import controller.Controller;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.Fad;
import model.Lager;

public class OpretLagerDialogPane extends Dialog<Lager>{

    private TextField kapacitetField = new TextField();
    private TextField navnField = new TextField();
    private Controller controller;


    public OpretLagerDialogPane(Controller controller){
        this.setTitle("Opret Lager");
        this.setHeaderText("Indtast Lager Information");

        this.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Navn"), 0, 0);
        grid.add(new Label("Kapacitet"), 0,1);

        grid.add(navnField, 1, 0);
        grid.add(kapacitetField, 1, 1);

        this.getDialogPane().setContent(grid);

        this.setResultConverter(dialogButton -> {
            if(dialogButton == ButtonType.OK){
                String navn = navnField.getText();
                int kapacitet = Integer.parseInt(kapacitetField.getText());

                Lager createdLager = controller.opretLager(navn, kapacitet);

                return createdLager;
            }
            return null;
        });

    }
}
