package co.edu.uptc.modelo;

public class Producto {

	private int id;
	private String nombre;
	private String marca;
	private String descripcion;
	private Categoria categoria;
	private SubCategoria subcategoria;
	private int cantidad;
	private int precioIva;
	private int precioProveedor;
	private int precioVenta;

	public Producto() {

	}

	public Producto(int id, String nombre, String marca, String descripcion, Categoria categoria,
			SubCategoria subcategoria, int cantidad, int precioIva, int precioProveedor, int precioVenta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.subcategoria = subcategoria;
		this.cantidad = cantidad;
		this.precioIva = precioIva;
		this.precioProveedor = precioProveedor;
		this.precioVenta = precioVenta;
	}

	

	@Override
	public String toString() {
		return "#"+id +"  "+ nombre;
	}

	public int getPrecioIva() {
		return precioIva;
	}

	public void setPrecioIva(int precioIva) {
		this.precioIva = precioIva;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public SubCategoria getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(SubCategoria subcategoria) {
		this.subcategoria = subcategoria;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecioProveedor() {
		return precioProveedor;
	}

	public void setPrecioProveedor(int precioProveedor) {
		this.precioProveedor = precioProveedor;
	}

	public int getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}

}
