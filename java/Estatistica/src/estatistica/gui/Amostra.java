package estatistica.gui;
import estatistica.materiais.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.awt.*;

public class Amostra {
	private JFrame frame;
	private JPanel panel;
	private String populationName;
	private String groupPopulationProp;
	private int totalElements;
	private double marginError;
	private double significanceValue;
	private int sampleSize;
	private double populationalProp;
	private HashMap<String,Integer> amostra;
	private ArrayList<Grupo> grupos;
  	private static int amostraNumber;

	
	public Amostra(String populationName, double significanceValue, ArrayList<Grupo> grupos, String groupPopulationProp, boolean option, double optionValue){
      	amostraNumber++;
		this.populationName = populationName;
		this.significanceValue = significanceValue;
		this.grupos = grupos;
		this.groupPopulationProp = groupPopulationProp;
		if(option){
			this.sampleSize = (int)optionValue;
		}else{
			this.marginError = optionValue;
		}
	}
	public void go(){
		calculateTotalElements();
		calculatePopulationalProp();
		
		if(this.sampleSize == 0) {
			calculateSampleSize();
		}else{ 
			calculateMarginError();
		}
		amostra = new HashMap<String,Integer>();
		Random random = new Random();
		ArrayList<Integer> generatedNumbers = new ArrayList<Integer>();
		for(int i = 0; i<sampleSize; i++){
			int number = 0;
			do{
				number = random.nextInt(totalElements);
			}while(generatedNumbers.contains(number));
			generatedNumbers.add(number);
			for(Grupo g : grupos){
				for(int j = 0; j<g.getMaterial().size(); j++){
					if(g.getMaterial().get(j).getId() == number){
						int newValue = 1;
						if(amostra.get(g.getNomeGrupo())!=null){newValue = amostra.get(g.getNomeGrupo()).intValue()+1; }
						amostra.put(g.getNomeGrupo(), newValue);
					}
				}
			}
		}

		String tamanhoDaAmostra = "Tamanho da Amostra: "+sampleSize+"\n";
		String margemDeErro = "Margem de Erro: "+marginError+"\n";
		String grupo = "Grupo "+grupos.get(0).getNomeGrupo()+": "+amostra.get(grupos.get(0).getNomeGrupo())+"\n";
		//String proporcaoPopulacional = "Proporção Populacional de "+groupPopulationProp+": "+populationalProp+"\n";
		String proporcaoPopulacional = "";
		for(int i = 1; i<amostra.size(); i++){
			grupo = grupo + "Grupo "+grupos.get(i).getNomeGrupo()+": "+amostra.get(grupos.get(i).getNomeGrupo())+"\n";
		}
		JOptionPane msg =  new JOptionPane(tamanhoDaAmostra+margemDeErro+proporcaoPopulacional+grupo, JOptionPane.INFORMATION_MESSAGE);
		JDialog dialog = msg.createDialog( "Amostra "+amostraNumber);

		dialog.setModal(false);
		dialog.setVisible(true);
	}
	
	public void calculateSampleSize(){
		double aboveValue = (double)totalElements*(populationalProp*(1.0-populationalProp))*Math.pow(significanceValue, 2);
		double belowValue = ((populationalProp*(1.0-populationalProp))*Math.pow(significanceValue, 2))+((totalElements-1)*Math.pow(marginError,2));
		this.sampleSize = (int)Math.ceil(aboveValue / belowValue);
	}
	
	public void calculateMarginError(){
		double doubleSampleSize = (double)sampleSize;
		double doubleTotalElements = (double)totalElements;
		double resPopulationalProp = 1.0 - populationalProp;
		double resultPQ = populationalProp*resPopulationalProp;
		double auxValue = Math.sqrt(resultPQ/doubleSampleSize)*Math.sqrt(((doubleTotalElements-doubleSampleSize)/(doubleTotalElements-1)));
		this.marginError = significanceValue*auxValue;
	}
	
	public void calculatePopulationalProp(){
		for(Grupo g : grupos){
			if(g.getNomeGrupo().equals(groupPopulationProp)){
				populationalProp = (double)g.getMaterial().size()/ (double)totalElements;
			}
		}
	}
	
	public void calculateTotalElements(){
		for(Grupo g : grupos){
			totalElements += g.getMaterial().size();
		}
	}
}
