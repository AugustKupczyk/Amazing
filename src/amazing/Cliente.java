package amazing;

public class Cliente {

	private int dni;
	private String cliente;
	private String direccion;

	public Cliente(String nombre,int dni, String direccion) {
		this.cliente = nombre;
		this.dni = dni;
		this.direccion = direccion;
	}

	public String obtenerNombreCliente() {
		return cliente;
	}

	public int obtenerDniCliente() {
		return dni;
	}

	public String obtenerDireccion() {
		return direccion;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + cliente + ", dni=" + dni + ", direccion=" + direccion + "]";
	}


	
}
