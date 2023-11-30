package gui;

import model.Fad;


// Leaf class
public class FadLeaf implements GUIComponent {
    private Fad fad;

    public FadLeaf(Fad fad) {
        this.fad = fad;
    }

    @Override
    public void displayInfo() {

    }
}
