package amazing;

import java.util.HashMap;
import java.util.Map;

public class Empresa<numeroDePedido, patente> implements IEmpresa {
	private String cuit;
	private HashMap<numeroDePedido, Pedido> pedidos;
	private HashMap<patente, Transporte> transportes;

	@Override
	public void crear(String cuit) {
		this.cuit = cuit;
		pedidos = new HashMap<numeroDePedido, Pedido>();
		transportes = new HashMap<patente, Transporte>();
	}

	@Override
	public void registrarAutomovil(String patente, int volMax, int valorViaje, int maxPaq) {
		Automovil automovil = new Automovil(patente, volMax, valorViaje, false, null, maxPaq);
		if (patente == automovil.identificarPatente()) {
			throw new RuntimeException("Ya esta ingresada esta matricula");
		}
		transportes.put(patente, automovil);
	}

//	private Transporte verificarPatente(String patente) {
//		if (transportes.containsKey(patente)){
//			return transportes.get(patente);
//		}
//		return throw new RuntimeException("Ya existe patente en el sistema");
//	}

	@Override
	public void registrarUtilitario(String patente, int volMax, int valorViaje, int valorExtra) {
		Utilitario utilitario = new Utilitario(patente, volMax, valorViaje, false, null, valorExtra);
		transportes.put(patente, utilitario);
	}

	@Override
	public void registrarCamion(String patente, int volMax, int valorViaje, int adicXPaq) {
		Camion camion = new Camion(patente, volMax, valorViaje, false, null, adicXPaq);
		transportes.put(patente, camion);
	}

	@Override
	public int registrarPedido(String cliente, String direccion, int dni) {
		// Create a new Cliente
		Cliente clienteObj = new Cliente(cliente, dni, direccion);

		// Create an empty Carrito (cart)
		Carrito carrito = new Carrito(0, null); // You might want to initialize the Carrito differently, depending on
												// your implementation.

		// Create a new Pedido with both the Cliente and Carrito
		Pedido pedido = new Pedido(0, clienteObj, 0, false, carrito);

		// Add the Pedido to the pedidos HashMap
		pedidos.put(pedido.validarNroPedido(), pedido);

		return pedido.validarNroPedido();
	}

	@Override
	public int agregarPaquete(int codPedido, int volumen, int precio, int costoEnvio) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean quitarPaquete(int codPaquete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cerrarPedido(int codPedido) {
		// TODO Auto-generated method stub

	}

	@Override
	public String cargarTransporte(String patente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double costoEntrega(String patente) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<Integer, String> pedidosNoEntregados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double facturacionTotalPedidosCerrados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hayTransportesIdenticos() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int agregarPaquete(int codPedido, int volumen, int precio, int porcentaje, int adicional) {
		// TODO Auto-generated method stub
		return 0;
	}

}