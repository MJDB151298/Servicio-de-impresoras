package Logica;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Impresora imp1 = new Impresora("A", 8);
		Impresora imp2 = new Impresora("B", 14);
		Thread cent1 = new CentroImpresion(imp1);
		Thread cent2 = new CentroImpresion(imp2);

		System.out.println("Iniciando Impresion");
		cent1.start();
		cent2.start();
	}

}
