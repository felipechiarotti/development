package simulator.mem.cache;
import java.util.ArrayList;

import simulator.mem.ram.Bloco;
import simulator.mem.ram.Celula;

public class Linha {
	private String id;
	private static int totalId;
	private String tag;
	private ArrayList<Celula> cols;
	
	public Linha(){
		cols = new ArrayList<Celula>();
		this.id = Integer.toBinaryString(0);
	}
	
	public void setLinha(String tag, Bloco bloco){
		this.tag = tag;
		totalId++;
		cols = new ArrayList<Celula>();
		this.id = Integer.toBinaryString(totalId);
		for(Celula cel : bloco.getCelulas()){
			this.cols.add(cel);
		}
	}
	
	public String getTag(){
		return this.tag;
	}
	public ArrayList<Celula> getCols(){
		return this.cols;
	}
	
	public String getId(){
		return this.id;
	}
}
