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
	            cargarPaqueteEspecial((PaqueteEspecial) paquete);
	        } else if (paquete instanceof PaqueteOrdinario) {
	            cargarPaqueteOrdinario((PaqueteOrdinario) paquete);
	        }
	    }

	    private void cargarPaqueteEspecial(PaqueteEspecial paqueteEspecial) {
	        paquetesEspeciales.add(paqueteEspecial);
	    }

	    private void cargarPaqueteOrdinario(PaqueteOrdinario paqueteOrdinario) {
	        paquetesOrdinarios.add(paqueteOrdinario);
	        if (paquetesOrdinarios.size() > 3) {
	            int paquetesExtras = paquetesOrdinarios.size() - 3;
	            valorDelViaje += (paquetesExtras * valorExtra);
	        }
	    }

	@Override
	protected double calcularValorDelViaje() {

		return super.calcularValorDelViaje();
	}

	@Override
	public String toString() {
		return "Utilitario [paquetesEspeciales=" + paquetesEspeciales + ", paquetesOrdinarios=" + paquetesOrdinarios
				+ ", valorExtra=" + valorExtra + "]";
	}

}
