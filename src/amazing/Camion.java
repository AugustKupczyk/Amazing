package amazing;

import java.util.ArrayList;
import java.util.List;

public class Camion extends Transporte {
	private List<PaqueteEspecial> paquetesEspeciales;
	private double adicXPaq; // Valor adicional por paquete para el camión

	public Camion(String patente, double volMaxDeCarga, double valorDelViaje, double adicXPaq) {
		super(patente, volMaxDeCarga, valorDelViaje);
		paquetesEspeciales = new ArrayList<>();
		this.adicXPaq = adicXPaq;
	}

	@Override
	public void cargarPaquete(Paquete paquete) {
		if (paquete instanceof PaqueteEspecial && paquete.calcularVolumen() > 2000) {
			paquetesEspeciales.add((PaqueteEspecial) paquete);
		}
	}

	@Override
	protected double calcularValorDelViaje() {
		double valorViaje = super.calcularValorDelViaje();

		// Calcular el valor adicional por paquete
		double valorAdicionalPorPaquete = paquetesEspeciales.size() * adicXPaq;

		// Sumar el valor adicional al valor del viaje
		valorViaje += valorAdicionalPorPaquete;

		return valorViaje;
	}

	@Override
	public String toString() {
		return "Camion [paquetesEspeciales=" + paquetesEspeciales + ", valorAdicional=" + adicXPaq + "]";
	}

}
