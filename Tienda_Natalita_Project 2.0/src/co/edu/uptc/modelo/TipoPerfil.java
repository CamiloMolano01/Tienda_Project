package co.edu.uptc.modelo;

public enum TipoPerfil {
	
	EMPLEADO("Empleado"), ADMIN("Administrador") ;

	private final String display;

	private TipoPerfil(String s) {
		display = s;
	}
	
	@Override
	public String toString() {
		return display;
	}

}
