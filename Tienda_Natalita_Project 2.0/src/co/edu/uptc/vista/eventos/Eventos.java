package co.edu.uptc.vista.eventos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Locale.Category;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.uptc.modelo.Categoria;
import co.edu.uptc.modelo.Facturas;
import co.edu.uptc.modelo.ProductoVenta;
import co.edu.uptc.modelo.SubCategoria;
import co.edu.uptc.modelo.TipoDocumento;
import co.edu.uptc.modelo.TipoPerfil;
import co.edu.uptc.vista.InicioSesion;
import co.edu.uptc.vista.VentanaPrincipal;
import co.edu.uptc.vista.paneles.BarraPaneles;

public class Eventos implements ActionListener {

	public VentanaPrincipal ventana;
	public boolean atrasCrearU = true;
	public boolean atrasVerU = true;
	public boolean atrasDatosPro = true;

	public Eventos(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String accion = e.getActionCommand();

		if (accion.equals("calculadora")) {
			ventana.getCalculadora().setVisible(true);
		}

		if (accion.equals("inicio")) {
			if (ventana.getBotonListener().isInicioActivado() == false) {
				borrarPaneles();
				ventana.add(ventana.getPanelInicial(), BorderLayout.CENTER);
				actualizarVentana();
			} else {

			}
		}

		if (accion.equals("actF")) {
			try {
				actualizarFacturas();
			} catch (IOException e1) {
				// TODO Bloque catch generado automáticamente
				e1.printStackTrace();
			}
		}

		if (accion.equals("resumen")) {
			if (ventana.getBotonListener().isResumenActivado() == false) {
				borrarPaneles();
				ventana.add(ventana.getPanelResumen(), BorderLayout.CENTER);
				try {
					actualizarFacturas();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				actualizarVentana();
			} else {

			}
		}

		if (accion.equals("empleados")) {

			if (atrasCrearU == false) {
				borrarPaneles();
				ventana.add(ventana.getPanelEmple().getPanelCrearUsuario(), BorderLayout.CENTER);
				actualizarVentana();
			} else if (atrasVerU == false) {
				borrarPaneles();
				ventana.add(ventana.getPanelEmple().getPanelVerUsurarios(), BorderLayout.CENTER);
				actualizarVentana();
			} else if (atrasCrearU == true && atrasVerU == true) {
				if (ventana.getBotonListener().isEmpleadosActivado() == false) {
					actualizarCrearVer();
				}

			}

		}

		if (accion.equals("inventario")) {

			if (atrasDatosPro == false) {
				borrarPaneles();
				ventana.add(ventana.getPanelInv().getPanelDatosPro(), BorderLayout.CENTER);
				actualizarVentana();
			} else {
				borrarPaneles();
				ventana.getPanelInv().actualizarTablaInventario();
				ventana.add(ventana.getPanelInv(), BorderLayout.CENTER);
				actualizarVentana();
			}
		}

		if (accion.equals("cambio")) {

			if (JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesion?", "Salir", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png")) == JOptionPane.YES_OPTION) {
				InicioSesion vista;
				try {
					vista = new InicioSesion();
					ventana.dispose();
					vista.setVisible(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}

		}

		if (accion.equals("crear")) {
			String usuario = ventana.getPanelEmple().getPanelCrearUsuario().getUsuario().getText();
			if (verificarUExiste(usuario) == false) {
				creacion();
			} else {
				JOptionPane.showMessageDialog(null, "Este nombre de usuario ya esta en uso", "Error",
						JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
				ventana.getPanelEmple().getPanelCrearUsuario().getUsuario().setText("");
			}
		}

		if (accion.equals("crearUsuario")) {
			borrarPaneles();
			ventana.add(ventana.getPanelEmple().getPanelCrearUsuario(), BorderLayout.CENTER);
			actualizarVentana();
			atrasCrearU = false;
		}

		if (accion.equals("atras")) {
			atrasCrearU = true;
			actualizarCrearVer();
		}

		if (accion.equals("atrasVer")) {
			atrasVerU = true;
			actualizarCrearVer();

		}

		if (accion.equals("verUsuarios")) {
			borrarPaneles();
			ventana.add(ventana.getPanelEmple().getPanelVerUsurarios(), BorderLayout.CENTER);

			if (ventana.getPanelEmple().getPanelVerUsurarios().getNombre().getText().length() > 0) {
				ventana.getPanelEmple().getPanelVerUsurarios().getCtDoc().setEnabled(true);
			} else {
				ventana.getPanelEmple().getPanelVerUsurarios().getCtDoc().setEnabled(false);
			}

			ventana.getPanelEmple().getPanelVerUsurarios().actualizarJList();
			actualizarVentana();
			atrasVerU = false;
		}

		if (accion.equals("eliminarUsuario")) {
			int posicion = ventana.getPanelEmple().getPanelVerUsurarios().getJlistUsuarios().getSelectedIndex();
			if (JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar al usuario?", "Eliminar",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
					new ImageIcon("./imagenes/error.png")) == JOptionPane.YES_OPTION) {
				try {
					ventana.getControlador().eliminarPerfil(posicion);
					ventana.getPanelEmple().getPanelVerUsurarios().actualizarJList();
					actualizarVentana();
					JOptionPane.showMessageDialog(null, "Usuario eliminado con exito", "Eliminado",
							JOptionPane.DEFAULT_OPTION, new ImageIcon("./imagenes/comprobado.png"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}

		}

		if (accion.equals("actualizarUsuario")) {
			actualizarUsuario();
		}

		if (accion.equals("agregarPro")) {
			borrarPaneles();
			limpiarcamposProdutos();
			ventana.getPanelInv().getPanelDatosPro().getTitulo().setText("Nuevo Producto");
			ventana.getPanelInv().getPanelDatosPro().getTitulo().setIcon(new ImageIcon("./imagenes/nuevoProducto.png"));
			ventana.getPanelInv().getPanelDatosPro().getAccionPro().setText("AGREGAR");
			ventana.getPanelInv().getPanelDatosPro().getAccionPro().setActionCommand("agregarProducto");
			ventana.getPanelInv().getPanelDatosPro().getCtCategoria().addItem(Categoria.VACIO);
			ventana.getPanelInv().getPanelDatosPro().getCtCategoria().setSelectedItem(Categoria.VACIO);
			ventana.add(ventana.getPanelInv().getPanelDatosPro(), BorderLayout.CENTER);
			actualizarVentana();
			atrasDatosPro = false;

		}

		if (accion.equals("editarPro")) {
			Integer posicion = ventana.getPanelInv().getTablaInventario().getSelectedRow();

			if (posicion >= 0 && posicion != null) {
				posicion = ventana.getPanelInv().getTablaInventario().convertRowIndexToModel(posicion);
				borrarPaneles();
				camposEditar(posicion);
				ventana.getPanelInv().getPanelDatosPro().getAccionPro().setActionCommand("actualizarProducto");
				ventana.add(ventana.getPanelInv().getPanelDatosPro(), BorderLayout.CENTER);
				actualizarVentana();
				atrasDatosPro = false;
			} else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un producto", "Error",
						JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
			}

		}

		if (accion.equals("agregarProducto")) {

			try {
				if (ventana.getPanelInv().getPanelDatosPro().getCodigo().getText().length() > 0) {
					int codigo = ventana.getPanelInv().getPanelDatosPro().validarID();
					if (codigo >= 0) {
						if (verificarCodProExiste(codigo) == false) {
							nuevoProducto();
							ventana.getPanelInicial().agregarCompletar();
						} else {
							JOptionPane.showMessageDialog(null, "Este codigo ya esta en uso", "Error",
									JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
							ventana.getPanelInv().getPanelDatosPro().getCodigo().setText("");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Tiene que completar todos los campos", "Faltan datos",
							JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
				}

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (accion.equals("actualizarProducto")) {
			try {
				actualizarProducto();
				ventana.getPanelInicial().agregarCompletar();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (accion.equals("eliminarPro")) {
			int posicion = ventana.getPanelInv().getTablaInventario().getSelectedRow();
			if (posicion >= 0) {
				if (JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este producto?", "Eliminar",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
						new ImageIcon("./imagenes/error.png")) == JOptionPane.YES_OPTION) {
					try {
						ventana.getControlador().eliminarProducto(posicion);
						ventana.getPanelInv().actualizarTablaInventario();
						actualizarVentana();
						JOptionPane.showMessageDialog(null, "Producto eliminado con exito", "Eliminado",
								JOptionPane.DEFAULT_OPTION, new ImageIcon("./imagenes/comprobado.png"));
						ventana.getPanelInicial().agregarCompletar();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}

			} else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un producto", "Error",
						JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
			}
		}

		if (accion.equals("atrasPro")) {
			atrasDatosPro = true;

			borrarPaneles();
			ventana.add(ventana.getPanelInv(), BorderLayout.CENTER);
			actualizarVentana();
			try {
				ventana.getPanelInv().getPanelDatosPro().eliminarVacio();
			} catch (Exception e2) {

			}
		}

		if (accion.equals("mas")) {
			int posicion = ventana.getPanelInicial().getTablaVenta().getSelectedRow();
			int cantidad = ventana.getControlador().getListaProductosVenta().get(posicion).getCantidad();
			if (cantidad < cantidad(
					ventana.getControlador().getListaProductosVenta().get(posicion).getProducto().getId())) {
				cantidad++;
			} else {
				JOptionPane.showMessageDialog(null, "Cantidad Maxima alcanzada", "ERROR", JOptionPane.WARNING_MESSAGE,
						new ImageIcon("./imagenes/error.png"));
			}
			ventana.getControlador().getListaProductosVenta().get(posicion).setCantidad(cantidad);
			ventana.getPanelInicial().actualizarTablaVenta();
			ventana.getPanelInicial().getTablaVenta().getSelectionModel().setSelectionInterval(posicion, posicion);
		}

		if (accion.equals("menos")) {
			int posicion = ventana.getPanelInicial().getTablaVenta().getSelectedRow();
			int cantidad = ventana.getControlador().getListaProductosVenta().get(posicion).getCantidad();
			if (cantidad > 1) {
				cantidad--;
				ventana.getControlador().getListaProductosVenta().get(posicion).setCantidad(cantidad);
				ventana.getPanelInicial().actualizarTablaVenta();
				ventana.getPanelInicial().getTablaVenta().getSelectionModel().setSelectionInterval(posicion, posicion);
				ventana.getPanelInicial().getBotonMas().setEnabled(true);
			} else if (cantidad == 1) {

				if (JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este producto de la compra?",
						"Eliminar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
						new ImageIcon("./imagenes/error.png")) == JOptionPane.YES_OPTION) {
					ventana.getControlador().getListaProductosVenta().remove(posicion);
					ventana.getPanelInicial().getTextBuscar().setText("");
					ventana.getPanelInicial().getInfoPro().setText("");
					ventana.getPanelInicial().actualizarTablaVenta();
					ventana.getPanelInicial().getBotonMas().setEnabled(false);
					ventana.getPanelInicial().getBotonMenos().setEnabled(false);
				}

			}
		}

		if (accion.equals("pagar")) {
			if (ventana.getPanelInicial().total() > 0) {
				if (JOptionPane.showConfirmDialog(null,
						"Compra total de: " + ventana.getPanelInicial().total() + "\n"
								+ "¿Esta seguro desea realizar la compra?",
						"PAGAR", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
						new ImageIcon("./imagenes/efectivo.png")) == JOptionPane.YES_OPTION) {

					for (int i = 0; i < ventana.getControlador().getListaProductosInventario().size(); i++) {
						for (int j = 0; j < ventana.getControlador().getListaProductosVenta().size(); j++) {
							if (ventana.getControlador().getListaProductosVenta().get(j).getProducto()
									.getId() == ventana.getControlador().getListaProductosInventario().get(i).getId()) {
								ventana.getControlador().getListaProductosInventario().get(i).setCantidad(ventana
										.getControlador().getListaProductosInventario().get(i).getCantidad()
										- ventana.getControlador().getListaProductosVenta().get(j).getCantidad());
							}

						}
					}

					for (int i = 0; i < ventana.getControlador().getListaPerfiles().size(); i++) {
						if (ventana.getControlador().getListaPerfiles().get(i).getUsuario()
								.equals(ventana.getControlador().getNombreUsuario())) {
							String hora = ventana.getPanelInferior().getHoraActual().getText();
							String fecha = ventana.getPanelInferior().getFecha().getText();
							String nombre = ventana.getControlador().getListaPerfiles().get(i).getUsuario();
							int total = ventana.getPanelInicial().total();
							try {
								ventana.getControlador().agregarFactura(i, nombre, hora, fecha, total);
								ventana.getPanelResumen().getPanelFacturas()
										.add(crearFacturas(null, false, hora, nombre, fecha, total));
								actualizarFacturas();

							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}

					ventana.getPanelInicial().getTextBuscar().setText("");
					ventana.getPanelInicial().getInfoPro().setText("");
					ventana.getPanelInicial().actualizarTablaVenta();
					JOptionPane.showMessageDialog(null, "Venta realizada correctamente", "", JOptionPane.DEFAULT_OPTION,
							new ImageIcon("./imagenes/comprobado.png"));
					ventana.getPanelInicial().getBotonMas().setEnabled(false);
					ventana.getPanelInicial().getBotonMenos().setEnabled(false);
					try {
						ventana.getControlador().guardarProductos();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}
			} else {
				JOptionPane.showMessageDialog(null, "El total de la compra debe ser mayor que cero (0)", "ERROR",
						JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
			}
		}

	}

	public void actualizarFacturas() throws IOException {
		ventana.getPanelResumen().getPanelFacturas().removeAll();

		for (int i = 0; i < ventana.getControlador().getListaPerfiles().size(); i++) {

			if (ventana.getControlador().getListaPerfiles().get(i).getUsuario()
					.equals(ventana.getControlador().getNombreUsuario())) {

				ventana.getControlador()
						.setListaFacturas(ventana.getControlador().getListaPerfiles().get(i).getListaFacturas());

				if (ventana.getControlador().getListaFacturas() != null) {
					for (int k = 0; k < ventana.getControlador().getListaFacturas().size(); k++) {

						String hora = ventana.getControlador().getListaFacturas().get(k).getHora();
						String nombre = ventana.getControlador().getListaPerfiles().get(i).getNombre();
						String fecha = ventana.getControlador().getListaFacturas().get(k).getFecha();
						float total = ventana.getControlador().getListaFacturas().get(k).getTotal();

						String[] parts = fecha.split("/");
						String part1 = parts[0];
						String part2 = parts[1];
						String part3 = parts[2];

						String[] partes = ventana.getPanelInferior().getFecha().getText().split("/");
						String parte1 = partes[0];
						String parte2 = partes[1];
						String parte3 = partes[2];
						if (ventana.getPanelResumen().getCombo().getSelectedItem().equals("Facturas Hoy")) {
							if (part1.equals(parte1)) {
								ventana.getPanelResumen().getPanelFacturas()
										.add(crearFacturas(
												ventana.getControlador().getListaFacturas().get(k).getListaVendidos(),
												true, hora, nombre, fecha, total));
							}

						} else if (ventana.getPanelResumen().getCombo().getSelectedItem().equals("Facturas Mes")) {

							if (part2.equals(parte2)) {
								ventana.getPanelResumen().getPanelFacturas()
										.add(crearFacturas(
												ventana.getControlador().getListaFacturas().get(k).getListaVendidos(),
												true, hora, nombre, fecha, total));
							}

						} else if (ventana.getPanelResumen().getCombo().getSelectedItem().equals("Facturas Año")) {

							if (part3.equals(parte3)) {
								ventana.getPanelResumen().getPanelFacturas()
										.add(crearFacturas(
												ventana.getControlador().getListaFacturas().get(k).getListaVendidos(),
												true, hora, nombre, fecha, total));
							}

						}

					}
				}
			}

		}

	}

	public JButton crearFacturas(List<ProductoVenta> vendidos, Boolean recuperar, String hora, String nombre,
			String fecha, float total) throws IOException {

		JButton panelFactura = new JButton();
		panelFactura.setBackground(ventana.getColorBase());
		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(ventana.getColorBase());
		JLabel labelTotal = new JLabel("Total: " + total);
		labelTotal.setForeground(Color.WHITE);
		JLabel labelInfo = new JLabel("Hora: " + hora + "    Fecha: " + fecha);
		labelInfo.setForeground(Color.WHITE);
		JLabel labelNombre = new JLabel("Nombre: " + nombre);
		labelNombre.setForeground(Color.WHITE);

		panelFactura.setLayout(new BorderLayout());
		DefaultTableModel modeloTabla;
		if (recuperar == true) {
			modeloTabla = new DefaultTableModel(ventana.getControlador().recuperarFactura(vendidos),
					new String[] { "id", "cantidad", "nombre", "precio" });

		} else {
			modeloTabla = new DefaultTableModel(ventana.getControlador().aniadirFactura(),
					new String[] { "id", "cantidad", "nombre", "precio" });
		}

		JTable tablaPro = new JTable(modeloTabla);
		tablaPro.setDefaultEditor(Object.class, null);
		tablaPro.setBackground(Color.white);

		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setViewportView(tablaPro);
		scrollpane.setPreferredSize(new Dimension(300, 180));
		scrollpane.setBackground(Color.WHITE);

		panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
		panelDatos.add(labelNombre);
		panelDatos.add(labelInfo);

		panelFactura.add(panelDatos, BorderLayout.NORTH);
		panelFactura.add(scrollpane, BorderLayout.CENTER);
		panelFactura.add(labelTotal, BorderLayout.SOUTH);
		return panelFactura;
	}

	public int cantidad(int id) {
		int numero = 0;
		for (int j = 0; j < ventana.getControlador().getListaProductosInventario().size(); j++) {
			if (ventana.getControlador().getListaProductosInventario().get(j).getId() == id) {
				numero = ventana.getControlador().getListaProductosInventario().get(j).getCantidad();
			}
		}
		return numero;
	}

	public void creacion() {

		String usuario = ventana.getPanelEmple().getPanelCrearUsuario().getUsuario().getText();
		String contraseña = String
				.valueOf(ventana.getPanelEmple().getPanelCrearUsuario().getContraseña().getPassword());
		String confcontra = String
				.valueOf(ventana.getPanelEmple().getPanelCrearUsuario().getConfContra().getPassword());
		TipoPerfil tipoPerfil = (TipoPerfil) ventana.getPanelEmple().getPanelCrearUsuario().getCtPerfil()
				.getSelectedItem();
		String nombre = ventana.getPanelEmple().getPanelCrearUsuario().getNombre().getText();
		String apellido = ventana.getPanelEmple().getPanelCrearUsuario().getApellido().getText();
		TipoDocumento tipoDocumento = (TipoDocumento) ventana.getPanelEmple().getPanelCrearUsuario().getCtDoc()
				.getSelectedItem();
		String numeroDoc = ventana.getPanelEmple().getPanelCrearUsuario().getNumeroDoc().getText();

		if ((usuario.length() > 0 && contraseña.length() > 0 && confcontra.length() > 0 && nombre.length() > 0
				&& apellido.length() > 0 && numeroDoc.length() > 0)) {

			if (contraseña.equals(confcontra)) {
				try {
					ventana.getControlador().agregarPerfil(usuario, contraseña, tipoPerfil, nombre, apellido, numeroDoc,
							tipoDocumento);
					JOptionPane.showMessageDialog(null, "Usuario nuevo agregado con exito", "Agregado",
							JOptionPane.DEFAULT_OPTION, new ImageIcon("./imagenes/comprobado.png"));
					atrasCrearU = true;
					limpiarcamposCrear();
					actualizarCrearVer();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error",
						JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
			}
		} else {
			JOptionPane.showMessageDialog(null, "Tiene que completar todos los campos", "Faltan datos",
					JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
		}
	}

	public void actualizarUsuario() {

		int posicion = ventana.getPanelEmple().getPanelVerUsurarios().getJlistUsuarios().getSelectedIndex();
		TipoDocumento tipoDoc = (TipoDocumento) ventana.getPanelEmple().getPanelVerUsurarios().getCtDoc()
				.getSelectedItem();
		TipoPerfil tipoPerfil = ventana.getControlador().getListaPerfiles().get(posicion).getTipoPerfil();
		String usuario = ventana.getPanelEmple().getPanelVerUsurarios().getUsuario().getText();
		String contraseña = String
				.valueOf(ventana.getPanelEmple().getPanelVerUsurarios().getContraseña().getPassword());
		String nombre = ventana.getPanelEmple().getPanelVerUsurarios().getNombre().getText();
		String apellido = ventana.getPanelEmple().getPanelVerUsurarios().getApellido().getText();
		String numeroDoc = ventana.getPanelEmple().getPanelVerUsurarios().getNumeroDoc().getText();

		String usuarioANT = ventana.getControlador().getListaPerfiles().get(posicion).getUsuario();
		String contraseñaANT = ventana.getControlador().getListaPerfiles().get(posicion).getContraseña();
		String nombreANT = ventana.getControlador().getListaPerfiles().get(posicion).getNombre();
		String apellidoANT = ventana.getControlador().getListaPerfiles().get(posicion).getApellido();
		String numeroDocANT = ventana.getControlador().getListaPerfiles().get(posicion).getNumeroDoc();
		TipoDocumento tipoDocANT = ventana.getControlador().getListaPerfiles().get(posicion).getTipoDoc();

		if (verificarUExiste(usuario) == true && !usuario.equals(usuarioANT)) {
			JOptionPane.showMessageDialog(null, "Este nombre de usuario ya esta en uso", "Error",
					JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
		} else {
			if (usuario.equals(usuarioANT) && contraseña.equals(contraseñaANT) && nombre.equals(nombreANT)
					&& apellido.equals(apellidoANT) && numeroDoc.equals(numeroDocANT) && tipoDoc.equals(tipoDocANT)) {
				JOptionPane.showMessageDialog(null, "Debe por lo menos cambiar un dato", "ERROR",
						JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
			} else {
				if (nombre.length() > 0 && usuario.length() > 0) {

					if (JOptionPane.showConfirmDialog(null, "¿Esta seguro de modificar al usuario?", "Editar",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
							new ImageIcon("./imagenes/error.png")) == JOptionPane.YES_OPTION) {
						try {
							ventana.getControlador().actualizarPerfil(posicion, usuario, contraseña, tipoPerfil, nombre,
									apellido, numeroDoc, tipoDoc);

							atrasVerU = true;
							limpiarcamposVer();
							actualizarCrearVer();

						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}

				}else {
					JOptionPane.showMessageDialog(null, "Datos vacios", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	}

	public void nuevoProducto() throws IOException {

		if (ventana.getPanelInv().getPanelDatosPro().getCodigo().getText().length() > 0
				&& ventana.getPanelInv().getPanelDatosPro().getCantidad().getText().length() > 0
				&& ventana.getPanelInv().getPanelDatosPro().getPrecioProveedor().getText().length() > 0
				&& ventana.getPanelInv().getPanelDatosPro().getPrecioVenta().getText().length() > 0) {

			int id = ventana.getPanelInv().getPanelDatosPro().validarID();
			String nombre = ventana.getPanelInv().getPanelDatosPro().getNombre().getText();
			String marca = ventana.getPanelInv().getPanelDatosPro().getMarca().getText();
			String descripcion = ventana.getPanelInv().getPanelDatosPro().getDescripcion().getText();
			Categoria categoria = (Categoria) ventana.getPanelInv().getPanelDatosPro().getCtCategoria()
					.getSelectedItem();
			SubCategoria subcategoria = (SubCategoria) ventana.getPanelInv().getPanelDatosPro().getCtSubCategoria()
					.getSelectedItem();
			int cantidad = ventana.getPanelInv().getPanelDatosPro().validarCantidad();
			int precioProveedor = ventana.getPanelInv().getPanelDatosPro().validarPrecioB();
			int precioVenta = ventana.getPanelInv().getPanelDatosPro().validarPrecioV();
			int precioIva = 0;

			switch (categoria) {
			case ALIMENTO:
				precioIva = (precioProveedor * 10) / 100;
				break;
			case ASEO:
				precioIva = (precioProveedor * 16) / 100;
				break;
			case DROGUERIA:
				precioIva = (precioProveedor * 14) / 100;
				break;
			case PAPELERIA:
				precioIva = (precioProveedor * 12) / 100;
				break;
			default:
				break;
			}

			if ((id > -1 && precioProveedor > -1 && precioVenta > -1)) {
				if ((nombre.length() > 0 && marca.length() > 0 && descripcion.length() > 0
						&& !categoria.equals(categoria.VACIO) && cantidad > -1)) {

					try {

						ventana.getControlador().agregarProducto(id, nombre, marca, descripcion, categoria,
								subcategoria, cantidad, precioIva, precioProveedor, precioVenta);
						JOptionPane.showMessageDialog(null, "Producto agregado correctamente", "Agregado",
								JOptionPane.DEFAULT_OPTION, new ImageIcon("./imagenes/comprobado.png"));

						limpiarcamposProdutos();
						actualizarDatosPro();

					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(null, "Tiene que completar todos los campos", "Faltan datos",
							JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
				}

			} else {
				JOptionPane.showMessageDialog(null, "El codigo y precios debe ser un numero mayor o igual a 0",
						"Faltan datos", JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
			}

		} else {
			JOptionPane.showMessageDialog(null, "Tiene que completar todos los campos", "Faltan datos",
					JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
		}

	}

	public void actualizarProducto() throws IOException {

		int posicion = ventana.getPanelInv().getTablaInventario().getSelectedRow();
		posicion = ventana.getPanelInv().getTablaInventario().convertRowIndexToModel(posicion);

		int id = ventana.getPanelInv().getPanelDatosPro().validarID();
		String nombre = ventana.getPanelInv().getPanelDatosPro().getNombre().getText();
		String marca = ventana.getPanelInv().getPanelDatosPro().getMarca().getText();
		String descripcion = ventana.getPanelInv().getPanelDatosPro().getDescripcion().getText();
		Categoria categoria = (Categoria) ventana.getPanelInv().getPanelDatosPro().getCtCategoria().getSelectedItem();
		SubCategoria subcategoria = (SubCategoria) ventana.getPanelInv().getPanelDatosPro().getCtSubCategoria()
				.getSelectedItem();
		int cantidad = ventana.getPanelInv().getPanelDatosPro().validarCantidad();
		int precioProveedor = ventana.getPanelInv().getPanelDatosPro().validarPrecioB();
		int precioVenta = ventana.getPanelInv().getPanelDatosPro().validarPrecioV();
		int precioIva = 0;

		int idANT = ventana.getControlador().getListaProductosInventario().get(posicion).getId();
		String nombreANT = ventana.getControlador().getListaProductosInventario().get(posicion).getNombre();
		String marcaANT = ventana.getControlador().getListaProductosInventario().get(posicion).getMarca();
		String descripcionANT = ventana.getControlador().getListaProductosInventario().get(posicion).getDescripcion();
		Categoria categoriaANT = ventana.getControlador().getListaProductosInventario().get(posicion).getCategoria();
		SubCategoria subcategoriaANT = ventana.getControlador().getListaProductosInventario().get(posicion)
				.getSubcategoria();
		int cantidadANT = ventana.getControlador().getListaProductosInventario().get(posicion).getCantidad();
		int precioProveedorANT = ventana.getControlador().getListaProductosInventario().get(posicion)
				.getPrecioProveedor();
		int precioVentaANT = ventana.getControlador().getListaProductosInventario().get(posicion).getPrecioVenta();
		int precioIvaANT = ventana.getControlador().getListaProductosInventario().get(posicion).getPrecioIva();

		switch (categoria) {
		case ALIMENTO:
			precioIva = (precioProveedor * 10) / 100;
			break;
		case ASEO:
			precioIva = (precioProveedor * 16) / 100;
			break;
		case DROGUERIA:
			precioIva = (precioProveedor * 14) / 100;
			break;
		case PAPELERIA:
			precioIva = (precioProveedor * 12) / 100;
			break;
		default:
			break;
		}

		if (verificarCodProExiste(id) == true && !(id == idANT)) {
			JOptionPane.showMessageDialog(null, "Este codigo ya esta siendo usado", "Error",
					JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
		} else {

			if (id == idANT && marca.equals(marcaANT) && nombre.equals(nombreANT) && descripcion.equals(descripcionANT)
					&& categoria.equals(categoriaANT) && subcategoria.equals(subcategoriaANT) && cantidad == cantidadANT
					&& precioProveedor == precioProveedorANT && precioVenta == precioVentaANT
					&& precioIva == precioIvaANT) {
				JOptionPane.showMessageDialog(null, "Debe por lo menos cambiar un dato", "ERROR",
						JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
			}

			else if (JOptionPane.showConfirmDialog(null, "¿Esta seguro de modificar este producto?", "Editar",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
					new ImageIcon("./imagenes/error.png")) == JOptionPane.YES_OPTION) {
				try {
					ventana.getControlador().actualizarProducto(posicion, id, nombre, marca, descripcion, categoria,
							subcategoria, cantidad, precioIva, precioProveedor, precioVenta);

					JOptionPane.showMessageDialog(null, "Producto actualizado correctamente", "Actualizado",
							JOptionPane.DEFAULT_OPTION, new ImageIcon("./imagenes/comprobado.png"));

					actualizarDatosPro();

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		}

	}

	public boolean verificarUExiste(String usuario) {

		boolean existe = false;

		for (int i = 0; i < ventana.getControlador().getListaPerfiles().size(); i++) {

			if (ventana.getControlador().getListaPerfiles().get(i).getUsuario().equals(usuario)) {
				existe = true;
			}

		}
		return existe;
	}

	public boolean verificarCodProExiste(int id) {

		boolean existe = false;

		for (int i = 0; i < ventana.getControlador().getListaProductosInventario().size(); i++) {

			if (ventana.getControlador().getListaProductosInventario().get(i).getId() == id) {
				existe = true;
			}

		}
		return existe;
	}

	public void camposEditar(int posicion) {

		String codigo = String.valueOf(ventana.getControlador().getListaProductosInventario().get(posicion).getId());
		String nombre = ventana.getControlador().getListaProductosInventario().get(posicion).getNombre();
		String marca = ventana.getControlador().getListaProductosInventario().get(posicion).getMarca();
		String descripcion = ventana.getControlador().getListaProductosInventario().get(posicion).getDescripcion();
		String cantidad = String
				.valueOf(ventana.getControlador().getListaProductosInventario().get(posicion).getCantidad());
		Categoria categoria = ventana.getControlador().getListaProductosInventario().get(posicion).getCategoria();
		SubCategoria subcategoria = ventana.getControlador().getListaProductosInventario().get(posicion)
				.getSubcategoria();
		String Pproveedor = String
				.valueOf(ventana.getControlador().getListaProductosInventario().get(posicion).getPrecioProveedor());
		String Pventa = String
				.valueOf(ventana.getControlador().getListaProductosInventario().get(posicion).getPrecioVenta());

		ventana.getPanelInv().getPanelDatosPro().getTitulo().setText("Editar Producto");
		ventana.getPanelInv().getPanelDatosPro().getTitulo().setIcon(new ImageIcon("./imagenes/producto.png"));
		ventana.getPanelInv().getPanelDatosPro().getAccionPro().setText("ACTUALIZAR");

		ventana.getPanelInv().getPanelDatosPro().getCodigo().setText(codigo);
		ventana.getPanelInv().getPanelDatosPro().getNombre().setText(nombre);
		ventana.getPanelInv().getPanelDatosPro().getMarca().setText(marca);
		ventana.getPanelInv().getPanelDatosPro().getDescripcion().setText(descripcion);
		ventana.getPanelInv().getPanelDatosPro().getCantidad().setText(cantidad);
		ventana.getPanelInv().getPanelDatosPro().getCtCategoria().setSelectedItem(categoria);
		ventana.getPanelInv().getPanelDatosPro().getCtSubCategoria().setSelectedItem(subcategoria);
		ventana.getPanelInv().getPanelDatosPro().getPrecioProveedor().setText(Pproveedor);
		ventana.getPanelInv().getPanelDatosPro().getPrecioVenta().setText(Pventa);

	}

	public void actualizarCrearVer() {

		borrarPaneles();
		ventana.add(ventana.getPanelEmple(), BorderLayout.CENTER);
		ventana.getPanelEmple().getPanelVerUsurarios().actualizarJList();
		actualizarVentana();

	}

	public void actualizarDatosPro() {

		borrarPaneles();
		ventana.getPanelInv().actualizarTablaInventario();
		ventana.add(ventana.getPanelInv(), BorderLayout.CENTER);
		actualizarVentana();
		atrasDatosPro = true;
	}

	public void limpiarcamposCrear() {
		ventana.getPanelEmple().getPanelCrearUsuario().getNombre().setText("");
		ventana.getPanelEmple().getPanelCrearUsuario().getApellido().setText("");
		ventana.getPanelEmple().getPanelCrearUsuario().getNumeroDoc().setText("");
		ventana.getPanelEmple().getPanelCrearUsuario().getUsuario().setText("");
		ventana.getPanelEmple().getPanelCrearUsuario().getContraseña().setText("");
		ventana.getPanelEmple().getPanelCrearUsuario().getConfContra().setText("");
	}

	public void limpiarcamposProdutos() {
		ventana.getPanelInv().getPanelDatosPro().getCodigo().setText("");
		ventana.getPanelInv().getPanelDatosPro().getNombre().setText("");
		ventana.getPanelInv().getPanelDatosPro().getDescripcion().setText("");
		ventana.getPanelInv().getPanelDatosPro().getMarca().setText("");
		ventana.getPanelInv().getPanelDatosPro().getCantidad().setText("");
		ventana.getPanelInv().getPanelDatosPro().getPrecioProveedor().setText("");
		ventana.getPanelInv().getPanelDatosPro().getPrecioVenta().setText("");

	}

	public void limpiarcamposVer() {
		ventana.getPanelEmple().getPanelVerUsurarios().getNombre().setText("");
		ventana.getPanelEmple().getPanelVerUsurarios().getApellido().setText("");
		ventana.getPanelEmple().getPanelVerUsurarios().getNumeroDoc().setText("");
		ventana.getPanelEmple().getPanelVerUsurarios().getUsuario().setText("");
		ventana.getPanelEmple().getPanelVerUsurarios().getContraseña().setText("");
		ventana.getPanelEmple().getPanelVerUsurarios().getTipo().setText("");
		ventana.getPanelEmple().getPanelVerUsurarios().getCtDoc().setSelectedIndex(0);
	}

	public void borrarPaneles() {
		ventana.remove(ventana.getPanelInicial());
		ventana.remove(ventana.getPanelResumen());
		ventana.remove(ventana.getPanelEmple());
		ventana.remove(ventana.getPanelEmple().getPanelCrearUsuario());
		ventana.remove(ventana.getPanelEmple().getPanelVerUsurarios());
		ventana.remove(ventana.getPanelInv());
		ventana.remove(ventana.getPanelInv().getPanelDatosPro());
	}

	public void actualizarVentana() {
		ventana.revalidate();
		ventana.repaint();
	}

}
