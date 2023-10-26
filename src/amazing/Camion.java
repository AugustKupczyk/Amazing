package amazing;

public class Camion extends Transporte {
	
	private double valorAdicional;
	
	public Camion(String patente, double volMaxDeCarga, double valorDelViaje, boolean cargado, Paquete paquetes, 
			double valorAdicional) {
		
		super(patente, volMaxDeCarga, valorDelViaje, cargado, paquetes);
		
		this.valorAdicional = valorAdicional;
	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
