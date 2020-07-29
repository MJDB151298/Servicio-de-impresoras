package Logica;

public class CentroImpresion extends Thread{

	Impresora impresora;

	public CentroImpresion(Impresora impresora) {
		super();
		this.impresora = impresora;
	}
	
	public void run(){
		int i=1;
		while(i<=impresora.getNum()){
			System.out.println("Impresora "+impresora.getTipo()+" Doc."+i+"");
			if(i==impresora.getNum())
			{
				System.out.println("La impresora "+impresora.getTipo()+" ha Terminado\r\n");
			}
			i++;
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
