package amazing;

import java.util.ArrayList;
import java.util.List;

public class Automovil extends Transporte {
	private List<PaqueteOrdinario> paquetesOrdinarios;

	public Automovil(String patente, double volMaxDeCarga, double valorDelViaje, double limitePaquetes) {
		super(patente, volMaxDeCarga, valorDelViaje);
		paquetesOrdinarios = new ArrayList<>();
	}

	 public void cargarPaquete(Paquete paquete) {
	        if (paquete instanceof PaqueteOrdinario && paquete.calcularVolumen() < 2000) {
	            paquetesOrdinarios.add((PaqueteOrdinario) paquete);
	            cargar();
	        } else {
	            throw new RuntimeException("El automóvil solo puede llevar paquetes ordinarios menores a 2000 de volumen.");
	        }
	    }

	@Override
	protected double calcularValorDelViaje() {
		return super.calcularValorDelViaje();
	}

	@Override
	public String toString() {
		return "Automovil [limitePaquetes=" + ", paquetesOrdinarios=" + paquetesOrdinarios + "]";
	}

}
