package amazing;

public class Carrito {
	
	private int id;
	
	private Paquete paquetesAEntregar;
	
	public Carrito(int id, Paquete paquetesAEntregar) {
		this.id = id;
		this.paquetesAEntregar = paquetesAEntregar;
	}
	
	public void agregarPaquete() {
		
	}
	
	public void eliminarPaquete() {
		
	}
	
	public Paquete obtenerPaquetes() {
		return paquetesAEntregar;
	}
}
