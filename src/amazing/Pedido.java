package amazing;

public class Pedido {
	
	private int numeroDePedido;
	private Cliente cliente;
	private double costoDeServicio;
	private boolean entregado;
	private Carrito carrito;
	private boolean cerrado;

	
	public Pedido(int numeroDePedido, Cliente cliente, double costoDeServicio, boolean entregado,Carrito carrito, boolean cerrado) {
		super();
		this.numeroDePedido = numeroDePedido;
		this.cliente = cliente;
		this.costoDeServicio = costoDeServicio;
		this.entregado = entregado;
		this.carrito = carrito;
		this.cerrado = cerrado;
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
	
}
