package estatistica.gui;

import estatistica.materiais.*;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class App {
	private int step;
	
	private JRadioButton[] option;
	private double optionValue;
	private boolean optionSelected;
	
	private JTextField populationName;
	private JComboBox significanceValue;
	private HashMap<Integer,Double> significanceValues;
	
	private JPanel groupPanel;
	private ArrayList<Grupo> group;
	private JTextField groupNames;
	private JTextField totalGroups;
	
	private JFrame frame;
	
	private JPanel topPanel;
	private JPanel southPanel;
	private JPanel background;
	
	ButtonGroup radioGroup;
	private JComboBox groupSelected;
	
	JButton continueButton;
	
	public void go(){
		step = 0;
		frame = new JFrame("Manipulável virtual: Estimando uma proporção populacional");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		background = new JPanel();
		topPanel = new JPanel(new GridLayout(2,2));
		
		JLabel populationNameLabel = new JLabel("Nome da População: ");
		JLabel quantityGroupLabel = new JLabel("Quantidade de Grupos: ");
		JLabel significanceValueLabel = new JLabel("Nível de Significância: ");
		String[] sig = {"1%","2%","3%","4%","5%","6%","7%","8%","9%","10%"};
		
		populationName = new JTextField();	
		populationName.addActionListener(new ContinueButtonListener());
		
		totalGroups = new JTextField("2");
		totalGroups.addActionListener(new ContinueButtonListener());
		significanceValue = new JComboBox(sig);
		
		continueButton = new JButton("Continuar");
		continueButton.addActionListener(new ContinueButtonListener());
		
		topPanel.add(populationNameLabel);	
		topPanel.add(populationName);
		topPanel.add(quantityGroupLabel);
		topPanel.add(totalGroups);
		background.add(BorderLayout.NORTH,topPanel);
				
		frame.getContentPane().add(BorderLayout.CENTER,background);
		frame.getContentPane().add(BorderLayout.SOUTH,continueButton);
		frame.setSize(680, 70);;
		frame.setVisible(true);
	}
	
	public void readSignificanceFile(){
		significanceValues = new HashMap<Integer,Double>();
		try{
			InputStream input = getClass().getResourceAsStream("/estatistica/files/significancia.csv");
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line = "";
			while((line = reader.readLine())!= null){
				String[] tokens = line.split(";");
				significanceValues.put(Integer.parseInt(tokens[0]), Double.parseDouble(tokens[1]));
			}
			
		}catch(IOException ex){
			JOptionPane.showMessageDialog(null, "Impossível localizar arquivo.");
		}
	}
	public class RadioButtonHandler implements ItemListener{
		public void itemStateChanged(ItemEvent event) {
			if(option[0].isSelected() || option[1].isSelected()){
				try{optionValue = Double.parseDouble(JOptionPane.showInputDialog("Digite o Valor:"));
				if(option[0].isSelected()){ optionSelected = false; }
				else{ optionSelected = true; }
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(null, "Margem de Erro ou População Inválida!\n\nEXEMPLOS:\nMargem de Erro: 0.05 \nTamanho da Amostra: 1800");
					radioGroup.clearSelection();
				}
			}
		}
		
	}
	public class ContinueButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			switch(step){
				case 0:
					 try{
						int total = Integer.parseInt(totalGroups.getText());
						if(populationName.getText().length() > 0 && total>1){
							groupPanel = new JPanel();
							groupPanel.setLayout(new BoxLayout(groupPanel,BoxLayout.Y_AXIS));
							group = new ArrayList<Grupo>();
							for(int i = 0; i<total; i++){
								String thisGroup = JOptionPane.showInputDialog("Nome do Grupo "+(i+1)+":");
								group.add(new Grupo(i,thisGroup));
								groupPanel.add(new JLabel("Quantidade de "+populationName.getText()+" do grupo "+thisGroup+":"));
								JTextField auxField = new JPasswordField(3);
								auxField.addActionListener(new ContinueButtonListener());
								groupPanel.add(auxField);

							}
							JCheckBox show = new JCheckBox("Exibir a quantidade de elementos em cada grupo");
							show.addItemListener(new ItemListener() {

					            @Override
					            public void itemStateChanged(ItemEvent e) {
					            	String text = "";
					            	int j = 0;
					            	for(int i = 1; i<groupPanel.getComponentCount(); i+=2){
					            		JPasswordField pass = (JPasswordField)groupPanel.getComponent(i);
					            		text+= group.get(j).getNomeGrupo()+": "+pass.getText()+"\n";
					            		j++;
					            	}
					               if(e.getStateChange() == ItemEvent.SELECTED){
					            	   JOptionPane messagePane = new JOptionPane(text,JOptionPane.INFORMATION_MESSAGE);
					            	   JDialog dialog = messagePane.createDialog("Quantidade de Elementos por Grupo");
					            	   dialog.setModal(false);
					            	   dialog.setVisible(true);
					            	   show.setSelected(false);
					               }
					            }
					        });
							groupPanel.add(show);
							background.add(BorderLayout.CENTER,groupPanel);
							frame.setSize(frame.getWidth(),frame.getHeight()+(50*total));
							step++;
						}else{
							JOptionPane.showMessageDialog(null, "Preencha os campos corretamente.");
						}
					}catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(null, "Número de Grupos Inválido.");
					}
				break;
				
				case 1:
					int totalComponents = groupPanel.getComponentCount();
					int i = 1;
					int j = 0;
					for(Grupo g : group){
						JTextField component = (JTextField)groupPanel.getComponent(i);
						try{
							int valor = Integer.parseInt(component.getText());
							group.get(j).setMaterial(valor);
							i+=2;
							j++;
						}catch(NumberFormatException ex){
							JOptionPane.showMessageDialog(null, "Preencha os valores corretamente.");;
						}

					}
					if(!group.isEmpty()){
						southPanel = new JPanel(new GridLayout(3,2));
						southPanel.add(new JLabel("Nível de Significância: "));
						southPanel.add(significanceValue);	
						
						southPanel.add(new JLabel("Estimar a proporção populacional do grupo: "));
						String[] gruposName = new String[group.size()];
						i = 0;
						for(Grupo g : group){
							gruposName[i] = g.getNomeGrupo();
							i++;
						}
						groupSelected = new JComboBox(gruposName);
						southPanel.add(groupSelected);
						southPanel.add(new JLabel("Fixar o valor de: "));
						radioGroup = new ButtonGroup();
						JPanel radioButtonPanel = new JPanel();
						option = new JRadioButton[2];
						option[0] = new JRadioButton("Margem de Erro",false);
						option[1] = new JRadioButton("Tamanho da Amostra",false);
						for(JRadioButton radio : option){
							radio.addItemListener(new RadioButtonHandler());
							radioButtonPanel.add(radio);
							radioGroup.add(radio);
						}
						
						southPanel.add(radioButtonPanel);
						background.add(BorderLayout.SOUTH,southPanel);
						frame.setSize(frame.getWidth(),frame.getHeight()+110);
						step++;
					}
				break;
				
				case 2:
					readSignificanceFile();	
					if(optionValue!=0){
						new Amostra(populationName.getText(), significanceValues.get(Integer.parseInt(significanceValue.getSelectedItem().toString().substring(0, 1))), group, group.get(groupSelected.getSelectedIndex()).getNomeGrupo(), optionSelected, optionValue).go();;					
					}else{
						JOptionPane.showMessageDialog(null, "Informe um valor de margem de erro ou tamanho da amostra!");
					}
				break;
			}
			frame.repaint();
			frame.revalidate();
			System.out.println(step);
		}
	}
	

	public static void main(String[] args){
		App gui = new App();
		gui.go();
	}
}
