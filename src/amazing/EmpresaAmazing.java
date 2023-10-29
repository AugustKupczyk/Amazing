package amazing;

import java.util.HashMap;
import java.util.Map;

public class EmpresaAmazing implements IEmpresa {
	private String cuit;
	private HashMap<Integer, Pedido> pedidos;
	private HashMap<String, Transporte> transportes;


	public EmpresaAmazing(String cuit) {
		
		// TODO Auto-generated constructor stub
		this.cuit= cuit;
		pedidos = new HashMap<>();
		transportes = new HashMap<>();
	
	}
	



	//@Override
	/*public void crear(String cuit) {
		this.cuit = cuit;
		pedidos = new HashMap<>();
		transportes = new HashMap<>();
	}*/
	
	
	@Override
	public void registrarAutomovil(String patente, int volMax, int valorViaje, int maxPaq) {
		Automovil automovil = new Automovil(patente, volMax, valorViaje, false, null, maxPaq);
		if (transportes.containsKey(patente)) {
			throw new RuntimeException("Ya esta ingresada esta matricula");
		}
		transportes.put(patente, automovil);
		//falta cantidad maxima de paquetes que transporta
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
	
		if (transportes.containsKey(patente)) {
			throw new RuntimeException("Ya esta ingresada esta matricula");	
		
		}
		
		 if (utilitario.calcularCantidadPaquetes() > 10) {
		        // Aplica el valor extra
		        utilitario.setValorExtra(valorExtra);
		    }
		
		transportes.put(patente, utilitario);
	}

	@Override
	public void registrarCamion(String patente, int volMax, int valorViaje, int adicXPaq) {
		Camion camion = new Camion(patente, volMax, valorViaje, false, null, adicXPaq);
		
		if (transportes.containsKey(patente)) {
			throw new RuntimeException("Ya esta ingresada esta matricula");	
		
		}
		
		
		
		
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
	public double cerrarPedido(int codPedido) {
		// TODO Auto-generated method stub

		return 0;
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