package Practica_Evaluable_AccesoDatos_1Eval;

import java.io.Serializable;

public class Coche implements Serializable { // IMPORTANTE: añadir implements Serialiable al crear la clase, si no al
												// escribir el fichero de objetos da error.
	String marca;
	String color;
	int puertas;
	int caballos;
	Double cilindrada;
	String caracteresExamen;
	int enteroExamen;
	double doubleExamen;

	public Coche(String marca, String color, int puertas, int caballos, Double cilindrada, String caracteresExamen,
			int enteroExamen, double doubleExamen) {

		this.marca = marca;
		this.color = color;
		this.puertas = puertas;
		this.caballos = caballos;
		this.cilindrada = cilindrada;
		// ____________________________________________________
		this.caracteresExamen = caracteresExamen;
		this.enteroExamen = enteroExamen;
		this.doubleExamen = doubleExamen;

	}

	public Coche() {
		this.marca = null;
		this.color = null;
		this.caracteresExamen = null;
	}

	// Gettters___________________________________________________________
	public String getMarca() {
		return marca;
	}

	public String getColor() {
		return color;
	}

	public int getPuertas() {
		return puertas;
	}

	public int getCaballos() {
		return caballos;
	}

	public Double getCilindrada() {
		return cilindrada;
	}

	public String getCaracteresExamen() {
		return caracteresExamen;
	}

	public int getEnteroExamen() {
		return enteroExamen;
	}

	public Double getDoubleExamen() {
		return doubleExamen;
	}

}
