package co.edu.uptc.vista.eventos;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import co.edu.uptc.vista.VentanaPrincipal;

public class BotonListener implements MouseListener {

	public VentanaPrincipal ventana;

	private boolean oculto1 = true;
	private boolean oculto2 = true;
	private boolean oculto3 = true;

	private Color colorFondoInicial;
	private Color colorLetraInicial;
	private Color colorFondoInicio;
	private Color colorLetraInicio;
	private Color colorFondoResumen;
	private Color colorLetraResumen;
	private Color colorFondoInventario;
	private Color colorLetraInventario;
	private Color colorFondoClientes;
	private Color colorLetraClientes;

	private boolean inicioActivado = true;
	private boolean empleadosActivado = false;
	private boolean resumenActivado = false;
	private boolean inventarioActivado = false;

	public BotonListener(VentanaPrincipal ventana) {
		this.ventana = ventana;

		colorFondoInicio = Color.WHITE;
		colorLetraInicio = new Color(0, 77, 77);
		colorFondoResumen = new Color(238, 237, 241);
		colorLetraResumen = new Color(100, 100, 100);
		colorFondoInventario = new Color(238, 237, 241);
		colorLetraInventario = new Color(100, 100, 100);
		colorFondoClientes = new Color(238, 237, 241);
		colorLetraClientes = new Color(100, 100, 100);

		colorFondoInicial = new Color(238, 237, 241);
		colorLetraInicial = new Color(100, 100, 100);
	}

	public void colorBase() {

		ventana.getBarraPaneles().getInicio().setForeground(colorLetraInicial);
		ventana.getBarraPaneles().getInicio().setBackground(colorFondoInicial);
		ventana.getBarraPaneles().getEmpleados().setForeground(colorLetraInicial);
		ventana.getBarraPaneles().getEmpleados().setBackground(colorFondoInicial);
		ventana.getBarraPaneles().getResumen().setForeground(colorLetraInicial);
		ventana.getBarraPaneles().getResumen().setBackground(colorFondoInicial);
		ventana.getBarraPaneles().getInventario().setForeground(colorLetraInicial);
		ventana.getBarraPaneles().getInventario().setBackground(colorFondoInicial);

		colorFondoInicio = colorFondoInicial;
		colorLetraInicio = colorLetraInicial;
		colorFondoResumen = colorFondoInicial;
		colorLetraResumen = colorLetraInicial;
		colorFondoInventario = colorFondoInicial;
		colorLetraInventario = colorLetraInicial;
		colorFondoClientes = colorFondoInicial;
		colorLetraClientes = colorLetraInicial;

	}

	public void falsos() {
		inicioActivado = false;
		empleadosActivado = false;
		resumenActivado = false;
		inventarioActivado = false;
	}

	@Override
	public void mouseClicked(MouseEvent evento) {
		
		if(evento.getSource() == ventana.getPanelInicial().getTextBuscar()) {
			ventana.getPanelInicial().getTextBuscar().setText("");
			ventana.getPanelInicial().getInfoPro().setText("");
			ventana.getPanelInicial().getTablaVenta().clearSelection();
			ventana.getPanelInicial().getBotonMas().setEnabled(false);
			ventana.getPanelInicial().getBotonMenos().setEnabled(false);
		}

		if (evento.getSource() == ventana.getBarraPaneles().getInicio()) {
			if (ventana.getBarraPaneles().getInicio().isEnabled() == false) {

			} else {
				colorBase();

				ventana.getBarraPaneles().getInicio().setForeground(ventana.getColorBase());
				ventana.getBarraPaneles().getInicio().setBackground(Color.WHITE);

				colorFondoInicio = ventana.getBarraPaneles().getInicio().getBackground();
				colorLetraInicio = ventana.getBarraPaneles().getInicio().getForeground();

				falsos();
				inicioActivado = true;
			}

		}

		if (evento.getSource() == ventana.getBarraPaneles().getResumen()) {
			if (ventana.getBarraPaneles().getResumen().isEnabled() == false) {

			} else {
				colorBase();

				ventana.getBarraPaneles().getResumen().setForeground(ventana.getColorBase());
				ventana.getBarraPaneles().getResumen().setBackground(Color.WHITE);

				colorFondoResumen = ventana.getBarraPaneles().getResumen().getBackground();
				colorLetraResumen = ventana.getBarraPaneles().getResumen().getForeground();

				falsos();
				resumenActivado = true;
			}
		}

		if (evento.getSource() == ventana.getBarraPaneles().getInventario()) {
			if (ventana.getBarraPaneles().getInventario().isEnabled() == false) {

			} else {
				colorBase();

				ventana.getBarraPaneles().getInventario().setForeground(ventana.getColorBase());
				ventana.getBarraPaneles().getInventario().setBackground(Color.WHITE);

				colorFondoInventario = ventana.getBarraPaneles().getInventario().getBackground();
				colorLetraInventario = ventana.getBarraPaneles().getInventario().getForeground();

				falsos();
				inventarioActivado = true;
			}
		}

		if (evento.getSource() == ventana.getBarraPaneles().getEmpleados()) {
			if (ventana.getBarraPaneles().getEmpleados().isEnabled() == false) {

			} else {
				colorBase();

				ventana.getBarraPaneles().getEmpleados().setForeground(ventana.getColorBase());
				ventana.getBarraPaneles().getEmpleados().setBackground(Color.WHITE);

				colorFondoClientes = ventana.getBarraPaneles().getEmpleados().getBackground();
				colorLetraClientes = ventana.getBarraPaneles().getEmpleados().getForeground();

				falsos();
				empleadosActivado = true;
			}
		}

		if (evento.getSource() == ventana.getPanelEmple().getPanelCrearUsuario().getVerOcultar1()) {
			if (oculto1 == true) {
				ventana.getPanelEmple().getPanelCrearUsuario().getVerOcultar1()
						.setIcon(new ImageIcon("./imagenes/mostrarContraseña.png"));
				ventana.getPanelEmple().getPanelCrearUsuario().getContraseña().setEchoChar((char) 0);
				oculto1 = false;
			} else if (oculto1 == false) {
				ventana.getPanelEmple().getPanelCrearUsuario().getVerOcultar1()
						.setIcon(new ImageIcon("./imagenes/contraseña.png"));
				ventana.getPanelEmple().getPanelCrearUsuario().getContraseña().setEchoChar('*');
				oculto1 = true;
			}

		}

		if (evento.getSource() == ventana.getPanelEmple().getPanelCrearUsuario().getVerOcultar2()) {
			if (oculto2 == true) {
				ventana.getPanelEmple().getPanelCrearUsuario().getVerOcultar2()
						.setIcon(new ImageIcon("./imagenes/mostrarContraseña.png"));
				ventana.getPanelEmple().getPanelCrearUsuario().getConfContra().setEchoChar((char) 0);
				oculto2 = false;
			} else if (oculto2 == false) {
				ventana.getPanelEmple().getPanelCrearUsuario().getVerOcultar2()
						.setIcon(new ImageIcon("./imagenes/contraseña.png"));
				ventana.getPanelEmple().getPanelCrearUsuario().getConfContra().setEchoChar('*');
				oculto2 = true;
			}

		}

		if (evento.getSource() == ventana.getPanelEmple().getPanelVerUsurarios().getVerOcultar()) {
			if (oculto3 == true) {
				ventana.getPanelEmple().getPanelVerUsurarios().getVerOcultar()
						.setIcon(new ImageIcon("./imagenes/mostrarContraseña.png"));
				ventana.getPanelEmple().getPanelVerUsurarios().getContraseña().setEchoChar((char) 0);
				oculto3 = false;
			} else if (oculto3 == false) {
				ventana.getPanelEmple().getPanelVerUsurarios().getVerOcultar()
						.setIcon(new ImageIcon("./imagenes/contraseña.png"));
				ventana.getPanelEmple().getPanelVerUsurarios().getContraseña().setEchoChar('*');
				oculto3 = true;
			}

		}

	}

	@Override
	public void mouseEntered(MouseEvent evento) {
		if (evento.getSource() == ventana.getBarraPaneles().getInicio()) {
			if (ventana.getBarraPaneles().getInicio().isEnabled() == false) {

			} else {
				ventana.getBarraPaneles().getInicio().setBackground(new Color(200, 200, 200));
				ventana.getBarraPaneles().getInicio().setForeground(Color.black);
			}
		}
		if (evento.getSource() == ventana.getBarraPaneles().getResumen()) {
			if (ventana.getBarraPaneles().getResumen().isEnabled() == false) {

			} else {
				ventana.getBarraPaneles().getResumen().setBackground(new Color(200, 200, 200));
				ventana.getBarraPaneles().getResumen().setForeground(Color.black);
			}
		}
		if (evento.getSource() == ventana.getBarraPaneles().getInventario()) {
			if (ventana.getBarraPaneles().getInventario().isEnabled() == false) {

			} else {
				ventana.getBarraPaneles().getInventario().setBackground(new Color(200, 200, 200));
				ventana.getBarraPaneles().getInventario().setForeground(Color.black);
			}
		}
		if (evento.getSource() == ventana.getBarraPaneles().getEmpleados()) {
			if (ventana.getBarraPaneles().getEmpleados().isEnabled() == false) {

			} else {
				ventana.getBarraPaneles().getEmpleados().setBackground(new Color(200, 200, 200));
				ventana.getBarraPaneles().getEmpleados().setForeground(Color.black);
			}
		}

		if (evento.getSource() == ventana.getBarraPaneles().getCambiarUsuario()) {
			if (ventana.getBarraPaneles().getCambiarUsuario().isEnabled() == false) {

			} else {
				ventana.getBarraPaneles().getCambiarUsuario().setBackground(new Color(0, 90, 90));
			}
		}

		if (evento.getSource() == ventana.getPanelEmple().getBotonCrearPerfil()) {
			if (ventana.getPanelEmple().getBotonCrearPerfil().isEnabled() == false) {

			} else {
				ventana.getPanelEmple().getBotonCrearPerfil().setBackground(new Color(0, 90, 90));
			}
		}

		if (evento.getSource() == ventana.getPanelEmple().getBotonVerPerfiles()) {
			if (ventana.getPanelEmple().getBotonVerPerfiles().isEnabled() == false) {

			} else {
				ventana.getPanelEmple().getBotonVerPerfiles().setBackground(new Color(0, 90, 90));
			}
		}

		if (evento.getSource() == ventana.getPanelInv().getBotonAgregar()) {
			if (ventana.getPanelInv().getBotonAgregar().isEnabled() == false) {

			} else {
				ventana.getPanelInv().getBotonAgregar().setBackground(new Color(0, 90, 90));
			}
		}

		if (evento.getSource() == ventana.getPanelInv().getBotonEditar()) {
			if (ventana.getPanelInv().getBotonEditar().isEnabled() == false) {

			} else {
				ventana.getPanelInv().getBotonEditar().setBackground(new Color(0, 90, 90));
			}
		}

		if (evento.getSource() == ventana.getPanelInv().getBotonEliminar()) {
			if (ventana.getPanelInv().getBotonEliminar().isEnabled() == false) {

			} else {
				ventana.getPanelInv().getBotonEliminar().setBackground(new Color(0, 90, 90));
			}
		}

	}

	@Override
	public void mouseExited(MouseEvent evento) {

		if (evento.getSource() == ventana.getBarraPaneles().getInicio()) {
			if (ventana.getBarraPaneles().getInicio().isEnabled() == false) {

			} else {
				ventana.getBarraPaneles().getInicio().setForeground(colorLetraInicio);
				ventana.getBarraPaneles().getInicio().setBackground(colorFondoInicio);
			}
		}
		if (evento.getSource() == ventana.getBarraPaneles().getResumen()) {
			if (ventana.getBarraPaneles().getResumen().isEnabled() == false) {

			} else {
				ventana.getBarraPaneles().getResumen().setForeground(colorLetraResumen);
				ventana.getBarraPaneles().getResumen().setBackground(colorFondoResumen);
			}
		}
		if (evento.getSource() == ventana.getBarraPaneles().getInventario()) {
			if (ventana.getBarraPaneles().getInventario().isEnabled() == false) {

			} else {
				ventana.getBarraPaneles().getInventario().setForeground(colorLetraInventario);
				ventana.getBarraPaneles().getInventario().setBackground(colorFondoInventario);
			}
		}
		if (evento.getSource() == ventana.getBarraPaneles().getEmpleados()) {
			if (ventana.getBarraPaneles().getEmpleados().isEnabled() == false) {

			} else {
				ventana.getBarraPaneles().getEmpleados().setForeground(colorLetraClientes);
				ventana.getBarraPaneles().getEmpleados().setBackground(colorFondoClientes);
			}
		}
		if (evento.getSource() == ventana.getBarraPaneles().getCambiarUsuario()) {
			if (ventana.getBarraPaneles().getCambiarUsuario().isEnabled() == false) {

			} else {
				ventana.getBarraPaneles().getCambiarUsuario().setBackground(ventana.getColorBase());
			}
		}

		if (evento.getSource() == ventana.getPanelEmple().getBotonCrearPerfil()) {
			if (ventana.getPanelEmple().getBotonCrearPerfil().isEnabled() == false) {

			} else {
				ventana.getPanelEmple().getBotonCrearPerfil().setBackground(ventana.getColorBase());
			}
		}
		if (evento.getSource() == ventana.getPanelEmple().getBotonVerPerfiles()) {
			if (ventana.getPanelEmple().getBotonVerPerfiles().isEnabled() == false) {

			} else {
				ventana.getPanelEmple().getBotonVerPerfiles().setBackground(ventana.getColorBase());
			}
		}

		if (evento.getSource() == ventana.getPanelInv().getBotonEliminar()) {
			if (ventana.getPanelInv().getBotonEliminar().isEnabled() == false) {

			} else {
				ventana.getPanelInv().getBotonEliminar().setBackground(ventana.getColorBase());
			}
		}

		if (evento.getSource() == ventana.getPanelInv().getBotonEditar()) {
			if (ventana.getPanelInv().getBotonEditar().isEnabled() == false) {

			} else {
				ventana.getPanelInv().getBotonEditar().setBackground(ventana.getColorBase());
			}
		}

		if (evento.getSource() == ventana.getPanelInv().getBotonAgregar()) {
			if (ventana.getPanelInv().getBotonAgregar().isEnabled() == false) {

			} else {
				ventana.getPanelInv().getBotonAgregar().setBackground(ventana.getColorBase());
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent evento) {
	}

	@Override
	public void mouseReleased(MouseEvent evento) {
	}

	public VentanaPrincipal getVentana() {
		return ventana;
	}

	public void setVentana(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	public Color getColorFondoInicial() {
		return colorFondoInicial;
	}

	public void setColorFondoInicial(Color colorFondoInicial) {
		this.colorFondoInicial = colorFondoInicial;
	}

	public Color getColorLetraInicial() {
		return colorLetraInicial;
	}

	public void setColorLetraInicial(Color colorLetraInicial) {
		this.colorLetraInicial = colorLetraInicial;
	}

	public Color getColorFondoInicio() {
		return colorFondoInicio;
	}

	public void setColorFondoInicio(Color colorFondoInicio) {
		this.colorFondoInicio = colorFondoInicio;
	}

	public Color getColorLetraInicio() {
		return colorLetraInicio;
	}

	public void setColorLetraInicio(Color colorLetraInicio) {
		this.colorLetraInicio = colorLetraInicio;
	}

	public Color getColorFondoResumen() {
		return colorFondoResumen;
	}

	public void setColorFondoResumen(Color colorFondoResumen) {
		this.colorFondoResumen = colorFondoResumen;
	}

	public Color getColorLetraResumen() {
		return colorLetraResumen;
	}

	public void setColorLetraResumen(Color colorLetraResumen) {
		this.colorLetraResumen = colorLetraResumen;
	}

	public Color getColorFondoInventario() {
		return colorFondoInventario;
	}

	public void setColorFondoInventario(Color colorFondoInventario) {
		this.colorFondoInventario = colorFondoInventario;
	}

	public Color getColorLetraInventario() {
		return colorLetraInventario;
	}

	public void setColorLetraInventario(Color colorLetraInventario) {
		this.colorLetraInventario = colorLetraInventario;
	}

	public Color getColorFondoClientes() {
		return colorFondoClientes;
	}

	public void setColorFondoClientes(Color colorFondoClientes) {
		this.colorFondoClientes = colorFondoClientes;
	}

	public Color getColorLetraClientes() {
		return colorLetraClientes;
	}

	public void setColorLetraClientes(Color colorLetraClientes) {
		this.colorLetraClientes = colorLetraClientes;
	}

	public boolean isInicioActivado() {
		return inicioActivado;
	}

	public void setInicioActivado(boolean inicioActivado) {
		this.inicioActivado = inicioActivado;
	}

	public boolean isEmpleadosActivado() {
		return empleadosActivado;
	}

	public void setEmpleadosActivado(boolean empleadosActivado) {
		this.empleadosActivado = empleadosActivado;
	}

	public boolean isResumenActivado() {
		return resumenActivado;
	}

	public void setResumenActivado(boolean resumenActivado) {
		this.resumenActivado = resumenActivado;
	}

	public boolean isInventarioActivado() {
		return inventarioActivado;
	}

	public void setInventarioActivado(boolean inventarioActivado) {
		this.inventarioActivado = inventarioActivado;
	}

}
