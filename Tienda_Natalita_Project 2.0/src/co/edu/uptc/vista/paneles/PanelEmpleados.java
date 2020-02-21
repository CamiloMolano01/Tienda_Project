package co.edu.uptc.vista.paneles;

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

import co.edu.uptc.vista.VentanaPrincipal;

public class PanelEmpleados extends JPanel {

	private VentanaPrincipal ventana;

	private JButton botonCrearPerfil;
	private JButton botonVerPerfiles;

	private JPanel panelElegir;
	private JPanel panelNombres;
	private PanelCrearUsuario panelCrearUsuario;
	private PanelVerUsuarios panelVerUsurarios;

	private JLabel ver;
	private JLabel crear;

	private Font letraGoogle;

	public PanelEmpleados(VentanaPrincipal ventana) {
		inicializador(ventana);
	}

	public void inicializador(VentanaPrincipal ventana) {
		this.ventana = ventana;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.white);

		letraGoogle = new Font("Open Sans", Font.BOLD, 15);

		panelCrearUsuario = new PanelCrearUsuario(ventana);
		panelVerUsurarios = new PanelVerUsuarios(ventana);

		panelElegir = new JPanel();
		panelElegir.setLayout(new FlowLayout());
		panelElegir.setBackground(Color.white);
		panelElegir.setMaximumSize(new Dimension(700, 250));

		panelNombres = new JPanel();
		panelNombres.setLayout(new FlowLayout());
		panelNombres.setBackground(Color.WHITE);

		botonCrearPerfil = new JButton();
		botonCrearPerfil.setPreferredSize(new Dimension(250, 250));
		botonCrearPerfil.setIcon(new ImageIcon("./imagenes/agregarUsuario.png"));
		botonCrearPerfil.setBackground(ventana.getColorBase());
		botonCrearPerfil.setActionCommand("crearUsuario");
		botonCrearPerfil.addActionListener(ventana.getEventos());
		botonCrearPerfil.addMouseListener(ventana.getBotonListener());
		botonCrearPerfil.setFocusPainted(false);
		botonCrearPerfil.setBorderPainted(false);
		botonCrearPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		botonVerPerfiles = new JButton();
		botonVerPerfiles.setPreferredSize(new Dimension(250, 250));
		botonVerPerfiles.setIcon(new ImageIcon("./imagenes/usuarios.png"));
		botonVerPerfiles.setBackground(ventana.getColorBase());
		botonVerPerfiles.addMouseListener(ventana.getBotonListener());
		botonVerPerfiles.setActionCommand("verUsuarios");
		botonVerPerfiles.addActionListener(ventana.getEventos());
		botonVerPerfiles.setFocusPainted(false);
		botonVerPerfiles.setBorderPainted(false);
		botonVerPerfiles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		ver = new JLabel("Ver usuarios");
		ver.setFont(letraGoogle);

		crear = new JLabel("Crear usuario");
		crear.setFont(letraGoogle);

		panelNombres.add(ver);
		panelNombres.add(Box.createRigidArea(new Dimension(320, 0)));
		panelNombres.add(crear);

		panelElegir.add(botonVerPerfiles);
		panelElegir.add(Box.createRigidArea(new Dimension(150, 0)));
		panelElegir.add(botonCrearPerfil);

		add(Box.createRigidArea(new Dimension(0, 130)));
		add(panelElegir);
		// add(Box.createRigidArea(new Dimension(0, -10)));
		add(panelNombres);
	}

	public VentanaPrincipal getVentana() {
		return ventana;
	}

	public void setVentana(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	public PanelVerUsuarios getPanelVerUsurarios() {
		return panelVerUsurarios;
	}

	public void setPanelVerUsurarios(PanelVerUsuarios panelVerUsurarios) {
		this.panelVerUsurarios = panelVerUsurarios;
	}

	public JButton getBotonCrearPerfil() {
		return botonCrearPerfil;
	}

	public void setBotonCrearPerfil(JButton botonCrearPerfil) {
		this.botonCrearPerfil = botonCrearPerfil;
	}

	public JButton getBotonVerPerfiles() {
		return botonVerPerfiles;
	}

	public void setBotonVerPerfiles(JButton botonVerPerfiles) {
		this.botonVerPerfiles = botonVerPerfiles;
	}

	public JPanel getPanelElegir() {
		return panelElegir;
	}

	public void setPanelElegir(JPanel panelElegir) {
		this.panelElegir = panelElegir;
	}

	public JPanel getPanelNombres() {
		return panelNombres;
	}

	public void setPanelNombres(JPanel panelNombres) {
		this.panelNombres = panelNombres;
	}

	public PanelCrearUsuario getPanelCrearUsuario() {
		return panelCrearUsuario;
	}

	public void setPanelCrearUsuario(PanelCrearUsuario panelCrearUsuario) {
		this.panelCrearUsuario = panelCrearUsuario;
	}

	public JLabel getVer() {
		return ver;
	}

	public void setVer(JLabel ver) {
		this.ver = ver;
	}

	public JLabel getCrear() {
		return crear;
	}

	public void setCrear(JLabel crear) {
		this.crear = crear;
	}

	public Font getLetraGoogle() {
		return letraGoogle;
	}

	public void setLetraGoogle(Font letraGoogle) {
		this.letraGoogle = letraGoogle;
	}

}
