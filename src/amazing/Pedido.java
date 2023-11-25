package amazing;

public class Pedido {
	
	private int codPedido;
	private Cliente cliente;
	private boolean entregado;
	private Carrito carrito;
	private boolean cerrado;
	private Transporte transporte;
	
	public Pedido(int codPedido,Cliente cliente, boolean entregado, Carrito carrito, boolean cerrado,Transporte transporte) {
		this.codPedido = codPedido;
		this.cliente = cliente;
		this.entregado = entregado;
		this.carrito = carrito;
		this.cerrado = cerrado;
		this.transporte = transporte;
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
	
	 public void asignarTransporteCargado(Transporte transporte) {
	        this.transporte = transporte;
	    }

	    public Transporte obtenerTransporteCargado() {
	        return transporte;
	    }

	@Override
	public String toString() {
		return "Pedido [numeroDePedido=" + ", cliente=" + cliente + ", entregado=" + entregado + ", carrito=" + carrito
				+ ", cerrado=" + cerrado + "]";
	}

}
