package amazing;

public class PaqueteEspecial extends Paquete {

	private double porcentajeAdicional;
	private double costoAdicional;
	
	public PaqueteEspecial(int identificador, double volumen, double precio, boolean entregado, 
			double porcentajeAdicional, double costoAdicional) {
		super(identificador, volumen, precio, entregado);
		this.porcentajeAdicional = porcentajeAdicional;
		this.costoAdicional = costoAdicional;
	}
	@Override
	public int compareTo(Paquete o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
