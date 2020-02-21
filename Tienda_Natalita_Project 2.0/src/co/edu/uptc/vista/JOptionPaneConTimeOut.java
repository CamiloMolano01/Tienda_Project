package co.edu.uptc.vista;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Muestra un JOptionPane con un timeout para que se cierre automaticamente.
 * 
 * @author chuidiang
 * 
 */
public class JOptionPaneConTimeOut {
	private static JOptionPane option = new JOptionPane("", JOptionPane.INFORMATION_MESSAGE);

	private static JDialog dialogo = null;

	public static void visualizaDialogo(Component padre, String texto, String titulo, final long timeout) {
		option.setMessage(texto);
		if (null == dialogo) {
			dialogo = option.createDialog(padre, titulo);
		} else {
			dialogo.setTitle(titulo);
		}

		Thread hilo = new Thread() {
			public void run() {
				try {
					Thread.sleep(timeout);
					if (dialogo.isVisible()) {
						dialogo.setVisible(false);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		hilo.start();

		dialogo.setVisible(true);
	}
}