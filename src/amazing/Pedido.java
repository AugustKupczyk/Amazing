package amazing;

public class Pedido {
	
	private int numeroDePedido;
	private Cliente cliente;
	private double costoDeServicio;
	private boolean entregado;
	private Carrito carrito;

	
	public Pedido(int numeroDePedido, Cliente cliente, double costoDeServicio, boolean entregado,Carrito carrito) {
		super();
		this.numeroDePedido = numeroDePedido;
		this.cliente = cliente;
		this.costoDeServicio = costoDeServicio;
		this.entregado = entregado;
		this.carrito = carrito;
	}
	
	public double obtenerCostoDeServicio() {
		return costoDeServicio;
	}
	
	public int validarNroPedido() {
		return numeroDePedido;
	}
	
	public Carrito obtenerCarrito() {
		return carrito;
	}
	
	
	public boolean estaEntregado() {
		return entregado;
	}
	
	public void entregarPedido() {
	}
	
	public Cliente obtenerCliente() {
		return cliente;
	}
	
}
