package main;

import edificio.Edificio;
import edificio.Fabrica;
import edificio.Residencia;

import java.util.TimerTask;

public class ResourceThread extends TimerTask{
    public void run() {

        if(this.edificio==null) return;
        x(this.edificio); // llamar a la función x()
    }

    private Edificio edificio;
    public static void x(Edificio edificio) {
        Main.money.setValue(Main.money.getValue()+(int)edificio.getMoney_to_generate());
        System.out.println("DINERO: "+Main.money.getValue());
    }
    public  ResourceThread(int map_value){
        Edificio edificio= null;

        if (map_value==Map.RESIDENCE_VALUE){
            edificio = new Residencia();

        }
        if (map_value==Map.FACTORY_VALUE){
            edificio = new Fabrica();
        }
        this.edificio=edificio;



    }
}
