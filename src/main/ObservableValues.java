package main;

import java.util.Observable;

public class ObservableValues extends Observable {
    private int value;

    public ObservableValues (int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
        setChanged();
        notifyObservers(value);
    }
    public int getValue() {
        return value;
    }
}
