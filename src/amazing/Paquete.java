package amazing;

public abstract class Paquete implements Comparable <Paquete> {
	
	private int identificador;
	protected double volumen;
	protected double costo;
	private boolean entregado;
	
	public Paquete(int identificador, double volumen, double costo, boolean entregado) {
		this.identificador = identificador;
		this.volumen = volumen;
		this.costo = costo;
		this.entregado = entregado;
	}
	
	public int obtenerIdentificador() {
		return identificador;
	}
	
	public double calcularVolumen() {
		return volumen;
	}
	
	public abstract double calcularCosto();
	
	public boolean estaEntregado(int identificador) {
		return entregado;
	}
}
