package simulator.mem.cache.associativo;

import java.util.ArrayList;

import simulator.mem.MemException;
import simulator.mem.cache.Cache;
import simulator.mem.cache.Linha;
import simulator.mem.ram.Bloco;
import simulator.mem.ram.Celula;
import simulator.mem.ram.Ram;

public class CacheAssociativo extends Cache{
	public CacheAssociativo (int size, int mode, Ram ram){
		super(size, mode, ram);	
	}

	public String read(String address) throws MemException {
		String result = "";
		
		String auxTag = "";
		for(int i = 0; i<this.getBitsToAddressTag()+this.getBitsToAddressLine(); i++){
			auxTag+=address.charAt(i);
		}

		String auxCol = "";
		for(int i = this.getBitsToAddressLine()+this.getBitsToAddressTag(); i<this.getBitsToAddressColByte(); i++){
			auxCol+= address.charAt(i);
		}
		
		ArrayList<Linha> linhas = this.getLinhas();
		for(int i = 0; i<this.getTotalLines(); i++){
			Linha linha = linhas.get(i);
			if(linha.getTag()!= null && linha.equals(auxTag)){
				result = linha.getCols().get(Integer.parseInt(auxCol,2)).getContent();
				return result;
			}
		}
		try{
			result = ram.read(address);
			writeCache(address);
			return result;
		}catch(MemException e){
			throw new MemException(e.getMessage());
		}
	}

	
	public void writeCache(String address) throws MemException {
		Bloco b = null;
		for(Bloco bl : ram.getBlocos()){
			for(Celula cel : bl.getCelulas()){
				if(cel.getAddress().equals(address)){
					b = bl;
					break;
				}
			}
		}
		Linha linha = null;
		int priority = Integer.parseInt(this.getLinhas().get(0).getId(),2);
		int line = 0;
		for(int i = 1; i<this.getTotalLines(); i++){
			if(Math.min(Integer.parseInt(this.getLinhas().get(i).getId(),2),priority) < priority){
				linha = this.getLinhas().get(i);
				priority = Integer.parseInt(linha.getId(),2);
				line = i;
			};
		}
		address = address.substring(0, getBitsToAddressTag()+getBitsToAddressLine());
		boolean already = false;
		for(Linha l : this.getLinhas()){
			if(l.getTag()!=null){
				if(l.getTag().equals(address)){
					already = true;
					break;
				}
			}
		}
		if(!already)this.getLinhas().get(line).setLinha(address, b);
	}
	
	public void write(String address, String content) throws MemException{
		try{
			ram.write(address, content);
			this.writeCache(address);
		}catch(MemException e){
			throw new MemException(e.getMessage());
		}
	}	
}
