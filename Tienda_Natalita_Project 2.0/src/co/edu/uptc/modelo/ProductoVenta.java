package co.edu.uptc.modelo;

public class ProductoVenta {

	private Producto producto;
	private int cantidad;
	private int precioCantidad;

	public ProductoVenta(Producto producto, int cantidad, int precioCantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioCantidad = precioCantidad;
	}

	@Override
	public String toString() {
		return "ProductoVenta [producto=" + producto + ", cantidad=" + cantidad + ", precioCantidad=" + precioCantidad
				+ "]";
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecioCantidad() {
		return precioCantidad;
	}

	public void setPrecioCantidad(int precioCantidad) {
		this.precioCantidad = precioCantidad;
	}

}
