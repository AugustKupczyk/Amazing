package amazing;

public class Automovil extends Transporte {
	
	private double limitePaquetes;
	
	public Automovil(String patente, double volMaxDeCarga, double valorDelViaje, boolean cargado, Paquete paquetes, double limitePaquetes) {
		super(patente, volMaxDeCarga, valorDelViaje, cargado, paquetes);
		this.limitePaquetes = limitePaquetes;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public double obtenerLimitePaquetes() {
		return limitePaquetes;
	}
//	public double identificarVolPaquete() {
//		return paquetes.
//	}

}
