package listas.lde;
import listas.les.ContaBancaria;
public class ContaBancariaLDE extends ContaBancaria  implements Cloneable{
	private ContaBancariaLDE proximo;
	
	public ContaBancariaLDE(){
		super();
		proximo = null;
	}
	public void setProximo(ContaBancariaLDE c){
		this.proximo = c;
	}
	public ContaBancariaLDE getProximo(){
		return this.proximo;
	}
	
	public String toString(){
		return this.getNumeroConta();
	}
	
	public ContaBancariaLDE clone(){
		ContaBancariaLDE conta = null;
		try{
			conta = (ContaBancariaLDE) super.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return conta;
	}
}
