package simulator.mem.ram;

import java.util.ArrayList;

import simulator.mem.Assistente;

public class Bloco {
	private int size;
	private ArrayList<Celula> celulas;
	private String address;
	private int bitsToAddress;
	
	public Bloco(int size){
		this.size = size;
		celulas = new ArrayList<Celula>();
	}
	
	public void setCelula(Celula c){
		if(celulas.size()<size){
			celulas.add(c);
		}
	}
	
	public ArrayList<Celula> getCelulas(){
		return this.celulas;
	}
	
	public void setAddress(String address){
		String res = "";
		for(int i = 0; i< Assistente.calculateTotalBits(size); i++){
			res+=address.charAt(i);
		}
		this.address = res;
	}
	
	public String getAddress(){
		return this.address;
	}
}
