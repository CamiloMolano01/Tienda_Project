package co.edu.uptc.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;

import co.edu.uptc.controlador.Controlador;
import co.edu.uptc.vista.eventos.BotonListener;
import co.edu.uptc.vista.eventos.Eventos;
import co.edu.uptc.vista.paneles.BarraPaneles;
import co.edu.uptc.vista.paneles.Calculadora;
import co.edu.uptc.vista.paneles.PanelEmpleados;
import co.edu.uptc.vista.paneles.PanelInferior;
import co.edu.uptc.vista.paneles.PanelInicial;
import co.edu.uptc.vista.paneles.PanelInventario;
import co.edu.uptc.vista.paneles.PanelResumen;

public class VentanaPrincipal extends JFrame {

	private Controlador controlador;
	private JOptionPaneConTimeOut joptiontime;

	private ImageIcon img;
	private PanelInferior panelInferior;
	private BarraPaneles barraPaneles;
	private Calculadora calculadora;
	private BotonListener botonListener;
	private Eventos eventos;

	private PanelInicial panelInicial;
	private PanelResumen panelResumen;
	private PanelEmpleados panelEmple;
	private PanelInventario panelInv;
	private Color colorBase;

	public VentanaPrincipal() {
		inicializador();
	}

	public void inicializador() {

		joptiontime = new JOptionPaneConTimeOut();
		controlador = new Controlador();
		eventos = new Eventos(this);

		colorBase = new Color(0, 77, 77);

		botonListener = new BotonListener(this);
		panelInferior = new PanelInferior(this);
		barraPaneles = new BarraPaneles(this);
		panelInicial = new PanelInicial(this);
		panelResumen = new PanelResumen(this);
		panelEmple = new PanelEmpleados(this);
		panelInv = new PanelInventario(this);
		calculadora = new Calculadora();

		setTitle("TNP 2.0");
		img = new ImageIcon("./imagenes/tiendacolor.png");
		setIconImage(img.getImage());
		setSize(1000, 700);
		// setMinimumSize(new Dimension(850, 600));
		setResizable(false);
		setLayout(new BorderLayout());

		add(panelInicial, BorderLayout.CENTER);
		add(panelInferior, BorderLayout.SOUTH);
		add(barraPaneles, BorderLayout.NORTH);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(false);

	}

	public Calculadora getCalculadora() {
		return calculadora;
	}

	public void setCalculadora(Calculadora calculadora) {
		this.calculadora = calculadora;
	}

	public PanelInventario getPanelInv() {
		return panelInv;
	}

	public void setPanelInv(PanelInventario panelInv) {
		this.panelInv = panelInv;
	}

	public JOptionPaneConTimeOut getJoptiontime() {
		return joptiontime;
	}

	public void setJoptiontime(JOptionPaneConTimeOut joptiontime) {
		this.joptiontime = joptiontime;
	}

	public Color getColorBase() {
		return colorBase;
	}

	public void setColorBase(Color colorBase) {
		this.colorBase = colorBase;
	}

	public PanelEmpleados getPanelEmple() {
		return panelEmple;
	}

	public void setPanelEmple(PanelEmpleados panelEmple) {
		this.panelEmple = panelEmple;
	}

	public Controlador getControlador() {
		return controlador;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public PanelResumen getPanelResumen() {
		return panelResumen;
	}

	public void setPanelResumen(PanelResumen panelResumen) {
		this.panelResumen = panelResumen;
	}

	public PanelInicial getPanelInicial() {
		return panelInicial;
	}

	public void setPanelInicial(PanelInicial panelInicial) {
		this.panelInicial = panelInicial;
	}

	public Eventos getEventos() {
		return eventos;
	}

	public void setEventos(Eventos eventos) {
		this.eventos = eventos;
	}

	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}

	public PanelInferior getPanelInferior() {
		return panelInferior;
	}

	public void setPanelInferior(PanelInferior panelInferior) {
		this.panelInferior = panelInferior;
	}

	public BarraPaneles getBarraPaneles() {
		return barraPaneles;
	}

	public void setBarraPaneles(BarraPaneles barraPaneles) {
		this.barraPaneles = barraPaneles;
	}

	public BotonListener getBotonListener() {
		return botonListener;
	}

	public void setBotonListener(BotonListener botonListener) {
		this.botonListener = botonListener;
	}

}
