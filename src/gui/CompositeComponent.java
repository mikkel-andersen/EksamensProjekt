package gui;

import java.util.ArrayList;
import java.util.List;

public class CompositeComponent implements GUIComponent{

    private List<GUIComponent> components = new ArrayList<>();

    public void addComponent(GUIComponent component){
        components.add(component);
    }

    @Override
    public void displayInfo() {
        for(GUIComponent component : components){
            component.displayInfo();
        }
    }
}