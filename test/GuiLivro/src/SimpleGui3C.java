import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui3C {
	JFrame frame;
	JLabel label;
	
	public void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("Mudar Cor");
		button.addActionListener(new ColorListener());
		
		JButton buttonLabel = new JButton("Alterar");
		buttonLabel.addActionListener(new LabelListener());
		
		
		label = new JLabel("Sou uma Label");
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.WEST, label);
		frame.getContentPane().add(BorderLayout.EAST,buttonLabel);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		
		
		frame.setSize(430,300);
		frame.setVisible(true);
	}
	
	class LabelListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			label.setText("Tome Cuidado!");
		}
	}
	
	class ColorListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			frame.repaint();
		}
	}
	
	public static void main(String[] args){
		SimpleGui3C gui = new SimpleGui3C();
		gui.go();
	}
}
