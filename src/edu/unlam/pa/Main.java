package edu.unlam.pa;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		String caso = "10";
		Celular c1 = new Celular(new File("Preparacion de prueba//Lote de prueba//Entrada//" + caso +".in"), new File("Ejecucion de prueba//Salida obtenida//" + caso + ".out"));
		c1.resolver();
		c1.mostrarSolucion();
		c1.imprimirSolucion();
	}

}
