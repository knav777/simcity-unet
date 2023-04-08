package edificio;

public class Servicio extends Edificio {
    private int capacidad;
    private String tipo_servicio;

    public Servicio(float costo_inicial, float costo_final, int capacidad, String tipo_servicio) {
        super(costo_inicial, costo_final);
        this.capacidad = capacidad;
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
