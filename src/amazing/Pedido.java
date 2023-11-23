package amazing;


public class Pedido {

	private int codPedido;
	private Cliente cliente;
	private double costoDeServicio;
	private boolean entregado;
	private Carrito carrito;
	private boolean cerrado;

	public Pedido(int codPedido, Cliente cliente, double costoDeServicio, boolean entregado, Carrito carrito,
			boolean cerrado) {
		super();
		this.codPedido = codPedido;
		this.cliente = cliente;
		this.costoDeServicio = costoDeServicio;
		this.entregado = entregado;
		this.carrito = carrito;
		this.cerrado = cerrado;
	}

	public double obtenerCostoDeServicio() {
		return costoDeServicio;
	}

	public int obtenerCodPedido() {
		return codPedido;
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
	

	public Cliente obtenerCliente() {
		return cliente;
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
		return "Pedido [numeroDePedido=" + codPedido + ", cliente=" + cliente + ", costoDeServicio=" + costoDeServicio
				+ ", entregado=" + entregado + ", carrito=" + carrito + ", cerrado=" + cerrado + "]";
	}

}
