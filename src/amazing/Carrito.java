package amazing;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private List<Paquete> paquetesAEntregar;

	public Carrito() {
		paquetesAEntregar = new ArrayList<>();
	}

	public void agregarPaquete(Paquete paquete) {
		paquetesAEntregar.add(paquete);
	}
	
	public void contienePaquete(Paquete paquete) {
		paquetesAEntregar.add(paquete);
	}

	public void eliminarPaquete(Paquete paquete) {
		paquetesAEntregar.remove(paquete);
	}

	public List<Paquete> obtenerPaquetes() {
		return paquetesAEntregar;
	}

	@Override
	public String toString() {
		return "Carrito [id=" +  ", paquetesAEntregar=" + paquetesAEntregar + "]";
	}

	
}
