package Practica_Evaluable_AccesoDatos_1Eval;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.io.StreamCorruptedException;

public class CrearRandomFile {

	public static void crearRand() throws IOException, ClassNotFoundException {

		Coche coche;

		File fichero = new File("ObjectCoches.dat");
		FileInputStream filein = new FileInputStream(fichero);
		ObjectInputStream dataIs = new ObjectInputStream(filein);

		File fichRandomCoches = new File("AleatorioExamen.dat");
		RandomAccessFile file = new RandomAccessFile(fichRandomCoches, "rw");

		int id = 1;

		try {

			// Aprovechamos la lectura secuencial y c�clica del fichero de objetos para
			// rellenar las variables y justo despu�s ir escribi�ndolas en el fichero
			// aleatorio.

			while (true) {

				// Lectura fichero de
				// objetos_____________________________________________________________________
				coche = (Coche) dataIs.readObject();
				String marca = coche.getMarca();
				String color = coche.getColor();
				int puertas = coche.getPuertas();
				int caballos = coche.getCaballos();
				Double cilindrada = coche.getCilindrada();
				// ----------------------------------------------------
				String caracteresExamen = coche.getCaracteresExamen();
				int enteroExamen = coche.getEnteroExamen();
				double doubleExamen = coche.getDoubleExamen();

				// Escritura fichero
				// aleatorio_____________________________________________________________________

				file.writeInt(id);// 4 bytes
				id++;

				StringBuffer bufferMarca = null;
				StringBuffer bufferColor = null;
				StringBuffer bufferCaracteresExamen = null;

				bufferMarca = new StringBuffer(marca);// 20 bytes
				bufferMarca.setLength(10);
				file.writeChars(bufferMarca.toString());

				bufferColor = new StringBuffer(color);// 20 bytes
				bufferColor.setLength(10);
				file.writeChars(bufferColor.toString());
				// ----------------------------------------------------
				bufferCaracteresExamen = new StringBuffer(caracteresExamen);// 24 bytes
				bufferCaracteresExamen.setLength(12);
				file.writeChars(bufferCaracteresExamen.toString());

				file.writeInt(puertas);// 4 bytes
				file.writeInt(caballos);// 4 bytes
				file.writeDouble(cilindrada);// 8 bytes
				// ----------------------------------------------------
				file.writeInt(enteroExamen);// 4 bytes
				file.writeDouble(doubleExamen);// 8 bytes

				// Total = 96 bytes
			}

		} catch (EOFException eo) {
			System.out.println("Fichero aleatorio creado");

		} catch (StreamCorruptedException e) {
			System.out.println("Error de lectura");
		}
		file.close();
		dataIs.close();
	}
}
