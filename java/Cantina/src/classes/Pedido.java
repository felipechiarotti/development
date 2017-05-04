package classes;
import java.util.ArrayList;
public class Pedido {
	private String clientName;
	private int orderingNumber;
	
	private String refeicao;
	private ArrayList<String> extras;
	
	public Pedido(){
		extras = new ArrayList<String>();
	}
	
	public void setClientName(String cn){
		this.clientName = cn;
	}
	
	public void setOrderingNumber(int n){
		this.orderingNumber = n;
	}
	
	public void setRefeicao(String r){
		this.refeicao = r;
	}
	
	public String getClientName(){
		return this.clientName;
	}
	
	public String getRefeicao(){
		return this.refeicao;
	}
	
	public int getOrderingNumber(){
		return this.orderingNumber;
	}
	
	public String getExtras(){
		String result="";
		for(int i = 0; i<extras.size(); i++){
			result+= extras.get(i)+"\n";
		}
		return result;
	}
	
	public void addExtra(String n){
		this.extras.add(n);
	}
	
	public boolean removeExtra(String n){
		if(this.extras.contains(n)){
			this.extras.remove(n);
			return true;
		}
		return false;
	}
	
	public String toString(){
		return getClientName()+" - "+getRefeicao();
	}
}
