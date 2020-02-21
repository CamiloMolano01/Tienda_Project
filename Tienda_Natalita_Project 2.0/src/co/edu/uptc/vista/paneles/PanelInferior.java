package co.edu.uptc.vista.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.vista.VentanaPrincipal;

public class PanelInferior extends JPanel implements Runnable {

	private VentanaPrincipal ventana;

	private String horas;
	private String minutos;
	private String segundos;
	private String amPm;
	private int dia;
	private int mes;
	private int anio;

	private Calendar calendario;
	private Thread h1;

	private JLabel horaActual;
	private JLabel fecha;
	private JLabel usuario;

	public PanelInferior(VentanaPrincipal ventana) {
		this.ventana = ventana;

		setLayout(new FlowLayout());
		setBackground(ventana.getColorBase());
		usuario = new JLabel();
		usuario.setForeground(Color.WHITE);
		usuario.setPreferredSize(new Dimension(165, 18));
		horaActual = new JLabel();
		horaActual.setForeground(Color.WHITE);
		fecha = new JLabel();
		fecha.setForeground(Color.WHITE);
		h1 = new Thread(this);
		h1.start();
		
		add(Box.createRigidArea(new Dimension(-400, 0)));
		add(usuario);
		add(Box.createRigidArea(new Dimension(200, 0)));
		add(horaActual);
		add(Box.createRigidArea(new Dimension(80, 0)));
		add(fecha);
	}

	public void calcular() {
		calendario = new GregorianCalendar();
		Date fechaHoraActual = new Date();

		calendario.setTime(fechaHoraActual);
		amPm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

		if (amPm.equals("PM")) {
			int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
			horas = h > 9 ? "" + h : "0" + h;
		} else {
			horas = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY)
					: "0" + calendario.get(Calendar.HOUR_OF_DAY);
		}
		minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE)
				: "0" + calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND)
				: "0" + calendario.get(Calendar.SECOND);
		dia = calendario.get(Calendar.DAY_OF_MONTH);
		mes = calendario.get(Calendar.MONTH) + 1;
		anio = calendario.get(Calendar.YEAR);

		if (mes > 9) {
			fecha.setText(dia + "/" + mes + "/" + anio);
		} else {
			fecha.setText(dia + "/" + "0" + mes + "/" + anio);
		}

	}

	@Override
	public void run() {
		Thread ct = Thread.currentThread();
		while (ct == h1) {
			calcular();
			horaActual.setText(horas + ":" + minutos + ":" + segundos + " " + amPm);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}

	}

	public VentanaPrincipal getVentana() {
		return ventana;
	}

	public void setVentana(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	public String getHoras() {
		return horas;
	}

	public void setHoras(String horas) {
		this.horas = horas;
	}

	public String getMinutos() {
		return minutos;
	}

	public void setMinutos(String minutos) {
		this.minutos = minutos;
	}

	public String getSegundos() {
		return segundos;
	}

	public void setSegundos(String segundos) {
		this.segundos = segundos;
	}

	public String getAmPm() {
		return amPm;
	}

	public void setAmPm(String amPm) {
		this.amPm = amPm;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Calendar getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendar calendario) {
		this.calendario = calendario;
	}

	public Thread getH1() {
		return h1;
	}

	public void setH1(Thread h1) {
		this.h1 = h1;
	}

	public JLabel getHoraActual() {
		return horaActual;
	}

	public void setHoraActual(JLabel horaActual) {
		this.horaActual = horaActual;
	}

	public JLabel getFecha() {
		return fecha;
	}

	public void setFecha(JLabel fecha) {
		this.fecha = fecha;
	}

	public JLabel getUsuario() {
		return usuario;
	}

	public void setUsuario(JLabel usuario) {
		this.usuario = usuario;
	}

}
