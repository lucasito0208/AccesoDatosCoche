package Practica_Evaluable_AccesoDatos_1Eval;

import java.io.IOException;
import java.util.Scanner;

public class PracticaEvaluable {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		boolean salir = false;

		do {
			Scanner reader = new Scanner(System.in);

			System.out.println("\n ");
			System.out.println("Elegir una opción \n");
			System.out.println("1. Crear ObjectFile");
			System.out.println("2. Crear RandomFile");
			System.out.println("3. Leer");
			System.out.println("4. Insertar");
			System.out.println("5. Modificar");
			System.out.println("6. Borrar");
			System.out.println("7. Salir");

			int opcion = reader.nextInt();

			switch (opcion) {

			case 1:
				EscribirFicheroCoches.crearObj();
				break;
			case 2:
				CrearRandomFile.crearRand();
				break;
			case 3:
				Lectura.leer();
				break;
			case 4:
				Insercion.insertar();
				break;
			case 5:
				Modificacion.modificar();
				break;
			case 6:
				Borrado.borrar();
				break;
			case 7:
				salir = true;
				System.out.println("Programa finalizado");
				break;
			}
		} while (salir == false);
	}
}
