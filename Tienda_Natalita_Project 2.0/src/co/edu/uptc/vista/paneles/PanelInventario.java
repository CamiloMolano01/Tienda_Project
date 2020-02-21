package co.edu.uptc.vista.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import co.edu.uptc.vista.VentanaPrincipal;

public class PanelInventario extends JPanel {

	private VentanaPrincipal ventana;
	// ------------------------//
	// ------------------------//

	private Font letraGoogle;

	private JTable tablaInventario;
	private DefaultTableModel modeloTablaInventario;
	private JScrollPane scrollpane;

	private JPanel panelBotones;

	private JLabel cantidadComprar;
	private JButton botonPagar;
	private JButton botonEliminar;
	private JButton botonEditar;
	private JButton botonAgregar;

	private PanelDatosProducto panelDatosPro;

	public PanelInventario(VentanaPrincipal ventana) {
		Inicializador(ventana);
	}

	public void Inicializador(VentanaPrincipal ventana) {
		this.ventana = ventana;
		setLayout(new FlowLayout());
		setBackground(Color.WHITE);

		panelDatosPro = new PanelDatosProducto(ventana);

		letraGoogle = new Font("Open Sans", Font.BOLD, 15);

		panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
		panelBotones.setBackground(Color.WHITE);

		modeloTablaInventario = new DefaultTableModel(new Object[][] {}, new String[] { "Codigo", "Nombre", "Marca",
				"Descripcion", "Categoria", "SubCategoria", "Cantidad", "P. proveedor", "IVA", "P. venta" });
		tablaInventario = new JTable(modeloTablaInventario);
		// tablaInventario.setEnabled(false);
		tablaInventario.setDefaultEditor(Object.class, null);

		TableColumnModel columnModel = tablaInventario.getColumnModel();
		columnModel.getColumn(0).setMinWidth(50);
		columnModel.getColumn(0).setMaxWidth(50);
		columnModel.getColumn(1).setMinWidth(70);
		columnModel.getColumn(1).setMaxWidth(70);
		columnModel.getColumn(3).setMinWidth(120);
		columnModel.getColumn(3).setMaxWidth(120);
		columnModel.getColumn(6).setMinWidth(65);
		columnModel.getColumn(6).setMaxWidth(65);
		columnModel.getColumn(8).setMinWidth(60);
		columnModel.getColumn(8).setMaxWidth(60);

		// Instanciamos el TableRowSorter y lo añadimos al JTable
		tablaInventario.setAutoCreateRowSorter(true);

		scrollpane = new JScrollPane();
		scrollpane.setViewportView(tablaInventario);
		scrollpane.setPreferredSize(new Dimension(800, 570));

		cantidadComprar = new JLabel("$$");
		cantidadComprar.setOpaque(true);
		cantidadComprar.setFont(letraGoogle);
		cantidadComprar.setPreferredSize(new Dimension(70, 40));

		botonPagar = new JButton();
		botonPagar.setIcon(new ImageIcon("./imagenes/dolar.png"));
		botonPagar.setPreferredSize(new Dimension(40, 40));
		botonPagar.setBackground(Color.WHITE);
		botonPagar.addMouseListener(ventana.getBotonListener());
		botonPagar.setActionCommand("botonPagar");
		botonPagar.addActionListener(ventana.getEventos());
		botonPagar.setFocusPainted(false);
		botonPagar.setBorderPainted(false);
		botonPagar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		botonEliminar = new JButton();
		botonEliminar.setIcon(new ImageIcon("./imagenes/eliminar.png"));
		botonEliminar.setAlignmentX(CENTER_ALIGNMENT);
		botonEliminar.setBackground(ventana.getColorBase());
		botonEliminar.addMouseListener(ventana.getBotonListener());
		botonEliminar.setActionCommand("eliminarPro");
		botonEliminar.addActionListener(ventana.getEventos());
		botonEliminar.setFocusPainted(false);
		botonEliminar.setBorderPainted(false);
		botonEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		botonEditar = new JButton();
		botonEditar.setIcon(new ImageIcon("./imagenes/editar.png"));
		botonEditar.setAlignmentX(CENTER_ALIGNMENT);
		botonEditar.setBackground(ventana.getColorBase());
		botonEditar.addMouseListener(ventana.getBotonListener());
		botonEditar.setActionCommand("editarPro");
		botonEditar.addActionListener(ventana.getEventos());
		botonEditar.setFocusPainted(false);
		botonEditar.setBorderPainted(false);
		botonEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		botonAgregar = new JButton("");
		botonAgregar.setIcon(new ImageIcon("./imagenes/nuevo.png"));
		botonAgregar.setAlignmentX(CENTER_ALIGNMENT);
		botonAgregar.setBackground(ventana.getColorBase());
		botonAgregar.addMouseListener(ventana.getBotonListener());
		botonAgregar.setActionCommand("agregarPro");
		botonAgregar.addActionListener(ventana.getEventos());
		botonAgregar.setFocusPainted(false);
		botonAgregar.setBorderPainted(false);
		botonAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// panelBotones.add(panelCompra);
		panelBotones.add(Box.createRigidArea(new Dimension(0, 40)));
		panelBotones.add(botonEliminar);
		panelBotones.add(Box.createRigidArea(new Dimension(0, 20)));
		panelBotones.add(botonEditar);
		panelBotones.add(Box.createRigidArea(new Dimension(0, 20)));
		panelBotones.add(botonAgregar);
		// System.out.println(scrollpane.getPreferredSize());
		// add(Box.createRigidArea(new Dimension(-50, 0)));
		add(scrollpane);
		add(Box.createRigidArea(new Dimension(20, 0)));
		add(panelBotones);
	}

	public void actualizarTablaInventario() {

		DefaultTableModel modeloTablaInv = new DefaultTableModel(

				ventana.getControlador().aniadirEnTablaInventario(), new String[] { "Codigo", "Nombre", "Marca",
						"Descripcion", "Categoria", "SubCategoria", "Cantidad", "P. proveedor", "IVA", "P. venta" }

		);

		// TableRowSorter<TableModel> elQueOrdena = new
		// TableRowSorter<TableModel>(modeloTablaInv);
		tablaInventario.setAutoCreateRowSorter(true);

		tablaInventario.setModel(modeloTablaInv);

		TableColumnModel columnModel = tablaInventario.getColumnModel();

		columnModel.getColumn(0).setMinWidth(50);
		columnModel.getColumn(0).setMaxWidth(50);
		columnModel.getColumn(1).setMinWidth(70);
		columnModel.getColumn(1).setMaxWidth(70);
		columnModel.getColumn(3).setMinWidth(120);
		columnModel.getColumn(3).setMaxWidth(120);
		columnModel.getColumn(6).setMinWidth(65);
		columnModel.getColumn(6).setMaxWidth(65);
		columnModel.getColumn(8).setMinWidth(60);
		columnModel.getColumn(8).setMaxWidth(60);

	}

	public VentanaPrincipal getVentana() {
		return ventana;
	}

	public void setVentana(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	public Font getLetraGoogle() {
		return letraGoogle;
	}

	public void setLetraGoogle(Font letraGoogle) {
		this.letraGoogle = letraGoogle;
	}

	public JTable getTablaInventario() {
		return tablaInventario;
	}

	public void setTablaInventario(JTable tablaInventario) {
		this.tablaInventario = tablaInventario;
	}

	public DefaultTableModel getModeloTablaInventario() {
		return modeloTablaInventario;
	}

	public void setModeloTablaInventario(DefaultTableModel modeloTablaInventario) {
		this.modeloTablaInventario = modeloTablaInventario;
	}

	public JScrollPane getScrollpane() {
		return scrollpane;
	}

	public void setScrollpane(JScrollPane scrollpane) {
		this.scrollpane = scrollpane;
	}

	public JPanel getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(JPanel panelBotones) {
		this.panelBotones = panelBotones;
	}

	public JLabel getCantidadComprar() {
		return cantidadComprar;
	}

	public void setCantidadComprar(JLabel cantidadComprar) {
		this.cantidadComprar = cantidadComprar;
	}

	public JButton getBotonPagar() {
		return botonPagar;
	}

	public void setBotonPagar(JButton botonPagar) {
		this.botonPagar = botonPagar;
	}

	public JButton getBotonEliminar() {
		return botonEliminar;
	}

	public void setBotonEliminar(JButton botonEliminar) {
		this.botonEliminar = botonEliminar;
	}

	public JButton getBotonEditar() {
		return botonEditar;
	}

	public void setBotonEditar(JButton botonEditar) {
		this.botonEditar = botonEditar;
	}

	public JButton getBotonAgregar() {
		return botonAgregar;
	}

	public void setBotonAgregar(JButton botonAgregar) {
		this.botonAgregar = botonAgregar;
	}

	public PanelDatosProducto getPanelDatosPro() {
		return panelDatosPro;
	}

	public void setPanelDatosPro(PanelDatosProducto panelDatosPro) {
		this.panelDatosPro = panelDatosPro;
	}

}
