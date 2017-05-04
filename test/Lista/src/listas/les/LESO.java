package listas.les;

public class LESO extends LES{
	public LESO(int size){
		super(size);
	}
	
	private int findAddressBinary(ContaBancaria conta){
		int inicio = 0;
		int fim = ultimo;
		int address = 0;
		int currNum = Integer.parseInt(conta.getNumeroConta());
		
		while(inicio<fim-1){
			address = (inicio+fim)/2;
			if(Integer.parseInt(c[address].getNumeroConta()) == currNum) return address;
			if(Integer.parseInt(c[address].getNumeroConta()) < currNum) inicio = address;
			else fim = address;

		}
		if(ultimo>0){
			if(Integer.parseInt(c[address].getNumeroConta()) < currNum){
				address++;
			}
		}
		return address;
	}
	private int findAddress(ContaBancaria conta){
		int address = 0;
		int accNumber = Integer.parseInt(conta.getNumeroConta());
		while(address < this.ultimo && (Integer.parseInt(this.c[address].getNumeroConta()) < accNumber)) address++;
		return address;
	}
	
	public void add(ContaBancaria c){
		if(!isFull()){
			int address = findAddressBinary(c);
			for(int j = ultimo; j>address; j--){
				this.c[j] = this.c[j-1];
			}
			this.c[address] = c;
			this.ultimo++;
		}
	}
}