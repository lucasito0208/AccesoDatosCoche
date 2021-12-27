
public class Convertidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hojaEstilo = "alumnosPlantilla.xsl";
		String datosAlumnos = "alumnos.xml";
		File pagHTML = new File("mipagina.html");
		
		//crear fichero HTML
		FileOutputStream flujoSalida = new FileOutputStream(pagHTML);
		Source estilos = new StreamSource(hojaEstilo); //Fuente XSL
		Source datos = new StreamSource(datosAlumnos); //Fuente XML
		
		//resultado de la transformacion 

	}

}
