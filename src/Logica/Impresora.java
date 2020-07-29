package Logica;

public class Impresora extends Thread {

	private String tipo;
	private int num;
	private volatile boolean isPrinting;
	
	public Impresora(String tipo, int num) {
		super();
		this.tipo = tipo;
		this.num = num;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void imprimir(){

	}
	
	

}
