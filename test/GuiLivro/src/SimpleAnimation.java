import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {
	int x = 20;
	int y = 20;

	public static void main(String[] args){
		SimpleAnimation gui = new SimpleAnimation();
		gui.go();
	}
	
	public void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyDrawPanel2 drawPanel = new MyDrawPanel2();
		
		frame.getContentPane().add(drawPanel);
		frame.setSize(300,300);
		frame.setVisible(true);
		
		for(int j = 0; j<500; j++){
			for(int i = 0; i<130; i++){
				if(j%2==0){
					x++;
					y++;
				}else{
					x--;
					y--;
				}

				drawPanel.repaint();
				
				try{
					Thread.sleep(20);
				}catch(Exception ex){
					
				}
			}
		}
	}
	
	public class MyDrawPanel2 extends JPanel{
		public void paintComponent(Graphics g){
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			g.setColor(Color.orange);
			g.fillOval(x,y,100,100);
			

		}
	}
}
