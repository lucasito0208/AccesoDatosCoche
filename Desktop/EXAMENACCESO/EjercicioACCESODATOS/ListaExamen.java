package Practica_Evaluable_AccesoDatos_1Eval;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ListaExamen {

	public static final String MIARCHIVO_XML = "./librería.xml";

	public static void main(String[] args) throws JAXBException, IOException {

		// Se crea la lista de libros.
		ArrayList<Coche> cocheLista = new ArrayList<Coche>();

		// Creamos dos libros y los añadimos.
		Coche coche1 = new Coche("BMW", "Rojo", 5, 120, 1.8, "dsadasd", 1, 1.0);
		Coche coche2 = new Coche("Seat", "Verde", 3, 100, 1.2, "dasdas", 2, 1.5);
		Coche coche3 = new Coche("Mercedes", "Azul", 5, 150, 1.5, "dasdas", 3, 1.6);

		// Los añadimos al arraylist LibroLista.
		cocheLista.add(coche1);
		cocheLista.add(coche2);
		cocheLista.add(coche3);

		cocheJAXB miCoche = new cocheJAXB(cocheLista);

		// MARSHALLING: permite crear XML a partir de una o más clases Java.
		// _____________________________________________________________________________

		// Creamos el contexto indicando la clase raíz.
		JAXBContext context = JAXBContext.newInstance(cocheJAXB.class);
		// Creamos el Marshaller, convierte el JavaBean en una cadena XML.
		Marshaller m = context.createMarshaller();
		// Formateamos el XML para que quede bien.
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		// Lo visualizamos con sysout
		m.marshal(miCoche, System.out);
		// Escribimos en el archivo
		m.marshal(miCoche, new File(MIARCHIVO_XML));
	}
}
