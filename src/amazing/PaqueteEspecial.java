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
	public double calcularCosto() {
	    double costo = 0;  // Utiliza la variable costo de la clase base

	    costo += costo * (porcentajeAdicional / 100);

	    if (volumen > 3000) {
	        costo += costoAdicional;
	        if (volumen > 5000) {
	            costo += costoAdicional; // Duplica el costo adicional
	        }
	    }

	    return costo;
	}
}


