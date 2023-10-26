package amazing;

import java.util.HashMap;
import java.util.Set;

public abstract class Transporte <identificador> implements Comparable <Transporte> {
	
	private String patente;
	private double volMaxDeCarga;
	private double valorDelViaje;
	private boolean cargado;
	private HashMap <identificador,Paquete> paquetes;
	
	public Transporte(String patente, double volMaxDeCarga, double valorDelViaje, boolean cargado, Paquete paquetes) {
		this.patente = patente;
		this.volMaxDeCarga = volMaxDeCarga;
		this.valorDelViaje = valorDelViaje;
		this.cargado = cargado;
		
	}
	
	public void cargarTransporte(String patente) {
		
	}
	
	public boolean estaCargado() {
		return cargado;
	}
	
	public double calcularValorDelViaje(String patente) {
		return valorDelViaje;
	}
	
	public String identificarPatente() {
		return patente;
	}
	
	public double calcularVolMaxDeCarga(){
		return volMaxDeCarga;
	}
	
	
	public Set<identificador> identificarTipoDePaquete() {
		return paquetes.keySet();
	}


	
}
