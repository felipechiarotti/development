package machine.gui;

import java.awt.*;
import java.awt.event.*;

import javax.print.DocFlavor.URL;
import javax.swing.*;

public class Machine {
	JFrame frame;
	JPanel panel;
	JButton[] coinButton;
	JButton[] selectButton;
	JButton takeTroco;
	public JLabel saldoLabel;
	public JLabel trocoLabel;
	public int saldoValue;
	public int trocoValue;
	
	public void go(){
		frame = new JFrame("Máquina de Café");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		panel = new JPanel(new GridLayout(2,2));
		
		coinButton = new JButton[2];
		coinButton[0] = new JButton("25C");
		coinButton[0].addActionListener(new Coin25Listener());
		coinButton[1] = new JButton("50C");
		coinButton[1].addActionListener(new Coin50Listener());	
		
		selectButton = new JButton[2];
		selectButton[0] = new JButton("Coffee");
		selectButton[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(trocoValue>0){
					JOptionPane.showMessageDialog(null, "Retire seu troco antes de fazer o pedido!");
				}else{
					switch(saldoValue){
				case 0:
					JOptionPane.showMessageDialog(null, "Saldo Insuficiente, insira mais: R$0,"+(25-saldoValue));
				break;
				
				default:
					JOptionPane.showMessageDialog(null, "Processando: Café!\nEstado: Café");
					saldoValue-=25;
				}
				}
				frame.setTitle("Estado: "+saldoValue);
				saldoLabel.setText("Saldo: R$0,"+saldoValue);
			}
		});
		
		selectButton[1] = new JButton("Cappuccino");
		selectButton[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(trocoValue>0){
					JOptionPane.showMessageDialog(null, "Retire seu troco antes de fazer o pedido!");
				}else{
					switch(saldoValue){
				case 50:
					JOptionPane.showMessageDialog(null, "Processando: Cappuccino!\nEstado: Cappuccino");
					saldoValue-=50;
				break;
				
				default:
					JOptionPane.showMessageDialog(null, "Saldo insuficiente, insira mais: R$0,"+(50-saldoValue));
				}
				}
				frame.setTitle("Estado: "+saldoValue);
				saldoLabel.setText("Saldo: R$0,"+saldoValue);
			}
		});
		
		panel.add(coinButton[0]);
		panel.add(coinButton[1]);
		panel.add(selectButton[0]);
		panel.add(selectButton[1]);
		
		saldoLabel = new JLabel("Saldo: "+this.saldoValue);
		trocoLabel = new JLabel("Troco: "+this.trocoValue);
		takeTroco = new JButton("Retirar Troco");
		takeTroco.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				trocoValue = 0;
				trocoLabel.setText("Troco: R$0,00");
				frame.setTitle("Estado: "+saldoValue);
			}
		});
		JPanel top = new JPanel(new GridLayout(1,2));
		top.add(saldoLabel);
		top.add(trocoLabel);
		top.add(takeTroco);
		
		frame.getContentPane().add(top,BorderLayout.NORTH);
		frame.getContentPane().add(panel,BorderLayout.CENTER);
		
		ImageIcon icone = new ImageIcon("icon.png");
		frame.setIconImage(icone.getImage());
		frame.setSize(400,200);
		frame.setVisible(true);
	}
	
	public class Coin25Listener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			if(trocoValue>0){
				JOptionPane.showMessageDialog(null, "Retire seu troco antes de fazer o pedido!");
			}else{
			switch(saldoValue){
				case 0:
					saldoValue+=25;
				break;
				
				case 25:
					saldoValue+=25;
				break;
				
				case 50:
					trocoValue=25;
				break;
			}
			String[] estado = new String[2];
			estado[0] = "Estado: "+saldoValue;
			if(trocoValue>0){
				estado[1] = " || Estado: Devolver "+trocoValue;				
			}else{
				estado[1] = "";
			}

			frame.setTitle(estado[0]+estado[1]);
			saldoLabel.setText("Saldo: R$0,"+saldoValue);
			trocoLabel.setText("Troco: R$0,"+trocoValue);
		}}
		
	}
	
	public class Coin50Listener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			switch(saldoValue){
				case 0:
					saldoValue+=50;
				break;
				
				default:
					trocoValue=50;
			}
			String[] estado = new String[2];
			estado[0] = "Estado: "+saldoValue;
			if(trocoValue>0){
				estado[1] = " || Estado: Devolver "+trocoValue;				
			}else{
				estado[1] = "";
			}

			frame.setTitle(estado[0]+estado[1]);
			saldoLabel.setText("Saldo: R$0,"+saldoValue);
			trocoLabel.setText("Troco: R$0,"+trocoValue);
		}
	}
	public static void main(String[] args){
		new Machine().go();
	}
}
