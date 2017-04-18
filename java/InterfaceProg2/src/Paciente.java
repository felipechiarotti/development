import java.util.Comparator;
public class Paciente implements Comparator<Paciente>{
	private String nome;
	private int prioridade;
	
	public int getPrioridade(){
		return this.prioridade;
	}

	public int compareTo(Paciente o) {
		// TODO Auto-generated method stub
		if(this.prioridade > o.getPrioridade()){
			return 1;
		}
		if(this.prioridade < o.getPrioridade()){
			return -1;
		}
		return 0;
	}

	@Override
	public int compare(Paciente arg0, Paciente arg1) {
		// TODO Auto-generated method stub
		return arg0.compareTo(arg1);
	}
}
