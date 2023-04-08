package edificio;

public class Edificio {
    private float costo_inicial;
    private float costo_final;

    public Edificio(float costo_inicial, float costo_final) {
        this.costo_inicial = costo_inicial;
        this.costo_final = costo_final;
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