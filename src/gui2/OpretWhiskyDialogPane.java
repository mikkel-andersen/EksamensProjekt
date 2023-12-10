package gui2;

import controller.Controller;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.Whisky;

public class OpretWhiskyDialogPane extends Dialog<Whisky> {

    private Controller controller;

    public OpretWhiskyDialogPane(Controller controller) {
        this.setTitle("Opret Whisky");
        this.setHeaderText("Indtast Whisky Information");

        this.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Navn"), 0, 0);
    }
}
