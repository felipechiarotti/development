package simulator.gui;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import simulator.mem.MemException;
import simulator.mem.cache.Cache;
import simulator.mem.cache.associativo.CacheAssociativo;
import simulator.mem.cache.direto.CacheDireto;
import simulator.mem.ram.Ram;

public class App {
	JFrame frame;
	JPanel mainPanel;
	JComboBox methodCombo;
	JTable ram;
	JTable cache;
	JTextField[] writeArea;
	JTextField readArea;
	Cache memCache;
	Ram memRam;
	
	JLabel addressBarr;
	JLabel dataBarr;
	JLabel signalBarr;
	
	int sizeCache = 16;
	int modeBytes = 0;
	
	public void go(){
		memRam = new Ram(64,8,0,2);
		memCache = new CacheDireto(16,0,memRam);

		
		frame = new JFrame("Simulador");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(1100, 250);
		mainPanel = new JPanel(new GridLayout(1,3));
		
		String[] methodString = {"Direto","Associativo","Associativo por Conjunto"};
		methodCombo = new JComboBox(methodString);
		methodCombo.setPreferredSize(new Dimension(100, 25));
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.BLACK);
		
		JPanel middlePanel = new JPanel();

		
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(Color.BLACK);
		
		cache = new JTable(		memCache.getTotalLines(),memCache.getBlockSize()+1);
		cache.getColumnModel().getColumn(0).setHeaderValue("Tag");
		cache.getColumnModel().getColumn(1).setHeaderValue("Byte 0");
		cache.getColumnModel().getColumn(2).setHeaderValue("Byte 1");
		JScrollPane cacheScroller = new JScrollPane(cache);
		cacheScroller.setPreferredSize(new Dimension(350,200));
		
		JLabel cacheLabel = new JLabel("CACHE");
		cacheLabel.setForeground(Color.WHITE);
		leftPanel.add(cacheLabel);
		leftPanel.add(cacheScroller);
		
		ram = new JTable(0,2);
		ram.getColumnModel().getColumn(0).setHeaderValue("Endereço");
		ram.getColumnModel().getColumn(1).setHeaderValue("Valor");
		DefaultTableModel model = (DefaultTableModel)ram.getModel();
		for(int i = 0; i<memRam.getSize(); i++){
			Object[] linha = {memRam.getCellList().get(i).getAddress(),memRam.getCellList().get(i).getContent()};
			model.addRow(linha);
		}

		JScrollPane ramScroller = new JScrollPane(ram);
		ramScroller.setPreferredSize(new Dimension(350,200));
		
		JLabel ramLabel = new JLabel("RAM");
		ramLabel.setForeground(Color.WHITE);
		rightPanel.add(ramLabel);
		rightPanel.add(ramScroller);
		
		String[] comboString = {"Direto","Associativo","Associativo p/ Conjunto"};
		methodCombo = new JComboBox(comboString);
		methodCombo.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent itemEvent){
				if(itemEvent.getStateChange()==ItemEvent.SELECTED){
					String item = (String)itemEvent.getItem();
					switch(item){
						case "Direto":
							memCache = new CacheDireto(sizeCache,modeBytes,memRam);
						break;
						
						case "Associativo":
							memCache = new CacheAssociativo(sizeCache,modeBytes,memRam);
						break;
						
						case "Associativo p/ Conjunto":
							
						break;
					}
					cache.setModel(new DefaultTableModel(memCache.getTotalLines(),memCache.getBlockSize()+1));
				}
			}
		});
		middlePanel.add(BorderLayout.NORTH,new JLabel("Método: "));
		middlePanel.add(BorderLayout.NORTH,methodCombo);
		
		JPanel readPanel = new JPanel(new GridLayout(1,3));
		readPanel.setBorder(BorderFactory.createTitledBorder("Leitura"));
		readArea = new JTextField();
		readArea.setColumns(10);
		JButton readButton = new JButton("Buscar");
		readButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					frame.repaint();
					String content = memCache.read(readArea.getText());
					addressBarr.setText("Barramento de Endereço: "+readArea.getText());
					signalBarr.setText("Barramento de Controle: READ");
					dataBarr.setText("Barramento de Dados: "+content);
					updateCacheTable();

				}catch(MemException ex){
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		
		readPanel.add(new JLabel("Endereço:"));
		readPanel.add(readArea);
		readPanel.add(readButton);
		
		JPanel writePanel = new JPanel(new GridLayout(2,3));
		writePanel.setBorder(BorderFactory.createTitledBorder("Gravação"));
		writeArea = new JTextField[2];
		for(int i = 0; i<writeArea.length; i++){writeArea[i] = new JTextField(); writeArea[i].setColumns(10);}
		JButton writeButton = new JButton("Gravar");
		writeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String address = writeArea[0].getText();
				String content = writeArea[1].getText();
				
				try{
					frame.repaint();
					
					memCache.write(address, content);

					addressBarr.setText("Barramento de Endereço: "+address);
					signalBarr.setText("Barramento de Controle: WRITE");
					dataBarr.setText("Barramento de Dados: "+content);
					
					DefaultTableModel ramModel = (DefaultTableModel)ram.getModel();
					int pos = Integer.parseInt(address,2);
					ramModel.setValueAt(content, pos, 1);
					updateCacheTable();
				}catch(MemException ex){
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		
		writePanel.add(new JLabel("Endereço:"));
		writePanel.add(writeArea[0]);
		writePanel.add(writeButton);
		writePanel.add(new JLabel("Valor:"));
		writePanel.add(writeArea[1]);
		
		JPanel barrPanel = new JPanel(new GridLayout(7,1)){
			public void paintComponent(Graphics g){	
				g.setColor(Color.GREEN);
				g.fillRect(0, 25, 360, 5);
				g.fillRect(0, 50, 360, 5);
				g.fillRect(0, 80, 360, 5);
			}
		};
		barrPanel.setPreferredSize(new Dimension(360,200));
		dataBarr = new JLabel("Barramento de Dados:");
		addressBarr = new JLabel("Barramento de Endereço:");
		signalBarr = new JLabel("Barramento de Controle:");
		
		barrPanel.add(addressBarr);
		barrPanel.add(dataBarr);
		barrPanel.add(signalBarr);
		
		middlePanel.add(readPanel);
		middlePanel.add(writePanel);
		middlePanel.add(barrPanel);
		mainPanel.add(BorderLayout.NORTH,leftPanel);
		mainPanel.add(BorderLayout.NORTH,middlePanel);
		mainPanel.add(BorderLayout.NORTH,rightPanel);
		frame.getContentPane().add(mainPanel);

		frame.setVisible(true);
	}
	
	private void updateCacheTable(){
		DefaultTableModel cacheModel = (DefaultTableModel)cache.getModel();
		for(int i = 0; i<memCache.getLinhas().size(); i++){
			if(memCache.getLinhas().get(i).getTag()!=null){ 
				Object[] linha = new Object[memCache.getLinhas().get(0).getCols().size()+1];
				linha[0] = memCache.getLinhas().get(i).getTag();
				cacheModel.setValueAt(linha[0], i, 0);
				int z = 1;
				for(int j = 0; j<linha.length-1; j++){
					linha[z] = memCache.getLinhas().get(i).getCols().get(j).getContent();
					System.out.println(linha[z]);
					cacheModel.setValueAt(linha[z], i, z);
					z++;
				}
			}
		}
	}
	public static void main(String[] args){
		new App().go();
	}
}
