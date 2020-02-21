package co.edu.uptc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Facturas {

	private String nombre;
	private String hora;
	private String fecha;
	private List<ProductoVenta> listaVendidos;
	private float total;

	public Facturas(String nombre, String hora, String fecha, List<ProductoVenta> listaVendidos, float total) {
		super();
		this.nombre = nombre;
		this.hora = hora;
		this.fecha = fecha;
		this.listaVendidos = listaVendidos;
		this.total = total;
	}

	@Override
	public String toString() {
		return "Facturas [nombre=" + nombre + ", hora=" + hora + ", fecha=" + fecha + ", listaVendidos=" + listaVendidos
				+ ", total=" + total + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public List<ProductoVenta> getListaVendidos() {
		return listaVendidos;
	}

	public void setListaVendidos(List<ProductoVenta> listaVendidos) {
		this.listaVendidos = listaVendidos;
	}

}
