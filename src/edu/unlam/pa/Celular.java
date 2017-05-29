package edu.unlam.pa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Celular extends EjercicioOIA {
	private int vecApps[];
	private int memTot = 0;
	private int memApp;
	// ATRIBUTOS PARA RESOLVER
	private int pos = 0;
	private int cantAppsAEliminar;
	
	public Celular(File entrada, File salida) throws FileNotFoundException {
		super(entrada, salida);
		Scanner sc = new Scanner(entrada);
		vecApps = new int[sc.nextInt()];
		memApp = sc.nextInt();
		for (int i = 0; i < vecApps.length; i++) {
			vecApps[i] = sc.nextInt();
			memTot += vecApps[i];
		}
		cantAppsAEliminar = vecApps.length +1;
		sc.close();
	}


	public void mostrarSolucion() {
		System.out.println(cantAppsAEliminar);
		System.out.println(pos+1);
	}

	@Override
	public void resolver() {
		int memAnt = 0;
		int sumaMem = 0;
		
		int j;
		if( memApp <= memTot) {
			for (int i = 0; i < vecApps.length; i++) {
				j = i;
				sumaMem = 0;
				while( j < vecApps.length && memApp > sumaMem && cantAppsAEliminar > j-i ) {
					sumaMem += vecApps[j];
					j++;
				}
				if(sumaMem >= memApp) {
						if(!(sumaMem == memAnt && pos != i)){
							cantAppsAEliminar = j-i;
							pos = i;
							memAnt = sumaMem;
				}
				}
			}
		} else {
			pos = -1;
		}
		
	}
	
	public void imprimirSolucion() throws FileNotFoundException {
		PrintWriter pr = new PrintWriter(salida);
		if(pos != -1) {
			pr.println(cantAppsAEliminar);
			pr.print(pos+1);
		} else {
			pr.println("MEMORIA INSUFICIENTE");
		}
		pr.close();
	}
}
