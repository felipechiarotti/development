package listas.lde;

import java.io.*;

public class LDE{
	ContaBancariaLDE first;
	public LDE(){
		this.first = null;
	}
	
	public void add(ContaBancariaLDE c){
		if(this.first==null){
			this.first = c;
		}else{
			ContaBancariaLDE conta = first;
			while(conta.getProximo()!=null){conta = conta.getProximo();}
			conta.setProximo(c);
		}
	}
	
	public ContaBancariaLDE get(int pos){
		ContaBancariaLDE conta = first;
		for(int i = 0; i<pos; i++){
			conta = conta.getProximo();
		}
		return conta;
	}
	
	public void remove(int pos){
		if(pos==0){
			first = first.getProximo();
		}else{
			int i = 0;
			ContaBancariaLDE c = first;
			
			while(i<pos-1 && c.getProximo()!=null){
				c = c.getProximo();
				i++;
			}
			c.setProximo(c.getProximo().getProximo());
		}
	}
	
	public LDE concatena(LDE lista){
		LDE auxList = new LDE();
		
		ContaBancariaLDE c = null;
		ContaBancariaLDE cAux = first;
		do{
			c = cAux.clone();
			c.setProximo(null);
			auxList.add(c);
		}while((cAux = cAux.getProximo())!=null);
		
		cAux = lista.first;
		do{
			c = cAux.clone();
			c.setProximo(null);
			auxList.add(c);
		}while((cAux=cAux.getProximo())!=null);
		return auxList;
	}
	
	public LDE igual(LDE lista){
		LDE auxList = new LDE();
		ContaBancariaLDE conta = first;
	
		do{
			ContaBancariaLDE check = lista.first;
			do{
				if(check.equals(conta)){
					ContaBancariaLDE c = auxList.first;
					boolean verify = false;
					do{
						if(c!=null){
							if(c.equals(check)){
								verify = true;
								break;
							}
						}else{
							break;
						}
					}while((c = c.getProximo()) != null);
					if(!verify){
						c = conta.clone();
						c.setProximo(null);
						auxList.add(c);
						break;
					}
				}
			}while((check = check.getProximo()) != null);
		}while((conta = conta.getProximo()) != null);
		return auxList;
	}
	
	public LDE diferente(LDE lista){
		LDE auxList = new LDE();
		ContaBancariaLDE conta = null;
		ContaBancariaLDE check = null;
		for(int i = 0; i<2; i++){
			if(i==0) conta = first;
			else conta = lista.first;
			do{
				if(i==0) check = lista.first;
				else check = first;
				boolean igual = false;
				do{
					if(check.equals(conta)){
						igual = true;
						break;
					}
				}while((check = check.getProximo()) != null);
				if(!igual){
					ContaBancariaLDE aux = conta.clone();
					aux.setProximo(null);
					auxList.add(aux);
				}
			}while((conta = conta.getProximo()) != null);
		}

		return auxList;
	}
	
	public int size(){
		int size = 0;
		ContaBancariaLDE conta = first;
		if(conta!=null){size++;}
		while((conta = conta.getProximo()) != null) size++;
		return size;
	}
	public String toString(){
		ContaBancariaLDE c = first;
		String result = first.toString();
		while((c = c.getProximo()) != null){
			result+= "\n"+c.toString();
		}
		return result;
	}
	
	public void bubble(){
		long time = System.currentTimeMillis();
		for(int i = 0; i<this.size()-1; i++){
			for(int j = 0; j<this.size(); j++){
				ContaBancariaLDE conta = this.get(j);
				if(conta.getProximo() != null){
					if(Integer.parseInt(conta.getProximo().getNumeroConta()) < Integer.parseInt(conta.getNumeroConta())){
						//System.out.print(Integer.parseInt(conta.getProximo().getNumeroConta()) +" é menor que "+Integer.parseInt(conta.getNumeroConta())+"\n");
						ContaBancariaLDE next = conta.getProximo();
						ContaBancariaLDE aux = next.getProximo();
						conta.setProximo(aux);
						next.setProximo(conta);
						if(j>0){
							this.get(j-1).setProximo(next);
						}else{
							this.first = next;
						}
					}
				}
			}
		}
		System.out.println("Método Bolha: "+ (((System.currentTimeMillis()-time))+" milissegundos"));
	}
	
	public void save(File file){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for(int i = 0; i<this.size(); i++){
				writer.write(this.get(i).getNumeroConta()+";"+this.get(i).getSaldo()+"\n");
			}
			writer.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	public void load(File file){
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			LDE list = new LDE();
			while((line = reader.readLine())!=null){
				String[] tokens = line.split(";");
				ContaBancariaLDE conta = new ContaBancariaLDE();
				conta.setNumeroConta(tokens[0]);
				list.add(conta);
			};
			this.first = list.first;

		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
