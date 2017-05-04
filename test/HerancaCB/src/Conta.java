
abstract public class Conta {
	private static int totalAccounts;
	private double saldo;
	private String accountNumber;
	
	public Conta(){
		this.totalAccounts++;
	}
	
	public void setSaldo(double saldo){
		this.saldo = saldo;
	}
	
	public void setAccountNumber(String accountNumber){
		this.accountNumber = accountNumber;
	}
	
	public int getTotalAccounts(){
		return this.totalAccounts;
	}
	
	public double getSaldo(){
		return this.saldo;
	}
	
	public String getAccountNumber(){
		return this.accountNumber;
	}
	
	public boolean deposita(double valor){
		this.saldo+=valor;
		return true;
	}
	
	public boolean saca(double valor){
		if(this.saldo-valor>=0){
			this.saldo-=valor;
			return true;
		}
		return false;
	}
}
