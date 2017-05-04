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
			quickSort(0,c.length-1); // Chama o método, passando como parâmetros a posição do elemento mais a esquerda e mais a direita
			System.out.println("Quick Sort: "+((System.currentTimeMillis()-time))+"ms");
		}

		/*
		public void quickSort(ContaBancaria[] list, int begin, int end){//Faz chamadas recursivas
			if(begin < end){ // Se o elemento denominado begin, for menor que o end
				int pivoPosition = explode(list,begin,end); //
				quickSort(list,begin,pivoPosition-1);
				quickSort(list,pivoPosition+1,end);
			}
		}
		*/
	    private void quickSort(int esq, int dir) {//Método fica fazendo chamadas recursivamente
	        int pivo = esq;//Através da regra de eleição de pivô, que será usado como base para as comparações
	        int i, j; //Variaveis auxiliares para a movimentação das posições
	        for (i = esq + 1; i <= dir; i++) {//Faz uma iteração, até que i seja maior que o elemento à direita
	            j = i;// J recebe i, para que o valor ao ser alterado na variavel j, não sofra alterações
	            if (Integer.parseInt(c[j].getNumeroConta()) < Integer.parseInt(c[pivo].getNumeroConta())) {//Elementos serão comparados com o pivô
	                ContaBancaria temp = c[j];//Verifica se a posição é menor que o pivô, caso sim, cria uma variável temporária para armazenar o valor da conta
	                while (j > pivo) {
	                    c[j] = c[j - 1];//J recebe o elemento anterior
	                    j--;
	                }
	                c[j] = temp;//Fazendo novamente o processo, agora o elemento da posição J, recebe o temporário
	                pivo++;
	            }
	        }
	        if (pivo - 1 >= esq) {// se o pivo-1 for maior que o elemento da esquerda
	            quickSort(esq, pivo - 1);//O valor é passado e chama recursivamente o método, passando o lado à esquerda do pivo.
	        }
	        if (pivo + 1 <= dir) {// se o pivo+1 for menor que o elemento da direita
	            quickSort(pivo + 1, dir);// O valor é passado e chama recursivamente o método, passando o lado à direita do pivo.
	        }
	    }
		/*
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
		*/
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

			//DIVIDE EM DUAS LISTAS
			for(int i = 0; i<first.length; i++){
				first[i] = list[i];
			}
			for(int i = first.length; i< list.length; i++){
				second[i-first.length] = list[i];
			}

			//RODA RECURSIVAMENTE ATÉ ORGANIZAR A PRIMEIRA LISTA DIVIDINDO-A EM PEDAÇOS CADA VEZ MENORES
			runMergeSort(first);

			//RODA RECURSIVAMENTE ATÉ ORGANIZAR A SEGUNDA LISTA DIVIDINDO-A EM PEDAÇOS CADA VEZ MENORES
			runMergeSort(second);

			//Junta e ordena as 2 listas em uma única (A inicialmente passada por parâmetro)
			merge(first,second,list);
			return list;
		}

		private void merge(ContaBancaria[] first, ContaBancaria[] second, ContaBancaria[] list){
			int firstAux = 0;
			int secondAux = 0;
			int j = 0;

			while(firstAux < first.length && secondAux< second.length ){ // Faz a iteração enquanto não chega no fim de nenhuma das 2 listas
				if(Integer.parseInt(first[firstAux].getNumeroConta()) < Integer.parseInt(second[secondAux].getNumeroConta())){ // A cada iteração, compara os elementos da lista 1, com a lista 2
					list[j] = first[firstAux]; // Se o elemento da primeira lista na posição dada por firstAux, for menor que da segunda lista
					firstAux++; //Escreve o valor em uma nova lista e aumenta o firstAux

				}else{
					list[j] = second[secondAux]; //Caso contrário, adiciona à lista principal o elemento da segunda lista
					secondAux++;
				}
				j++;
			}

			while(first.length-firstAux > 0){ // Adiciona à lista principal, os elementos restantes da primeira lista
				list[j] = first[firstAux];
				firstAux++;
				j++;
			}

			while(second.length-secondAux > 0){ // Adiciona à lista principal, os elementos restantes da segunda lista
				list[j] = second[secondAux];
				secondAux++;
				j++;
			}
		}
	}

	public class BubbleSort{
		public void sort(){
			long time = System.currentTimeMillis();
			for(int i = 0; i<c.length; i++){ //Manter uma iteração pelo tamanho de elementos do array, do primeiro ao ultimo
				for(int j = 0; j<c.length-1; j++){//Manter uma iteração pelo tamanho de elementos do array, do primeiro ao penultimo, para que seja comparado termo a termo
					if(Integer.parseInt(c[j].getNumeroConta()) > Integer.parseInt(c[j+1].getNumeroConta())){ // Compara se é maior que o valor na proxima posição
						ContaBancaria temp = c[j];//Caso o proximo seja maior, é colocado em uma variavel temporaria
						c[j] = c[j+1];//****	A INVERSÃO DAS DUAS POSIÇÕES
						c[j+1] = temp;//**** É FEITA ATRAVÉS DE ATRIBUIÇÕES DE VALORES ÀS VARIAVEIS
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
				ContaBancaria temp = c[i]; // Variável temporaria para armazenar a posição do elemento que será utilizado
				for(int j = i-1; (j>=0) && (Integer.parseInt(temp.getNumeroConta()) < Integer.parseInt(c[j].getNumeroConta())); j--){ //Mantém a iteração enquanto as posições forem válidas, e a anteiror for maior que 0
					c[j+1] = c[j]; // A inversão dos valores é efetuada
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

			LES[] bucket = new LES[totalBuckets]; // Cria e seta os baldes
			for(int i = 0; i<totalBuckets; i++){
				bucket[i] = new LES(length);
			}
			for(int i = 0; i<length; i++){ // Responsável por colcoar os elementos em seus respectivos baldes
				int j = (int) Math.floor((Integer.parseInt(c[i].getNumeroConta()))/divisor);
				bucket[j].add(c[i]);
			}

			int added = 0;
			for(int i = 0; i<totalBuckets; i++){ // Retira os elementos dos baldes ordenados
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
				for(int i = 0; i<auxList.size(); i++){ // Responsável pro adicionar a quantidade necessaria de "0" até dar o tamanho do maior numero
					ContaBancaria conta = auxList.getConta(i);
					String result = "%0"+Integer.toString(size)+"d";
					conta.setNumeroConta(String.format(result, Integer.parseInt(conta.getNumeroConta())));
				}

				LES[] buckets = new LES[10]; // Gera os baldes a serem utilizados
				for(int i = 0; i < buckets.length; i++){
					buckets[i] = new LES(auxList.size());
				}

				for(int i = 0; i < size; i++){
					for(int j = 0; j < auxList.size(); j++){ // Faz uma iteração pegando os digitos de cada elemento
						buckets[Integer.parseInt(""+(auxList.getConta(j).getNumeroConta().charAt(size-i-1)))].add(auxList.getConta(j));
					}
					int auxListSize = auxList.size();
					auxList = new LES(auxListSize);

					int z = 0;
					int x = 0;
					while(z < auxListSize){ // Itera até adicionar cada elemento aos baldes e remove-los até estar ordenado de forma correta
						if(buckets[x].size() == 0){
							x++;
						}else{
							auxList.add(buckets[x].getConta(0));
							buckets[x].remove(0);
							z++;
						}
					}
				}

				for(int i = 0; i< auxList.size(); i++){ // Remove os "0" adicionados anteriormente
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
