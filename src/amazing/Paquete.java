package amazing;

public abstract class Paquete implements Comparable<Paquete> {

	private int identificador;
	protected double volumen;
	protected double precio;
	private boolean cargado;

	public Paquete(int identificador, double volumen, double costo, boolean cargado) {
		this.identificador = identificador;
		this.volumen = volumen;
		this.precio = costo;
		this.cargado = cargado;
	}

	public int obtenerIdentificador() {
		return identificador;
	}

	public double calcularVolumen() {
		return volumen;
	}

	public abstract double calcularTotalAPagar();

	public boolean estaCargado() {
		return cargado;
	}
	
	public void cargar() {
		cargado = true;
	}

	public double obtenerPrecio() {
		return precio;
	}

	@Override
	public int compareTo(Paquete o) {
		// Puedes comparar paquetes según algún criterio, como el identificador.
		return Integer.compare(this.identificador, o.identificador);
	}

	@Override
	public String toString() {
		return "Paquete [identificador=" + identificador + ", volumen=" + volumen + ", precio=" + precio
				+ ", entregado=" + cargado + "]";
	}

}
