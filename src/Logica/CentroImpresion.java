package Logica;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class CentroImpresion extends Thread{

	private volatile ArrayList<Impresora> impresoras_a;
	private volatile ArrayList<Impresora> impresoras_b;
	private volatile int id_proceso;

	public CentroImpresion(ArrayList<Impresora> impresoras_a, ArrayList<Impresora> impresoras_b, int id_proceso) {
		super();
		this.impresoras_a = impresoras_a;
		this.impresoras_b = impresoras_b;
		this.id_proceso = id_proceso;
	}

	//SE CREA UN TRABAJO QUE ALEATORAMIENTE PUEDE SER DE TIPO A, B O C
	public void run(){
		int i = 1;
		while(true){
			String [] arr = {"A", "B", "C"};
			Random random = new Random();
			int tipo_id = random.nextInt(arr.length);
			Trabajo trabajo = new Trabajo("Soy el trabajo " + i + " del proceso " + getId_proceso(), arr[tipo_id]);

			if(trabajo.getTipo().equalsIgnoreCase("A")){
				this.llamar_impresora(trabajo, this.getImpresoras_a());
			}

			if(trabajo.getTipo().equalsIgnoreCase("B")){
				this.llamar_impresora(trabajo, this.getImpresoras_b());
			}

			if(trabajo.getTipo().equalsIgnoreCase("C")){
				int tipo_impresora_id = random.nextInt(arr.length-1);
				if(arr[tipo_impresora_id].equalsIgnoreCase("A")){
					this.llamar_impresora(trabajo, this.getImpresoras_a());
				}
				else{
					this.llamar_impresora(trabajo, this.getImpresoras_b());
				}
			}
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){

			}
			i++;
		}
	}

	//SE BUSCA UNA IMPRESORA QUE EN ESE MOMENTO NO SE ENCUENTRE IMPRIMIENDO
	public void llamar_impresora(Trabajo trabajo, ArrayList<Impresora> impresoras){
		boolean imprimido = false;
		while(!imprimido){
			for(Impresora impresora : impresoras){
				if(!impresora.isPrinting()){
					imprimido = true;
					impresora.setTrabajo(trabajo);
					impresora.run();
					break;
				}
			}
		}
	}

	public int getId_proceso() {
		return id_proceso;
	}

	public ArrayList<Impresora> getImpresoras_a() {
		synchronized (this){
			return impresoras_a;
		}
	}

	public ArrayList<Impresora> getImpresoras_b() {
		synchronized (this) {
			return impresoras_b;
		}
	}
}
