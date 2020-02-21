package co.edu.uptc.modelo;

import java.util.List;

import javax.swing.JButton;

public class Perfil {

	private String usuario;
	private String contrase�a;
	private TipoPerfil tipoPerfil;
	private String nombre;
	private String apellido;
	private String numeroDoc;
	private TipoDocumento tipoDoc;
	private List<Facturas> listaFacturas;

	public Perfil() {

	}

	public Perfil(String usuario, String contrase�a, TipoPerfil tipoPerfil, String nombre, String apellido,
			String numeroDoc, TipoDocumento tipoDoc, List<Facturas> listaFacturas) {
		super();
		this.usuario = usuario;
		this.contrase�a = contrase�a;
		this.tipoPerfil = tipoPerfil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numeroDoc = numeroDoc;
		this.tipoDoc = tipoDoc;
		this.listaFacturas = listaFacturas;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public TipoPerfil getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(TipoPerfil tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNumeroDoc() {
		return numeroDoc;
	}

	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

	public TipoDocumento getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDocumento tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public List<Facturas> getListaFacturas() {
		return listaFacturas;
	}

	public void setListaFacturas(List<Facturas> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}

}
