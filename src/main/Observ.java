package main;

import java.util.Observable;

class Observ extends Observable {
    private String optionOB;

    public void setOptionOB(String value) {
        this.optionOB = value;
        setChanged();
        notifyObservers(value);
    }

    public String getOptionOB() {
        return optionOB;
    }
}
