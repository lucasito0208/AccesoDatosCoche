package Practica_Evaluable_AccesoDatos_1Eval;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class cocheJAXB {

	private ArrayList<Coche> listacoche;

	public cocheJAXB(ArrayList<Coche> listacoche) {
		this.listacoche = listacoche;

	}

	public cocheJAXB() {
	}

}
