package main;

import edificio.Fabrica;
import edificio.Residencia;
import edificio.Servicio;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends JFrame {
    static int i,j;
    static int happiness=100;
    static int population=0;
    static int money=100;
    static int level=0;

    static boolean validated=true;
    public static void main(String[] args) {
       Main main=new Main();
       main.starGame();
    }
    public void starGame(){
        /**CARLOS MENSAJES
         * MOSTRAR MENSAJE AL USUARIO
         * INDICAR INDICACIONES NIVEL 1
         *  'FIJATE EN LOS VALORES DINERO, FELICIDAD... '
         *  'DEBES CONSTRUIR UNA CARRETERA'
         */
        GameWindow window = new GameWindow();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public boolean validations(float initial_cost,int map_value,int i,int j){
        if (Map.map[this.i][this.j]!=0){
            /**CARLOS MENSAJES
             * MOSTRAR MENSAJE AL USUARIO
             *  'NO PUEDES SOBREESCRIBIR EN ESTE ESPACIO, YA ESTA EN USO'
             */
            return false;

        }
        if (Main.money-initial_cost < 0){
            /**CARLOS MENSAJES
             * MOSTRAR MENSAJE AL USUARIO
             *  'NO PUEDES  CONSTRUIR, FALTA DINERO'
             */
            return false;

        }

        if(map_value!=Map.ROAD_VALUE && !this.mapRoadValidate(i,j)){
            return false;
        }

        return  true;
    }
public boolean mapRoadValidate(int i, int j){


    if (i > 0 && Map.map[i-1][j] == 4) {
        return  true;
    }

    if (i < Map.map.length-1 && Map.map[i+1][j] == 4) {
        return  true;
    }

    if (j > 0 && Map.map[i][j-1] == 4) {
        return  true;
    }

    if (j < Map.map[0].length-1 && Map.map[i][j+1] == 4) {
        return  true;
    }
    return false;
}
    public void levels(String option){
        switch (option) {
            case Map.RESIDENCE_IMG:
                if(Main.level==1){
                    Main.level++;
                    Main.happiness-=10;
                    Main.money+=3500;

                }
                ResourceThread hilo = new ResourceThread(1);
                Timer timer = new Timer();

                timer.schedule(new ResourceThread(1), 0, 10000); // llamar a la tarea cada 60 segundos
                break;
            case Map.FACTORY_IMG:
                if(Main.level==2){
                    Main.level++;
                    Main.happiness-=10;
                    Main.money+=4000;
                }
                ResourceThread hilo2 = new ResourceThread(2);
                Timer timer2 = new Timer();
                timer2.schedule(new ResourceThread(2), 0, 20000); // llamar a la tarea cada 60 segundos
                break;

            // Puedes agregar más casos aquí
            case Map.ELECTRICITY_IMG:
                if(Main.level==3){
                    Main.level++;
                    Main.happiness-=10;
                    Main.money+=4000;
                }
                break;
            case Map.WATER_IMG:
                if(Main.level==3){
                    Main.level++;
                    Main.happiness-=10;
                }
                break;
            case Map.ROAD_IMG:
                if(Main.level==0){
                    Main.level++;
                    Main.happiness-=10;
                    Main.money+=1000;
                }

                break;

        }
    }


    public void mouseClicked(String option){
        Main.validated = true;
        float initial_cost=0;
        int map_value=0;
        int aux_happiness=0;
        int time_to_generate=0;
        switch (option) {
            case Map.RESIDENCE_IMG:

                map_value=Map.RESIDENCE_VALUE;
                Residencia residencia = new Residencia();//
                initial_cost = residencia.getCostoInicial();
                aux_happiness = residencia.getHappiness();
                time_to_generate = residencia.getTime_to_generate();
                break;
            case Map.FACTORY_IMG:
                map_value=Map.FACTORY_VALUE;
                Fabrica fabrica = new Fabrica();
                initial_cost = fabrica.getCostoInicial();
                aux_happiness = fabrica.getHappiness();
                time_to_generate = fabrica.getTime_to_generate();
                break;

            // Puedes agregar más casos aquí
            case Map.ELECTRICITY_IMG:
                map_value=Map.SERVICE_VALUE;
                Servicio servicio_electricity = new Servicio("ELECTRICITY");

                initial_cost =servicio_electricity.getCostoInicial();
                aux_happiness = servicio_electricity.getHappiness();
                break;
            case Map.WATER_IMG:
                map_value=Map.SERVICE_VALUE;
                Servicio servicio_water = new Servicio("WATER");
                initial_cost = servicio_water.getCostoInicial();
                aux_happiness = servicio_water.getHappiness();
                break;
            case Map.ROAD_IMG:
                map_value=Map.ROAD_VALUE;
                initial_cost = 100;

                break;

        }

//        System.out.println(this.validations(initial_cost));
        if (!this.validations(initial_cost,map_value,this.i,this.j)) {
            Main.validated=false;
           return;
        }
        Map.map[this.i][this.j]=map_value;
        Main.money -=initial_cost;
        System.out.println(aux_happiness);
        Main.happiness+=aux_happiness;
        this.levels(option);


        System.out.println("'DINERO'"+Main.money);
        System.out.println("'FELICIDAD'"+Main.happiness);
        System.out.println("'POBLACION'"+Main.population);
        System.out.println("'LEVEL'"+Main.level);

        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                System.out.print(Map.map[i][j]+ " ");
            }
            System.out.println();
        }


    }
}




