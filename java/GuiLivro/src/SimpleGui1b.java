import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;

public class SimpleGui1b implements ActionListener {
	JButton button;
	MyDrawPanel panel;
	
	public static void main(String[] args){
		SimpleGui1b gui = new SimpleGui1b();
		gui.go();
	}
	
	
	
	public void go(){
		JFrame frame = new JFrame();
		panel = new MyDrawPanel();
		button = new JButton("Trocar Cor");
		button.addActionListener(this);
		
		frame.getContentPane().add(panel);
		panel.add(BorderLayout.EAST,button);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){
		panel.repaint();
	}
}
