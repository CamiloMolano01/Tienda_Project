package co.edu.uptc.vista.paneles;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import co.edu.uptc.modelo.TipoDocumento;
import co.edu.uptc.modelo.TipoPerfil;
import co.edu.uptc.vista.VentanaPrincipal;

public class PanelCrearUsuario extends JPanel {

	private VentanaPrincipal ventana;

	private Font letraGoogle;

	private JPanel datos1;
	private JPanel datos2;
	private JPanel panelseparador;
	private JPanel salirTitulo;

	private JPanel panelCotraseña;
	private JPanel panelConfCotraseña;

	private JTextField usuario;
	private JPasswordField contraseña;
	private JPasswordField confContra;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField numeroDoc;

	private JButton atras;
	private JButton crear;
	private JButton verOcultar1;
	private JButton verOcultar2;

	private JLabel titulo;

	private JSeparator sepUsuario;
	private JSeparator sepContraseña;
	private JSeparator sepConfirmarContraseña;
	private JSeparator sepNombre;
	private JSeparator sepApellido;
	private JSeparator sepNumeroDoc;

	private JSeparator separadorVertical;

	private DefaultComboBoxModel<TipoPerfil> boxTipoPerfil;
	private JComboBox<TipoPerfil> ctPerfil;

	private DefaultComboBoxModel<TipoDocumento> boxTipoDoc;
	private JComboBox<TipoDocumento> ctDoc;

	private TextPrompt promptUsuario;
	private TextPrompt promptContraseña;
	private TextPrompt promptConfirmarC;
	private TextPrompt promptNombre;
	private TextPrompt promptApellido;
	private TextPrompt promptNumeroDoc;

	public PanelCrearUsuario(VentanaPrincipal ventana) {
		this.ventana = ventana;
		setLayout(new FlowLayout());
		setBackground(Color.WHITE);

		letraGoogle = new Font("Open Sans", Font.BOLD, 15);

		verOcultar1 = new JButton();
		verOcultar1.setIcon(new ImageIcon("./imagenes/contraseña.png"));
		verOcultar1.setPreferredSize(new Dimension(25, 25));
		verOcultar1.setFocusPainted(false);
		verOcultar1.setBorderPainted(false);
		verOcultar1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		verOcultar1.setBackground(Color.WHITE);
		verOcultar1.addMouseListener(ventana.getBotonListener());

		verOcultar2 = new JButton();
		verOcultar2.setIcon(new ImageIcon("./imagenes/contraseña.png"));
		verOcultar2.setPreferredSize(new Dimension(25, 25));
		verOcultar2.setFocusPainted(false);
		verOcultar2.setBorderPainted(false);
		verOcultar2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		verOcultar2.setBackground(Color.WHITE);
		verOcultar2.addMouseListener(ventana.getBotonListener());

		salirTitulo = new JPanel();
		salirTitulo.setLayout(new FlowLayout());

		panelCotraseña = new JPanel();
		panelCotraseña.setLayout(new FlowLayout());

		panelConfCotraseña = new JPanel();
		panelConfCotraseña.setLayout(new FlowLayout());

		panelseparador = new JPanel();
		panelseparador.setLayout(new BoxLayout(panelseparador, BoxLayout.Y_AXIS));
		panelseparador.setBackground(Color.WHITE);

		separadorVertical = new JSeparator(SwingConstants.VERTICAL);
		separadorVertical.setPreferredSize(new Dimension(2, 500));
		separadorVertical.setBackground(Color.WHITE);

		sepUsuario = new JSeparator();
		sepUsuario.setBackground(ventana.getColorBase());
		sepUsuario.setMaximumSize(new Dimension(350, 2));
		sepUsuario.setPreferredSize(new Dimension(350, 2));

		sepContraseña = new JSeparator();
		sepContraseña.setBackground(ventana.getColorBase());
		sepContraseña.setMaximumSize(new Dimension(350, 2));
		sepContraseña.setPreferredSize(new Dimension(350, 2));

		sepConfirmarContraseña = new JSeparator();
		sepConfirmarContraseña.setBackground(ventana.getColorBase());
		sepConfirmarContraseña.setMaximumSize(new Dimension(350, 2));
		sepConfirmarContraseña.setPreferredSize(new Dimension(350, 2));

		sepNombre = new JSeparator();
		sepNombre.setBackground(ventana.getColorBase());
		sepNombre.setMaximumSize(new Dimension(350, 2));
		sepNombre.setPreferredSize(new Dimension(350, 2));

		sepApellido = new JSeparator();
		sepApellido.setBackground(ventana.getColorBase());
		sepApellido.setMaximumSize(new Dimension(350, 2));
		sepApellido.setPreferredSize(new Dimension(350, 2));

		sepNumeroDoc = new JSeparator();
		sepNumeroDoc.setBackground(ventana.getColorBase());
		sepNumeroDoc.setMaximumSize(new Dimension(350, 2));
		sepNumeroDoc.setPreferredSize(new Dimension(350, 2));

		boxTipoPerfil = new DefaultComboBoxModel<>(TipoPerfil.values());
		boxTipoDoc = new DefaultComboBoxModel<>(TipoDocumento.values());

		ctPerfil = new JComboBox<>(boxTipoPerfil);
		ctPerfil.setMaximumSize(new Dimension(200, 30));
		ctPerfil.setPreferredSize(new Dimension(200, 30));
		ctPerfil.setFont(letraGoogle);
		ctPerfil.setEnabled(false);

		ctDoc = new JComboBox<>(boxTipoDoc);
		ctDoc.setMaximumSize(new Dimension(200, 30));
		ctDoc.setPreferredSize(new Dimension(200, 30));
		ctDoc.setFont(letraGoogle);

		usuario = new JTextField();
		usuario.setMaximumSize(new Dimension(350, 30));
		usuario.setPreferredSize(new Dimension(350, 30));
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
		contraseña.setMaximumSize(new Dimension(350, 30));
		contraseña.setPreferredSize(new Dimension(350, 30));
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

		confContra = new JPasswordField();
		confContra.setMaximumSize(new Dimension(350, 30));
		confContra.setPreferredSize(new Dimension(350, 30));
		confContra.setFont(letraGoogle);
		confContra.setHorizontalAlignment(JTextField.CENTER);
		confContra.setOpaque(false);
		confContra.setBorder(null);
		confContra.setEchoChar('*');
		confContra.setForeground(Color.BLACK);
		confContra.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (confContra.getPassword().length == 18) {
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
		nombre.setMaximumSize(new Dimension(350, 30));
		nombre.setPreferredSize(new Dimension(350, 30));
		nombre.setFont(letraGoogle);
		nombre.setHorizontalAlignment(JTextField.CENTER);
		nombre.setOpaque(false);
		nombre.setBorder(null);
		nombre.setForeground(Color.BLACK);
		nombre.setCaretColor(Color.BLACK);

		apellido = new JTextField();
		apellido.setMaximumSize(new Dimension(350, 30));
		apellido.setPreferredSize(new Dimension(350, 30));
		apellido.setFont(letraGoogle);
		apellido.setHorizontalAlignment(JTextField.CENTER);
		apellido.setOpaque(false);
		apellido.setBorder(null);
		apellido.setForeground(Color.BLACK);
		apellido.setCaretColor(Color.BLACK);

		numeroDoc = new JTextField();
		numeroDoc.setMaximumSize(new Dimension(350, 30));
		numeroDoc.setPreferredSize(new Dimension(350, 30));
		numeroDoc.setFont(letraGoogle);
		numeroDoc.setHorizontalAlignment(JTextField.CENTER);
		numeroDoc.setOpaque(false);
		numeroDoc.setBorder(null);
		numeroDoc.setForeground(Color.BLACK);
		numeroDoc.setCaretColor(Color.BLACK);

		promptUsuario = new TextPrompt("                      Ingrese el usuario", usuario);
		promptUsuario.changeAlpha(0.35f);

		promptContraseña = new TextPrompt("                   Ingrese la contraseña", contraseña);
		promptContraseña.changeAlpha(0.35f);

		promptConfirmarC = new TextPrompt("                 Confirme la contraseña", confContra);
		promptConfirmarC.changeAlpha(0.35f);

		promptNombre = new TextPrompt("                    Ingrese el nombre", nombre);
		promptNombre.changeAlpha(0.35f);

		promptApellido = new TextPrompt("                    Ingrese el apellido", apellido);
		promptApellido.changeAlpha(0.35f);

		promptNumeroDoc = new TextPrompt("           Ingrese el numero de documento", numeroDoc);
		promptNumeroDoc.changeAlpha(0.35f);

		atras = new JButton();
		atras.setIcon(new ImageIcon("./imagenes/atras.png"));
		atras.setBackground(ventana.getColorBase());
		atras.setFocusPainted(false);
		atras.setBorderPainted(false);
		atras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		atras.setActionCommand("atras");
		atras.addActionListener(ventana.getEventos());

		crear = new JButton("CREAR");
		crear.setForeground(Color.white);
		crear.setBackground(ventana.getColorBase());
		crear.setFocusPainted(false);
		crear.setBorderPainted(false);
		crear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		crear.setIcon(new ImageIcon("./imagenes/botonAgrega.png"));
		crear.setPreferredSize(new Dimension(90, 50));
		crear.setAlignmentX(CENTER_ALIGNMENT);
		crear.setActionCommand("crear");
		crear.addActionListener(ventana.getEventos());

		titulo = new JLabel("Crear usuario");
		titulo.setFont(letraGoogle);
		titulo.setIcon(new ImageIcon("./imagenes/formulario.png"));

		salirTitulo.add(Box.createRigidArea(new Dimension(-160, 0)));
		salirTitulo.add(atras);
		salirTitulo.add(Box.createRigidArea(new Dimension(100, 0)));
		salirTitulo.add(titulo);
		salirTitulo.setMaximumSize(new Dimension(480, 60));
		salirTitulo.setPreferredSize(new Dimension(480, 60));
		salirTitulo.setBackground(Color.WHITE);

		panelCotraseña.setMaximumSize(new Dimension(415, 31));
		panelCotraseña.add(Box.createRigidArea(new Dimension(17, 0)));
		panelCotraseña.setBackground(Color.WHITE);
		panelCotraseña.add(contraseña);
		panelCotraseña.add(verOcultar1);

		panelConfCotraseña.setMaximumSize(new Dimension(415, 31));
		panelConfCotraseña.add(Box.createRigidArea(new Dimension(17, 0)));
		panelConfCotraseña.setBackground(Color.WHITE);
		panelConfCotraseña.add(confContra);
		panelConfCotraseña.add(verOcultar2);

		datos1 = new JPanel();
		datos1.setLayout(new BoxLayout(datos1, BoxLayout.Y_AXIS));
		datos1.setBackground(Color.WHITE);
		datos1.setPreferredSize(new Dimension(480, 500));

		datos2 = new JPanel();
		datos2.setLayout(new BoxLayout(datos2, BoxLayout.Y_AXIS));
		datos2.setBackground(Color.WHITE);
		datos2.setPreferredSize(new Dimension(480, 550));

		// datos1.add(Box.createRigidArea(new Dimension(0, -55)));
		datos1.add(Box.createRigidArea(new Dimension(480, 0)));
		datos1.add(salirTitulo);

		datos1.add(Box.createRigidArea(new Dimension(0, 55)));
		datos1.add(usuario);
		datos1.add(sepUsuario);
		datos1.add(Box.createRigidArea(new Dimension(0, 55)));
		datos1.add(panelCotraseña);
		datos1.add(Box.createRigidArea(new Dimension(-3, 0)));
		datos1.add(sepContraseña);
		datos1.add(Box.createRigidArea(new Dimension(0, 55)));
		datos1.add(panelConfCotraseña);
		datos1.add(sepConfirmarContraseña);
		datos1.add(Box.createRigidArea(new Dimension(0, 55)));
		datos1.add(ctPerfil);

		// datos2.add(Box.createRigidArea(new Dimension(0, 55)));
		datos2.add(Box.createRigidArea(new Dimension(480, 70)));
		datos2.add(nombre);
		datos2.add(sepNombre);
		datos2.add(Box.createRigidArea(new Dimension(0, 55)));
		datos2.add(apellido);
		datos2.add(sepApellido);
		datos2.add(Box.createRigidArea(new Dimension(0, 55)));
		datos2.add(ctDoc);
		datos2.add(Box.createRigidArea(new Dimension(0, 55)));
		datos2.add(numeroDoc);
		datos2.add(sepNumeroDoc);
		datos2.add(Box.createRigidArea(new Dimension(0, 70)));
		datos2.add(crear);

		panelseparador.add(Box.createRigidArea(new Dimension(0, 30)));
		panelseparador.add(separadorVertical);

		add(datos1);
		add(Box.createRigidArea(new Dimension(0, 0)));
		add(panelseparador);
		add(Box.createRigidArea(new Dimension(0, 0)));
		add(datos2);

	}

	public VentanaPrincipal getVentana() {
		return ventana;
	}

	public void setVentana(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}
	
	

	public Font getLetraGoogle() {
		return letraGoogle;
	}

	public void setLetraGoogle(Font letraGoogle) {
		this.letraGoogle = letraGoogle;
	}

	public JPanel getDatos1() {
		return datos1;
	}

	public void setDatos1(JPanel datos1) {
		this.datos1 = datos1;
	}

	public JPanel getDatos2() {
		return datos2;
	}

	public void setDatos2(JPanel datos2) {
		this.datos2 = datos2;
	}
	
	

	public JPanel getPanelseparador() {
		return panelseparador;
	}

	public void setPanelseparador(JPanel panelseparador) {
		this.panelseparador = panelseparador;
	}

	public JPanel getSalirTitulo() {
		return salirTitulo;
	}

	public void setSalirTitulo(JPanel salirTitulo) {
		this.salirTitulo = salirTitulo;
	}

	public JPanel getPanelCotraseña() {
		return panelCotraseña;
	}

	public void setPanelCotraseña(JPanel panelCotraseña) {
		this.panelCotraseña = panelCotraseña;
	}

	public JPanel getPanelConfCotraseña() {
		return panelConfCotraseña;
	}

	public void setPanelConfCotraseña(JPanel panelConfCotraseña) {
		this.panelConfCotraseña = panelConfCotraseña;
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

	public JButton getAtras() {
		return atras;
	}

	public void setAtras(JButton atras) {
		this.atras = atras;
	}

	public JButton getCrear() {
		return crear;
	}

	public void setCrear(JButton crear) {
		this.crear = crear;
	}

	public JButton getVerOcultar1() {
		return verOcultar1;
	}

	public void setVerOcultar1(JButton verOcultar1) {
		this.verOcultar1 = verOcultar1;
	}

	public JButton getVerOcultar2() {
		return verOcultar2;
	}

	public void setVerOcultar2(JButton verOcultar2) {
		this.verOcultar2 = verOcultar2;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
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

	public JSeparator getSepConfirmarContraseña() {
		return sepConfirmarContraseña;
	}

	public void setSepConfirmarContraseña(JSeparator sepConfirmarContraseña) {
		this.sepConfirmarContraseña = sepConfirmarContraseña;
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

	public JSeparator getSeparadorVertical() {
		return separadorVertical;
	}

	public void setSeparadorVertical(JSeparator separadorVertical) {
		this.separadorVertical = separadorVertical;
	}

	public DefaultComboBoxModel<TipoPerfil> getBoxTipoPerfil() {
		return boxTipoPerfil;
	}

	public void setBoxTipoPerfil(DefaultComboBoxModel<TipoPerfil> boxTipoPerfil) {
		this.boxTipoPerfil = boxTipoPerfil;
	}

	public DefaultComboBoxModel<TipoDocumento> getBoxTipoDoc() {
		return boxTipoDoc;
	}

	public void setBoxTipoDoc(DefaultComboBoxModel<TipoDocumento> boxTipoDoc) {
		this.boxTipoDoc = boxTipoDoc;
	}

	public JPasswordField getConfContra() {
		return confContra;
	}

	public void setConfContra(JPasswordField confContra) {
		this.confContra = confContra;
	}

	public JComboBox<TipoPerfil> getCtPerfil() {
		return ctPerfil;
	}

	public void setCtPerfil(JComboBox<TipoPerfil> ctPerfil) {
		this.ctPerfil = ctPerfil;
	}

	public JComboBox<TipoDocumento> getCtDoc() {
		return ctDoc;
	}

	public void setCtDoc(JComboBox<TipoDocumento> ctDoc) {
		this.ctDoc = ctDoc;
	}

	public TextPrompt getPromptUsuario() {
		return promptUsuario;
	}

	public void setPromptUsuario(TextPrompt promptUsuario) {
		this.promptUsuario = promptUsuario;
	}

	public TextPrompt getPromptContraseña() {
		return promptContraseña;
	}

	public void setPromptContraseña(TextPrompt promptContraseña) {
		this.promptContraseña = promptContraseña;
	}

	public TextPrompt getPromptConfirmarC() {
		return promptConfirmarC;
	}

	public void setPromptConfirmarC(TextPrompt promptConfirmarC) {
		this.promptConfirmarC = promptConfirmarC;
	}

	public TextPrompt getPromptNombre() {
		return promptNombre;
	}

	public void setPromptNombre(TextPrompt promptNombre) {
		this.promptNombre = promptNombre;
	}

	public TextPrompt getPromptApellido() {
		return promptApellido;
	}

	public void setPromptApellido(TextPrompt promptApellido) {
		this.promptApellido = promptApellido;
	}

	public TextPrompt getPromptNumeroDoc() {
		return promptNumeroDoc;
	}

	public void setPromptNumeroDoc(TextPrompt promptNumeroDoc) {
		this.promptNumeroDoc = promptNumeroDoc;
	}

}
