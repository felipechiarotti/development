import java.awt.*;
import javax.swing.*;

public class MyDrawPanel extends JPanel{
	public void paintComponent(Graphics g){
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		int red = (int)(Math.random()*255);
		int green = (int)(Math.random()*255);
		int blue = (int)(Math.random()*255);

		Color randomColor = new Color(red,green,blue);
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint gradient = new GradientPaint(50,50,randomColor,100,100,randomColor.brighter());
		
		g2d.setPaint(gradient);
		g2d.fillOval(10, 10, 220, 220);

	}
}
