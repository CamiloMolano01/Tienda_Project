package co.edu.uptc.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import co.edu.uptc.dao.DAOTNP2;
import co.edu.uptc.modelo.Categoria;
import co.edu.uptc.modelo.Perfil;
import co.edu.uptc.modelo.Producto;
import co.edu.uptc.modelo.ProductoVenta;
import co.edu.uptc.modelo.SubCategoria;
import co.edu.uptc.modelo.TipoDocumento;
import co.edu.uptc.modelo.TipoPerfil;
import co.edu.uptc.modelo.Facturas;

public class Controlador {

	private List<Perfil> listaPerfiles;
	private List<ProductoVenta> listaProductosVenta;
	private List<Producto> listaProductosInventario;
	private List<Facturas> listaFacturas;

	private String nombreUsuario;
	private int resultadoValidacion;
	private boolean usuarioEncontrado;
	private boolean contraseñaCorrecta;
	private DAOTNP2 dao;

	public Controlador() {
		dao = new DAOTNP2();
		listaPerfiles = new ArrayList<>();
		listaProductosVenta = new ArrayList<>();
		listaProductosInventario = new ArrayList<>();
		listaFacturas = new ArrayList<>();
	}

	// Productos Inventario

	public void leerListaProductos() throws IOException {
		listaProductosInventario = dao.leerProductosInventario();
	}

	public void guardarProductos() throws IOException {
		dao.guardarInventario(listaProductosInventario);
	}

	public void agregarProducto(int id, String nombre, String marca, String descripcion, Categoria categoria,
			SubCategoria subcategoria, int cantidad, int precioIva, int precioProveedor, int precioVenta)
			throws IOException {

		listaProductosInventario.add(new Producto(id, nombre, marca, descripcion, categoria, subcategoria, cantidad,
				precioIva, precioProveedor, precioVenta));
		guardarProductos();
	}

	public void actualizarProducto(int posicion, int id, String nombre, String marca, String descripcion,
			Categoria categoria, SubCategoria subcategoria, int cantidad, int precioIva, int precioProveedor,
			int precioVenta) throws IOException {
		listaProductosInventario.remove(posicion);
		listaProductosInventario.add(new Producto(id, nombre, marca, descripcion, categoria, subcategoria, cantidad,
				precioIva, precioProveedor, precioVenta));
		guardarProductos();
	}

	public void eliminarProducto(int posicion) throws IOException {
		listaProductosInventario.remove(posicion);
		guardarProductos();
	}

	// PERFILES

	public void leerListaPerfiles() throws IOException {
		listaPerfiles = dao.leerPerfiles();
	}

	public void guardarPerfiles() throws IOException {
		dao.guardarPerfiles(listaPerfiles);

	}

	public void agregarPerfil(String usuario, String contraseña, TipoPerfil tipoPerfil, String nombre, String apellido,
			String numeroDoc, TipoDocumento tipoDoc) throws IOException {
	
			listaPerfiles.add(new Perfil(usuario, contraseña, tipoPerfil, nombre, apellido, numeroDoc, tipoDoc, null));
		
		guardarPerfiles();

	}

	public void actualizarPerfil(int posicion, String usuario, String contraseña, TipoPerfil tipoPerfil, String nombre,
			String apellido, String numeroDoc, TipoDocumento tipoDoc) throws IOException {
		List<Facturas> lista = listaFacturas;
		listaPerfiles.remove(posicion);
		//for (int i = 0; i < listaFacturas.size(); i++) {
			//listaFacturas.get(i).setNombre(nombre);
		//}
		listaPerfiles.add(posicion,
				new Perfil(usuario, contraseña, tipoPerfil, nombre, apellido, numeroDoc, tipoDoc, lista));
		
		guardarPerfiles();
	}

	public void eliminarPerfil(int posicion) throws IOException {
		listaPerfiles.remove(posicion);
		guardarPerfiles();
	}

	public void agregarFactura(int i, String nombre, String hora, String fecha, int total) throws IOException {
		if (listaFacturas == null) {
			listaFacturas = new ArrayList<>();
		}
		listaFacturas.add(new Facturas(nombre, hora, fecha, listaProductosVenta, total));
		listaPerfiles.get(i).setListaFacturas(listaFacturas);
	}

	public void validarInicio(String usuario, String contraseña) {
		usuarioEncontrado = false;
		contraseñaCorrecta = false;
		for (int i = 0; i < listaPerfiles.size(); i++) {

			if (listaPerfiles.get(i).getUsuario().equals(usuario)) {
				usuarioEncontrado = true;
				if (!listaPerfiles.get(i).getContraseña().equals(contraseña)) {

					contraseñaCorrecta = false;

				} else if (listaPerfiles.get(i).getUsuario().equals(usuario)
						&& listaPerfiles.get(i).getContraseña().equals(contraseña)) {

					contraseñaCorrecta = true;

					if (listaPerfiles.get(i).getTipoPerfil().equals(TipoPerfil.ADMIN)) {
						resultadoValidacion = 1;
					}
					if (listaPerfiles.get(i).getTipoPerfil().equals(TipoPerfil.EMPLEADO)) {
						resultadoValidacion = 2;
					}

					nombreUsuario = usuario;

				}
			}

		}

	}

	public List<String> verListaPerfiles() {
		List<String> list = new ArrayList<>();
		if (listaPerfiles != null && !listaPerfiles.isEmpty()) {
			for (Perfil perfil : listaPerfiles) {
				StringBuilder sb = new StringBuilder();
				sb.append(" Usuario: ");
				sb.append(perfil.getUsuario() + "  ");
				sb.append(" Nombre: ");
				sb.append(perfil.getNombre() + "  ");
				sb.append(" Apellido: ");
				sb.append(perfil.getApellido() + "  ");
				list.add(sb.toString());
			}
		}
		return list;
	}

	public String[][] aniadirEnTablaVenta() {
		String matriz[][] = new String[listaProductosVenta.size()][6];
		for (int i = 0; i < listaProductosVenta.size(); i++) {
			matriz[i][0] = String.valueOf(listaProductosVenta.get(i).getProducto().getId());
			matriz[i][1] = listaProductosVenta.get(i).getProducto().getNombre();
			matriz[i][2] = String.valueOf(listaProductosVenta.get(i).getCantidad());
			matriz[i][3] = String.valueOf((listaProductosVenta.get(i).getProducto().getPrecioVenta()
					- listaProductosVenta.get(i).getProducto().getPrecioIva())
					* listaProductosVenta.get(i).getCantidad());
			matriz[i][4] = String.valueOf((listaProductosVenta.get(i).getProducto().getPrecioIva())
					* listaProductosVenta.get(i).getCantidad());
			matriz[i][5] = String.valueOf(actualizarPrecio(i));
		}
		return matriz;
	}

	public String[][] aniadirFactura() throws IOException {

		String matriz[][] = new String[listaProductosVenta.size()][4];
		for (int i = 0; i < listaProductosVenta.size(); i++) {
			matriz[i][0] = String.valueOf(listaProductosVenta.get(i).getProducto().getId());
			matriz[i][1] = String.valueOf(listaProductosVenta.get(i).getCantidad());
			matriz[i][2] = listaProductosVenta.get(i).getProducto().getNombre();
			matriz[i][3] = String.valueOf(listaProductosVenta.get(i).getPrecioCantidad());
		}

		guardarPerfiles();
		listaProductosVenta = new ArrayList<>();
		return matriz;
	}

	public String[][] recuperarFactura(List<ProductoVenta> vendidos) throws IOException {

		String matriz[][] = new String[vendidos.size()][4];
		for (int i = 0; i < vendidos.size(); i++) {
			matriz[i][0] = String.valueOf(vendidos.get(i).getProducto().getId());
			matriz[i][1] = String.valueOf(vendidos.get(i).getCantidad());
			matriz[i][2] = vendidos.get(i).getProducto().getNombre();
			matriz[i][3] = String.valueOf(vendidos.get(i).getPrecioCantidad());
		}

		// guardarPerfiles();
		// listaProductosVenta = new ArrayList<>();
		return matriz;
	}

	public int actualizarPrecio(int i) {
		listaProductosVenta.get(i).setPrecioCantidad(
				listaProductosVenta.get(i).getProducto().getPrecioVenta() * listaProductosVenta.get(i).getCantidad());
		int precio = listaProductosVenta.get(i).getPrecioCantidad();
		return precio;
	}

	public String[][] aniadirEnTablaInventario() {
		String matriz[][] = new String[listaProductosInventario.size()][10];

		for (int i = 0; i < listaProductosInventario.size(); i++) {
			matriz[i][0] = String.valueOf(listaProductosInventario.get(i).getId());
			matriz[i][1] = listaProductosInventario.get(i).getNombre();
			matriz[i][2] = listaProductosInventario.get(i).getMarca();
			matriz[i][3] = listaProductosInventario.get(i).getDescripcion();
			matriz[i][4] = String.valueOf(listaProductosInventario.get(i).getCategoria());
			matriz[i][5] = String.valueOf(listaProductosInventario.get(i).getSubcategoria());
			matriz[i][6] = String.valueOf(listaProductosInventario.get(i).getCantidad());
			matriz[i][7] = String.valueOf(listaProductosInventario.get(i).getPrecioProveedor());
			matriz[i][8] = String.valueOf(listaProductosInventario.get(i).getPrecioIva());
			matriz[i][9] = String.valueOf(listaProductosInventario.get(i).getPrecioVenta());
		}

		return matriz;

	}

	public List<Facturas> getListaFacturas() {
		return listaFacturas;
	}

	public void setListaFacturas(List<Facturas> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}

	public boolean isUsuarioEncontrado() {
		return usuarioEncontrado;
	}

	public void setUsuarioEncontrado(boolean usuarioEncontrado) {
		this.usuarioEncontrado = usuarioEncontrado;
	}

	public boolean isContraseñaCorrecta() {
		return contraseñaCorrecta;
	}

	public void setContraseñaCorrecta(boolean contraseñaCorrecta) {
		this.contraseñaCorrecta = contraseñaCorrecta;
	}

	public int getResultadoValidacion() {
		return resultadoValidacion;
	}

	public void setResultadoValidacion(int resultadoValidacion) {
		this.resultadoValidacion = resultadoValidacion;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public DAOTNP2 getDao() {
		return dao;
	}

	public void setDao(DAOTNP2 dao) {
		this.dao = dao;
	}

	public List<Perfil> getListaPerfiles() {
		return listaPerfiles;
	}

	public void setListaPerfiles(List<Perfil> listaPerfiles) {
		this.listaPerfiles = listaPerfiles;
	}

	public List<ProductoVenta> getListaProductosVenta() {
		return listaProductosVenta;
	}

	public void setListaProductosVenta(List<ProductoVenta> listaProductosVenta) {
		this.listaProductosVenta = listaProductosVenta;
	}

	public List<Producto> getListaProductosInventario() {
		return listaProductosInventario;
	}

	public void setListaProductosInventario(List<Producto> listaProductosInventario) {
		this.listaProductosInventario = listaProductosInventario;
	}

}
