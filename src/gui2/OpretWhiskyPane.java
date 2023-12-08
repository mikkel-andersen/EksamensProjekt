package gui2;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import model.Whisky;

import javafx.scene.control.ListView;

import javax.swing.plaf.basic.BasicButtonUI;
import java.net.http.WebSocket;
import java.util.List;

public class OpretWhiskyPane extends GridPane {

    private ListView <Whisky> lstWhisky = new ListView<>();
    private Button btnOpretWhisky = new Button("Opret Whisky");

    public OpretWhiskyPane() {
        this.setGridLinesVisible(false);
        this.setHgap(20);
        this.setVgap(10);

        this.add(lstWhisky, 0, 0);
        this.add(btnOpretWhisky, 1, 0);
    }

    /*public void updateControls() {
        lstWhisky.getItems().clear();
       List<Whisky> whiskies = controller.getWhiskies();
        if (whiskies != null) {
            lstWhisky.getItems().addAll(whiskies);
        }
    }*/
/*
    public void openCreateWhiskyDialog() {
        OpretWhiskyDialog createWhiskyDialog = new createWhiskyDialog("Opret Whisky");
        createWhiskyDialog.showAndWait();
        this.updateControls();
    }
*/
}
