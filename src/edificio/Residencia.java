package edificio;

public class Residencia extends Edificio {
    private int poblacion;
    private int felicidad;
    private float dinero_generar;
    private float tiempo_generar;

    // Constructor
    public Residencia() {
        this.costo_inicial = 1000;
        this.costo_final = 5000;
        this.poblacion = 5;
        this.felicidad = 5;
        this.dinero_generar = dinero_generar;
        this.tiempo_generar = tiempo_generar;
    }

    // Métodos get y set para poblacion
    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    // Métodos get y set para felicidad
    public int getFelicidad() {
        return felicidad;
    }

    public void setFelicidad(int felicidad) {
        this.felicidad = felicidad;
    }

    // Métodos get y set para dinero_generar
    public float getDinero_generar() {
        return dinero_generar;
    }

    public void setDinero_generar(float dinero_generar) {
        this.dinero_generar = dinero_generar;
    }

    // Métodos get y set para tiempo_generar
    public float getTiempo_generar() {
        return tiempo_generar;
    }

    public void setTiempo_generar(float tiempo_generar) {
        this.tiempo_generar = tiempo_generar;
    }

    public void Recoger_dinero() {
        // implementación del método Recoger_dinero()
    }
}
