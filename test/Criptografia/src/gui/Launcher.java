package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Launcher {
	private JFrame frame;

        
    	public class ConfigMatrix{
    		private JFrame janela;
    		private JPanel panel;
    	    private JTextField primeiroDigito;
    	    private JTextField segundoDigito;
    	    private JTextField terceiroDigito;
    	    private JTextField quartoDigito;
    	    private JTextField quintoDigito;
    	    private JTextField sextoDigito;
    	    private JTextField setimoDigito;
    	    private JTextField oitavoDigito;
    	    private JTextField nonoDigito;
    	    
    	    public void go(){
    	    	janela = new JFrame("Configuração de Chave");
    	    	 panel = new JPanel(new GridLayout(3,3));
    	    		JButton finishPerson = new JButton("Concluir");
                    finishPerson.addActionListener(new ActionListener(){
                       public void actionPerformed(ActionEvent e){
                           if(primeiroDigito.getText().length()>0 && segundoDigito.getText().length()>0 && quartoDigito.getText().length()>0 && quintoDigito.getText().length()>0){
                               if(terceiroDigito.getText().length()>0 && sextoDigito.getText().length()>0 && nonoDigito.getText().length()>0){
                            	   double[][] mat = {{Double.parseDouble(primeiroDigito.getText()),Double.parseDouble(segundoDigito.getText()),Double.parseDouble(terceiroDigito.getText())},
                            			   			 {Double.parseDouble(quartoDigito.getText()),Double.parseDouble(quintoDigito.getText()),Double.parseDouble(sextoDigito.getText())},
                            			   			 {Double.parseDouble(setimoDigito.getText()),Double.parseDouble(oitavoDigito.getText()),Double.parseDouble(nonoDigito.getText())}};
                                   App app = new App(mat);
                                   app.go();
                               }else{
                                   double[][] mat = {{Double.parseDouble(primeiroDigito.getText()),Double.parseDouble(segundoDigito.getText())},{Double.parseDouble(quartoDigito.getText()),Double.parseDouble(quintoDigito.getText())}};
                                   App app = new App(mat);
                                   app.go();
                               }
                               janela.dispose();
                           }else{
                               JOptionPane.showMessageDialog(null, "Preencha pelo menos uma matriz de ordem quadrada!");
                           }
                       }
                       
                    });              
                 primeiroDigito = new JTextField();
                 segundoDigito = new JTextField();
                 terceiroDigito = new JTextField();
                 quartoDigito = new JTextField();
                 quintoDigito = new JTextField();
                 sextoDigito = new JTextField();
                 setimoDigito = new JTextField();
                 oitavoDigito = new JTextField();
                 nonoDigito = new JTextField();
                 
                 
                 panel.add(primeiroDigito);
                 panel.add(segundoDigito);
                 panel.add(terceiroDigito);
                 panel.add(quartoDigito);
                 panel.add(quintoDigito);
                 panel.add(sextoDigito);
                 panel.add(setimoDigito);
                 panel.add(oitavoDigito);
                 panel.add(nonoDigito);
                 janela.getContentPane().add(BorderLayout.SOUTH,finishPerson);
                 
                 janela.getContentPane().add(BorderLayout.NORTH,panel);
                 janela.setLocationRelativeTo(null);
                 janela.setSize(300,120);
                 janela.setVisible(true);
         	
    	    }
    	}
	public void go(){
		
		frame = new JFrame("Criptografia com Matrizes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
		JButton patternApp = new JButton("Padrão");
		patternApp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				App app = new App(false);
				app.go();
			}
		});
		
		JButton randomApp = new JButton("Aleatório");
		randomApp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				App app = new App(true);
				app.go();
			}
		});
		
		JButton personApp = new JButton("Personalizado");
		personApp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
                ConfigMatrix conf = new ConfigMatrix();
                conf.go();
			}
		});
                
		
		frame.getContentPane().add(BorderLayout.EAST,patternApp);
		frame.getContentPane().add(BorderLayout.WEST,randomApp);
		frame.getContentPane().add(BorderLayout.CENTER,personApp);

        frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args){
		Launcher gui = new Launcher();
		gui.go();
	}
}
