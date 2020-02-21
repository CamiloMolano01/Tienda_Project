
package co.edu.uptc.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import co.edu.uptc.vista.eventos.ISActionComand;
import co.edu.uptc.vista.eventos.ISBotonListener;
import co.edu.uptc.vista.paneles.TextPrompt;

public class InicioSesion extends JFrame {

	private String sesionTitulo;
	private String tienda;
	private String nombreIngresado;
	private Font letraLobster;
	private Font letraGoogle;

	private VentanaPrincipal ventanaP;

	private JPanel panelDual;
	private JPanel panelIcono;
	private JPanel panelIniciarSesion;
	private JPanel panelCotrase�a;
	private JPanel panelRegistrarse;
	private JPanel panelLetra;

	private JTextField nombreUsuario;
	private JPasswordField contrase�a;

	private JLabel logo;
	private ImageIcon Ilogo;

	private JButton verOcultar;

	private JLabel imagen;
	private ImageIcon icono;

	private JLabel nombreTienda;
	private ImageIcon iconoVer;

	private ISBotonListener botonlis;
	private ISActionComand actionlis;

	private JSeparator sepUsuario;
	private JSeparator sepContrase�a;

	private TextPrompt promptUsuario;
	private TextPrompt promptContrase�a;

	private JButton entrar;

	public InicioSesion() throws IOException {
		setTitle(sesionTitulo);
		setSize(800, 600);
		setResizable(false);
		setLayout(new BorderLayout());
		
		ventanaP = new VentanaPrincipal();
		botonlis = new ISBotonListener(this);
		actionlis = new ISActionComand(this);
		
		ventanaP.getControlador().leerListaPerfiles();
		ventanaP.getControlador().leerListaProductos();

		tienda = "Tienda Natalita\n Project";
		iconoVer = new ImageIcon("./imagenes/contrase�a.png");

		verOcultar = new JButton();
		verOcultar.setIcon(iconoVer);
		verOcultar.setPreferredSize(new Dimension(25, 25));
		verOcultar.setFocusPainted(false);
		verOcultar.setBorderPainted(false);
		verOcultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		verOcultar.setBackground(new Color(0, 77, 77));
		verOcultar.addMouseListener(botonlis);

		entrar = new JButton("Entrar");
		entrar.setMaximumSize(new Dimension(80, 30));
		entrar.setBackground(new Color(0, 153, 153));
		entrar.setFont(letraGoogle);
		entrar.setForeground(Color.WHITE);
		entrar.setAlignmentX(CENTER_ALIGNMENT);
		entrar.setActionCommand("entrar");
		entrar.addActionListener(actionlis);

		letraLobster = new Font("Lobster", Font.BOLD, 42);
		letraGoogle = new Font("Open Sans", Font.BOLD, 15);

		sepUsuario = new JSeparator();
		sepUsuario.setBackground(Color.white);
		sepUsuario.setMaximumSize(new Dimension(230, 1));

		sepContrase�a = new JSeparator();
		sepContrase�a.setBackground(Color.white);
		sepContrase�a.setMaximumSize(new Dimension(230, 1));

		nombreTienda = new JLabel("<html><div style='text-align: center;'>Tienda Natalita<br>Project</div></html>");
		nombreTienda.setForeground(Color.BLACK);
		nombreTienda.setFont(letraLobster);

		panelCotrase�a = new JPanel();
		panelCotrase�a.setLayout(new FlowLayout());

		panelDual = new JPanel();
		panelDual.setLayout(new FlowLayout());

		panelLetra = new JPanel();
		panelLetra.setLayout(new FlowLayout());
		panelLetra.setBackground(new Color(0, 153, 153));
		panelLetra.setPreferredSize(new Dimension(370, 300));
		panelLetra.add(Box.createRigidArea(new Dimension(0, 150)));
		panelLetra.add(nombreTienda);

		panelIcono = new JPanel();
		panelIcono.setLayout(new BorderLayout());
		panelIcono.setBackground(new Color(0, 153, 153));
		panelIcono.setPreferredSize(new Dimension(370, 290));

		panelIniciarSesion = new JPanel();
		panelIniciarSesion.setBackground(new Color(0, 77, 77));
		panelIniciarSesion.setLayout(new BoxLayout(panelIniciarSesion, BoxLayout.Y_AXIS));

		nombreUsuario = new JTextField();
		nombreUsuario.setMaximumSize(new Dimension(220, 30));
		nombreUsuario.setHorizontalAlignment(JTextField.CENTER);
		nombreUsuario.setOpaque(false);
		nombreUsuario.setBorder(null);
		nombreUsuario.setForeground(Color.WHITE);
		nombreUsuario.setCaretColor(Color.white);
		nombreUsuario.setFont(letraGoogle);
		nombreUsuario.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (nombreUsuario.getText().length() == 25) {
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

		contrase�a = new JPasswordField();
		contrase�a.setPreferredSize(new Dimension(220, 30));
		contrase�a.setEchoChar('*');
		contrase�a.setHorizontalAlignment(JTextField.CENTER);
		contrase�a.setOpaque(false);
		contrase�a.setBorder(null);
		contrase�a.setForeground(Color.WHITE);
		contrase�a.setCaretColor(Color.white);
		contrase�a.setFont(letraGoogle);
		contrase�a.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (contrase�a.getPassword().length == 18) {
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

		promptUsuario = new TextPrompt("        Ingrese el usuario", nombreUsuario);
		promptUsuario.changeAlpha(0.35f);

		promptContrase�a = new TextPrompt("      Ingrese la contrase�a", contrase�a);
		promptContrase�a.changeAlpha(0.35f);

		panelCotrase�a.setMaximumSize(new Dimension(450, 32));
		panelCotrase�a.setBackground(new Color(0, 77, 77));
		panelCotrase�a.add(Box.createRigidArea(new Dimension(25, 0)));
		panelCotrase�a.add(contrase�a);
		panelCotrase�a.add(verOcultar);

		logo = new JLabel();
		Ilogo = new ImageIcon("./imagenes/loginUsuario.png");
		logo.setIcon(Ilogo);
		logo.setAlignmentX(CENTER_ALIGNMENT);

		panelIniciarSesion.add(Box.createRigidArea(new Dimension(430, 100)));
		panelIniciarSesion.add(logo);
		panelIniciarSesion.add(Box.createRigidArea(new Dimension(0, 40)));
		panelIniciarSesion.add(nombreUsuario);
		panelIniciarSesion.add(sepUsuario);
		panelIniciarSesion.add(Box.createRigidArea(new Dimension(0, 30)));
		panelIniciarSesion.add(panelCotrase�a);
		panelIniciarSesion.add(sepContrase�a);
		panelIniciarSesion.add(Box.createRigidArea(new Dimension(0, 30)));
		panelIniciarSesion.add(entrar);

		imagen = new JLabel();
		icono = new ImageIcon("./imagenes/logoTiendaGrande.png");
		imagen.setIcon(icono);

		panelRegistrarse = new JPanel();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		panelIcono.add(Box.createRigidArea(new Dimension(65, 0)), BorderLayout.WEST);
		panelIcono.add(imagen, BorderLayout.CENTER);

		panelLetra.add(panelIcono);

		add(panelLetra, BorderLayout.WEST);
		add(panelIniciarSesion, BorderLayout.CENTER);
	}

	public static void main(String[] args) throws IOException {

		new InicioSesion();
	}

	public String getNombreIngresado() {
		return nombreIngresado;
	}

	public void setNombreIngresado(String nombreIngresado) {
		this.nombreIngresado = nombreIngresado;
	}

	public JSeparator getSepUsuario() {
		return sepUsuario;
	}

	public void setSepUsuario(JSeparator sepUsuario) {
		this.sepUsuario = sepUsuario;
	}

	public JSeparator getSepContrase�a() {
		return sepContrase�a;
	}

	public void setSepContrase�a(JSeparator sepContrase�a) {
		this.sepContrase�a = sepContrase�a;
	}

	public Font getLetraLobster() {
		return letraLobster;
	}

	public void setLetraLobster(Font letraLobster) {
		this.letraLobster = letraLobster;
	}

	public Font getLetraGoogle() {
		return letraGoogle;
	}

	public void setLetraGoogle(Font letraGoogle) {
		this.letraGoogle = letraGoogle;
	}

	public VentanaPrincipal getVentanaP() {
		return ventanaP;
	}

	public void setVentanaP(VentanaPrincipal ventanaP) {
		this.ventanaP = ventanaP;
	}

	public JLabel getLogo() {
		return logo;
	}

	public void setLogo(JLabel logo) {
		this.logo = logo;
	}

	public ImageIcon getIlogo() {
		return Ilogo;
	}

	public void setIlogo(ImageIcon ilogo) {
		Ilogo = ilogo;
	}

	public JSeparator getSeparadorUsuario() {
		return sepUsuario;
	}

	public void setSeparadorUsuario(JSeparator separadorUsuario) {
		this.sepUsuario = separadorUsuario;
	}

	public JSeparator getSeparadorContrase�a() {
		return sepContrase�a;
	}

	public void setSeparadorContrase�a(JSeparator separadorContrase�a) {
		this.sepContrase�a = separadorContrase�a;
	}

	public TextPrompt getPromptUsuario() {
		return promptUsuario;
	}

	public void setPromptUsuario(TextPrompt promptUsuario) {
		this.promptUsuario = promptUsuario;
	}

	public TextPrompt getPromptContrase�a() {
		return promptContrase�a;
	}

	public void setPromptContrase�a(TextPrompt promptContrase�a) {
		this.promptContrase�a = promptContrase�a;
	}

	public ISActionComand getActionlis() {
		return actionlis;
	}

	public void setActionlis(ISActionComand actionlis) {
		this.actionlis = actionlis;
	}

	public ISBotonListener getBotonlis() {
		return botonlis;
	}

	public void setBotonlis(ISBotonListener botonlis) {
		this.botonlis = botonlis;
	}

	public JButton getEntrar() {
		return entrar;
	}

	public void setEntrar(JButton entrar) {
		this.entrar = entrar;
	}

	public String getSesionTitulo() {
		return sesionTitulo;
	}

	public void setSesionTitulo(String sesionTitulo) {
		this.sesionTitulo = sesionTitulo;
	}

	public String getTienda() {
		return tienda;
	}

	public void setTienda(String tienda) {
		this.tienda = tienda;
	}

	public Font getLetraTipo() {
		return letraLobster;
	}

	public void setLetraTipo(Font letraTipo) {
		this.letraLobster = letraTipo;
	}

	public JPanel getPanelDual() {
		return panelDual;
	}

	public void setPanelDual(JPanel panelDual) {
		this.panelDual = panelDual;
	}

	public JPanel getPanelIcono() {
		return panelIcono;
	}

	public void setPanelIcono(JPanel panelIcono) {
		this.panelIcono = panelIcono;
	}

	public JPanel getPanelIniciarSesion() {
		return panelIniciarSesion;
	}

	public void setPanelIniciarSesion(JPanel panelIniciarSesion) {
		this.panelIniciarSesion = panelIniciarSesion;
	}

	public JPanel getPanelCotrase�a() {
		return panelCotrase�a;
	}

	public void setPanelCotrase�a(JPanel panelCotrase�a) {
		this.panelCotrase�a = panelCotrase�a;
	}

	public JPanel getPanelRegistrarse() {
		return panelRegistrarse;
	}

	public void setPanelRegistrarse(JPanel panelRegistrarse) {
		this.panelRegistrarse = panelRegistrarse;
	}

	public JPanel getPanelLetra() {
		return panelLetra;
	}

	public void setPanelLetra(JPanel panelLetra) {
		this.panelLetra = panelLetra;
	}

	public JTextField getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(JTextField nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public JPasswordField getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(JPasswordField contrase�a) {
		this.contrase�a = contrase�a;
	}

	public JButton getVerOcultar() {
		return verOcultar;
	}

	public void setVerOcultar(JButton verOcultar) {
		this.verOcultar = verOcultar;
	}

	public JLabel getImagen() {
		return imagen;
	}

	public void setImagen(JLabel imagen) {
		this.imagen = imagen;
	}

	public ImageIcon getIcono() {
		return icono;
	}

	public void setIcono(ImageIcon icono) {
		this.icono = icono;
	}

	public JLabel getNombreTienda() {
		return nombreTienda;
	}

	public void setNombreTienda(JLabel nombreTienda) {
		this.nombreTienda = nombreTienda;
	}

	public ImageIcon getIconoVer() {
		return iconoVer;
	}

	public void setIconoVer(ImageIcon iconoVer) {
		this.iconoVer = iconoVer;
	}

}
