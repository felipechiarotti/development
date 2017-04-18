package pokecalculo.source;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Gui {
	private JFrame frame;
	private JPanel panel;
	private JLabel[] pokemonLabel;
	private JLabel infoLabel;
	
	public void go(){
		frame = new JFrame("PokéCalculo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		Map mapa = new Map();
		for(int i = 0; i<60; i++){
			mapa.setPokemon();
		}
		int x = 0;
		infoLabel = new JLabel("Coordenada: ");
		pokemonLabel = new JLabel[60];
		Pokemon[][][]pokemons = mapa.getPokemon();
		ArrayList<ArrayList<Integer>> pokemonPos = mapa.getPokemonPos();
		for(int i = 0; i<pokemonPos.size(); i++){
			pokemonLabel[x] = new JLabel();
			pokemonLabel[x].setText(pokemons[pokemonPos.get(i).get(0)][pokemonPos.get(i).get(1)][pokemonPos.get(i).get(2)].getName()+" ("+pokemonPos.get(i).get(0)+","+pokemonPos.get(i).get(1)+","+pokemonPos.get(i).get(2)+")");
			pokemonLabel[x].setBounds(pokemonPos.get(i).get(0)*6, pokemonPos.get(i).get(1)*20, 500, 100);
			pokemonLabel[x].setFont(new Font("Serif",Font.PLAIN, (pokemonPos.get(i).get(2))+15));
			panel.add(pokemonLabel[x]);
			x++;
		}
		frame.getContentPane().add(panel);
		frame.setSize(137*7, 137*5);
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		Gui gui = new Gui();
		gui.go();
	}
}
