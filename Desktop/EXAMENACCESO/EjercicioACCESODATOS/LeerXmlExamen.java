package Practica_Evaluable_AccesoDatos_1Eval;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerXmlExamen {

	public static void main(String[] args) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document documento = builder.parse(new File("examen.xml")); // cargamos el documento Empleados.xml que vamos
																		// a leer con el método parse().
			documento.getDocumentElement().normalize();

			System.out.printf("Elemento raiz: %s %n ", documento.getDocumentElement().getNodeName()); // Sacamos por
																										// pantalla el
																										// nombre del
																										// nodo raíz.

			NodeList coches = documento.getElementsByTagName("Coche"); // Creamos una lista con todos los nodos
																		// empleado.
			System.out.printf("Nodos empleado a recorrer: %d %n", coches.getLength()); // Sacamos por pantalla la
																						// cantidad de nodos que vamos a
																						// recorrer.

			// Recorremos la lista.
			for (int i = 0; i < coches.getLength(); i++) {
				Node coch = coches.item(i);

				if (coch.getNodeType() == Node.ELEMENT_NODE) { // Tipo de nodo.

					// Obtenemos los elementos del nodo.
					Element elemento = (Element) coch;

					System.out.printf("ID = %s %n", elemento.getElementsByTagName("id").item(0).getTextContent());
					System.out.printf("* Marca = %s %n",
							elemento.getElementsByTagName("marcas").item(0).getTextContent());
					System.out.printf("* Color = %s %n",
							elemento.getElementsByTagName("colores").item(0).getTextContent());
					System.out.printf("* Caracteres = %s %n",
							elemento.getElementsByTagName("caracteresExamens").item(0).getTextContent());

					System.out.printf("* Puertas = %s %n",
							elemento.getElementsByTagName("puertas").item(0).getTextContent());
					System.out.printf("* Caballos = %s %n",
							elemento.getElementsByTagName("caballos").item(0).getTextContent());
					System.out.printf("* Cilindrada = %s %n",
							elemento.getElementsByTagName("cilindrada").item(0).getTextContent());
					System.out.printf("* EnteroExamen = %s %n",
							elemento.getElementsByTagName("enteroExamen").item(0).getTextContent());
					System.out.printf("* DoubleExamen = %s %n",
							elemento.getElementsByTagName("doubleExamen").item(0).getTextContent());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
