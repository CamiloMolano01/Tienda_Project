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
				vista.getVerOcultar().setIcon(new ImageIcon("./imagenes/mostrarContrase�a.png"));
				vista.getContrase�a().setEchoChar((char) 0);
				oculto = false;
			} else if (oculto == false) {
				vista.getVerOcultar().setIcon(new ImageIcon("./imagenes/contrase�a.png"));
				vista.getContrase�a().setEchoChar('*');
				oculto = true;
			}

		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

	}

}
