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
	public double calcularTotalAPagar() {
		double precioBase = super.obtenerPrecio();
		double adicionalPorcentaje = precioBase * (porcentajeAdicional / 100.0);
		double adicionalVolumen = 0;

		// Utilizamos el volumen de la instancia actual para evitar confusión con el
		// atributo de la clase.
		if (this.volumen > 3000) {
			adicionalVolumen += costoAdicional;
		}

		if (this.volumen > 5000) {
			adicionalVolumen += 2 * costoAdicional;
		}

		return precioBase + adicionalPorcentaje + adicionalVolumen;
	}

	@Override
	public String toString() {
		return "PaqueteEspecial [porcentajeAdicional=" + porcentajeAdicional + ", costoAdicional=" + costoAdicional
				+ "]";
	}

	@Override
	public int compareTo(Paquete o) {
		// Comparación basada en el volumen (ejemplo, puedes ajustarlo según tus
		// necesidades).
		return Double.compare(this.volumen, o.volumen);
	}

}
