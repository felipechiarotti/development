import javax.swing.*;
public class Gui {
	public static  void main(String[] args){
		JFrame frame = new JFrame();
		JButton button = new JButton("Clique aqui");
		frame.getContentPane().add(button);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
}
