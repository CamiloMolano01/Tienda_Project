package co.edu.uptc.vista.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import co.edu.uptc.vista.VentanaPrincipal;

public class PanelResumen extends JPanel {

	private VentanaPrincipal ventana;

	private JButton mas;
	private JScrollPane scrollpane;
	private JPanel panelFacturas;
	private JPanel opciones;
	private JPanel panelEspacio;
	private JButton actualizar;
	
	private JComboBox<String> combo;

	public PanelResumen(VentanaPrincipal ventana) {
		inicializador(ventana);
	}

	public void inicializador(VentanaPrincipal ventana) {
		this.ventana = ventana;
		setLayout(new FlowLayout());
		setBackground(Color.white);
		
		opciones = new JPanel();
		opciones.setLayout(new BoxLayout(opciones, BoxLayout.Y_AXIS));
		opciones.setPreferredSize(new Dimension(200, 300));
		opciones.setBackground(Color.WHITE);

		panelEspacio = new JPanel();
		panelEspacio.setLayout(new BoxLayout(panelEspacio, BoxLayout.Y_AXIS));

		combo = new JComboBox<>();
		combo.addItem("Facturas Hoy");
		combo.addItem("Facturas Mes");
		combo.addItem("Facturas Año");
		combo.setPreferredSize(new Dimension(120, 40));
		combo.setMaximumSize(new Dimension(120, 40));
		combo.setAlignmentX(CENTER_ALIGNMENT);
		
		actualizar = new JButton();
		actualizar.setIcon(new ImageIcon("./imagenes/actualizar.png"));
		actualizar.setActionCommand("actF");
		actualizar.addActionListener(ventana.getEventos());
		actualizar.addMouseListener(ventana.getBotonListener());
		actualizar.setFocusPainted(false);
		actualizar.setBackground(ventana.getColorBase());
		actualizar.setBorderPainted(false);
		actualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		actualizar.setAlignmentX(CENTER_ALIGNMENT);
		actualizar.setPreferredSize(new Dimension(64,64));
		actualizar.setMaximumSize(new Dimension(64,64));
		
		opciones.add(Box.createRigidArea(new Dimension(0, 140)));
		opciones.add(combo);
		opciones.add(Box.createRigidArea(new Dimension(0, 10)));
		opciones.add(actualizar);

		panelFacturas = new JPanel();
		panelFacturas.setLayout(new FlowLayout());

		scrollpane = new JScrollPane();
		scrollpane.setViewportView(panelFacturas);
		scrollpane.setPreferredSize(new Dimension(750, 270));

		panelEspacio.add(Box.createRigidArea(new Dimension(0, 140)));
		panelEspacio.add(scrollpane);
		panelEspacio.setBackground(Color.WHITE);

		add(opciones);
		add(panelEspacio);
	}

	public VentanaPrincipal getVentana() {
		return ventana;
	}

	public void setVentana(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	public JPanel getPanelEspacio() {
		return panelEspacio;
	}

	public void setPanelEspacio(JPanel panelEspacio) {
		this.panelEspacio = panelEspacio;
	}

	public JComboBox<String> getCombo() {
		return combo;
	}

	public void setCombo(JComboBox<String> combo) {
		this.combo = combo;
	}

	public JButton getMas() {
		return mas;
	}

	public void setMas(JButton mas) {
		this.mas = mas;
	}

	public JScrollPane getScrollpane() {
		return scrollpane;
	}

	public void setScrollpane(JScrollPane scrollpane) {
		this.scrollpane = scrollpane;
	}

	public JPanel getPanelFacturas() {
		return panelFacturas;
	}

	public void setPanelFacturas(JPanel panelFacturas) {
		this.panelFacturas = panelFacturas;
	}

	public JPanel getOpciones() {
		return opciones;
	}

	public void setOpciones(JPanel opciones) {
		this.opciones = opciones;
	}

}
