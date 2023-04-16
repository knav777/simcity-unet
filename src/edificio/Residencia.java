package edificio;

public class Residencia extends Edificio {
    private int population;
    private int happiness;
    private float money_to_generate;
    private float time_to_generate;



    // Constructor
    public Residencia() {
        this.costo_inicial = 1000;
        this.costo_final = 500;
        this.happiness = 5;
        this.population = 5;
        this.money_to_generate = 50;
        this.time_to_generate = 60;
    }

    // Métodos get y set para poblacion
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    // Métodos get y set para felicidad
    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    // Métodos get y set para dinero_generar
    public float getMoney_to_generate() {
        return money_to_generate;
    }

    public void setMoney_to_generate(float money_to_generate) {
        this.money_to_generate = money_to_generate;
    }

    // Métodos get y set para tiempo_generar
    public float getTime_to_generate() {
        return time_to_generate;
    }

    public void setTime_to_generate(float tiempo_generar) {
        this.time_to_generate = time_to_generate;
    }

    public void Recoger_dinero() {
        // implementación del método Recoger_dinero()
    }
}
