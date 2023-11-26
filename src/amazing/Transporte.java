package amazing;

import java.util.ArrayList;
import java.util.List;

public abstract class Transporte {
	private String patente;
	private double volMaxDeCarga;
	protected double valorDelViaje;
	protected boolean cargado;
	private List<Paquete> paquetes;

	public Transporte(String patente, double volMaxDeCarga, double valorDelViaje) {
		this.patente = patente;
		this.volMaxDeCarga = volMaxDeCarga;
		this.valorDelViaje = valorDelViaje;
		this.cargado = false;
		this.paquetes = new ArrayList<>();
	}

	public boolean estaCargado() {
		return cargado;
	}

	protected void cargar() {
		cargado = true;
	}

	protected double calcularValorDelViaje() {
		return valorDelViaje;
	}

	public String identificarPatente() {
		return patente;
	}

	public double calcularVolMaxDeCarga() {
		return volMaxDeCarga;
	}

	public List<Paquete> identificarPaquetes() {
		return paquetes;
	}

	public abstract void cargarPaquete(Paquete paquete);

	@Override
	public String toString() {
		return "Transporte [patente=" + patente + ", volMaxDeCarga=" + volMaxDeCarga + ", valorDelViaje="
				+ valorDelViaje + ", cargado=" + cargado + ", paquetes=" + paquetes + "]";
	}

}
