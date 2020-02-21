package co.edu.uptc.modelo;

public enum TipoDocumento {

	CC("Cedula de Ciudadania"), TI("Tarjeta de identidad"), CE("Cedula de Extranjeria");

	private final String display;

	private TipoDocumento(String s) {
		display = s;
	}
	
	@Override
	public String toString() {
		return display;
	}

	public String getDisplay() {
		return display;
	}
	
	

}
