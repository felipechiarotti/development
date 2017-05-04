package estatistica.materiais;

import java.util.ArrayList;

public class Grupo {
	private int idGrupo;
	private String nomeGrupo;
	private ArrayList<Material> material;
	
	public Grupo(int idGrupo, String nomeGrupo){
		this.idGrupo = idGrupo;
		this.nomeGrupo = nomeGrupo;
		material = new ArrayList<Material>();
	}
	public void setIdGrupo(int idGrupo){
		this.idGrupo = idGrupo;
	}
	
	public void setNomeGrupo(String nome){
		this.nomeGrupo = nome;
	}
	
	public int getIdGrupo(){
		return this.idGrupo;
	}
	
	public String getNomeGrupo(){
		return this.nomeGrupo;
	}
	
	public void setMaterial(int quant){
		for(int i = 0; i<quant; i++){
			material.add(new Material());
		}
	}
	
	public ArrayList<Material> getMaterial(){
		return this.material;
	}
}
