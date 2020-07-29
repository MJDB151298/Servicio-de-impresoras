package Logica;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		ArrayList<Impresora> impresoras_a = new ArrayList<>();
		ArrayList<Impresora> impresoras_b = new ArrayList<>();

		System.out.println("Ingrese la cantidad de impresoras A");
		int cantidadA = sc.nextInt();

		System.out.println("Ingrese la cantidad de impresoras B");
		int cantidadB = sc.nextInt();

		for(int i = 0; i < cantidadA; i++){
			impresoras_a.add(new Impresora("A", i+1));
		}
		for(int i = 0; i < cantidadB; i++){
			impresoras_b.add(new Impresora("B", i+1));
		}

		System.out.println("Cuantos procesos desea utilizar?");
		int cantidad_procesos = sc.nextInt();
		ArrayList<CentroImpresion> centroImpresiones = new ArrayList<>();
		for(int i = 0; i < cantidad_procesos; i++){
			centroImpresiones.add(new CentroImpresion(impresoras_a, impresoras_b, i+1));
		}
		System.out.println("Iniciando Impresion");
		for(CentroImpresion centroImpresion : centroImpresiones){
			centroImpresion.start();
		}


	}

}
