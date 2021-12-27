package Practica_Evaluable_AccesoDatos_1Eval;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribirFicheroCoches {

	public static void crearObj() throws IOException {

		File fichero = new File("ObjectCoches.dat");
		FileOutputStream fileout = new FileOutputStream(fichero);
		ObjectOutputStream dataOs = new ObjectOutputStream(fileout);

		Coche coche;

		String marcas[] = { "BMW", "Mercedes", "Seat" };
		String[] colores = { "rojo", "negro", "plata" };
		int[] puertas = { 5, 4, 5 };
		int[] caballos = { 150, 200, 90 };
		Double[] cilindradas = { 1.6, 1.9, 1.4 };
		// ------------------------------------------------------------------
		String[] caracteresExamen = { "dsfasfs", "fdsfdsf", "sdfdsfs" };
		int[] enteroExamen = { 1, 2, 3 };
		Double[] doubleExamen = { 1.0, 1.1, 1.2 };

		for (int i = 0; i < marcas.length; i++) {
			coche = new Coche(marcas[i], colores[i], puertas[i], caballos[i], cilindradas[i], caracteresExamen[i],
					enteroExamen[i], doubleExamen[i]);
			dataOs.writeObject(coche);
		}
		dataOs.close();
		System.out.println("Fichero de Objetos creado");
	}

}
