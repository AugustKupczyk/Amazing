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

	@Override
	public void registrarAutomovil(String patente, int volMax, int valorViaje, int maxPaq) {
		Automovil automovil = new Automovil(patente, volMax, valorViaje, maxPaq);
		if (transportes.containsKey(patente)) {
			throw new RuntimeException("Ya esta ingresada esta matricula");
		}
		transportes.put(patente, automovil);

	}

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

		Cliente clienteObj = new Cliente(cliente, dni, direccion);

		Carrito carrito = new Carrito(0);

		Pedido pedido = new Pedido(0, clienteObj, 0, false, carrito, false);

		pedidos.put(pedido.validarNroPedido(), pedido);

		return pedido.validarNroPedido();
	}

	@Override
	public int agregarPaquete(int codPedido, int volumen, int precio, int costoEnvio) {

		if (!pedidos.containsKey(codPedido)) {
			throw new RuntimeException("El pedido no está registrado en el sistema.");
		}

		Pedido pedido = pedidos.get(codPedido);

		if (pedido.estaEntregado()) {
			throw new RuntimeException("El pedido ya está finalizado.");
		}

		if (pedido.estaCerrado()) {
			throw new RuntimeException("El pedido ya está cerrado.");
		}

		// Creamos un paquete de tipo ordinario y asignamos un código único
		int codigoUnicoPaquete = generarCodigoUnicoPaquete();
		PaqueteOrdinario paquete = new PaqueteOrdinario(codigoUnicoPaquete, volumen, precio, false, costoEnvio);

		Carrito carrito = pedido.obtenerCarrito();

		carrito.agregarPaquete(paquete);

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

		if (!pedidos.containsKey(codPedido)) {
			throw new RuntimeException("El pedido no está registrado en el sistema.");
		}

		Pedido pedido = pedidos.get(codPedido);

		if (pedido.estaEntregado()) {
			throw new RuntimeException("El pedido ya está finalizado.");
		}

		if (pedido.estaCerrado()) {
			throw new RuntimeException("El pedido ya está cerrado.");
		}

		// Calculamos el precio con el porcentaje adicional (si es mayor a 0)
		double precioConAdicional = precio;
		if (porcentajeAdicional > 0) {
			precioConAdicional += (precio * porcentajeAdicional / 100.0);
		}

		// Verificamos si se agrega el adicional
		if (volumen > 3000) {
			precioConAdicional += adicional;
		}

		// Creamos un paquete de tipo especial y asignamos un código único
		int codigoUnicoPaquete = generarCodigoUnicoPaquete();
		PaqueteEspecial paquete = new PaqueteEspecial(codigoUnicoPaquete, volumen, precioConAdicional, false,
				porcentajeAdicional, adicional);

		// Agregamos el paquete al carrito del pedido
		Carrito carrito = pedido.obtenerCarrito();
		carrito.agregarPaquete(paquete);

		return codigoUnicoPaquete;
	}

	@Override
	public boolean quitarPaquete(int codPaquete) {

		for (Pedido pedido : pedidos.values()) {

			if (!pedido.estaEntregado()) {
				Carrito carrito = pedido.obtenerCarrito();
				List<Paquete> paquetes = carrito.obtenerPaquetes();

				// Buscamos el paquete en el carrito del pedido
				for (Paquete paquete : paquetes) {
					if (paquete.obtenerIdentificador() == codPaquete) {

						// Eliminamos el paquete del carrito
						carrito.eliminarPaquete(paquete);
						return true;
					}
				}
			}
		}

		throw new RuntimeException("No se encontro");
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
			totalAPagar += paquete.calcularTotalAPagar();

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
		// Verificar si la patente está registrada en el sistema
		if (!transportes.containsKey(patente)) {
			throw new RuntimeException("La patente no está registrada en el sistema.");
		}

		// Obtener el transporte correspondiente a la patente
		Transporte transporte = transportes.get(patente);

		// Verificar si el transporte está cargado
		if (!transporte.estaCargado()) {
			throw new RuntimeException("El transporte no está cargado.");
		}

		// Obtener el valor del viaje según la patente proporcionada
		return transporte.calcularValorDelViaje(patente);
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