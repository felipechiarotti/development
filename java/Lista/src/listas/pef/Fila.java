package listas.pef;
import listas.les.*;
public class Fila extends LES{
	public Fila(int size){
		super(size);
	}
	
	public ContaBancaria remove(){
		ContaBancaria conta = null;
		if(!this.isEmpty()){
			conta = this.c[0];
			int i = 0;
			while(i<this.ultimo){
				this.c[i] = this.c[i+1];
				i++;
			}
			this.c[ultimo-1] = null;
			ultimo--;
		}
		return conta;
	}
}
