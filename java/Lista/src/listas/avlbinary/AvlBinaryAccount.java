package listas.avlbinary;

public class AvlBinaryAccount {
	private double balance;
	private int accountNumber;
	private AvlBinaryAccount left;
	private AvlBinaryAccount right;
	private int height;
	
	public AvlBinaryAccount(){
		this.accountNumber = (int)(Math.random()*1000);
	}
	
	public AvlBinaryAccount(String accountNumber){
		this.accountNumber = Integer.parseInt(accountNumber);
	}
	
	public AvlBinaryAccount(int accountNumber){
		this.accountNumber = accountNumber;
	}
	
	public double getBalance(){
		return this.balance;
	}
	
	public void setLeft(AvlBinaryAccount left){
		this.left = left;
	}
	
	public void setRight(AvlBinaryAccount right){
		this.right = right;
	}
	
	public AvlBinaryAccount getLeft(){
		return this.left;
	}
	
	public AvlBinaryAccount getRight(){
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
	
	public void setAccountNumber(int number){
		this.accountNumber = number;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public void setHeight(){
		this.height = height;
	}
	public String toString(){
		return this.getLeft().getAccountNumber()+" <--- "+this.accountNumber+" ---> "+this.getRight().getAccountNumber()+"\n";
	}
}
