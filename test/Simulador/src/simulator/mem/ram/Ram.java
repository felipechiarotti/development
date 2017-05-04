package simulator.mem.ram;

import simulator.mem.Assistente;
import simulator.mem.MemException;
import simulator.mem.Memoria;
import java.util.ArrayList;

public class Ram extends Memoria{
	private int bitsToAddress;
	private ArrayList<Bloco> blocos;
	private int blockSize;
	
	public Ram(int size, int cellSize, int mode, int blockSize){
		super(size,cellSize,mode);
		bitsToAddress = Assistente.calculateTotalBits(this.getSize());
		for(int i = 0; i<this.getSize(); i++){
			this.celulas.add(new Celula(cellSize,bitsToAddress));
		}
		
		this.blockSize = blockSize;
		blocos = new ArrayList<Bloco>();
		int x = 0;
		for(int i = 0; i<this.getTotalBlocks(); i++){
			Bloco bloco = new Bloco(this.blockSize);
			for(int j = 0; j<blockSize; j++){
				if(j==0) bloco.setAddress(this.getCellList().get(x).getAddress());
				bloco.setCelula(this.getCellList().get(x));
				x++;
			}

			blocos.add(bloco);
		}

	}
	
	public int getBitsToAddressRam(){
		return this.bitsToAddress;
	}
	
	public ArrayList<Bloco> getBlocos(){
		return this.blocos;
	}
	public int getTotalBlocks(){
		return this.getSize() / this.getBlockSize();
	}
	
	public int getBlockSize(){
		return this.blockSize;
	}
	public String read(String address) throws MemException{
			int pos = Integer.parseInt(address, 2);
			if(pos>celulas.size()){throw new MemException("Endereço não pode ser lido.");}	
			return celulas.get(pos).getContent();
	}
	
	public void write(String address, String content) throws MemException{
		int pos = Integer.parseInt(address,2);
		if(pos > celulas.size()) throw new MemException("Endereço não pode ser gravado.");
		else celulas.get(pos).setContent(content);
	}
}
