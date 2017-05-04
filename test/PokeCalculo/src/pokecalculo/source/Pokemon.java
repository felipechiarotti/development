package pokecalculo.source;
import pokecalculo.source.*;
import java.io.*;
import java.util.*;
public class Pokemon {
	private int number;
	private String name;
	private HashMap<Integer, String> pokemonList;
	
	public Pokemon(boolean random){
		loadFile(new File("pokemon-list-complete.csv"));
		if(random){
			int randomNumber = (int)(Math.random()*151);
			setPokemon(randomNumber);
		}
	}
	
	public void setNumber(int n){
		this.number = n;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setPokemon(int n){
		setNumber(n);
		setName(pokemonList.get(n));
	}
	
	public int getNumber(){
		return this.number;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String toString(){
		return this.number +" - "+this.name;
	}
	
	public void loadFile(File file){
		try{
			pokemonList = new HashMap<Integer, String>();
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = reader.readLine())!= null){
				String[] tokens = line.split(",");
				pokemonList.put(Integer.parseInt(tokens[0]), tokens[1]);
			}
			reader.close();
		}catch(IOException ex){
			System.out.println(ex.getMessage());
		}
	}
}
