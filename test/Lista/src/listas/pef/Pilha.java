package listas.pef;
import listas.les.*;
public class Pilha extends LES{
	
	public Pilha(int size){
		super(size);
	}
	
	public ContaBancaria remove(){
		ContaBancaria conta = null;
		if(!this.isEmpty()){
			conta = this.c[ultimo-1];
			this.c[ultimo-1] = null;
			ultimo--;
		}
		return conta;
	}
}
