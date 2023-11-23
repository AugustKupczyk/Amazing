package amazing;

public class PaqueteOrdinario extends Paquete {

	private double costoDeEnvio;

	public PaqueteOrdinario(int identificador, double volumen, double costo, boolean entregado, double costoDeEnvio) {
		super(identificador, volumen, costo, entregado);
		this.costoDeEnvio = costoDeEnvio;
	}


	public double calcularCostoDeEnvio() {
		return costoDeEnvio;
	}

	@Override
	public double calcularTotalAPagar() {
		return super.obtenerPrecio() + calcularCostoDeEnvio();
	}

	@Override
	public String toString() {
		return "PaqueteOrdinario [costoDeEnvio=" + costoDeEnvio + "]";
	}

	@Override
	public int compareTo(Paquete o) {
		// Comparación simple basada en el identificador.
		return Integer.compare(this.obtenerIdentificador(), o.obtenerIdentificador());
	}

}
