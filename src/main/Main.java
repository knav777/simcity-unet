package main;

import edificio.Fabrica;
import edificio.Residencia;
import edificio.Servicio;

import javax.swing.*;

import java.util.Timer;

public class Main{
    static int i, j;
    static ObservableValues happiness = new ObservableValues(100);
    static ObservableValues population = new ObservableValues(0);
    static ObservableValues money = new ObservableValues(100);
    static ObservableValues level = new ObservableValues(0);

    static Observ message = new Observ("");

    static Observ info = new Observ("<html>Inicie construyendo <br>una carretera para<br>subir al nivel 1</html>");

    static boolean validated = true;

    public static void main(String[] args) {
        Main main = new Main();
        main.starGame();
    }

    public void starGame() {

        GameWindow window = new GameWindow();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public boolean validations(float initial_cost, int map_value, int i, int j) {
        if (Map.map[this.i][this.j] != 0) {

            message.setOptionOB("<html>NO PUEDES CONSTRUIR,<br>ESPACIO OCUPADO.</html>");
            return false;

        }
        if (Main.money.getValue() - initial_cost < 0) {

            message.setOptionOB("<html>NO PUEDES CONSTRUIR, <br>FONDOS INSUFICIENTES.</html>");
            return false;

        }

        if (map_value != Map.ROAD_VALUE && !this.mapRoadValidate(i, j)) {
            message.setOptionOB("<html>NO PUEDES CONSTRUIR,<br>DEBE ESTAR ADYACENTE A LA CARRETERA.</html>");
            return false;
        }

        return true;
    }

    public boolean mapRoadValidate(int i, int j) {


        if (i > 0 && Map.map[i - 1][j] == 4) {
            return true;
        }

        if (i < Map.map.length - 1 && Map.map[i + 1][j] == 4) {
            return true;
        }

        if (j > 0 && Map.map[i][j - 1] == 4) {
            return true;
        }

        if (j < Map.map[0].length - 1 && Map.map[i][j + 1] == 4) {
            return true;
        }
        return false;
    }

    public void levels(String option) {

        switch (option) {
            case Map.RESIDENCE_IMG:
                if (Main.level.getValue() == 1) {
                    info.setOptionOB("<html>HAS SUBIDO DE NIVEL<br>Ahora construye una fábrica<br>para subir de nivel</html>");
                    Main.level.setValue(Main.level.getValue()+1);
                    Main.money.setValue(Main.money.getValue() + 3500);
                    Main.happiness.setValue(Main.happiness.getValue() - 10);
                }
                ResourceThread hilo = new ResourceThread(1);
                Timer timer = new Timer();

                if(Main.happiness.getValue()<=95) {
                    Main.happiness.setValue(Main.happiness.getValue() + 5);
                }

                Main.population.setValue(Main.population.getValue() + 5);

                timer.schedule(new ResourceThread(1), 0, 10000); // llamar a la tarea cada 60 segundos
                break;
            case Map.FACTORY_IMG:
                if (Main.level.getValue() == 2) {
                    info.setOptionOB("<html>HAS SUBIDO DE NIVEL<br>Ahora construye un servicio publico<br>para subir de nivel</html>");
                    Main.level.setValue(Main.level.getValue()+1);
                    Main.happiness.setValue(Main.happiness.getValue() - 10);
                    Main.money.setValue(Main.money.getValue() + 4000);
                }
                ResourceThread hilo2 = new ResourceThread(2);
                Timer timer2 = new Timer();
                timer2.schedule(new ResourceThread(2), 0, 20000); // llamar a la tarea cada 60 segundos
                break;

            // Puedes agregar más casos aquí
            case Map.WATER_IMG:
                if (Main.level.getValue() == 3) {
                    info.setOptionOB("<html>HAS TERMINADO EL TUTORIAL<br>Sigue disfrutando del juego.</html>");
                    Main.level.setValue(Main.level.getValue()+1);
                    Main.money.setValue(Main.money.getValue() + 4000);
                }
                if(Main.happiness.getValue()<=90) {
                    Main.happiness.setValue(Main.happiness.getValue() + 10);
                } else {
                    Main.happiness.setValue(100);
                }
                break;

            case Map.ELECTRICITY_IMG:
                if (Main.level.getValue() == 3) {
                    info.setOptionOB("<html>HAS TERMINADO EL TUTORIAL<br>Sigue disfrutando del juego</html>");
                    Main.level.setValue(Main.level.getValue()+1);
                    Main.money.setValue(Main.money.getValue() + 4000);
                }
                if(Main.happiness.getValue()<=90) {
                    Main.happiness.setValue(Main.happiness.getValue() + 10);
                } else {
                    Main.happiness.setValue(100);
                }
                break;

            case Map.ROAD_IMG:
                if (Main.level.getValue() == 0) {
                    info.setOptionOB("<html>HAS SUBIDO DE NIVEL <br> Ahora construye una residencia<br>para subir de nivel</html>");
                    Main.level.setValue(Main.level.getValue() + 1);
                    Main.money.setValue(Main.money.getValue() + 1000);
                    Main.happiness.setValue(Main.happiness.getValue() - 10);
                }

                break;

        }
    }

    public void mouseClicked(String option) {
        Main.validated = true;
        float initial_cost = 0;
        int map_value = 0;
        int aux_happiness = 0;
        int time_to_generate = 0;
        Main main = new Main();
        switch (option) {
            case Map.RESIDENCE_IMG:

                map_value = Map.RESIDENCE_VALUE;
                Residencia residencia = new Residencia();//
                initial_cost = residencia.getCostoInicial();
                aux_happiness = residencia.getHappiness();
                time_to_generate = residencia.getTime_to_generate();
                break;
            case Map.FACTORY_IMG:
                map_value = Map.FACTORY_VALUE;
                Fabrica fabrica = new Fabrica();
                initial_cost = fabrica.getCostoInicial();
                aux_happiness = fabrica.getHappiness();
                time_to_generate = fabrica.getTime_to_generate();
                break;

            // Puedes agregar más casos aquí
            case Map.ELECTRICITY_IMG:
                map_value = Map.SERVICE_VALUE;
                Servicio servicio_electricity = new Servicio("ELECTRICITY");

                initial_cost = servicio_electricity.getCostoInicial();
                aux_happiness = servicio_electricity.getHappiness();
                break;
            case Map.WATER_IMG:
                map_value = Map.SERVICE_VALUE;
                Servicio servicio_water = new Servicio("WATER");
                initial_cost = servicio_water.getCostoInicial();
                aux_happiness = servicio_water.getHappiness();
                break;
            case Map.ROAD_IMG:
                map_value = Map.ROAD_VALUE;
                initial_cost = 100;

                break;

        }

//        System.out.println(this.validations(initial_cost));
        if (!this.validations(initial_cost, map_value, this.i, this.j)) {
            Main.validated = false;
            return;
        }
        Map.map[this.i][this.j] = map_value;
        //Main.money -= initial_cost;
        System.out.println(aux_happiness);
        //Main.happiness += aux_happiness;
        this.levels(option);

        message.setOptionOB("");

        //Main.happiness.setValue(Main.happiness.getValue() - 10);
        Main.money.setValue(Main.money.getValue() - (int)initial_cost);


        System.out.println("'DINERO: '" + Main.money.getValue());
        System.out.println("'FELICIDAD: '" + Main.happiness.getValue());
        System.out.println("'POBLACION: '" + Main.population.getValue());
        System.out.println("'LEVEL: '" + Main.level.getValue());

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(Map.map[i][j] + " ");
            }
            System.out.println();
        }


    }
}




