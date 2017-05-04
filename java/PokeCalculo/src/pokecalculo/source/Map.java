package pokecalculo.source;
import java.util.ArrayList;

import pokecalculo.source.*;
public class Map {
	private double totalArea;
	private Pokemon[][][] map;
	public int width;
	public int height;
	public int zAxis;
	public static int totalPokemon; 
	
	public Map(){
		width = height = 137;
		zAxis = 11;
		totalArea = width*height;
		map = new Pokemon[width][height][zAxis];
		totalPokemon = 0;
	}
	public void setPokemon(){
		boolean set = false;
		int[] setPosition = new int[3];
		Pokemon poke = null;
		do{
			poke = new Pokemon(true);
			int x = ((int)Math.sqrt(poke.getNumber()*totalPokemon))*2;
			System.out.println((int)(poke.getName().charAt(poke.getName().length()/2)));
			int y = (int)(poke.getName().charAt(poke.getName().length()/2)) /(totalPokemon+1);
			setPosition[0] = x;
			setPosition[1] = y;
			setPosition[2] = (int)(x/(zAxis+1));
			
			set = false;
			
			ArrayList<ArrayList<Integer>> pokemonPos = getPokemonPos();
			if(pokemonPos.size()>0){        
				for(int i = 0; i<pokemonPos.size(); i++){
				int[] pos = new int[3];
				for(int j = 0; j<pokemonPos.get(i).size(); j++){
					pos[j] = pokemonPos.get(i).get(j);
				}
				if(Plain.distance(pos, setPosition) < 5){
					set = true;
					break;
				}
				}
			}
		}while(set);
		map[setPosition[0]][setPosition[1]][setPosition[2]] = poke;
		totalPokemon++;
	}
	public void setPokemon(Pokemon poke){
		boolean set = false;
		int[] setPosition = new int[3];
		do{
			int x = ((int)Math.sqrt(poke.getNumber()*totalPokemon))*2;
			int y = (int)(poke.getName().charAt(poke.getName().length()/2)) /(totalPokemon+1);
			setPosition[0] = x;
			setPosition[1] = y;
			setPosition[2] = (int)(x/zAxis);
			
			set = false;
			
			ArrayList<ArrayList<Integer>> pokemonPos = getPokemonPos();
			if(pokemonPos.size()>0){        
				for(int i = 0; i<pokemonPos.size(); i++){
				int[] pos = new int[3];
				for(int j = 0; j<pokemonPos.get(i).size(); j++){
					pos[j] = pokemonPos.get(i).get(j);
				}
				if(Plain.distance(pos, setPosition) < 5){
					set = true;
					break;
				}
				}
			}
		}while(set);
		map[setPosition[0]][setPosition[1]][setPosition[2]] = poke;
		totalPokemon++;
	}
	
	public ArrayList<ArrayList<Integer>> getPokemonPos(){
		ArrayList<ArrayList<Integer>> pokemonPos = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i<this.width; i++){
			for(int j = 0; j<this.height; j++){
				for(int z = 0; z<zAxis; z++){
					if(map[i][j][z] != null){
						ArrayList<Integer> pos = new ArrayList<Integer>();
						pos.add(i);
						pos.add(j);
						pos.add(z);
						pokemonPos.add(pos);
					}
				}
			}
		}
		return pokemonPos;
	}
	public Pokemon[][][] getPokemon(){
		return this.map;
	}
	
}