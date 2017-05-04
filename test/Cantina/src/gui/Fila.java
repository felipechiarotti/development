package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import classes.*;

public class Fila {
	private JFrame frame;
	private DefaultListModel<String> list;
	private FilaPedido filaPedidos;
	private JList<String> listFila;
	
	public static void main(String[] args){
		Fila gui = new Fila();
		gui.go();
	}
	public void go(){
		frame = new JFrame("Controle de Pedidos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		filaPedidos = new FilaPedido();
		
		listFila = new JList<String>();
		JButton addPedido = new JButton("Novo Pedido");
		addPedido.addActionListener(new novoPedidoActionListener());
		
		JButton removePedido = new JButton("Entregar Pedido");
		removePedido.addActionListener(new removePedidoActionListener());
		
		frame.getContentPane().add(BorderLayout.CENTER,listFila);
		frame.getContentPane().add(BorderLayout.NORTH,addPedido);
		frame.getContentPane().add(BorderLayout.SOUTH,removePedido);
		
		frame.setSize(300,500);
		frame.setVisible(true);
	}
	
	public void UpdateJList(){
		list = new DefaultListModel<String>();
		for(int i = 0; i<filaPedidos.size(); i++){
			list.addElement(filaPedidos.get(i).toString());			
		}

		
		listFila.setModel(list);
		listFila.setSelectedIndex(0);
	}
	
	class novoPedidoActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			NewOrdering newGui = new NewOrdering();
			newGui.go();
		}
	}
	
	class removePedidoActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(filaPedidos.remove()){
				JOptionPane.showMessageDialog(null, "Removido");
				UpdateJList();
			}
		}
	}
	
	public class NewOrdering {
		JFrame frame;
		JTextField extras;
		JTextField nome;
		JTextField prato;
		private Pedido pedido;

		
		public void go(){
			frame = new JFrame("Adicionar um Pedido");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			pedido = new Pedido();
			
			JLabel pratoLabel = new JLabel("Nome do Prato: ");
			JLabel extraLabel = new JLabel("Extra: ");
			
			nome = new JTextField();
			nome.setColumns(15);
			
			extras = new JTextField();
			extras.setColumns(15);
			
			prato = new JTextField();
			prato.setColumns(15);
			
			JButton addExtra = new JButton("Adicionar Extra");
			addExtra.addActionListener(new addExtraListener());
			
			JButton removeExtra = new JButton("Remover Extra");
			removeExtra.addActionListener(new removeExtraListener());
			
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(4,2));
			panel.setBorder(BorderFactory.createTitledBorder("Novo Pedido"));
			panel.add(new JLabel("Nome do Cliente: "));
			panel.add(nome);
			
			panel.add(new JLabel("Nome do Prato: "));
			panel.add(prato);
			
			panel.add(new JLabel("Extra: "));
			panel.add(extras);
			
			panel.add(removeExtra);
			panel.add(addExtra);

			JButton finish = new JButton("Concluir Pedido");
			finish.addActionListener(new finishListener());
			
			frame.getContentPane().add(BorderLayout.CENTER,panel);
			frame.getContentPane().add(BorderLayout.SOUTH,finish);
			frame.pack();
			frame.setVisible(true);
		}
		
		class addExtraListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				if(extras.getText().length()>0){
					pedido.addExtra(extras.getText());
					extras.setText("");
				}
			}
		}
		class removeExtraListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				if(pedido.removeExtra(extras.getText())){
					JOptionPane.showMessageDialog(null, extras.getText()+" removido.");
					extras.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "Extra não existente na lista");
				}
			}
		}
		
		class finishListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				if(prato.getText().length()>0 && nome.getText().length()>0){
					pedido.setClientName(nome.getText());
					pedido.setRefeicao(prato.getText());
					JOptionPane.showMessageDialog(null, "Pedido Adicionado");
					filaPedidos.add(pedido);
					UpdateJList();
					frame.dispose();
				}
			}
		}
	}
}
