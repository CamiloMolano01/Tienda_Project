package co.edu.uptc.vista.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import com.mxrck.autocompleter.tests.Person;

import co.edu.uptc.modelo.Producto;
import co.edu.uptc.modelo.ProductoVenta;
import co.edu.uptc.vista.VentanaPrincipal;

public class PanelInicial extends JPanel {

	private VentanaPrincipal ventana;
	private Font letraGoogle;
	private JPanel flowMASMENOS;

	private JTextField textBuscar;
	private JLabel busqueda;

	private JPanel panelTabla;
	private JPanel panelDerecha;
	private JPanel panelBusqueda;

	private JLabel precio;

	private JTable tablaVenta;
	private DefaultTableModel modeloTablaVenta;
	private JScrollPane scrollpane;
	private JScrollPane scrollBusqueda;

	private JButton calculadora;
	private JButton pagar;
	private JButton botonMas;
	private JButton botonMenos;
	private JTextArea infoPro;
	private TextAutoCompleter textAutoCompleter;

	public PanelInicial(VentanaPrincipal ventana) {
		inicializador(ventana);
	}

	public void inicializador(VentanaPrincipal ventana) {
		this.ventana = ventana;
		setLayout(new FlowLayout());
		setBackground(Color.WHITE);
		letraGoogle = new Font("Open Sans", Font.BOLD, 14);

		panelTabla = new JPanel();
		panelTabla.setLayout(new BoxLayout(panelTabla, BoxLayout.Y_AXIS));

		flowMASMENOS = new JPanel();
		flowMASMENOS.setLayout(new FlowLayout());

		panelDerecha = new JPanel();
		panelDerecha.setLayout(new BoxLayout(panelDerecha, BoxLayout.Y_AXIS));

		panelBusqueda = new JPanel();
		panelBusqueda.setLayout(new FlowLayout());

		busqueda = new JLabel("Buscar producto: ");
		textBuscar = new JTextField();
		textBuscar.setPreferredSize(new Dimension(120, 30));
		textBuscar.addMouseListener(ventana.getBotonListener());

		botonMas = new JButton("+1");
		botonMas.setIcon(new ImageIcon("./imagenes/botonAgrega.png"));
		botonMas.setEnabled(false);
		botonMas.setActionCommand("mas");
		botonMas.addActionListener(ventana.getEventos());

		botonMenos = new JButton("-1");
		botonMenos.setIcon(new ImageIcon("./imagenes/botonResta.png"));
		botonMenos.setEnabled(false);
		botonMenos.setActionCommand("menos");
		botonMenos.addActionListener(ventana.getEventos());

		infoPro = new JTextArea();
		infoPro.setRows(6);
		infoPro.setFont(letraGoogle);
		infoPro.setEditable(false);
		infoPro.setPreferredSize(new Dimension(265, 120));
		// infoPro.setText(t);

		precio = new JLabel("TOTAL: " + total());
		precio.setFont(letraGoogle);
		precio.setForeground(Color.red);
		//precio.setBackground(Color.blue);
		precio.setPreferredSize(new Dimension(50, 30));
		precio.setHorizontalAlignment(JLabel.CENTER);
		precio.setAlignmentX(CENTER_ALIGNMENT);

		textAutoCompleter = new TextAutoCompleter(textBuscar, new AutoCompleterCallback() {
			@Override
			public void callback(Object selectedItem) {
				Producto pro = (Producto) selectedItem;
				if (pro.getCantidad() > 0) {
					infoPro.setText("");

					if (estaEnLista(pro) == false) {
						ventana.getControlador().getListaProductosVenta()
								.add(new ProductoVenta(pro, 1, pro.getPrecioVenta()));
					}
					
					infoPro.setText(llenarText(pro));
					actualizarTablaVenta();
					int posicion = posicionLista(pro);
					tablaVenta.getSelectionModel().setSelectionInterval(posicion, posicion);
					botonMenos.setEnabled(true);
					botonMas.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "No hay unidades disponibles para este producto",
							"Sin unidades", JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
					actualizarTablaVenta();
				}
				
			}
		});
		textAutoCompleter.setMode(0);

		calculadora = new JButton("Calculadora");
		calculadora.setActionCommand("calculadora");
		calculadora.addActionListener(ventana.getEventos());
		calculadora.setPreferredSize(new Dimension(120, 50));
		calculadora.setIcon(new ImageIcon("./imagenes/calculadora.png"));
		calculadora.setHorizontalAlignment(JButton.CENTER);
		calculadora.setAlignmentX(CENTER_ALIGNMENT);
		calculadora.setFocusPainted(false);
		calculadora.setBackground(ventana.getColorBase());
		calculadora.setBorderPainted(false);
		calculadora.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		pagar = new JButton("PAGAR");
		pagar.setActionCommand("pagar");
		pagar.addActionListener(ventana.getEventos());
		pagar.setPreferredSize(new Dimension(80, 80));
		pagar.setIcon(new ImageIcon("./imagenes/bolsa.png"));
		pagar.setHorizontalAlignment(JButton.CENTER);
		pagar.setAlignmentX(CENTER_ALIGNMENT);
		pagar.setFocusPainted(false);
		pagar.setBackground(ventana.getColorBase());
		//pagar.setBorderPainted(false);
		pagar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//pagar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		//pagar.setBorder(new RoundedBorder(40)); 

		modeloTablaVenta = new DefaultTableModel(new Object[][] {},
				new String[] { "id", "nombre", "cantidad", "precio", "IVA", "total" });
		tablaVenta = new JTable(modeloTablaVenta);
		//tablaVenta.setEd
		tablaVenta.setDefaultEditor(Object.class, null);
		tablaVenta.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tablaMouseClicked(evt);
			}
		});
		// tablaVenta.setAutoCreateRowSorter(true);
		scrollpane = new JScrollPane();
		scrollpane.setViewportView(tablaVenta);
		scrollpane.setPreferredSize(new Dimension(600, 500));

		scrollBusqueda = new JScrollPane();
		scrollBusqueda.setViewportView(infoPro);
		scrollBusqueda.setPreferredSize(new Dimension(270, 130));

		panelTabla.add(Box.createRigidArea(new Dimension(0, 20)));
		panelTabla.add(scrollpane);
		panelTabla.add(precio);
		panelTabla.setBackground(Color.WHITE);

		panelBusqueda.add(busqueda);
		panelBusqueda.add(textBuscar);
		flowMASMENOS.add(botonMas);
		flowMASMENOS.add(botonMenos);

		panelDerecha.add(panelBusqueda);
		panelDerecha.add(scrollBusqueda);
		panelDerecha.add(flowMASMENOS);
		panelDerecha.add(Box.createRigidArea(new Dimension(0, 20)));
		panelDerecha.add(calculadora);
		panelDerecha.add(Box.createRigidArea(new Dimension(0, 15)));
		panelDerecha.add(pagar);
		panelDerecha.setBackground(Color.WHITE);

		add(panelTabla);
		add(panelDerecha);
	}

	public void actualizarTablaVenta() {
		tablaVenta.setModel(new DefaultTableModel(ventana.getControlador().aniadirEnTablaVenta(),
				new String[] { "id", "nombre", "cantidad", "precio", "IVA", "total" }));
		precio.setText("TOTAL: " + total());
	}

	public String llenarText(Producto pro) {
		String cadenaInformativa = "";
		cadenaInformativa += "               EN INVENTARIO" + "\n";
		cadenaInformativa += "   ID:                    " + pro.getId() + "\n";
		cadenaInformativa += "   NOMBRE:          " + pro.getNombre() + "\n";
		cadenaInformativa += "   MARCA:             " + pro.getMarca() + "\n";
		cadenaInformativa += "   CANTIDAD:         " + pro.getCantidad() + "\n";
		cadenaInformativa += "   PRECIO:             " + pro.getPrecioVenta();
		return cadenaInformativa;
	}

	private void tablaMouseClicked(java.awt.event.MouseEvent evt) {

		if (evt.getButton() == 1) {
			int fila = tablaVenta.getSelectedRow();
			textBuscar.setText("");
			botonMas.setEnabled(true);
			botonMenos.setEnabled(true);
			infoPro.setText(llenarText(ventana.getControlador().getListaProductosVenta().get(fila).getProducto()));
		}

	}

	public void agregarCompletar() {
		textAutoCompleter.removeAllItems();
		for (int i = 0; i < ventana.getControlador().getListaProductosInventario().size(); i++) {
			textAutoCompleter.addItem(ventana.getControlador().getListaProductosInventario().get(i));
		}
	}

	public boolean estaEnLista(Producto pro) {
		for (int j = 0; j < ventana.getControlador().getListaProductosVenta().size(); j++) {
			if (ventana.getControlador().getListaProductosVenta().get(j).getProducto().getId() == pro.getId()) {
				return true;
			}

		}
		return false;
	}
	
	public int total() {
		int numero = 0;
		for (int i = 0; i < ventana.getControlador().getListaProductosVenta().size(); i++) {
			numero += ventana.getControlador().getListaProductosVenta().get(i).getPrecioCantidad();
		}
		return numero;
	}
	
	public int posicionLista(Producto pro) {
		int numero = 0;
		for (int j = 0; j < ventana.getControlador().getListaProductosVenta().size(); j++) {
			if (ventana.getControlador().getListaProductosVenta().get(j).getProducto().getId() == pro.getId()) {
				numero = j;
			}

		}
		return numero;
	}
	

	public VentanaPrincipal getVentana() {
		return ventana;
	}

	public void setVentana(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	public JTextArea getInfoPro() {
		return infoPro;
	}

	public void setInfoPro(JTextArea infoPro) {
		this.infoPro = infoPro;
	}

	public Font getLetraGoogle() {
		return letraGoogle;
	}

	public void setLetraGoogle(Font letraGoogle) {
		this.letraGoogle = letraGoogle;
	}

	public JTextField getTextBuscar() {
		return textBuscar;
	}

	public void setTextBuscar(JTextField textBuscar) {
		this.textBuscar = textBuscar;
	}

	public JLabel getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(JLabel busqueda) {
		this.busqueda = busqueda;
	}

	public JPanel getPanelTabla() {
		return panelTabla;
	}

	public void setPanelTabla(JPanel panelTabla) {
		this.panelTabla = panelTabla;
	}

	public JPanel getPanelDerecha() {
		return panelDerecha;
	}

	public void setPanelDerecha(JPanel panelDerecha) {
		this.panelDerecha = panelDerecha;
	}

	public JPanel getPanelBusqueda() {
		return panelBusqueda;
	}

	public void setPanelBusqueda(JPanel panelBusqueda) {
		this.panelBusqueda = panelBusqueda;
	}

	public JLabel getPrecio() {
		return precio;
	}

	public void setPrecio(JLabel precio) {
		this.precio = precio;
	}

	public JTable getTablaVenta() {
		return tablaVenta;
	}

	public void setTablaVenta(JTable tablaVenta) {
		this.tablaVenta = tablaVenta;
	}

	public DefaultTableModel getModeloTablaVenta() {
		return modeloTablaVenta;
	}

	public void setModeloTablaVenta(DefaultTableModel modeloTablaVenta) {
		this.modeloTablaVenta = modeloTablaVenta;
	}

	public JScrollPane getScrollpane() {
		return scrollpane;
	}

	public void setScrollpane(JScrollPane scrollpane) {
		this.scrollpane = scrollpane;
	}

	public JScrollPane getScrollBusqueda() {
		return scrollBusqueda;
	}

	public void setScrollBusqueda(JScrollPane scrollBusqueda) {
		this.scrollBusqueda = scrollBusqueda;
	}

	public JButton getCalculadora() {
		return calculadora;
	}

	public void setCalculadora(JButton calculadora) {
		this.calculadora = calculadora;
	}

	public JButton getPagar() {
		return pagar;
	}

	public void setPagar(JButton pagar) {
		this.pagar = pagar;
	}

	public TextAutoCompleter getTextAutoCompleter() {
		return textAutoCompleter;
	}

	public void setTextAutoCompleter(TextAutoCompleter textAutoCompleter) {
		this.textAutoCompleter = textAutoCompleter;
	}

	public JPanel getFlowMASMENOS() {
		return flowMASMENOS;
	}

	public void setFlowMASMENOS(JPanel flowMASMENOS) {
		this.flowMASMENOS = flowMASMENOS;
	}

	public JButton getBotonMas() {
		return botonMas;
	}

	public void setBotonMas(JButton botonMas) {
		this.botonMas = botonMas;
	}

	public JButton getBotonMenos() {
		return botonMenos;
	}

	public void setBotonMenos(JButton botonMenos) {
		this.botonMenos = botonMenos;
	}

}
