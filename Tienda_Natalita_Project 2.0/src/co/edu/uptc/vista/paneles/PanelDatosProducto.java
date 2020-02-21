package co.edu.uptc.vista.paneles;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import co.edu.uptc.modelo.Categoria;
import co.edu.uptc.modelo.SubCategoria;
import co.edu.uptc.vista.VentanaPrincipal;

public class PanelDatosProducto extends JPanel {

	private VentanaPrincipal ventana;
	private JPanel datos1;
	private JPanel datos2;
	private JPanel panelseparador;
	private JSeparator separadorVertical;
	private JPanel panelCategoria;
	private JPanel atrasTitulo;

	private JSeparator sepCodigo;
	private JSeparator sepNombre;
	private JSeparator sepMarca;
	private JSeparator sepDescripcion;
	private JSeparator sepCantidad;
	private JSeparator sepPrecioProveedor;
	private JSeparator sepPrecioVenta;

	private JTextField codigo;
	private JTextField nombre;
	private JTextField marca;
	private JTextField descripcion;
	private JTextField cantidad;
	private JComboBox<Categoria> ctCategoria;
	private JComboBox<SubCategoria> ctSubCategoria;
	private JTextField precioProveedor;
	private JTextField precioVenta;

	private TextPrompt promptCodigo;
	private TextPrompt promptNombre;
	private TextPrompt promptMarca;
	private TextPrompt promptDescripcion;
	private TextPrompt promptCantidad;
	private TextPrompt promptProveedor;
	private TextPrompt promptVenta;

	private Font letraGoogle;

	private JLabel titulo;
	private JButton atras;
	private JButton accionPro;

	public PanelDatosProducto(VentanaPrincipal ventana) {
		this.ventana = ventana;
		setLayout(new FlowLayout());
		setBackground(Color.WHITE);

		letraGoogle = new Font("Open Sans", Font.BOLD, 15);

		atrasTitulo = new JPanel();
		atrasTitulo.setLayout(new FlowLayout());

		panelCategoria = new JPanel();
		panelCategoria.setLayout(new FlowLayout());
		panelCategoria.setPreferredSize(new Dimension(460, 50));
		panelCategoria.setMaximumSize(new Dimension(460, 50));
		panelCategoria.setMinimumSize(new Dimension(460, 50));
		panelCategoria.setBackground(Color.white);

		panelseparador = new JPanel();
		panelseparador.setLayout(new BoxLayout(panelseparador, BoxLayout.Y_AXIS));
		panelseparador.setBackground(Color.WHITE);

		separadorVertical = new JSeparator(SwingConstants.VERTICAL);
		separadorVertical.setPreferredSize(new Dimension(2, 500));
		separadorVertical.setBackground(Color.WHITE);

		codigo = new JTextField();
		codigo.setMaximumSize(new Dimension(350, 30));
		codigo.setPreferredSize(new Dimension(350, 30));
		codigo.setFont(letraGoogle);
		codigo.setHorizontalAlignment(JTextField.CENTER);
		codigo.setOpaque(false);
		codigo.setBorder(null);
		codigo.setForeground(Color.BLACK);
		codigo.setCaretColor(Color.BLACK);

		nombre = new JTextField();
		nombre.setMaximumSize(new Dimension(350, 30));
		nombre.setPreferredSize(new Dimension(350, 30));
		nombre.setFont(letraGoogle);
		nombre.setHorizontalAlignment(JTextField.CENTER);
		nombre.setOpaque(false);
		nombre.setBorder(null);
		nombre.setForeground(Color.BLACK);
		nombre.setCaretColor(Color.BLACK);

		marca = new JTextField();
		marca.setMaximumSize(new Dimension(350, 30));
		marca.setPreferredSize(new Dimension(350, 30));
		marca.setFont(letraGoogle);
		marca.setHorizontalAlignment(JTextField.CENTER);
		marca.setOpaque(false);
		marca.setBorder(null);
		marca.setForeground(Color.BLACK);
		marca.setCaretColor(Color.BLACK);

		descripcion = new JTextField();
		descripcion.setMaximumSize(new Dimension(350, 30));
		descripcion.setPreferredSize(new Dimension(350, 30));
		descripcion.setFont(letraGoogle);
		descripcion.setHorizontalAlignment(JTextField.CENTER);
		descripcion.setOpaque(false);
		descripcion.setBorder(null);
		descripcion.setForeground(Color.BLACK);
		descripcion.setCaretColor(Color.BLACK);

		cantidad = new JTextField();
		cantidad.setMaximumSize(new Dimension(350, 30));
		cantidad.setPreferredSize(new Dimension(350, 30));
		cantidad.setFont(letraGoogle);
		cantidad.setHorizontalAlignment(JTextField.CENTER);
		cantidad.setOpaque(false);
		cantidad.setBorder(null);
		cantidad.setForeground(Color.BLACK);
		cantidad.setCaretColor(Color.BLACK);

		precioProveedor = new JTextField();
		precioProveedor.setMaximumSize(new Dimension(350, 30));
		precioProveedor.setPreferredSize(new Dimension(350, 30));
		precioProveedor.setFont(letraGoogle);
		precioProveedor.setHorizontalAlignment(JTextField.CENTER);
		precioProveedor.setOpaque(false);
		precioProveedor.setBorder(null);
		precioProveedor.setForeground(Color.BLACK);
		precioProveedor.setCaretColor(Color.BLACK);

		precioVenta = new JTextField();
		precioVenta.setMaximumSize(new Dimension(350, 30));
		precioVenta.setPreferredSize(new Dimension(350, 30));
		precioVenta.setFont(letraGoogle);
		precioVenta.setHorizontalAlignment(JTextField.CENTER);
		precioVenta.setOpaque(false);
		precioVenta.setBorder(null);
		precioVenta.setForeground(Color.BLACK);
		precioVenta.setCaretColor(Color.BLACK);

		atras = new JButton();
		atras.setIcon(new ImageIcon("./imagenes/atras.png"));
		atras.setBackground(ventana.getColorBase());
		atras.setFocusPainted(false);
		atras.setBorderPainted(false);
		atras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		atras.setActionCommand("atrasPro");
		atras.addActionListener(ventana.getEventos());

		titulo = new JLabel();
		titulo.setFont(letraGoogle);
		// titulo.setIcon(new ImageIcon("./imagenes/nuevoProducto.png"));

		// boxCategoria = new DefaultComboBoxModel<>(Categoria.ALIMENTO);

		ctCategoria = new JComboBox<>();
		ctCategoria.addItem(Categoria.ALIMENTO);
		ctCategoria.addItem(Categoria.ASEO);
		ctCategoria.addItem(Categoria.DROGUERIA);
		ctCategoria.addItem(Categoria.PAPELERIA);
		ctCategoria.setMaximumSize(new Dimension(200, 30));
		ctCategoria.setPreferredSize(new Dimension(200, 30));
		ctCategoria.setFont(letraGoogle);
		ctCategoria.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rellenaSubcategoria((Categoria) ctCategoria.getSelectedItem());
				ctSubCategoria.setEnabled(true);

			}

		});
		/*
		 * ctCategoria.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent arg0) { rellenaCombo2((String)
		 * combo1.getSelectedItem()); }
		 * 
		 * // Se rellenan los valores de combo2 iniciales. rellenaCombo2 ((String)
		 * combo1.getSelectedItem()); });
		 */
		// ctCategoria.setEnabled(false);

		ctSubCategoria = new JComboBox<>();
		ctSubCategoria.setMaximumSize(new Dimension(200, 30));
		ctSubCategoria.setPreferredSize(new Dimension(200, 30));
		ctSubCategoria.setFont(letraGoogle);
		ctSubCategoria.setEnabled(false);

		panelCategoria.add(ctCategoria);
		panelCategoria.add(ctSubCategoria);

		atrasTitulo.add(Box.createRigidArea(new Dimension(-140, 0)));
		atrasTitulo.add(atras);
		atrasTitulo.add(Box.createRigidArea(new Dimension(100, 0)));
		atrasTitulo.add(titulo);
		atrasTitulo.setMaximumSize(new Dimension(480, 60));
		atrasTitulo.setPreferredSize(new Dimension(480, 60));
		atrasTitulo.setBackground(Color.WHITE);

		sepCodigo = new JSeparator();
		sepCodigo.setBackground(ventana.getColorBase());
		sepCodigo.setMaximumSize(new Dimension(350, 2));
		sepCodigo.setPreferredSize(new Dimension(350, 2));

		sepNombre = new JSeparator();
		sepNombre.setBackground(ventana.getColorBase());
		sepNombre.setMaximumSize(new Dimension(350, 2));
		sepNombre.setPreferredSize(new Dimension(350, 2));

		sepMarca = new JSeparator();
		sepMarca.setBackground(ventana.getColorBase());
		sepMarca.setMaximumSize(new Dimension(350, 2));
		sepMarca.setPreferredSize(new Dimension(350, 2));

		sepDescripcion = new JSeparator();
		sepDescripcion.setBackground(ventana.getColorBase());
		sepDescripcion.setMaximumSize(new Dimension(350, 2));
		sepDescripcion.setPreferredSize(new Dimension(350, 2));

		sepCantidad = new JSeparator();
		sepCantidad.setBackground(ventana.getColorBase());
		sepCantidad.setMaximumSize(new Dimension(350, 2));
		sepCantidad.setPreferredSize(new Dimension(350, 2));

		sepPrecioProveedor = new JSeparator();
		sepPrecioProveedor.setBackground(ventana.getColorBase());
		sepPrecioProveedor.setMaximumSize(new Dimension(350, 2));
		sepPrecioProveedor.setPreferredSize(new Dimension(350, 2));

		sepPrecioVenta = new JSeparator();
		sepPrecioVenta.setBackground(ventana.getColorBase());
		sepPrecioVenta.setMaximumSize(new Dimension(350, 2));
		sepPrecioVenta.setPreferredSize(new Dimension(350, 2));

		promptCodigo = new TextPrompt("          Ingrese el codigo (solo numeros)", codigo);
		promptCodigo.changeAlpha(0.35f);

		promptMarca = new TextPrompt("                     Ingrese la marca", marca);
		promptMarca.changeAlpha(0.35f);

		promptDescripcion = new TextPrompt("       Ingrese la descripcion del producto", descripcion);
		promptDescripcion.changeAlpha(0.35f);

		promptNombre = new TextPrompt("          Ingrese el nombre del producto", nombre);
		promptNombre.changeAlpha(0.35f);

		promptCantidad = new TextPrompt("                    Ingrese la cantidad", cantidad);
		promptCantidad.changeAlpha(0.35f);

		promptProveedor = new TextPrompt("     Ingrese el precio del proveedor (Base)", precioProveedor);
		promptProveedor.changeAlpha(0.35f);

		promptVenta = new TextPrompt("Ingrese el precio de venta (Base + ganancia)", precioVenta);
		promptVenta.changeAlpha(0.35f);

		accionPro = new JButton("AGREGAR");
		accionPro.setForeground(Color.white);
		accionPro.setBackground(ventana.getColorBase());
		accionPro.setFocusPainted(false);
		accionPro.setBorderPainted(false);
		accionPro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		accionPro.setIcon(new ImageIcon("./imagenes/botonAgrega.png"));
		accionPro.setPreferredSize(new Dimension(90, 50));
		accionPro.setAlignmentX(CENTER_ALIGNMENT);
		// accionPro.setActionCommand("nuevoPro");
		accionPro.addActionListener(ventana.getEventos());

		datos1 = new JPanel();
		datos1.setLayout(new BoxLayout(datos1, BoxLayout.Y_AXIS));
		datos1.setBackground(Color.WHITE);
		datos1.setPreferredSize(new Dimension(480, 550));

		datos2 = new JPanel();
		datos2.setLayout(new BoxLayout(datos2, BoxLayout.Y_AXIS));
		datos2.setBackground(Color.WHITE);
		datos2.setPreferredSize(new Dimension(480, 550));

		datos1.add(Box.createRigidArea(new Dimension(490, 0)));
		datos1.add(Box.createRigidArea(new Dimension(0, 25)));
		datos1.add(atrasTitulo);
		datos1.add(Box.createRigidArea(new Dimension(0, 80)));
		datos1.add(codigo);
		datos1.add(sepCodigo);
		datos1.add(Box.createRigidArea(new Dimension(0, 50)));
		datos1.add(nombre);
		datos1.add(sepNombre);
		datos1.add(Box.createRigidArea(new Dimension(0, 50)));
		datos1.add(marca);
		datos1.add(sepMarca);
		datos1.add(Box.createRigidArea(new Dimension(0, 50)));
		datos1.add(descripcion);
		datos1.add(sepDescripcion);

		// datos2.add(Box.createRigidArea(new Dimension(490, 0)));
		datos2.add(Box.createRigidArea(new Dimension(0, 100)));
		datos2.add(cantidad);
		datos2.add(sepCantidad);
		datos2.add(Box.createRigidArea(new Dimension(0, 50)));
		datos2.add(panelCategoria);
		datos2.add(Box.createRigidArea(new Dimension(0, 45)));
		datos2.add(precioProveedor);
		datos2.add(sepPrecioProveedor);
		datos2.add(Box.createRigidArea(new Dimension(0, 50)));
		datos2.add(precioVenta);
		datos2.add(sepPrecioVenta);
		datos2.add(Box.createRigidArea(new Dimension(0, 70)));
		datos2.add(accionPro);

		panelseparador.add(Box.createRigidArea(new Dimension(0, 30)));
		panelseparador.add(separadorVertical);

		add(datos1);
		add(Box.createRigidArea(new Dimension(0, 0)));
		add(panelseparador);
		add(Box.createRigidArea(new Dimension(0, 0)));
		add(datos2);

	}

	public void rellenaSubcategoria(Categoria seleccionCategoria) {

		ctSubCategoria.removeAllItems();

		if (seleccionCategoria.equals(Categoria.ALIMENTO)) {
			ctCategoria.removeItem(Categoria.VACIO);
			ctSubCategoria.addItem(SubCategoria.AGUA);
			ctSubCategoria.addItem(SubCategoria.ALIMENTO_ANIMALES);
			ctSubCategoria.addItem(SubCategoria.BEBIDAS_ALCOHOLICAS);
			ctSubCategoria.addItem(SubCategoria.BEBIDAS_GASEOSAS);
			ctSubCategoria.addItem(SubCategoria.ENLATADO);
			ctSubCategoria.addItem(SubCategoria.BEBIDAS_LACTEAS);
			ctSubCategoria.addItem(SubCategoria.CARNES);
			ctSubCategoria.addItem(SubCategoria.FRUTA_VERDURA);
			ctSubCategoria.addItem(SubCategoria.GRANOS);
			ctSubCategoria.addItem(SubCategoria.DULCES);
			ctSubCategoria.addItem(SubCategoria.PANADERIA);
		} else if (seleccionCategoria.equals(Categoria.ASEO)) {
			ctCategoria.removeItem(Categoria.VACIO);
			ctSubCategoria.addItem(SubCategoria.HOGAR);
			ctSubCategoria.addItem(SubCategoria.DENTAL);
			ctSubCategoria.addItem(SubCategoria.PERSONAL);
			ctSubCategoria.addItem(SubCategoria.BAÑO);
		} else if (seleccionCategoria.equals(Categoria.PAPELERIA)) {
			ctCategoria.removeItem(Categoria.VACIO);
			ctSubCategoria.addItem(SubCategoria.PAPELERIA_GENERAL);
		} else if (seleccionCategoria.equals(Categoria.DROGUERIA)) {
			ctCategoria.removeItem(Categoria.VACIO);
			ctSubCategoria.addItem(SubCategoria.DROGA_PERSONAS);
			ctSubCategoria.addItem(SubCategoria.DROGA_ANIMALES);
		}
	}

	public void eliminarVacio() {
		ctCategoria.removeItem(Categoria.VACIO);
	}

	public int validarID() {
		int valor = -1;
		String id = codigo.getText();
		try {
			valor = Integer.parseInt(id);
			if(valor < 0) {
				JOptionPane.showMessageDialog(null, "El valor ingresado para el ID debe ser positivo", "ERROR",
						JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
				codigo.setText("");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "El valor ingresado para el ID no es valido", "ERROR",
					JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
		}
		return valor;
	}

	public int validarCantidad() {
		int valor = -1;
		String id = cantidad.getText();
		try {
			valor = Integer.parseInt(id);
			if(valor < 0) {
				JOptionPane.showMessageDialog(null, "El valor ingresado en cantidad debe ser positivo", "ERROR",
						JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
				cantidad.setText("");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "El valor ingresado en cantidad no es valido", "ERROR",
					JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
		}
		return valor;
	}


	public int validarPrecioV() {
		int valor = -1;
		String id = precioVenta.getText();
		try {
			valor = Integer.parseInt(id);
			if(valor < 0) {
				JOptionPane.showMessageDialog(null, "El valor ingresado para el precio de venta debe ser positivo", "ERROR",
						JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
				cantidad.setText("");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "El valor ingresado en precio venta no es valido", "ERROR",
					JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
		}
		return valor;
	}
	
	public int validarPrecioB() {
		int valor = -1;
		String id = precioProveedor.getText();
		try {
			valor = Integer.parseInt(id);
			if(valor < 0) {
				JOptionPane.showMessageDialog(null, "El valor ingresado para el precio base debe ser positivo", "ERROR",
						JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
				cantidad.setText("");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "El valor ingresado en precio base no es valido", "ERROR",
					JOptionPane.WARNING_MESSAGE, new ImageIcon("./imagenes/error.png"));
		}
		return valor;
	}

	public VentanaPrincipal getVentana() {
		return ventana;
	}

	public void setVentana(VentanaPrincipal ventana) {
		this.ventana = ventana;
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

	public JSeparator getSeparadorVertical() {
		return separadorVertical;
	}

	public void setSeparadorVertical(JSeparator separadorVertical) {
		this.separadorVertical = separadorVertical;
	}

	public JPanel getPanelCategoria() {
		return panelCategoria;
	}

	public void setPanelCategoria(JPanel panelCategoria) {
		this.panelCategoria = panelCategoria;
	}

	public JPanel getAtrasTitulo() {
		return atrasTitulo;
	}

	public void setAtrasTitulo(JPanel atrasTitulo) {
		this.atrasTitulo = atrasTitulo;
	}

	public JSeparator getSepCodigo() {
		return sepCodigo;
	}

	public void setSepCodigo(JSeparator sepCodigo) {
		this.sepCodigo = sepCodigo;
	}

	public JSeparator getSepNombre() {
		return sepNombre;
	}

	public void setSepNombre(JSeparator sepNombre) {
		this.sepNombre = sepNombre;
	}

	public JSeparator getSepMarca() {
		return sepMarca;
	}

	public void setSepMarca(JSeparator sepMarca) {
		this.sepMarca = sepMarca;
	}

	public JSeparator getSepDescripcion() {
		return sepDescripcion;
	}

	public void setSepDescripcion(JSeparator sepDescripcion) {
		this.sepDescripcion = sepDescripcion;
	}

	public JSeparator getSepCantidad() {
		return sepCantidad;
	}

	public void setSepCantidad(JSeparator sepCantidad) {
		this.sepCantidad = sepCantidad;
	}

	public JSeparator getSepPrecioProveedor() {
		return sepPrecioProveedor;
	}

	public void setSepPrecioProveedor(JSeparator sepPrecioProveedor) {
		this.sepPrecioProveedor = sepPrecioProveedor;
	}

	public JSeparator getSepPrecioVenta() {
		return sepPrecioVenta;
	}

	public void setSepPrecioVenta(JSeparator sepPrecioVenta) {
		this.sepPrecioVenta = sepPrecioVenta;
	}

	public JTextField getCodigo() {
		return codigo;
	}

	public void setCodigo(JTextField codigo) {
		this.codigo = codigo;
	}

	public JTextField getNombre() {
		return nombre;
	}

	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	public JTextField getMarca() {
		return marca;
	}

	public void setMarca(JTextField marca) {
		this.marca = marca;
	}

	public JTextField getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(JTextField descripcion) {
		this.descripcion = descripcion;
	}

	public JTextField getCantidad() {
		return cantidad;
	}

	public void setCantidad(JTextField cantidad) {
		this.cantidad = cantidad;
	}

	public JComboBox<Categoria> getCtCategoria() {
		return ctCategoria;
	}

	public void setCtCategoria(JComboBox<Categoria> ctCategoria) {
		this.ctCategoria = ctCategoria;
	}

	public JComboBox<SubCategoria> getCtSubCategoria() {
		return ctSubCategoria;
	}

	public void setCtSubCategoria(JComboBox<SubCategoria> ctSubCategoria) {
		this.ctSubCategoria = ctSubCategoria;
	}

	public JTextField getPrecioProveedor() {
		return precioProveedor;
	}

	public void setPrecioProveedor(JTextField precioProveedor) {
		this.precioProveedor = precioProveedor;
	}

	public JTextField getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(JTextField precioVenta) {
		this.precioVenta = precioVenta;
	}

	public TextPrompt getPromptCodigo() {
		return promptCodigo;
	}

	public void setPromptCodigo(TextPrompt promptCodigo) {
		this.promptCodigo = promptCodigo;
	}

	public TextPrompt getPromptNombre() {
		return promptNombre;
	}

	public void setPromptNombre(TextPrompt promptNombre) {
		this.promptNombre = promptNombre;
	}

	public TextPrompt getPromptMarca() {
		return promptMarca;
	}

	public void setPromptMarca(TextPrompt promptMarca) {
		this.promptMarca = promptMarca;
	}

	public TextPrompt getPromptDescripcion() {
		return promptDescripcion;
	}

	public void setPromptDescripcion(TextPrompt promptDescripcion) {
		this.promptDescripcion = promptDescripcion;
	}

	public TextPrompt getPromptCantidad() {
		return promptCantidad;
	}

	public void setPromptCantidad(TextPrompt promptCantidad) {
		this.promptCantidad = promptCantidad;
	}

	public TextPrompt getPromptProveedor() {
		return promptProveedor;
	}

	public void setPromptProveedor(TextPrompt promptProveedor) {
		this.promptProveedor = promptProveedor;
	}

	public TextPrompt getPromptVenta() {
		return promptVenta;
	}

	public void setPromptVenta(TextPrompt promptVenta) {
		this.promptVenta = promptVenta;
	}

	public Font getLetraGoogle() {
		return letraGoogle;
	}

	public void setLetraGoogle(Font letraGoogle) {
		this.letraGoogle = letraGoogle;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JButton getAtras() {
		return atras;
	}

	public void setAtras(JButton atras) {
		this.atras = atras;
	}

	public JButton getAccionPro() {
		return accionPro;
	}

	public void setAccionPro(JButton accionPro) {
		this.accionPro = accionPro;
	}

}
