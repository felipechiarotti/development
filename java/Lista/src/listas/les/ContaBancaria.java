package listas.les;
public class ContaBancaria {
	private String numeroConta;
	private float saldo;
	//private static int total=4;
	/**
	 * @param args
	 */

	
	public ContaBancaria(){
		this.numeroConta = Integer.toString((int)(Math.random()*100000));
		//this.numeroConta = Integer.toString(this.total);
		//this.total--;
		//this.numeroConta = Integer.toString(ContaBancaria.total);
	}
	
	public boolean saca(float val){
		if(((this.saldo - val) >= 0.0F) && val>0.0F){
			this.saldo -= val;
			return true;
		}
		return false;
	}
	
	public void deposita(float val){
		this.saldo += val;
	}
	
	public float getSaldo(){
		return this.saldo;
	}
	
	public String getNumeroConta(){
		return this.numeroConta;
	}
	
	
	public String toString(){
		return this.numeroConta;
	}

	public boolean equals(ContaBancaria c){
		if(this.numeroConta.equals(c.getNumeroConta())){
			return true;
		}
		return false;
	}
	public void setNumeroConta(String numero){
		this.numeroConta = numero;
	}
}
