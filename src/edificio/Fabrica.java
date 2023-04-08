package edificio;

public class Fabrica extends Edificio {
    private String material_actual;
    private int tiempo_material;

    public Fabrica(float costo_inicial, float costo_final, String material_actual, int tiempo_material) {
        super(costo_inicial, costo_final);
        this.material_actual = material_actual;
        this.tiempo_material = tiempo_material;
    }

    public String getMaterialActual() {
        return material_actual;
    }

    public void setMaterialActual(String materialActual) {
        this.material_actual = materialActual;
    }

    public int getTiempoMaterial() {
        return tiempo_material;
    }

    public void setTiempoMaterial(int tiempoMaterial) {
        this.tiempo_material = tiempoMaterial;
    }

    public void Recoger_material() {
        // implementación del método Recoger_material()
    }

    public void producirMaterial(int cantidad) {
        int tiempoRestante = getTiempoMaterial() - cantidad;
        if (tiempoRestante < 0) {
            tiempoRestante = 0;
        }
        setTiempoMaterial(tiempoRestante);
    }

    public void cambiarMaterial(String nuevoMaterial) {
        setMaterialActual(nuevoMaterial);
        setTiempoMaterial(0);
    }
}