package edificio;

public class Edificio {
    protected float costo_inicial;
    protected float costo_final;
    protected int population;
    protected int happiness;
    protected float money_to_generate;
    protected int time_to_generate;
    public Edificio() {

    }

    // Getters y setters para los atributos
    public float getCostoInicial() {
        return costo_inicial;
    }

    public void setCostoInicial(float costo_inicial) {
        this.costo_inicial = costo_inicial;
    }

    public float getCostoFinal() {
        return costo_final;
    }

    public int getHappiness() {
        return happiness;
    }
    public float getMoney_to_generate() {
        return money_to_generate;
    }
    public int getTime_to_generate() {
        return time_to_generate;
    }
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }
    public void setCostoFinal(float costo_final) {
        this.costo_final = costo_final;
    }

    public void Construir() {
        // Lógica para construir el edificio
    }

    public void Destruir() {
        // Lógica para destruir el edificio
    }




}