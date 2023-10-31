package amazing;

public class Cliente {

	private String nombre;
	private int dni;
	private String direccion;

	public Cliente(String nombre, int dni, String direccion) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
	}

	public String obtenerNombreCliente() {
		return nombre;
	}

	public int obtenerDniCliente() {
		return dni;
	}

	public String obtenerDireccion() {
		return direccion;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", dni=" + dni + ", direccion=" + direccion + "]";
	}


	
}
