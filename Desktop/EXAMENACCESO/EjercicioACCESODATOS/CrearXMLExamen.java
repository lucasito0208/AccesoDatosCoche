package Practica_Evaluable_AccesoDatos_1Eval;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class CrearXMLExamen {

	public static void main(String[] args) throws IOException {

		File fichero = new File("AleatorioExamen.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "r");

		int id, puertas, caballos, enteroExamen, posicion = 0;
		double cilindrada, doubleExamen;
		char marca[] = new char[10], aux;
		char color[] = new char[10];
		char caracteresExamen[] = new char[12];

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();

			// creamos un documento vac�o con el nodo ra�z Empleados
			Document document = implementation.createDocument(null, "Coches", null);
			document.setXmlVersion("1.0"); // agregamos la versi�n de XML a document

			for (;;) {

				file.seek(posicion); // nos posicionamos
				id = file.readInt(); // obtenemos el ID

				for (int i = 0; i < marca.length; i++) {
					aux = file.readChar();
					marca[i] = aux;
				}
				for (int i = 0; i < color.length; i++) {
					aux = file.readChar();
					color[i] = aux;
				}
				for (int i = 0; i < caracteresExamen.length; i++) {
					aux = file.readChar();
					caracteresExamen[i] = aux;
				}

				String marcas = new String(marca);
				String colores = new String(color);
				String caracteresExamens = new String(caracteresExamen);

				puertas = file.readInt();
				caballos = file.readInt();
				cilindrada = file.readDouble();
				enteroExamen = file.readInt();
				doubleExamen = file.readDouble();

				if (id > 0) {

					Element raiz = document.createElement("Coche");// creamos el nodo ra�z empleado con
																		// create.Element
					document.getDocumentElement().appendChild(raiz); // lo pegamos a la ra�z del documento

					// se a�aden los hijos del nodo ra�z "Empleado"
					crearElemento("id", Integer.toString(id), raiz, document); // al crear un documento XML todo tiene
																				// que ir en texto, por eso se castea
																				// todo a String (toString)
					crearElemento("marcas", marcas.trim(), raiz, document);
					crearElemento("colores", colores.trim(), raiz, document);
					crearElemento("caracteresExamens", caracteresExamens.trim(), raiz, document);// se meten como par�metros el nombre
																					// de la etiqueta, el nodo ra�z y el
																					// document
					crearElemento("puertas", Integer.toString(puertas), raiz, document);
					crearElemento("caballos", Integer.toString(caballos), raiz, document);
					crearElemento("cilindrada", Double.toString(cilindrada), raiz, document);
					crearElemento("enteroExamen", Integer.toString(enteroExamen), raiz, document);
					crearElemento("doubleExamen", Double.toString(doubleExamen), raiz, document);

				}

				posicion = posicion + 96; // nos posicionamos en el siguiente empleado

				if (file.getFilePointer() == file.length())
					break;

			} // fin bucle for hipo

			Source source = new DOMSource(document); // se crea la fuente XML

			Result result = new StreamResult(new java.io.File("examen.xml")); // se crea el resultado en el fichero
																					// Empleados.xml, el fichero se crea
																					// por defecto en la carpeta del
																					// proyecto.

			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result); // se realiza la transformaci�n del documento al fichero

			Result console = new StreamResult(System.out); // para mostrar el documento por pantalla
			transformer.transform(source, console);

		} catch (Exception e) {
			System.err.println("Error " + e);
		}

		file.close(); // cerrar fichero
	}

	public static void crearElemento(String datoCoche, String valor, Element raiz, Document document) {

		Element elem = document.createElement(datoCoche); // creamos un hijo
		Text text = document.createTextNode(valor); // damos valor
		raiz.appendChild(elem); // pegamos el elemento hijo a la raiz
		elem.appendChild(text); // pegamos el valor
	}

}
