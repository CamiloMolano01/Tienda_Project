package co.edu.uptc.vista.eventos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import co.edu.uptc.vista.InicioSesion;

public class ISBotonListener implements MouseListener {

	private InicioSesion vista;
	private boolean oculto = true;

	public ISBotonListener(InicioSesion vista) {
		this.vista = vista;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		
		if (e.getSource() == vista.getVerOcultar()) {
			if (oculto == true) {
				vista.getVerOcultar().setIcon(new ImageIcon("./imagenes/mostrarContraseña.png"));
				vista.getContraseña().setEchoChar((char) 0);
				oculto = false;
			} else if (oculto == false) {
				vista.getVerOcultar().setIcon(new ImageIcon("./imagenes/contraseña.png"));
				vista.getContraseña().setEchoChar('*');
				oculto = true;
			}

		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Apéndice de método generado automáticamente

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Apéndice de método generado automáticamente

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Apéndice de método generado automáticamente

	}

}
