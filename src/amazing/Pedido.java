package amazing;

public class Pedido {
	
	private int codPedido;
	private Cliente cliente;
	private boolean entregado;
	private Carrito carrito;
	private boolean cerrado;

	public Pedido(int codPedido,Cliente cliente, boolean entregado, Carrito carrito, boolean cerrado) {
		this.codPedido = codPedido;
		this.cliente = cliente;
		this.entregado = entregado;
		this.carrito = carrito;
		this.cerrado = cerrado;
	}

	
	public int obtenerCodPedido() {
		return codPedido;
	}
	
	public Cliente obtenerCliente() {
		return cliente;
	}

	public Carrito obtenerCarrito() {
		return carrito;
	}

	public boolean estaEntregado() {
		return entregado;
	}

	public void entregarPedido() {
		entregado = true;
	}

	public boolean estaCerrado() {
		return cerrado;
	}

	public void cerrarPedido() {
		cerrado = true;
	}

	public void agregarPaquete(Paquete paquete) {
		if (!estaCerrado()) {
			carrito.agregarPaquete(paquete);
		} else {
			System.out.println("No se pueden agregar paquetes a un pedido cerrado.");
		}
	}

	@Override
	public String toString() {
		return "Pedido [numeroDePedido=" + ", cliente=" + cliente + ", entregado=" + entregado + ", carrito=" + carrito
				+ ", cerrado=" + cerrado + "]";
	}

}
