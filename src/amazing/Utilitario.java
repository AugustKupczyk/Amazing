package amazing;

public class Utilitario extends Transporte {
	
	private double valorExtra;
	
	public Utilitario(String patente, double volMaxDeCarga, double valorDelViaje, boolean cargado, Paquete paquetes, double valorExtra) {
		super(patente, volMaxDeCarga, valorDelViaje, cargado, paquetes);
		valorExtra = this.valorExtra;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public double calcularCantidadPaquetes() {
		return paquetes.size();
	}
	
	public double obtenerValorExtra() {
		return valorExtra;
	}



}

