package estatistica.gui;
import estatistica.materiais.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;

public class Amostraa {
	JFrame frame;
	JPanel background;
	private ArrayList<Material> materiais;
	private int tamanhoAmostra;
	private int[] totalDeCadaGrupo;
	private int totalDeObjetos;
	private int[] totalDeCadaObjeto;
	private String nomePopulacao;
	private ArrayList<String> nomesGrupos;
	private static int amostra;
	
	public Amostra(ArrayList<Material> m, int tamanhoAmostra, int totalObjetos, int totalDeCadaObjeto[],ArrayList<String> nomesGrupos, String nomePopulacao){
		this.materiais = m;
		this.totalDeObjetos = totalObjetos;
		this.tamanhoAmostra = tamanhoAmostra;
		this.totalDeCadaObjeto = totalDeCadaObjeto;
		this.nomePopulacao = nomePopulacao;
		this.nomesGrupos = nomesGrupos;
		amostra++;
	}
	
	public void go(){
		frame = new JFrame("Amostra "+ amostra);
		background = new JPanel();
		Random random = new Random();
		ArrayList<Material> materiaisAmostra = new ArrayList<Material>();
		totalDeCadaGrupo = new int[totalDeObjetos];
		for(int i = 0; i<tamanhoAmostra; i++){
			int numeroAleatorio = random.nextInt(materiais.size());
					materiaisAmostra.add(materiais.get(numeroAleatorio));
					totalDeCadaGrupo[materiais.get(numeroAleatorio).group.getIdGrupo()]++;
		}
		String[] result = new String[totalDeObjetos];
		for(int i = 0; i<totalDeObjetos; i++){
			result[i] = "Total de Amostras de " +nomesGrupos.get(i)+": "+totalDeCadaGrupo[i];
		}
		JList list = new JList(result);
		JScrollPane scroll = new JScrollPane(list);
		scroll.setPreferredSize(new Dimension(400,100));
		
		frame.getContentPane().add(scroll);
		frame.pack();
		int y = (amostra-1)/3;
		int x = (amostra-1)%3;
		int resX = x*frame.getWidth();
		frame.setLocation(resX, (y*frame.getHeight()));
		frame.setVisible(true);
	}
}
