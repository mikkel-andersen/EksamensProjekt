package gui;

import model.Lager;

class LagerLeaf implements GUIComponent {
    private Lager lager;

    public LagerLeaf(Lager lager) {
        this.lager = lager;
    }

    @Override
    public void displayInfo() {

    }
}