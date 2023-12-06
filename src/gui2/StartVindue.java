package gui2;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartVindue extends Application {

    private Controller controller;
    private OpretFadOgDestillationerPane opretFadOgDestillationerPane;
    private OpretOgVisLagerPane opretOgVisLagerPane;

    @Override
    public void init() {
        controller = Controller.getController();
        controller.createSomeObjects();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Fade og Destillationer");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(800);
        stage.show();
    }

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTabPane(TabPane tabPane){
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabOpretFad = new Tab("Opret fad og destillationer");
        Tab tabOpretLager = new Tab("Opret & Se Lager");

        OpretOgVisLagerPane opretOgVisLagerPane = new OpretOgVisLagerPane();
        tabOpretLager.setContent(opretOgVisLagerPane);
        OpretFadOgDestillationerPane opretFadOgDestillationerPane = new OpretFadOgDestillationerPane(opretOgVisLagerPane);
        tabOpretFad.setContent(opretFadOgDestillationerPane);


        tabPane.getTabs().addAll(tabOpretFad, tabOpretLager);

        tabOpretFad.setOnSelectionChanged(event -> opretFadOgDestillationerPane.updateControls());



    }


}
