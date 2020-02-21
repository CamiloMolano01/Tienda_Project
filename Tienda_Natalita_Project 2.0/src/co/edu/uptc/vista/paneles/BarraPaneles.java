package co.edu.uptc.vista.paneles;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.vista.VentanaPrincipal;

public class BarraPaneles extends JPanel {

	private VentanaPrincipal ventana;

	private JButton inicio;
	private JButton resumen;
	private JButton inventario;
	private JButton empleados;

	private JLabel imagenTipo;
	private ImageIcon ITipo;
	private JButton cambiarUsuario;
	private ImageIcon Icambio;

	public BarraPaneles(VentanaPrincipal ventana) {
		inicializador(ventana);
	}

	public void inicializador(VentanaPrincipal ventana) {
		this.ventana = ventana;
		setLayout(new FlowLayout());
		setBackground(ventana.getColorBase());

		inicio = new JButton("INICIO");
		inicio.setPreferredSize(new Dimension(150, 40));
		inicio.setBackground(Color.WHITE);
		inicio.setForeground(ventana.getColorBase());
		inicio.addMouseListener(ventana.getBotonListener());
		inicio.setActionCommand("inicio");
		inicio.addActionListener(ventana.getEventos());
		inicio.setFocusPainted(false);
		inicio.setBorderPainted(false);
		inicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		resumen = new JButton("RESUMEN");
		resumen.setPreferredSize(new Dimension(150, 40));
		resumen.setBackground(new Color(238, 237, 241));
		resumen.setForeground(new Color(100, 100, 100));
		resumen.addMouseListener(ventana.getBotonListener());
		resumen.setActionCommand("resumen");
		resumen.addActionListener(ventana.getEventos());
		resumen.setFocusPainted(false);
		resumen.setBorderPainted(false);
		resumen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		inventario = new JButton("INVENTARIO");
		inventario.setPreferredSize(new Dimension(150, 40));
		inventario.setBackground(new Color(238, 237, 241));
		inventario.setForeground(new Color(100, 100, 100));
		inventario.addMouseListener(ventana.getBotonListener());
		inventario.setActionCommand("inventario");
		inventario.addActionListener(ventana.getEventos());
		inventario.setFocusPainted(false);
		inventario.setBorderPainted(false);
		inventario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		empleados = new JButton("EMPLEADOS");
		empleados.setPreferredSize(new Dimension(150, 40));
		empleados.setBackground(new Color(238, 237, 241));
		empleados.setForeground(new Color(100, 100, 100));
		// empleados.addMouseListener(ventana.getBotonListener());
		empleados.setActionCommand("empleados");
		empleados.addActionListener(ventana.getEventos());
		empleados.setFocusPainted(false);
		empleados.setBorderPainted(false);
		empleados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		imagenTipo = new JLabel();

		cambiarUsuario = new JButton();
		cambiarUsuario.setPreferredSize(new Dimension(60, 50));
		cambiarUsuario.setBackground(ventana.getColorBase());
		cambiarUsuario.setActionCommand("cambio");
		cambiarUsuario.addActionListener(ventana.getEventos());
		cambiarUsuario.addMouseListener(ventana.getBotonListener());
		cambiarUsuario.setFocusPainted(false);
		cambiarUsuario.setBorderPainted(false);
		cambiarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		Icambio = new ImageIcon("./imagenes/cambioUsuario.png");
		cambiarUsuario.setIcon(Icambio);

		add(imagenTipo);
		add(Box.createRigidArea(new Dimension(100, 0)));
		add(inicio);
		add(resumen);
		add(inventario);
		add(empleados);
		add(Box.createRigidArea(new Dimension(90, 0)));
		add(cambiarUsuario);

	}

	public VentanaPrincipal getVentana() {
		return ventana;
	}

	public void setVentana(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	public JLabel getImagenTipo() {
		return imagenTipo;
	}

	public void setImagenTipo(JLabel imagenTipo) {
		this.imagenTipo = imagenTipo;
	}

	public ImageIcon getITipo() {
		return ITipo;
	}

	public void setITipo(ImageIcon iTipo) {
		ITipo = iTipo;
	}

	public JButton getCambiarUsuario() {
		return cambiarUsuario;
	}

	public void setCambiarUsuario(JButton cambiarUsuario) {
		this.cambiarUsuario = cambiarUsuario;
	}

	public ImageIcon getIcambio() {
		return Icambio;
	}

	public void setIcambio(ImageIcon icambio) {
		Icambio = icambio;
	}

	public JButton getInicio() {
		return inicio;
	}

	public void setInicio(JButton inicio) {
		this.inicio = inicio;
	}

	public JButton getResumen() {
		return resumen;
	}

	public void setResumen(JButton resumen) {
		this.resumen = resumen;
	}

	public JButton getInventario() {
		return inventario;
	}

	public void setInventario(JButton inventario) {
		this.inventario = inventario;
	}

	public JButton getEmpleados() {
		return empleados;
	}

	public void setEmpleados(JButton empleados) {
		this.empleados = empleados;
	}

}
