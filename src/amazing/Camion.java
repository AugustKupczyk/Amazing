package amazing;

import java.util.ArrayList;
import java.util.List;

public class Camion extends Transporte {
    private List<PaqueteEspecial> paquetesEspeciales;
    private double valorAdicional;

    public Camion(String patente, double volMaxDeCarga, double valorDelViaje, double valorAdicional) {
        super(patente, volMaxDeCarga, valorDelViaje);
        paquetesEspeciales = new ArrayList<>();
        this.valorAdicional = valorAdicional;
    }

    @Override
    public void cargarPaquete(Paquete paquete) {
        if (paquete instanceof PaqueteEspecial && paquete.calcularVolumen() > 2000) {
            paquetesEspeciales.add((PaqueteEspecial) paquete);
            cargar(true);
        }
    }

    public double obtenerValorAdicional() {
        return valorAdicional;
    }
}
