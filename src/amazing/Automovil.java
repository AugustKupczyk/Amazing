package amazing;

import java.util.ArrayList;
import java.util.List;

public class Automovil extends Transporte {
	private double limitePaquetes;
	private List<PaqueteOrdinario> paquetesOrdinarios;

	public Automovil(String patente, double volMaxDeCarga, double valorDelViaje, double limitePaquetes) {
		super(patente, volMaxDeCarga, valorDelViaje);
		this.limitePaquetes = limitePaquetes;
		paquetesOrdinarios = new ArrayList<>();
	}

	@Override
	public void cargarPaquete(Paquete paquete) {
		if (paquete instanceof PaqueteOrdinario) {
			PaqueteOrdinario paqueteOrdinario = (PaqueteOrdinario) paquete;
			if (paqueteOrdinario.calcularVolumen() <= 2000 && paquetesOrdinarios.size() < limitePaquetes) {
				paquetesOrdinarios.add(paqueteOrdinario);
				cargar(true);
			}
		}
	}

	@Override
	protected double calcularValorDelViaje(String patente) {

		return super.calcularValorDelViaje(patente);
	}

	@Override
	public String toString() {
		return "Automovil [limitePaquetes=" + limitePaquetes + ", paquetesOrdinarios=" + paquetesOrdinarios + "]";
	}

}
