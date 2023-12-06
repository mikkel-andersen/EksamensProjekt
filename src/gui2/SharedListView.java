package gui2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.util.List;

    public class SharedListView<T> extends ListView<T> {

        public void setItemsAndBind(List<T> items) {
            ObservableList<T> observableList = FXCollections.observableArrayList(items);
            setItems(observableList);
        }
    }