package amazing;

import java.util.ArrayList;
import java.util.List;

public class Utilitario extends Transporte {
    private List<PaqueteEspecial> paquetesEspeciales;
    private List<PaqueteOrdinario> paquetesOrdinarios;
    private double valorExtra;

    public Utilitario(String patente, double volMaxDeCarga, double valorDelViaje, double valorExtra) {
        super(patente, volMaxDeCarga, valorDelViaje);
        paquetesEspeciales = new ArrayList<>();
        paquetesOrdinarios = new ArrayList<>();
        this.valorExtra = valorExtra;
    }

    @Override
    public void cargarPaquete(Paquete paquete) {
        if (paquete instanceof PaqueteEspecial) {
            paquetesEspeciales.add((PaqueteEspecial) paquete);
            cargar(true);
        } else if (paquete instanceof PaqueteOrdinario) {
            paquetesOrdinarios.add((PaqueteOrdinario) paquete);
            if (paquetesOrdinarios.size() > 3) {
            	int paquetesExtras = paquetesOrdinarios.size() - 3;
                valorDelViaje += (paquetesExtras * valorExtra);
            }
        }
    }
}
