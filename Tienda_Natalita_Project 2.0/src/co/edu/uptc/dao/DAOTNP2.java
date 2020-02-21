package co.edu.uptc.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import co.edu.uptc.modelo.Perfil;
import co.edu.uptc.modelo.Producto;

public class DAOTNP2 {

	private Gson gson;

	public DAOTNP2() {
		gson = new Gson();

	}

	public void guardarPerfiles(List<Perfil> listaPerfiles) throws IOException {

		File guarda = new File(
				"C:\\Users\\CamiloMolano\\espacio_eclipse\\Tienda_Natalita_Project 2.0\\LISTASTIENDA\\listaPerfiles");

		try {

			FileWriter save = new FileWriter(guarda + ".json");
			save.write(gson.toJson(listaPerfiles));
			save.close();

		} catch (Exception e) {

		}
	}

	public void guardarInventario(List<Producto> listaInventario) throws IOException {

		File guarda = new File(
				"C:\\Users\\CamiloMolano\\espacio_eclipse\\Tienda_Natalita_Project 2.0\\LISTASTIENDA\\listaInventario");

		try {

			FileWriter save = new FileWriter(guarda + ".json");
			save.write(gson.toJson(listaInventario));
			save.close();

		} catch (Exception e) {

		}
	}

	public List<Perfil> leerPerfiles() throws IOException {
		List<Perfil> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(
				"./LISTASTIENDA/listaPerfiles.json"));
		String line = br.readLine();

		while (line != null) {

			Type tipoListaPerfiles = new TypeToken<List<Perfil>>() {}.getType();
			List<Perfil> perfiles = gson.fromJson(line, tipoListaPerfiles);

			list = perfiles;
			line = br.readLine();
		}
		return list;
	}

	public List<Producto> leerProductosInventario() throws IOException {
		List<Producto> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(
				"./LISTASTIENDA/listaInventario.json"));
		String line = br.readLine();

		while (line != null) {

			Type tipoListaProductosInventario = new TypeToken<List<Producto>>() {
			}.getType();
			List<Producto> productosInventario = gson.fromJson(line, tipoListaProductosInventario);

			list = productosInventario;
			line = br.readLine();
		}
		return list;
	}

}
