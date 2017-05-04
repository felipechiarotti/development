package simulator.mem.ram;

import java.util.Random;

import simulator.mem.Assistente;

public class Celula{
		private String address;
		private String content;
		private static int position;
		
		public Celula(int cellSize, int bitSize){
			content = Integer.toBinaryString((new Random().nextInt(256)));
			content = Assistente.fillAddress(content,cellSize);
			
			address = Integer.toBinaryString(position);
			address = Assistente.fillAddress(address, bitSize);
			
			position++;
		}
		
		public void setContent(String content){
			this.content = content;
		}
		
		public String getContent(){
			return this.content;
		}
		
		public String getAddress(){
			return this.address;
		}
}
