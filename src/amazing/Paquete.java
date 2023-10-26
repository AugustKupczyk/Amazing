package amazing;

public abstract class Paquete implements Comparable <Paquete> {
	
	private int identificador;
	private double volumen;
	private double precio;
	private boolean entregado;
	
	public Paquete(int identificador, double volumen, double precio, boolean entregado) {
		this.identificador = identificador;
		this.volumen = volumen;
		this.precio = precio;
		this.entregado = entregado;
	}
	
	public int obtenerIdentificador() {
		return identificador;
	}
	
	public double calcularVolumen() {
		return volumen;
	}
	
	public double obtenerPrecio() {
		return precio;
	}
	
	public boolean estaEntregado(int identificador) {
		return entregado;
	}
}
