package listas.les;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import listas.lde.ContaBancariaLDE;
import listas.lde.LDE;

public class LES{
	protected int maxTam;
	protected int ultimo;
	public ContaBancaria[] c;
	
	public LES(int maxTam){
		this.maxTam = maxTam;
		c = new ContaBancaria[maxTam];
	}
	public LES(String nameFile){
		this.load(new File(nameFile));
	}
	public String toString(){
	String result = "";
	for(int i = 0; i<ultimo; i++){
		result+= c[i].toString()+"\n";
	}	
	return result;
	}

	public void add(ContaBancaria c){
		if(!isFull()){
			this.c[ultimo] = c;
			this.ultimo++;
		}
	}
	
	public boolean remove(int pos){
			if(!this.isEmpty()){
				for(int i = pos; i<ultimo; i++){
				this.c[i] = this.c[i+1];
				}
				this.c[ultimo-1] = null;
				this.ultimo--;
				return true;
			}
			return false;
	}
	public boolean remove(String numero){
		for(int i = 0; i<ultimo; i++){
			if(this.c[i].getNumeroConta() == numero){
				for(int x=i; x<ultimo; x++){
					this.c[x] = this.c[x+1];
				}
				this.c[ultimo-1] = null;
				ultimo--;
				return true;
			}
		}
		
		return false;
	}
	
	public ContaBancaria getConta(int pos){
		if(pos<ultimo && !isEmpty()){
			return c[pos];
		}
		return null;
	}
	
	public ContaBancaria getConta(String n){
		for(int i = 0; i<ultimo; i++){
			if(this.c[i].getNumeroConta().equals(n)){
				return c[i];
			}
		}
		return null;
	}
	
	public int size(){
		return this.ultimo;
	}
	
	public boolean isEmpty(){
		if(ultimo==0){
			return true;
		}
		return false;
	}
	
	public boolean isFull(){
		if(ultimo==maxTam){
			return true;
		}
		return false;
	}
	
	public LES concatena(LES l){
		int uSizeList = this.ultimo-1+l.size();
		LES auxList = new LES(uSizeList);
		for(int i = 0; i<l.size(); i++){
			auxList.add(l.getConta(i));
		}
		for(int i = 0; i<ultimo; i++){
			for(int j = 0; j<auxList.size(); j++){
				if(auxList.getConta(j).equals(l.getConta(i))){
					break;
				}else if(j==auxList.size()-1){
					auxList.add(l.getConta(i));
				}
			}
		}
		return auxList;
	}
	
	public LES diference(LES l){
		int bigger = Math.max(l.size(), ultimo);
		LES auxList = new LES(this.ultimo-1+l.size());
		for(int i = 0; i<bigger; i++){
			int res = 0;
			for(int j = 0; j<ultimo; j++){
				if(this.c[j].equals(l.getConta(i))){
					res++;
				}
			}
			if(res==0){
				auxList.add(l.getConta(i));
			}
		}
		return auxList;
	}
	
	public LES equal(LES l){
		int bigger = Math.max(l.size(), ultimo);
		LES auxList = new LES(bigger);
		for(int i = 0; i<bigger; i++){
			int res = 0;
			for(int j = 0; j<ultimo; j++){
				if(this.c[j].equals(l.getConta(i))){
					auxList.add(l.getConta(i));
				}
			}
		}
		return auxList;
	}
	
	public void sort(int n){
		switch(n){
		case 0:
			new BubbleSort().sort();;
		break;
		
		case 1:
			new QuickSort().sort();
		break;
		
		case 2:
			new MergeSort().sort();;
		break;
		
		case 3:
			new InsertionSort().sort();;
		break;
		
		case 4:
			new BucketSort().sort();
		break;
		
		case 5:
			new RadixSort().sort();
		break;
		}
	}
	
	public void save(File file){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for(int i = 0; i<this.size(); i++){
				writer.write(this.getConta(i).getNumeroConta()+";"+this.getConta(i).getSaldo()+"\n");
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
			ContaBancaria[] list = new ContaBancaria[10];
			int i = 0;
			int j = 1;
			while((line = reader.readLine())!=null){
				if(i%10==0){
					ContaBancaria[] temp = list;
					list = new ContaBancaria[10*j];
					for(int z = 0; z<temp.length; z++){
						list[z] = temp[z];
					}
					j++;
				}
				String[] tokens = line.split(";");
				ContaBancaria conta = new ContaBancaria();
				conta.setNumeroConta(tokens[0]);
				list[i] = conta;
				this.ultimo = i;
				i++;
			};
			this.c = list;
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

	public class QuickSort{
		public void sort(){
			long time = System.currentTimeMillis();
			quickSort(c,0,c.length-1);
			System.out.println("Quick Sort: "+((System.currentTimeMillis()-time))+"ms");
		}
		
		public void quickSort(ContaBancaria[] list, int begin, int end){
			if(begin < end){
				int pivoPosition = explode(list,begin,end);
				quickSort(list,begin,pivoPosition-1);
				quickSort(list,pivoPosition+1,end);
			}
		}
		
		private int explode(ContaBancaria[] list, int begin, int end){
			ContaBancaria pivoTemp = list[begin];
			int f = end;
			int aux = begin+1;
			
			while(aux<=f){
				if(Integer.parseInt(list[aux].getNumeroConta())<=Integer.parseInt(pivoTemp.getNumeroConta())){
					aux++;
				}else if(Integer.parseInt(pivoTemp.getNumeroConta()) < Integer.parseInt(list[f].getNumeroConta())){
					f--;
				}else{
					ContaBancaria change = list[aux];
					list[aux] = list[f];
					list[f] = change;
					aux++;
					f--;
				}
			}
			list[begin] = list[f];
			list[f] = pivoTemp;
			return f;
		}
	}
	
	public class MergeSort{
		public void sort(){
			long time = System.currentTimeMillis();
			runMergeSort(c);
			System.out.println("Merge Sort: "+(System.currentTimeMillis()-time)+"ms");
		}
		
		private ContaBancaria[] runMergeSort(ContaBancaria[] list){
			if(list.length<=1){
				return list;
			}
			ContaBancaria[] first = new ContaBancaria[list.length/2];
			ContaBancaria[] second = new ContaBancaria[list.length-first.length];

			for(int i = 0; i<first.length; i++){
				first[i] = list[i];
			}
			for(int i = first.length; i< list.length; i++){
				second[i-first.length] = list[i];
			}
			runMergeSort(first);
			runMergeSort(second);
			merge(first,second,list);
			return list;
		}
		
		private void merge(ContaBancaria[] first, ContaBancaria[] second, ContaBancaria[] list){
			int firstAux = 0;
			int secondAux = 0;
			int j = 0;
			
			while(firstAux < first.length && secondAux< second.length ){

				if(Integer.parseInt(first[firstAux].getNumeroConta()) < Integer.parseInt(second[secondAux].getNumeroConta())){
					list[j] = first[firstAux];
					firstAux++;

				}else{
					list[j] = second[secondAux];
					secondAux++;
				}
				j++;
			}
			
			while(first.length-firstAux > 0){
				list[j] = first[firstAux];
				firstAux++;
				j++;
			}
			
			while(second.length-secondAux > 0){
				list[j] = second[secondAux];
				secondAux++;
				j++;
			}
		}
	}
		
	public class BubbleSort{
		public void sort(){
			long time = System.currentTimeMillis();
			for(int i = 0; i<c.length; i++){
				for(int j = 0; j<c.length-1; j++){
					if(Integer.parseInt(c[j].getNumeroConta()) > Integer.parseInt(c[j+1].getNumeroConta())){
						ContaBancaria temp = c[j];
						c[j] = c[j+1];
						c[j+1] = temp;
					}
				}
			}
			System.out.println("Bubble Sort: "+(System.currentTimeMillis()-time)+"ms");
		}
	}
	
	public class InsertionSort{
		public void sort(){
			long time = System.currentTimeMillis();
			for(int i = 1; i<ultimo; i++){
				ContaBancaria temp = c[i];
				for(int j = i-1; (j>=0) && (Integer.parseInt(temp.getNumeroConta()) < Integer.parseInt(c[j].getNumeroConta())); j--){
					c[j+1] = c[j];
					c[j] = temp;
				}
			}	
		System.out.println("Insertion Sort: "+(System.currentTimeMillis()-time)+"ms");
		}
	}
	
	public class BucketSort{
		public void sort(){
			int length = c.length;
			

			int max = 0;
			for(int i = 0; i<length; i++){
				if(Integer.parseInt(c[i].getNumeroConta()) > max){
					max = Integer.parseInt(c[i].getNumeroConta());
				}
			}
			
			int min = max;
			for(int i = 0; i<length; i++){
				if(Integer.parseInt(c[i].getNumeroConta()) < min){
					min = Integer.parseInt(c[i].getNumeroConta());
				}
			}
			
			int totalBuckets = length;
			int divisor = (int) Math.ceil((max+1)/totalBuckets+1);

			LES[] bucket = new LES[totalBuckets];
			for(int i = 0; i<totalBuckets; i++){
				bucket[i] = new LES(length);
			}
			for(int i = 0; i<length; i++){
				int j = (int) Math.floor((Integer.parseInt(c[i].getNumeroConta()))/divisor);
				bucket[j].add(c[i]);
			}
			
			int added = 0;
			for(int i = 0; i<totalBuckets; i++){
				if(bucket[i].size() != 0){
					if(bucket[i].size() > 1){
						bucket[i].sort(3);
					}
					for(int j = 0; j< bucket[i].ultimo; j++){
						c[added] = bucket[i].getConta(j);
						added++;
					}
				}
			}
		}
	}
		public class RadixSort{
			public void sort(){
				LES auxList = new LES(ultimo);
				for(ContaBancaria cs : c){
					auxList.add(cs);
				}
				c = new ContaBancaria[auxList.size()];
				
				int size = 0;
				for(int i = 0; i<auxList.size(); i++){
					if(auxList.getConta(i).getNumeroConta().length() > size){
						size = auxList.getConta(i).getNumeroConta().length();
					}
				}
				for(int i = 0; i<auxList.size(); i++){
					ContaBancaria conta = auxList.getConta(i);
					String result = "%0"+Integer.toString(size)+"d";
					conta.setNumeroConta(String.format(result, Integer.parseInt(conta.getNumeroConta())));
				}
				
				LES[] buckets = new LES[10];
				for(int i = 0; i < buckets.length; i++){
					buckets[i] = new LES(auxList.size());
				}

				for(int i = 0; i < size; i++){
					for(int j = 0; j < auxList.size(); j++){
						buckets[Integer.parseInt(""+(auxList.getConta(j).getNumeroConta().charAt(size-i-1)))].add(auxList.getConta(j));
					}
					int auxListSize = auxList.size();
					auxList = new LES(auxListSize);

					int z = 0;
					int x = 0;
					while(z < auxListSize){
						if(buckets[x].size() == 0){
							x++;
						}else{
							auxList.add(buckets[x].getConta(0));
							buckets[x].remove(0);
							z++;
						}

					}
				}
				
				for(int i = 0; i< auxList.size(); i++){
					ContaBancaria conta = auxList.getConta(i);
					int z = 0;
					while(conta.getNumeroConta().startsWith("0") && z<size-1){
						z++;
					}
					conta.setNumeroConta(conta.getNumeroConta().substring(z));
					c[i] = conta;
				}
			}
		}
}