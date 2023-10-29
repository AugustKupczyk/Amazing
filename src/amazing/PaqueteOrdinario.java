package amazing;

public class PaqueteOrdinario extends Paquete {
	
	private double costoDeEnvio;
	
	public PaqueteOrdinario(int identificador, double volumen, double precio, 
										boolean entregado, double costoDeEnvio) {
		super(identificador, volumen, precio, entregado);
		this.costoDeEnvio = costoDeEnvio;
	}

	@Override
	public int compareTo(Paquete o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public double calcularCostoDeEnvio() {
		return costoDeEnvio;
	}

}
