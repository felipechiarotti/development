package listas.binary;

public class BinaryAccount {
	private double balance;
	private int accountNumber;
	private BinaryAccount father;
	private BinaryAccount left;
	private BinaryAccount right;
	
	public BinaryAccount(){
		this.accountNumber = (int)(Math.random()*1000);
	}
	
	public BinaryAccount(String accountNumber){
		this.accountNumber = Integer.parseInt(accountNumber);
	}
	
	public BinaryAccount(int accountNumber){
		this.accountNumber = accountNumber;
	}
	
	public double getBalance(){
		return this.balance;
	}
	
	public void setLeft(BinaryAccount left){
		this.left = left;
	}
	
	public void setRight(BinaryAccount right){
		this.right = right;
	}
	
	public BinaryAccount getLeft(){
		return this.left;
	}
	
	public BinaryAccount getRight(){
		return this.right;
	}
	public int getAccountNumber(){
		return this.accountNumber;
	}
	
	public void setBalance(double balance){
		this.balance+= balance;
	}
	
	public void setAccountNumber(String number){
		this.accountNumber = Integer.parseInt(number);
	}
	
	public void setFather(BinaryAccount father){
		this.father = father;
	}
	
	public BinaryAccount getFather(){
		return this.father;
	}
	public void setAccountNumber(int number){
		this.accountNumber = number;
	}
	
	public String toString(){
		return this.getLeft().getAccountNumber()+" <--- "+this.accountNumber+" ---> "+this.getRight().getAccountNumber()+"\n";
	}
}
