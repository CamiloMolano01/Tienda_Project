package co.edu.uptc.modelo;

public enum SubCategoria {

	HOGAR("Hogar"), BAÑO("Baño"), PERSONAL("Personal"), DENTAL("Dental"), AGUA("Agua"), ENLATADO(
			"Enlatados"), FRUTA_VERDURA("Frutas/Verduras"), DULCES("Dulces"), GRANOS("Granos"), BEBIDAS_ALCOHOLICAS(
					"Bebidas alcoholicas"), BEBIDAS_GASEOSAS("Bebidas gaseosas"), BEBIDAS_LACTEAS(
							"Bebidas Lacteas"), CARNES("Carnes"), ALIMENTO_ANIMALES("Alimento animales"), PANADERIA(
									"Panaderia"), DROGA_PERSONAS("Droga personas"), DROGA_ANIMALES(
											"Droga veterinaria"), PAPELERIA_GENERAL("Papeleria general");

	private final String display;

	private SubCategoria(String s) {
		display = s;
	}

	@Override
	public String toString() {
		return display;
	}
}
