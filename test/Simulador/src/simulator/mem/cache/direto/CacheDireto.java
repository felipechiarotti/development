package simulator.mem.cache.direto;

import simulator.mem.MemException;
import simulator.mem.ram.Bloco;
import simulator.mem.ram.Celula;
import simulator.mem.ram.Ram;
import simulator.mem.cache.Cache;
import simulator.mem.cache.Linha;

public class CacheDireto extends Cache{
	public CacheDireto(int size, int mode, Ram ram){
		super(size, mode, ram);
	}
	
	public String read(String address) throws MemException{
		int pos = Integer.parseInt(address,2);
		
		String line = "";
		for(int i = 0; i<this.getBitsToAddressLine(); i++){
			line+=address.charAt(i);
		}

		String tag = "";
		for(int i = this.getBitsToAddressLine(); i<this.getBitsToAddressTag()+this.getBitsToAddressLine(); i++){
			tag+= address.charAt(i);
		}

		String col = "";
		for(int i = this.getBitsToAddressTag()+this.getBitsToAddressLine(); i<address.length(); i++){
			col+= address.charAt(i);
		}
		
		int lineNumber = Integer.parseInt(line,2);
		int tagNumber = Integer.parseInt(tag,2);
		int colNumber = Integer.parseInt(col,2);
		
		if(lineNumber<this.getTotalLines() && address.length()== this.getBitsToAddressColByte()+this.getBitsToAddressLine()+this.getBitsToAddressTag()){
			Linha linha = this.getLinhas().get(lineNumber);
			if(linha.getTag()==null || !linha.getTag().equals(tag)){
				try{
					String result = ram.read(address);
					writeCache(address);
					return result;
				}catch(MemException e){
					throw new MemException(e.getMessage());
				}
			}else{
				return linha.getCols().get(colNumber).getContent();
			}
		}
		throw new MemException("Endereço Inválido.");
	}
	
	public void write(String address, String content) throws MemException{
		try{
			ram.write(address, content);
			this.writeCache(address);
		}catch(MemException e){
			throw new MemException(e.getMessage()); 
		}
	}
	
	public void writeCache(String address) throws MemException{
		Bloco bloco = null;
		for(Bloco b : ram.getBlocos()){
			for(Celula c : b.getCelulas()){
				if(c.getAddress().equals(address)){
					bloco = b;
					break;
				}
			}
		}
		String line = "";
		for(int i = 0; i<this.getBitsToAddressLine(); i++){
			line+=address.charAt(i);
		}
		
		String tag = "";
		for(int i = this.getBitsToAddressLine(); i<this.getBitsToAddressTag()+this.getBitsToAddressLine(); i++){
			tag+= address.charAt(i);
		}

		int lineNumber = Integer.parseInt(line,2);
		this.getLinhas().get(lineNumber).setLinha(tag, bloco);
	}
}
