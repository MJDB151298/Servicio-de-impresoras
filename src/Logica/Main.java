package Logica;

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
			impresoras_a.add(new Impresora("A", 1));
		}
		for(int i = 0; i < cantidadB; i++){
			impresoras_b.add(new Impresora("B", 1));
		}

		System.out.println("El size de las impresoras A es: " + impresoras_a.size());
		System.out.println("El size de las impresoras B es: " + impresoras_b.size());


		/**CODIGO ORIGINAL**/
		Impresora imp1 = new Impresora("A", 8);
		Impresora imp2 = new Impresora("B", 14);
		Thread cent1 = new CentroImpresion(imp1);
		Thread cent2 = new CentroImpresion(imp2);

		System.out.println("Iniciando Impresion");
		cent1.start();
		cent2.start();
	}

}
