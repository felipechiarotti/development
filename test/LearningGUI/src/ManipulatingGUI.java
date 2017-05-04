import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ManipulatingGUI implements ListSelectionListener{
	JList list;
	
	public void go(){
		JFrame frame = new JFrame("Nova Janela");
		JPanel panel = new JPanel();
		String[] listEntries = {"alpha","beta","gama","delta","epsilon","zeta","eta","theta"};
		list = new JList(listEntries);
		
		JScrollPane scroller = new JScrollPane(list);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		list.setVisibleRowCount(5);
		list.addListSelectionListener(this);
		
		
		panel.add(scroller);
		frame.getContentPane().add(BorderLayout.NORTH,panel);
		frame.setSize(250,200);
		frame.setVisible(true);
	}
	public void valueChanged(ListSelectionEvent lse){
		if(!lse.getValueIsAdjusting()){
			String selection = (String) list.getSelectedValue();
			System.out.println(selection);
		}
	}

	public static void main(String[] args){
		ManipulatingGUI gui = new ManipulatingGUI();	
		gui.go();
	}
}
