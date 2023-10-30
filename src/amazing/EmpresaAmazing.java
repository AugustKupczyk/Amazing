package amazing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpresaAmazing implements IEmpresa {
	private String cuit;
	private HashMap<Integer, Pedido> pedidos;
	private HashMap<String, Transporte> transportes;

	public EmpresaAmazing(String cuit) {

		// TODO Auto-generated constructor stub
		this.cuit = cuit;
		pedidos = new HashMap<>();
		transportes = new HashMap<>();

	}

	// @Override
	/*
	 * public void crear(String cuit) { this.cuit = cuit; pedidos = new HashMap<>();
	 * transportes = new HashMap<>(); }
	 */

	@Override
	public void registrarAutomovil(String patente, int volMax, int valorViaje, int maxPaq) {
		Automovil automovil = new Automovil(patente, volMax, valorViaje, maxPaq);
		if (transportes.containsKey(patente)) {
			throw new RuntimeException("Ya esta ingresada esta matricula");
		}
		transportes.put(patente, automovil);
		// falta cantidad maxima de paquetes que transporta
	}

//	private Transporte verificarPatente(String patente) {
//		if (transportes.containsKey(patente)){
//			return transportes.get(patente);
//		}
//		return throw new RuntimeException("Ya existe patente en el sistema");
//	}

	@Override
	public void registrarUtilitario(String patente, int volMax, int valorViaje, int valorExtra) {
		Utilitario utilitario = new Utilitario(patente, volMax, valorViaje, valorExtra);

		if (transportes.containsKey(patente)) {
			throw new RuntimeException("Ya esta ingresada esta matricula");

		}

		transportes.put(patente, utilitario);
	}

	@Override
	public void registrarCamion(String patente, int volMax, int valorViaje, int adicXPaq) {
		Camion camion = new Camion(patente, volMax, valorViaje, adicXPaq);

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
		Carrito carrito = new Carrito(0); // You might want to initialize the Carrito differently, depending on
											// your implementation.

		// Create a new Pedido with both the Cliente and Carrito
		Pedido pedido = new Pedido(0, clienteObj, 0, false, carrito, false);

		// Add the Pedido to the pedidos HashMap
		pedidos.put(pedido.validarNroPedido(), pedido);

		return pedido.validarNroPedido();
	}

	@Override
	public int agregarPaquete(int codPedido, int volumen, int precio, int costoEnvio) {
		// Verificar si el pedido existe en el sistema
		if (!pedidos.containsKey(codPedido)) {
			throw new RuntimeException("El pedido no está registrado en el sistema.");
		}

		// Obtener el pedido correspondiente
		Pedido pedido = pedidos.get(codPedido);

		// Verificar si el pedido ya está finalizado
		if (pedido.estaEntregado()) {
			throw new RuntimeException("El pedido ya está finalizado.");
		}

		// Crear un paquete de tipo ordinario y asignar un código único
		int codigoUnicoPaquete = generarCodigoUnicoPaquete();
		PaqueteOrdinario paquete = new PaqueteOrdinario(codigoUnicoPaquete, volumen, precio, false, costoEnvio);

		// Agregar el paquete al carrito del pedido
		Carrito carrito = pedido.obtenerCarrito();
		carrito.agregarPaquete(paquete);

		// Devolver el código único del paquete
		return codigoUnicoPaquete;
	}

	// Método para generar un código único para el paquete
	private static int codigoUnicoPaquete = 1; // Inicializamos el contador en 1

	private int generarCodigoUnicoPaquete() {
		int codigo = codigoUnicoPaquete;
		codigoUnicoPaquete++; // Incrementa el contador para el próximo paquete
		return codigo;
	}

	@Override
	public int agregarPaquete(int codPedido, int volumen, int precio, int porcentajeAdicional, int adicional) {
		// Verificar si el pedido existe en el sistema
		if (!pedidos.containsKey(codPedido)) {
			throw new RuntimeException("El pedido no está registrado en el sistema.");
		}

		// Obtener el pedido correspondiente
		Pedido pedido = pedidos.get(codPedido);

		// Verificar si el pedido ya está finalizado
		if (pedido.estaEntregado()) {
			throw new RuntimeException("El pedido ya está finalizado.");
		}

		// Calcular el precio con el porcentaje adicional (si es mayor a 0)
		double precioConAdicional = precio;
		if (porcentajeAdicional > 0) {
			precioConAdicional += (precio * porcentajeAdicional / 100.0);
		}

		// Verificar si se agrega el adicional
		if (volumen > 3000) {
			precioConAdicional += adicional;
		}

		// Crear un paquete de tipo especial y asignar un código único
		int codigoUnicoPaquete = generarCodigoUnicoPaquete();
		PaqueteEspecial paquete = new PaqueteEspecial(codigoUnicoPaquete, volumen, precioConAdicional, false,
				porcentajeAdicional, adicional);

		// Agregar el paquete al carrito del pedido
		Carrito carrito = pedido.obtenerCarrito();
		carrito.agregarPaquete(paquete);

		// Devolver el código único del paquete
		return codigoUnicoPaquete;
	}

	@Override
	public boolean quitarPaquete(int codPaquete) {
		// Complejidad en términos de O grande: O(N * M), donde N es el número de
		// pedidos y M es el número promedio de paquetes en cada carrito.

		for (Pedido pedido : pedidos.values()) {
			// Verificar si el pedido no está finalizado
			if (!pedido.estaEntregado()) {
				Carrito carrito = pedido.obtenerCarrito();
				List<Paquete> paquetes = carrito.obtenerPaquetes();

				// Buscar el paquete en el carrito del pedido
				for (Paquete paquete : paquetes) {
					if (paquete.obtenerIdentificador() == codPaquete) {
						// Eliminar el paquete del carrito
						carrito.eliminarPaquete(paquete);
						return true; // Paquete encontrado y eliminado, devolvemos true
					}
				}
			}
		}

		throw new RuntimeException("No se encontro"); // Paquete no encontrado o pedido finalizado, devolvemos false
	}

	@Override
	public double cerrarPedido(int codPedido) {
		Pedido pedido = pedidos.get(codPedido);

		if (pedido == null) {
			throw new RuntimeException("El pedido no está registrado en el sistema.");
		}

		if (pedido.estaEntregado()) {
			throw new RuntimeException("El pedido ya ha sido finalizado.");
		}

		double costoDeServicio = pedido.obtenerCostoDeServicio();
		Carrito carrito = pedido.obtenerCarrito();
		List<Paquete> paquetes = carrito.obtenerPaquetes();

		double totalAPagar = costoDeServicio;

		for (Paquete paquete : paquetes) {
			totalAPagar += paquete.calcularCosto();
		}

		pedido.cerrarPedido();

		return totalAPagar;
	}

	@Override
	public String cargarTransporte(String patente) {
		return "";

	}
	
	@Override
	public double costoEntrega(String patente) {
		
		return 0;
	}


	@Override
	public Map<Integer, String> pedidosNoEntregados() {
		return null;
	}

	@Override
	public double facturacionTotalPedidosCerrados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hayTransportesIdenticos() {

		return false;
	}

	@Override
	public String toString() {
		return "EmpresaAmazing con CUIT: " + cuit;
	}

	
}