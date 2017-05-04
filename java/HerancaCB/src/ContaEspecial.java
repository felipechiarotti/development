
public class ContaEspecial extends Conta {

	public boolean saca(double valor){
		this.setSaldo(this.getSaldo()-valor);
		return true;
	}
}
