package edificio;

public class Servicio extends Edificio {
    private int capacidad;
    private String tipo_servicio;

    public Servicio(String tipo_servicio) {
        this.costo_inicial = 1000;
        this.costo_final = 5000;
        this.capacidad = 5;
        this.tipo_servicio = tipo_servicio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }
}
