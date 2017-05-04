	package estatistica.materiais;

public class Material {
	private int id;
	private static int total;
	
	public Material(){
		this.id = total;
		total++;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
}
