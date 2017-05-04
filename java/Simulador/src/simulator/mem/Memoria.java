package simulator.mem;
import java.util.ArrayList;

import simulator.mem.ram.Celula;

abstract public class Memoria implements IMem{
	private int size;
	private int cellSize;
	protected ArrayList<Celula> celulas;
	
	public Memoria(int size, int cellSize, int mode){
		try{
			this.size = Assistente.toByteConvert(mode, size);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		this.cellSize = cellSize;
		celulas = new ArrayList<Celula>();
	}
	
	public int getSize(){
		return this.size;
	}
	
	public int getCellSize(){
		return this.cellSize;
	}
	
	public ArrayList<Celula> getCellList(){
		return this.celulas;
	}
}
