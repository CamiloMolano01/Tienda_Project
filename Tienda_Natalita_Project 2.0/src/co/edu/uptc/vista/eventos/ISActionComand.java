package co.edu.uptc.vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import co.edu.uptc.vista.InicioSesion;
import co.edu.uptc.vista.JOptionPaneConTimeOut;

public class ISActionComand implements ActionListener {

	private InicioSesion vista;

	public ISActionComand(InicioSesion vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String accion = e.getActionCommand();
		if (accion.equals("entrar")) {
			String usuario = vista.getNombreUsuario().getText();
			String contraseña = new String(vista.getContraseña().getPassword());

			vista.getVentanaP().getControlador().validarInicio(usuario, contraseña);
			int valor = vista.getVentanaP().getControlador().getResultadoValidacion();
			boolean usuarioEncontrado = vista.getVentanaP().getControlador().isUsuarioEncontrado();
			boolean contraseñaCorrecta = vista.getVentanaP().getControlador().isContraseñaCorrecta();
			String nombreUsuario = vista.getVentanaP().getControlador().getNombreUsuario();

			if (usuarioEncontrado == true && contraseñaCorrecta == true) {
				if (valor == 2) {
					vista.getVentanaP().getBarraPaneles().getEmpleados().setEnabled(false);
					vista.getVentanaP().getPanelInv().getBotonAgregar().setEnabled(false);
					vista.getVentanaP().getPanelInv().getBotonEliminar().setEnabled(false);
					vista.getVentanaP().getPanelInv().getBotonEditar().setEnabled(false);
					vista.getVentanaP().getBarraPaneles().getImagenTipo()
							.setIcon(new ImageIcon("./imagenes/normal.png"));

				} else if (valor == 1) {
					
					vista.getVentanaP().getBarraPaneles().getEmpleados()
							.addMouseListener(vista.getVentanaP().getBotonListener());
					vista.getVentanaP().getBarraPaneles().getImagenTipo()
							.setIcon(new ImageIcon("./imagenes/admin.png"));

				}
				vista.getVentanaP().getPanelInferior().getUsuario().setText("Usuario: " + nombreUsuario);
				JOptionPaneConTimeOut.visualizaDialogo(null, "Bienvenido " + nombreUsuario, "Iniciando", 800);
				vista.getVentanaP().setVisible(true);
				vista.dispose();
				vista.getVentanaP().getPanelInicial().agregarCompletar();
			} else if (usuarioEncontrado == true && contraseñaCorrecta == false) {

				JOptionPane.showMessageDialog(null, "El usuario existe pero la contraseña es incorrecta", "Error",
						JOptionPane.DEFAULT_OPTION, new ImageIcon("./imagenes/error.png"));

			} else if (usuarioEncontrado == false) {

				JOptionPane.showMessageDialog(null, "El usuario no se encuentra en el sistema", "Error",
						JOptionPane.DEFAULT_OPTION, new ImageIcon("./imagenes/error.png"));

			}

		}

	}

}
