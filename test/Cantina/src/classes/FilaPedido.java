package classes;
import java.util.ArrayList;

public class FilaPedido {
	private ArrayList<Pedido> pedidos;
	
	public FilaPedido(){
		this.pedidos = new ArrayList<Pedido>();
	}
	
	public void add(Pedido p){
		this.pedidos.add(p);
	}
	
	public boolean remove(){
		if(!this.pedidos.isEmpty()){
			this.pedidos.remove(0);
			return true;
		}
		return false;
	}
	public int size(){
		return this.pedidos.size();
	}
	public Pedido get(int n){
		return this.pedidos.get(n);
	}
	public String toString(){
		String result = "";
		for(int i = 0; i<pedidos.size(); i++){
			result+=pedidos.get(i).getOrderingNumber() + " - " +pedidos.get(i).getClientName()+"\n";
		}
		return result;
	}
}
