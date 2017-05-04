package estatistica.gui;
import javax.swing.*;
import estatistica.materiais.Material;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.*;

public class Launch {
	JFrame frame;
	ArrayList<JLabel> totalMaterialLabel;
	ArrayList<JTextField> totalMaterialField;		
	JPanel background;
	JTextField totalMateriaisTextField;
	ArrayList<String> nomesGrupos;
	public void go(){
		String populacao = JOptionPane.showInputDialog("Digite o nome da População");

		frame = new JFrame("Análise Estatística");
		background = new JPanel();
		JPanel topPanel = new JPanel();
		
		JLabel totalMateriaisLabel = new JLabel ("Quantidade de "+populacao+": ");
		totalMateriaisTextField = new JTextField(3);
		totalMateriaisTextField.setText("2");
		
		JButton setConfigs = new JButton("Iniciar");
		setConfigs.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				totalMaterialLabel = new ArrayList<JLabel>();
				totalMaterialField = new ArrayList<JTextField>();
				int totalMateriais = Integer.parseInt(totalMateriaisTextField.getText());
				if(totalMateriais>1){
					GridLayout grid = new GridLayout(totalMateriais,2);
					JPanel panel = new JPanel(grid);

					//Box labelBox = new Box(BoxLayout.Y_AXIS);
					//Box fieldBox = new Box(BoxLayout.Y_AXIS);
					nomesGrupos = new ArrayList<String>();
					for(int i = 0; i<totalMateriais; i++){
						nomesGrupos.add(JOptionPane.showInputDialog("Digite o nome do(a) "+populacao+" "+(i+1)));
						JLabel quantObjetoLabel = new JLabel("Quantidade de "+nomesGrupos.get(i)+": ");
						JTextField quantObjetoField = new JTextField(5);
						totalMaterialLabel.add(quantObjetoLabel);
						totalMaterialField.add(quantObjetoField);
						panel.add(quantObjetoLabel);
						panel.add(quantObjetoField);
					}
					if(background.getComponentCount()>1){
						for(int i = 0; i<background.getComponentCount(); i++){
							background.remove(1);
						}
					}
					JPanel southPanel = new JPanel();
					JButton getAmostras = new JButton("Coletar Amostra");
					JLabel totalAmostrasLabel = new JLabel("Tamanho da Amostra: ");
					JTextField totalAmostrasField = new JTextField(4);
					getAmostras.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							int totalMateriais = Integer.parseInt(totalMateriaisTextField.getText());
							ArrayList<Material> m = new ArrayList<Material>();
							int[] totalDeCada = new int[totalMateriais];
							for(int i = 0; i<totalMateriais; i++){
								int matAtualSize = Integer.parseInt(totalMaterialField.get(i).getText());
								totalDeCada[i] = matAtualSize;
								for(int j = 0; j<matAtualSize; j++){
									m.add(new Material(i,nomesGrupos.get(i)));
								}
							}			
							
//							float estimativaP;
//							float margemDeErro;
//							float nivelSignificancia;
//							float calc = (total*estimativaP*(1-estimativaP)*(()));
//							int tamanhoAmostra;
							
							int total=0;
							for(int i = 0; i<totalDeCada.length; i++){
								total+=totalDeCada[i];
							}
							if(total<Integer.parseInt(totalAmostrasField.getText())){
								JOptionPane.showMessageDialog(null, "Tamanho da Amostra precisa ser menor que o total de itens.");
							}else{
								Amostra guiAmostra = new Amostra(m,Integer.parseInt(totalAmostrasField.getText()),totalMateriais,totalDeCada,nomesGrupos,populacao);
								guiAmostra.go();
							}
						}
					});

					JScrollPane scroll = new JScrollPane(panel);
					scroll.setPreferredSize(new Dimension(390,(totalMateriais<25)?(20*totalMateriais)+10:(20*25)));

					
					southPanel.add(BorderLayout.WEST,totalAmostrasLabel);
					southPanel.add(BorderLayout.EAST,totalAmostrasField);
					southPanel.add(BorderLayout.CENTER,getAmostras);
					background.add(BorderLayout.CENTER,scroll);
					background.add(BorderLayout.SOUTH,southPanel);

					frame.setSize(400,(totalMateriais<25)?140+(20*totalMateriais) : 130+(20*25));
					frame.repaint();
					frame.revalidate();

				}else{
					JOptionPane.showMessageDialog(null, "Preencha com pelo menos 2 Objetos!");
				}
			}
		});

		topPanel.add(BorderLayout.EAST,totalMateriaisLabel);
		topPanel.add(BorderLayout.CENTER,totalMateriaisTextField);
		topPanel.add(BorderLayout.WEST,setConfigs);
		background.add(BorderLayout.NORTH,topPanel);


		frame.getContentPane().add(background);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,90);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
}
