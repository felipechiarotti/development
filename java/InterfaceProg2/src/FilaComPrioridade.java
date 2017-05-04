import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
public class FilaComPrioridade<T> implements IPrioridade<T> {
	List<T> pacientes;
	public FilaComPrioridade(int total){
		this.pacientes = new ArrayList<T>();
	}
	public void inserir(T p){
		pacientes.add(p);
	}
	
	public T remover(){
		T p = pacientes.get(0);
		pacientes.remove(0);
		return p;
	}
	
	public boolean estaVazia(){
		return pacientes.isEmpty();
	}
	}
