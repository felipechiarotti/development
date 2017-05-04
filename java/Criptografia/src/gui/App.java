package gui;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import util.*;

public class App {
	JFrame frame;
	Criptografy crip;
	JTextArea in;
	JTextArea out;
	
	public App(double[][] prim){
		crip = new Criptografy();
		crip.setPrimaryKey(prim);
	}
	
	public App(boolean r){
		crip = new Criptografy();
		double[][] primaryKey = new double[2][2];
		if(r){
			for(int i = 0; i<2; i++){
				for(int j = 0; j<2; j++){
					primaryKey[i][j] = (int)(Math.random()*9)+2;
				}
			}
		}else{
			for(int i = 0; i<2; i++){
				for(int j = 0; j<2; j++){
					primaryKey[i][j] = i+1+j;
				}                             
			}
		}
		crip.setPrimaryKey(primaryKey);		
	}
	
	public void go(){
		frame = new JFrame("Criptografia com Matrizes");
		
		JButton encrypt = new JButton("Criptografar");
		encrypt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					crip.setPhrase(in.getText());
					crip.encrypt();
					out.setText(crip.getStringPhrase(true));
			}
		});
		
		JButton decrypt = new JButton("Descriptografar");
		decrypt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(crip.status()){
					crip.decrypt();
				}
				in.setText(crip.getStringPhrase(false));
			}
		});
		in = new JTextArea(2,36);
		in.setLineWrap(true);
		out = new JTextArea(5,36);
		out.setLineWrap(true);
		
		JScrollPane scrollIn = new JScrollPane(in);
		JScrollPane scrollOut = new JScrollPane(out);

		frame.getContentPane().add(BorderLayout.WEST,scrollIn);
		frame.getContentPane().add(BorderLayout.EAST,scrollOut);
		frame.getContentPane().add(BorderLayout.NORTH,encrypt);
		frame.getContentPane().add(BorderLayout.SOUTH,decrypt);
		
		frame.setSize(800,400);
		frame.setVisible(true);
	}
}
