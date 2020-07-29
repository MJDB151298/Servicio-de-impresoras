package Logica;

import sun.java2d.loops.TransformBlit;

import java.util.Random;

public class Impresora extends Thread {

	private String tipo;
	private int num;
	private volatile boolean isPrinting;
	private volatile Trabajo trabajo;
	
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

	public boolean isPrinting() {
		synchronized (this) {
			return isPrinting;
		}
	}

	public Trabajo getTrabajo() {
		synchronized (this){
			return trabajo;
		}
	}

	public void setTrabajo(Trabajo trabajo) {
		synchronized (this) {
			this.trabajo = trabajo;
		}
	}

	//SE IMPRIME EL TRABAJO EL CUAL PUEDE DURAR COMO MAXIMO 30 SEGUNDOS
	public void run() {
		Random random = new Random();
		this.isPrinting = true;
		System.out.println("La impresora " + this.getNum() + " de tipo " + this.getTipo() + " esta imprimiendo el mensaje: " + this.getTrabajo().getTexto());
		try{
			Thread.sleep(random.nextInt(30000));
		}catch(InterruptedException e){

		}

		this.isPrinting = false;
	}
	
	

}
