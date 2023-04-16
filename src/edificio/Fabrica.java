package edificio;

public class Fabrica extends Edificio {
    private String material_actual;
    private int tiempo_material;
    private int time_to_generate;
    public Fabrica( ) {
        this.costo_inicial = 2000;
        this.costo_final = 1000;
        this.happiness = -5;
        this.time_to_generate = 20;
        this.money_to_generate = 83;
//        this.material_actual = material_actual;
//        this.tiempo_material = tiempo_material;
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



    public void setTime_to_generate(int tiempo_generar) {
        this.time_to_generate = time_to_generate;
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