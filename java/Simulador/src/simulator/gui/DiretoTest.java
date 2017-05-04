package simulator.gui;

import simulator.mem.ram.Ram;
import simulator.mem.MemException;
import simulator.mem.cache.associativo.CacheAssociativo;
import simulator.mem.cache.direto.CacheDireto;
import simulator.mem.cache.associativo.CacheAssociativo;
import java.util.ArrayList;

public class DiretoTest {
	public static void main (String[]args){
		Ram ram = new Ram(64,8,1,4);
		CacheDireto cache = new CacheDireto(1,1,ram);
		try{
			ram.write("0000000000000000", "EOQ");
			ram.write("0000000000000001", "EOQ2");
			ram.write("0000000000000010", "EOQ3");
		}catch(MemException e){
			e.printStackTrace();
		}
		//CacheAssociativo cache = new CacheAssociativo(4,0,ram);
		try{
			System.out.println(cache.read("0000000000000000"));
			System.out.println(cache.read("0000000100000000"));
		}catch(MemException e){
			e.printStackTrace();
		}
		for(int i = 0; i<4; i++){
			for(int j = 0; j<cache.getLinhas().get(i).getCols().size(); j++){
				System.out.print(cache.getLinhas().get(i).getCols().get(j).getAddress()+" ");
			}
			System.out.println();
		}

		for(int j = 0; j<ram.getBlockSize(); j++){
			System.out.print(ram.getBlocos().get(0).getCelulas().get(j).getContent()+" ");
		}
		System.out.println();
		try{
			cache.write("0000000000000000", "Teste");
			for(int j = 0; j<ram.getBlockSize(); j++){
				System.out.print(ram.getBlocos().get(0).getCelulas().get(j).getContent()+" ");
			}	
		}catch(MemException ex){
		
		}

	}
}
