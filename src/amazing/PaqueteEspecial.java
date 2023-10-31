package amazing;

public class PaqueteEspecial extends Paquete {

	private double porcentajeAdicional;
	private double costoAdicional;

	public PaqueteEspecial(int identificador, double volumen, double costo, boolean entregado,
			double porcentajeAdicional, double costoAdicional) {
		super(identificador, volumen, costo, entregado);
		this.porcentajeAdicional = porcentajeAdicional;
		this.costoAdicional = costoAdicional;
	}

	@Override
	public int compareTo(Paquete o) {
		return 0;
	}

	@Override

	public double calcularTotalAPagar() {

		double precioBase = obtenerPrecio();
		double adicionalPorcentaje = precioBase * (porcentajeAdicional / 100.0);
		double adicionalVolumen = 0;

		double volumen = calcularVolumen();

		if (volumen > 3000) {
			adicionalVolumen += costoAdicional;
		}

		if (volumen > 5000) {
			adicionalVolumen += 2 * costoAdicional;
		}

		return precioBase + adicionalPorcentaje + adicionalVolumen;
	}

	@Override
	public String toString() {
		return "PaqueteEspecial [porcentajeAdicional=" + porcentajeAdicional + ", costoAdicional=" + costoAdicional
				+ "]";
	}

}
