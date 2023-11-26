package amazing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmpresaAmazing implements IEmpresa {
	private String cuit;
	private Set<Pedido> pedidos;
	private Map<Integer, Cliente> clientes;
	private HashMap<String, Transporte> transportes;
	private int codPedido;
	private int codPaquete;
	private double facturacionTotal;

	public EmpresaAmazing(String cuit) {

		// TODO Auto-generated constructor stub
		this.cuit = cuit;
		pedidos = new HashSet<>();
		transportes = new HashMap<>();
		this.codPedido = 0;
		this.codPaquete = 0;
		facturacionTotal = 0;
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

	/**
	 * Se registra un nuevo pedido en el sistema proporcionando los siguientes
	 * datos: - el nombre del cliente que lo solicita - su dirección - su dni
	 * 
	 * El sistema le asigna un numero de pedido unico y crea un carrito de ventas
	 * vacio. Devuelve el numero de pedido asignado.
	 * 
	 */

	@Override
	public int registrarPedido(String cliente, String direccion, int dni) {
		codPedido++;
		Cliente c = new Cliente(cliente, dni, direccion);
		Carrito carrito = new Carrito();
		Pedido p = new Pedido(codPedido, c, false, carrito, false, null);
		pedidos.add(p);
		return codPedido;
	}

	/**
	 * Se registra la compra de un producto, el cual se agregara al carrito del
	 * pedido dado como un paquete de tipo ordinario.
	 * 
	 * Se ingresan los datos necesario para agregarlo: - pedido al que corresponde
	 * agregarlo - volumen del paquete a agregar - precio del producto que contiene
	 * el paquete.
	 * 
	 * Ademas por ser un paquete de tipo ordinario: - costo del envio
	 * 
	 * Si ese pedido no esta registrado en el sistema o ya está finalizado se debe
	 * generar una excepcion.
	 * 
	 * devuelve el codigo de paquete unico.
	 * 
	 */

	@Override
	public int agregarPaquete(int codPedido, int volumen, int precio, int costoEnvio) {
		Pedido p = buscarPedido(codPedido);
		PaqueteOrdinario paquete = new PaqueteOrdinario(codPaquete, volumen, precio, false, costoEnvio);
		p.obtenerCarrito().obtenerPaquetes().add(paquete);

		return codPaquete;
	}

	private Pedido buscarPedido(int codPedido) {
		for (Pedido p : pedidos) {
			if (p.obtenerCodPedido() == codPedido) {
				return p;
			}
		}
		throw new RuntimeException("El pedido no está registrado en el sistema.");
	}

	@Override
	public int agregarPaquete(int codPedido, int volumen, int precio, int porcentaje, int adicional) {
		Pedido p = buscarPedido(codPedido);
		PaqueteEspecial paquete = new PaqueteEspecial(codPaquete, volumen, precio, false, porcentaje, adicional);
		p.obtenerCarrito().obtenerPaquetes().add(paquete);

		return codPaquete;
	}

//	**
//	 * quita un paquete del pedido dado su codigo unico de paquete.
//	 * 
//	 * Devuelve true si pudo quitar el paquete. 
//	 * si no lo encontró o  el pedido ya esta finalizado, devuelve false.
//	 * 
//	 * Demostrar la complejidad en terminos de O grande en el informe.
//	 */

	@Override
	public boolean quitarPaquete(int codPaquete) {
		Pedido p = buscarPedido(codPedido);
		p.obtenerCarrito().obtenerPaquetes().remove(codPaquete);
		return true;
	}

	/**
	 * Se registra la finalizacion de un pedido registrado en la empresa, dado su
	 * codigo. Devuelve el total a pagar por el pedido.
	 * 
	 * Si ese codigo no esta en el sistema o ya fue finalizado se debe generar una
	 * excepcion.
	 *
	 */

	@Override
	public double cerrarPedido(int codPedido) {
		double totalAFacturar = 0;
		Pedido p = buscarPedido(codPedido);
		if (p.estaCerrado()) {
			throw new IllegalStateException("El pedido ya ha sido cerrado anteriormente.");
		}
		for (Paquete paquete : p.obtenerCarrito().obtenerPaquetes()) {
			totalAFacturar += paquete.calcularTotalAPagar();
		}
		p.cerrarPedido();

		facturacionTotal += totalAFacturar;

		return totalAFacturar;
	}

	/**
	 * Se solicita la carga de un transporte registrado en la empresa, dada su
	 * patente.
	 * 
	 * Devuelve un String con forma de listado donde cada renglón representa un
	 * paquete cargado. Cada renglón debe respetar el siguiente formato: " + [
	 * NroPedido - codPaquete ] direccion" por ejemplo: " + [ 1002 - 101 ] Gutierrez
	 * 1147"
	 *
	 * Los paquetes que se cargan deben pertenecer a pedidos finaizados. Si no se
	 * encontró ningún paquete para cargar, se debe devolver un string vacio.
	 * 
	 * Si esa patente no esta en el sistema se debe generar una excepcion.
	 * 
	 */

	@Override
	public String cargarTransporte(String patente) {
		StringBuilder sb = new StringBuilder();
		Transporte t = buscarTransporte(patente);
		for (Pedido pedido : pedidos) {
			for (Paquete paquete : pedido.obtenerCarrito().obtenerPaquetes()) {
				if (!paquete.estaCargado() && pedido.estaCerrado()) {
					t.cargarPaquete(paquete);
					sb.append(String.format(" + [ %d - %d ] %s\n", pedido.obtenerCodPedido(),
							paquete.obtenerIdentificador(), pedido.obtenerCliente().obtenerDireccion()));
				}
			}
		}
		System.out.println(t.identificarPaquetes());
		return sb.toString();
	}

	private Transporte buscarTransporte(String patente) {
		if (transportes.containsKey(patente)) {
			return transportes.get(patente);
		}
		throw new RuntimeException("El transporte no está registrado en el sistema.");
	}

	/**
	 * Se solicita el costo del viaje de un transporte dado su patente Este costo es
	 * el que cobra el transporte (a la empresa) por entregar la carga una vez que
	 * fue cargado con los paquetes.
	 * 
	 * Una vez cargado, aunque no se haya podido completar, el transporte reparte
	 * los paquetes cargados.
	 * 
	 * Se devuelve el valor del viaje segun lo indicado en cada tipo de transporte.
	 * Cada tipo de transporte tiene su forma de calcular el costo del viaje.
	 * 
	 * Si esa patente no esta en el sistema se debe generar una excepcion. Si el
	 * transporte no esta cargado genera un excepcion.
	 * 
	 * En O(1)
	 */

	@Override
	public double costoEntrega(String patente) {
		Transporte t = buscarTransporte(patente);

		double carga = 0;
		if (t.identificarPaquetes().isEmpty()) {
			throw new RuntimeException("el vehiculo no tiene paquetes cargados.");
		}

		return t.calcularValorDelViaje();

	}

	/**
	 * Devuelve los pedidos cerrados y que no fueron entregados en su totalidad. O
	 * sea, que tienen paquetes sin entregar.
	 * 
	 * Devuelve un diccionario cuya clave es el codigo del pedido y el valor es el
	 * nombre del cliente que lo pidio.
	 * 
	 */

	@Override
	public Map<Integer, String> pedidosNoEntregados() {
		return null;
//		Map<Integer, String> pedidosNoEntregados = new HashMap<>();
//
//		for (Pedido pedido : pedidos.values()) {
//			// Verificar si el pedido está cerrado y no entregado
//			if (pedido.estaCerrado() && !pedido.estaEntregado()) {
//
//				Cliente cliente = pedido.obtenerCliente();
//
//				// Agregar al Map con el código del pedido y el nombre del cliente
//				pedidosNoEntregados.put(pedido.obtenerCodPedido(), cliente.obtenerNombreCliente());
//			}
//		}
//
//		return pedidosNoEntregados;
	}

	/**
	 * Devuelve la suma del precio facturado de todos los pedidos cerrados.
	 * 
	 * Se debe realizar esta operacion en O(1).
	 */

	@Override
	public double facturacionTotalPedidosCerrados() {
		return facturacionTotal;
	}

	/**
	 * Se consideran transportes identicos a 2 transportes cargados con: - distinta
	 * patente, - mismo tipo y - la misma carga. Se considera misma carga al tener
	 * la misma cantidad de paquetes con las mismas caracteristicas: - mismo
	 * volumen, - mismo tipo - mismo precio y - mismos atributos según el tipo de
	 * Paquete VER EJEMPLO EN ENUNCIADO
	 */

	@Override
	public boolean hayTransportesIdenticos() {
		return false;

	}

	@Override
	public String toString() {
		return "EmpresaAmazing [cuit=" + cuit + ", pedidos=" + pedidos + ", clientes=" + clientes + ", transportes="
				+ transportes + ", codPedido=" + codPedido + ", codPaquete=" + codPaquete + ", facturacionTotal="
				+ facturacionTotal + "]";
	}
}
