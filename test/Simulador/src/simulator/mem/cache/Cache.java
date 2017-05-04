package simulator.mem.cache;

import java.util.ArrayList;

import simulator.mem.Assistente;
import simulator.mem.MemException;
import simulator.mem.Memoria;
import simulator.mem.ram.Ram;

abstract public class Cache extends Memoria{
		private ArrayList<Linha> linhas;
		private int totalLines;
		private int blockSize;
		private int bitsToAddressLines;
		private int bitsToAddressTag;
		private int bitsToAddressColByte;
		public Ram ram;
		
		public Cache(int size, int mode, Ram ram){
			super(size, ram.getCellSize(), mode);
			this.ram = ram;
			linhas = new ArrayList<Linha>();
			this.blockSize = ram.getBlockSize();
			
			bitsToAddressColByte = Assistente.calculateTotalBits(blockSize);
			setTotalLines();
			for(int i = 0; i<this.totalLines; i++){
				this.linhas.add(new Linha());
			}
			bitsToAddressLines = Assistente.calculateTotalBits(totalLines);
			bitsToAddressTag = Assistente.calculateTotalBits(ram.getTotalBlocks()/this.totalLines);
		}
		
		private void setTotalLines(){
			totalLines = this.getSize() / this.blockSize;
		}
		public int getBitsToAddressColByte(){
			return this.bitsToAddressColByte;
		}

		public int getTotalLines(){
			return this.totalLines;
		}
		
		public int getBlockSize(){
			return this.blockSize;
		}
		
		public int getBitsToAddressTag(){
			return this.bitsToAddressTag;
		}
		
		public int getBitsToAddressLine(){
			return this.bitsToAddressLines;
		}
		public ArrayList<Linha> getLinhas(){
			return this.linhas;
		}
}
