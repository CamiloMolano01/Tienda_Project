package co.edu.uptc.modelo;

public enum Categoria {

	VACIO(""), ASEO("Aseo"), DROGUERIA("Drogueria"), ALIMENTO("Alimento"), PAPELERIA("Papeleria");

	private final String display;

	private Categoria(String s) {
		display = s;
	}

	@Override
	public String toString() {
		return display;
	}

}
