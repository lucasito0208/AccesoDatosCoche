package Practica_Evaluable_AccesoDatos_1Eval;

import java.io.FileReader;
import java.util.ArrayList;
import javax.xml.bind.Unmarshaller;

public class VisualizarLista {

	public static void main(String[] args) {

		Coche coche;
		// UNMARSHALLING: permite crear objetos Java a partir de un XML.
		// _____________________________________________________________________________

		// Visualizamos ahora los datos del documento XML creado.
		System.out.println("------Leo el XML-------");
		// Se crea un unmarshaller en el contexto de la clase Libreria.
		Unmarshaller unmars = context.createUnmarshaller();
		// Utilizamos el m�todo unmarshal para obtener datos de un Reader.
		cocheJAXB cocheJAXBAux = (cocheJAXB) unmars.unmarshal(new FileReader(MIARCHIVO_XML));

		// Recuperamos los datos y visualizamos.
		System.out.println("Marca de Coche: " + coche.getMarca());
		System.out.println("Color de coche: " + coche.getColor());
		System.out.println("Marca de Coche: " + coche.getPuertas());
		System.out.println("Color de coche: " + coche.getCaballos());
		System.out.println("Marca de Coche: " + coche.getCilindrada());
		System.out.println("Color de coche: " + coche.getDoubleExamen());
		System.out.println("Marca de Coche: " + coche.getCaracteresExamen());
		System.out.println("Color de coche: " + coche.getEnteroExamen());


		ArrayList<Coche> libroLista = cocheJAXBAux.getListaCoche();
		for (Coche libro : libroLista) {		

		}

}
