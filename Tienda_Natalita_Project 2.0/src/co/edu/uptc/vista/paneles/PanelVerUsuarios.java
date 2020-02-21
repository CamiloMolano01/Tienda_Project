package co.edu.uptc.vista.paneles;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import co.edu.uptc.modelo.TipoDocumento;
import co.edu.uptc.vista.VentanaPrincipal;

public class PanelVerUsuarios extends JPanel {

	private VentanaPrincipal ventana;
	private JList<String> jlistUsuarios;
	private JScrollPane scroll;

	private JPanel panelIzquierdo;
	private JPanel panelDerecho;
	private JPanel boxNNE;
	private JPanel boxATA;
	private JPanel flowBox;
	private JPanel atrasTitulo;
	private JPanel panelCotraseña;

	private Font letraGoogle;

	private JTextField usuario;
	private JPasswordField contraseña;
	private JLabel tipo;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField numeroDoc;

	private JLabel lusuario;
	private JLabel lcontraseña;
	private JLabel ltipo;
	private JLabel lnombre;
	private JLabel lapellido;
	private JLabel lnumeroDoc;
	private JLabel ltipoDoc;
	private JLabel titulo;

	private JSeparator sepUsuario;
	private JSeparator sepContraseña;
	private JSeparator sepTipo;
	private JSeparator sepNombre;
	private JSeparator sepApellido;
	private JSeparator sepNumeroDoc;
	private JSeparator sepTipoDoc;

	private JButton verOcultar;
	private JButton eliminar;
	private JButton actualizar;
	private JButton atras;

	private DefaultComboBoxModel<TipoDocumento> boxTipoDoc;
	private JComboBox<TipoDocumento> ctDoc;

	public PanelVerUsuarios(VentanaPrincipal ventana) {
		this.ventana = ventana;
		setLayout(new FlowLayout());
		setBackground(Color.WHITE);

		letraGoogle = new Font("Open Sans", Font.BOLD, 15);

		atrasTitulo = new JPanel();
		atrasTitulo.setLayout(new FlowLayout());

		boxTipoDoc = new DefaultComboBoxModel<>(TipoDocumento.values());
		ctDoc = new JComboBox<>(boxTipoDoc);

		verOcultar = new JButton();
		verOcultar.setIcon(new ImageIcon("./imagenes/contraseña.png"));
		verOcultar.setPreferredSize(new Dimension(25, 25));
		verOcultar.setFocusPainted(false);
		verOcultar.setBorderPainted(false);
		verOcultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		verOcultar.setBackground(Color.WHITE);
		verOcultar.addMouseListener(ventana.getBotonListener());

		panelCotraseña = new JPanel();
		panelCotraseña.setLayout(new FlowLayout());

		panelIzquierdo = new JPanel();
		panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
		panelIzquierdo.setBackground(Color.WHITE);
		panelIzquierdo.setPreferredSize(new Dimension(490, 560));

		panelDerecho = new JPanel();
		panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
		panelDerecho.setPreferredSize(new Dimension(490, 560));
		panelDerecho.setBackground(Color.white);

		boxNNE = new JPanel();
		boxNNE.setLayout(new BoxLayout(boxNNE, BoxLayout.Y_AXIS));
		boxNNE.setPreferredSize(new Dimension(240, 320));
		boxNNE.setBackground(Color.WHITE);

		boxATA = new JPanel();
		boxATA.setLayout(new BoxLayout(boxATA, BoxLayout.Y_AXIS));
		boxATA.setPreferredSize(new Dimension(240, 320));
		boxATA.setBackground(Color.WHITE);

		flowBox = new JPanel();
		flowBox.setLayout(new FlowLayout());
		flowBox.setPreferredSize(new Dimension(480, 320));
		flowBox.setBackground(Color.WHITE);

		usuario = new JTextField();
		usuario.setMaximumSize(new Dimension(250, 30));
		usuario.setPreferredSize(new Dimension(250, 30));
		usuario.setFont(letraGoogle);
		usuario.setHorizontalAlignment(JTextField.CENTER);
		usuario.setOpaque(false);
		usuario.setBorder(null);
		usuario.setForeground(Color.BLACK);
		usuario.setCaretColor(Color.BLACK);
		usuario.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (usuario.getText().length() == 25) {
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});

		contraseña = new JPasswordField();
		contraseña.setMaximumSize(new Dimension(250, 30));
		contraseña.setPreferredSize(new Dimension(250, 30));
		contraseña.setFont(letraGoogle);
		contraseña.setHorizontalAlignment(JTextField.CENTER);
		contraseña.setEchoChar('*');
		contraseña.setOpaque(false);
		contraseña.setBorder(null);
		contraseña.setForeground(Color.BLACK);
		contraseña.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (contraseña.getPassword().length == 18) {
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});

		nombre = new JTextField();
		nombre.setMaximumSize(new Dimension(220, 30));
		nombre.setPreferredSize(new Dimension(220, 30));
		nombre.setFont(letraGoogle);
		nombre.setHorizontalAlignment(JTextField.CENTER);
		nombre.setOpaque(false);
		nombre.setBorder(null);
		nombre.setForeground(Color.BLACK);
		nombre.setCaretColor(Color.BLACK);

		apellido = new JTextField();
		apellido.setMaximumSize(new Dimension(220, 30));
		apellido.setPreferredSize(new Dimension(220, 30));
		apellido.setFont(letraGoogle);
		apellido.setHorizontalAlignment(JTextField.CENTER);
		apellido.setOpaque(false);
		apellido.setBorder(null);
		apellido.setForeground(Color.BLACK);
		apellido.setCaretColor(Color.BLACK);

		numeroDoc = new JTextField();
		numeroDoc.setMaximumSize(new Dimension(220, 30));
		numeroDoc.setPreferredSize(new Dimension(220, 30));
		numeroDoc.setFont(letraGoogle);
		numeroDoc.setHorizontalAlignment(JTextField.CENTER);
		numeroDoc.setOpaque(false);
		numeroDoc.setBorder(null);
		numeroDoc.setForeground(Color.BLACK);
		numeroDoc.setCaretColor(Color.BLACK);

		// tipoDoc = new JLabel();
		ctDoc.setMaximumSize(new Dimension(220, 30));
		ctDoc.setPreferredSize(new Dimension(220, 30));
		ctDoc.setAlignmentX(CENTER_ALIGNMENT);
		// ctDoc.setHorizontalAlignment(JLabel.CENTER);
		ctDoc.setFont(letraGoogle);

		tipo = new JLabel();
		tipo.setPreferredSize(new Dimension(250, 30));
		tipo.setMaximumSize(new Dimension(250, 30));
		tipo.setAlignmentX(CENTER_ALIGNMENT);
		tipo.setHorizontalAlignment(JLabel.CENTER);
		tipo.setFont(letraGoogle);

		lusuario = new JLabel("USUARIO: ");
		lusuario.setFont(letraGoogle);
		lusuario.setAlignmentX(CENTER_ALIGNMENT);
		lcontraseña = new JLabel("CONTRASEÑA: ");
		lcontraseña.setFont(letraGoogle);
		lcontraseña.setAlignmentX(CENTER_ALIGNMENT);
		ltipo = new JLabel("TIPO PERFIL: ");
		ltipo.setFont(letraGoogle);
		ltipo.setAlignmentX(CENTER_ALIGNMENT);
		lnombre = new JLabel("NOMBRE: ");
		lnombre.setFont(letraGoogle);
		lnombre.setAlignmentX(RIGHT_ALIGNMENT);
		lapellido = new JLabel("APELLIDO: ");
		lapellido.setFont(letraGoogle);
		lapellido.setAlignmentX(RIGHT_ALIGNMENT);
		lnumeroDoc = new JLabel("NUM DOC: ");
		lnumeroDoc.setFont(letraGoogle);
		lnumeroDoc.setAlignmentX(RIGHT_ALIGNMENT);
		ltipoDoc = new JLabel("TIPO DOC: ");
		ltipoDoc.setFont(letraGoogle);
		ltipoDoc.setAlignmentX(RIGHT_ALIGNMENT);

		sepUsuario = new JSeparator();
		sepUsuario.setBackground(ventana.getColorBase());
		sepUsuario.setMaximumSize(new Dimension(250, 2));
		sepUsuario.setPreferredSize(new Dimension(250, 2));

		sepContraseña = new JSeparator();
		sepContraseña.setBackground(ventana.getColorBase());
		sepContraseña.setMaximumSize(new Dimension(250, 2));
		sepContraseña.setPreferredSize(new Dimension(250, 2));

		sepTipo = new JSeparator();
		sepTipo.setBackground(ventana.getColorBase());
		sepTipo.setMaximumSize(new Dimension(250, 2));
		sepTipo.setPreferredSize(new Dimension(250, 2));

		sepNombre = new JSeparator();
		sepNombre.setBackground(ventana.getColorBase());
		sepNombre.setMaximumSize(new Dimension(220, 2));
		sepNombre.setPreferredSize(new Dimension(220, 2));

		sepApellido = new JSeparator();
		sepApellido.setBackground(ventana.getColorBase());
		sepApellido.setMaximumSize(new Dimension(220, 2));
		sepApellido.setPreferredSize(new Dimension(220, 2));

		sepNumeroDoc = new JSeparator();
		sepNumeroDoc.setBackground(ventana.getColorBase());
		sepNumeroDoc.setMaximumSize(new Dimension(220, 2));
		sepNumeroDoc.setPreferredSize(new Dimension(220, 2));

		sepTipoDoc = new JSeparator();
		sepTipoDoc.setBackground(ventana.getColorBase());
		sepTipoDoc.setMaximumSize(new Dimension(220, 2));
		sepTipoDoc.setPreferredSize(new Dimension(220, 2));

		jlistUsuarios = new JList<>();
		jlistUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlistUsuarios.setLayoutOrientation(JList.VERTICAL);
		jlistUsuarios.setFont(letraGoogle);

		jlistUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				listaMouseClicked(evt);
			}
		});

		scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setViewportView(jlistUsuarios);

		eliminar = new JButton();
		// eliminar.setPreferredSize(new Dimension(50, 50));
		eliminar.setIcon(new ImageIcon("./imagenes/eliminarUsuario.png"));
		// eliminar.setMinimumSize(new Dimension(50, 50));
		eliminar.setAlignmentX(LEFT_ALIGNMENT);
		eliminar.setBackground(ventana.getColorBase());
		eliminar.setFocusPainted(false);
		eliminar.setBorderPainted(false);
		eliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eliminar.setActionCommand("eliminarUsuario");
		eliminar.addActionListener(ventana.getEventos());

		actualizar = new JButton();
		// actualizar.setPreferredSize(new Dimension(50, 50));
		actualizar.setIcon(new ImageIcon("./imagenes/editarUsuario.png"));
		// actualizar.setMinimumSize(new Dimension(50, 50));
		actualizar.setAlignmentX(RIGHT_ALIGNMENT);
		actualizar.setBackground(ventana.getColorBase());
		actualizar.setFocusPainted(false);
		actualizar.setBorderPainted(false);
		actualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		actualizar.setActionCommand("actualizarUsuario");
		actualizar.addActionListener(ventana.getEventos());

		atras = new JButton();
		atras.setIcon(new ImageIcon("./imagenes/atras.png"));
		atras.setBackground(ventana.getColorBase());
		atras.setFocusPainted(false);
		atras.setBorderPainted(false);
		atras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		atras.setActionCommand("atrasVer");
		atras.addActionListener(ventana.getEventos());

		panelCotraseña.setMaximumSize(new Dimension(305, 31));
		panelCotraseña.add(Box.createRigidArea(new Dimension(15, 0)));
		panelCotraseña.setBackground(Color.WHITE);
		panelCotraseña.add(contraseña);
		panelCotraseña.add(verOcultar);

		boxATA.add(Box.createRigidArea(new Dimension(220, 0)));
		boxATA.add(Box.createRigidArea(new Dimension(0, 20)));
		boxATA.add(lapellido);
		boxATA.add(apellido);
		boxATA.add(sepApellido);
		boxATA.add(Box.createRigidArea(new Dimension(0, 35)));
		boxATA.add(ltipoDoc);
		boxATA.add(ctDoc);
		boxATA.add(sepTipoDoc);
		boxATA.add(Box.createRigidArea(new Dimension(0, 70)));
		boxATA.add(actualizar);

		boxNNE.add(Box.createRigidArea(new Dimension(220, 0)));
		boxNNE.add(Box.createRigidArea(new Dimension(0, 20)));
		boxNNE.add(lnombre);
		boxNNE.add(nombre);
		boxNNE.add(sepNombre);
		boxNNE.add(Box.createRigidArea(new Dimension(0, 35)));
		boxNNE.add(lnumeroDoc);
		boxNNE.add(numeroDoc);
		boxNNE.add(sepNumeroDoc);
		boxNNE.add(Box.createRigidArea(new Dimension(0, 70)));
		boxNNE.add(eliminar);

		flowBox.add(Box.createRigidArea(new Dimension(490, 0)));
		// flowBox.add(Box.createRigidArea(new Dimension(0, 80)));
		flowBox.add(boxNNE);
		flowBox.add(boxATA);

		panelDerecho.add(Box.createRigidArea(new Dimension(490, 0)));
		panelDerecho.add(Box.createRigidArea(new Dimension(0, 20)));
		panelDerecho.add(lusuario);
		panelDerecho.add(usuario);
		panelDerecho.add(sepUsuario);
		panelDerecho.add(Box.createRigidArea(new Dimension(0, 20)));
		panelDerecho.add(lcontraseña);
		panelDerecho.add(panelCotraseña);
		panelDerecho.add(sepContraseña);
		panelDerecho.add(Box.createRigidArea(new Dimension(0, 20)));
		panelDerecho.add(ltipo);
		panelDerecho.add(tipo);
		panelDerecho.add(sepTipo);
		panelDerecho.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDerecho.add(flowBox);

		titulo = new JLabel("Ver Usuarios");
		titulo.setFont(letraGoogle);
		titulo.setIcon(new ImageIcon("./imagenes/formulario.png"));

		atrasTitulo.add(Box.createRigidArea(new Dimension(-160, 0)));
		atrasTitulo.add(atras);
		atrasTitulo.add(Box.createRigidArea(new Dimension(100, 0)));
		atrasTitulo.add(titulo);
		atrasTitulo.setMaximumSize(new Dimension(480, 60));
		atrasTitulo.setPreferredSize(new Dimension(480, 60));
		atrasTitulo.setBackground(Color.WHITE);

		panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 25)));
		panelIzquierdo.add(atrasTitulo);
		panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 80)));
		panelIzquierdo.add(scroll);
		panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 80)));

		add(panelIzquierdo);
		add(panelDerecho);

	}

	public void actualizarJList() {
		jlistUsuarios.setListData(ventana.getControlador().verListaPerfiles()
				.toArray(new String[ventana.getControlador().verListaPerfiles().size()]));
	}

	private void listaMouseClicked(java.awt.event.MouseEvent evt) {

		if (evt.getButton() == 1) {
			int fila = jlistUsuarios.getSelectedIndex();
			ctDoc.setEnabled(true);
			String usuario1 = ventana.getControlador().getListaPerfiles().get(fila).getUsuario();
			String contraseña1 = ventana.getControlador().getListaPerfiles().get(fila).getContraseña();
			String tipoPerfil1 = String.valueOf(ventana.getControlador().getListaPerfiles().get(fila).getTipoPerfil());
			String nombre1 = ventana.getControlador().getListaPerfiles().get(fila).getNombre();
			String apellido1 = ventana.getControlador().getListaPerfiles().get(fila).getApellido();
			String numeroDoc1 = ventana.getControlador().getListaPerfiles().get(fila).getNumeroDoc();
			TipoDocumento tipoDoc1 = ventana.getControlador().getListaPerfiles().get(fila).getTipoDoc();

			usuario.setText(usuario1);
			contraseña.setText(contraseña1);
			tipo.setText(tipoPerfil1);
			nombre.setText(nombre1);
			apellido.setText(apellido1);
			numeroDoc.setText(numeroDoc1);
			ctDoc.setSelectedItem(tipoDoc1);
		}

	}

	public JPanel getPanelIzquierdo() {
		return panelIzquierdo;
	}

	public void setPanelIzquierdo(JPanel panelIzquierdo) {
		this.panelIzquierdo = panelIzquierdo;
	}

	public JPanel getPanelDerecho() {
		return panelDerecho;
	}

	public DefaultComboBoxModel<TipoDocumento> getBoxTipoDoc() {
		return boxTipoDoc;
	}

	public void setBoxTipoDoc(DefaultComboBoxModel<TipoDocumento> boxTipoDoc) {
		this.boxTipoDoc = boxTipoDoc;
	}

	public JComboBox<TipoDocumento> getCtDoc() {
		return ctDoc;
	}

	public void setCtDoc(JComboBox<TipoDocumento> ctDoc) {
		this.ctDoc = ctDoc;
	}

	public void setPanelDerecho(JPanel panelDerecho) {
		this.panelDerecho = panelDerecho;
	}

	public JPanel getBoxNNE() {
		return boxNNE;
	}

	public void setBoxNNE(JPanel boxNNE) {
		this.boxNNE = boxNNE;
	}

	public JPanel getBoxATA() {
		return boxATA;
	}

	public void setBoxATA(JPanel boxATA) {
		this.boxATA = boxATA;
	}

	public JPanel getFlowBox() {
		return flowBox;
	}

	public void setFlowBox(JPanel flowBox) {
		this.flowBox = flowBox;
	}

	public JPanel getAtrasTitulo() {
		return atrasTitulo;
	}

	public void setAtrasTitulo(JPanel atrasTitulo) {
		this.atrasTitulo = atrasTitulo;
	}

	public JPanel getPanelCotraseña() {
		return panelCotraseña;
	}

	public void setPanelCotraseña(JPanel panelCotraseña) {
		this.panelCotraseña = panelCotraseña;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JButton getVerOcultar() {
		return verOcultar;
	}

	public void setVerOcultar(JButton verOcultar) {
		this.verOcultar = verOcultar;
	}

	public JButton getAtras() {
		return atras;
	}

	public void setAtras(JButton atras) {
		this.atras = atras;
	}

	public VentanaPrincipal getVentana() {
		return ventana;
	}

	public void setVentana(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	public JList<String> getJlistUsuarios() {
		return jlistUsuarios;
	}

	public void setJlistUsuarios(JList<String> jlistUsuarios) {
		this.jlistUsuarios = jlistUsuarios;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public Font getLetraGoogle() {
		return letraGoogle;
	}

	public void setLetraGoogle(Font letraGoogle) {
		this.letraGoogle = letraGoogle;
	}

	public JTextField getUsuario() {
		return usuario;
	}

	public void setUsuario(JTextField usuario) {
		this.usuario = usuario;
	}

	public JPasswordField getContraseña() {
		return contraseña;
	}

	public void setContraseña(JPasswordField contraseña) {
		this.contraseña = contraseña;
	}

	public JLabel getTipo() {
		return tipo;
	}

	public void setTipo(JLabel tipo) {
		this.tipo = tipo;
	}

	public JTextField getNombre() {
		return nombre;
	}

	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	public JTextField getApellido() {
		return apellido;
	}

	public void setApellido(JTextField apellido) {
		this.apellido = apellido;
	}

	public JTextField getNumeroDoc() {
		return numeroDoc;
	}

	public void setNumeroDoc(JTextField numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

	public JLabel getLusuario() {
		return lusuario;
	}

	public void setLusuario(JLabel lusuario) {
		this.lusuario = lusuario;
	}

	public JLabel getLcontraseña() {
		return lcontraseña;
	}

	public void setLcontraseña(JLabel lcontraseña) {
		this.lcontraseña = lcontraseña;
	}

	public JLabel getLtipo() {
		return ltipo;
	}

	public void setLtipo(JLabel ltipo) {
		this.ltipo = ltipo;
	}

	public JLabel getLnombre() {
		return lnombre;
	}

	public void setLnombre(JLabel lnombre) {
		this.lnombre = lnombre;
	}

	public JLabel getLapellido() {
		return lapellido;
	}

	public void setLapellido(JLabel lapellido) {
		this.lapellido = lapellido;
	}

	public JLabel getLnumeroDoc() {
		return lnumeroDoc;
	}

	public void setLnumeroDoc(JLabel lnumeroDoc) {
		this.lnumeroDoc = lnumeroDoc;
	}

	public JLabel getLtipoDoc() {
		return ltipoDoc;
	}

	public void setLtipoDoc(JLabel ltipoDoc) {
		this.ltipoDoc = ltipoDoc;
	}

	public JSeparator getSepUsuario() {
		return sepUsuario;
	}

	public void setSepUsuario(JSeparator sepUsuario) {
		this.sepUsuario = sepUsuario;
	}

	public JSeparator getSepContraseña() {
		return sepContraseña;
	}

	public void setSepContraseña(JSeparator sepContraseña) {
		this.sepContraseña = sepContraseña;
	}

	public JSeparator getSepTipo() {
		return sepTipo;
	}

	public void setSepTipo(JSeparator sepTipo) {
		this.sepTipo = sepTipo;
	}

	public JSeparator getSepNombre() {
		return sepNombre;
	}

	public void setSepNombre(JSeparator sepNombre) {
		this.sepNombre = sepNombre;
	}

	public JSeparator getSepApellido() {
		return sepApellido;
	}

	public void setSepApellido(JSeparator sepApellido) {
		this.sepApellido = sepApellido;
	}

	public JSeparator getSepNumeroDoc() {
		return sepNumeroDoc;
	}

	public void setSepNumeroDoc(JSeparator sepNumeroDoc) {
		this.sepNumeroDoc = sepNumeroDoc;
	}

	public JSeparator getSepTipoDoc() {
		return sepTipoDoc;
	}

	public void setSepTipoDoc(JSeparator sepTipoDoc) {
		this.sepTipoDoc = sepTipoDoc;
	}

	public JButton getEliminar() {
		return eliminar;
	}

	public void setEliminar(JButton eliminar) {
		this.eliminar = eliminar;
	}

	public JButton getActualizar() {
		return actualizar;
	}

	public void setActualizar(JButton actualizar) {
		this.actualizar = actualizar;
	}

}
