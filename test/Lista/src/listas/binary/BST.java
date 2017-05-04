package listas.binary;

public class BST {
	private BinaryAccount mainNode; //Nó Principal

	public void insert(BinaryAccount account){ //Construtor da Árvore
		if(mainNode!=null){	//Caso a árvore já tenha algum nó
			BinaryAccount search = search(mainNode, account); // Procura a posição onde deve ser inserido
			if(search.getAccountNumber() < account.getAccountNumber()){ // Caso o elemento da posição encontrada seja menor que o que deseja inserir
				search.setRight(account); // Insere na direita
			}else{ // Caso seja maior que o encontrado
				search.setLeft(account); // Insere na esquerda
			}
			account.setFather(search); // Seta o nó pai da do elemento adicionado
		}else{
			mainNode = account; //Caso a árvore não tenha nenhum elemento adicionado, seta o nó principal
		}
	}
	public void delete(BinaryAccount account){
		if(mainNode!=null){ // Verifica se tem algo adicionado, já que não é possível remover se estiver vazio
			BinaryAccount search = search(mainNode, account); // Encontra o nó a ser removido
			BinaryAccount leftNode = search.getLeft(); // Pega seu elemento a esquerda
			BinaryAccount rightNode = search.getRight(); // E pega seu elemento a direita
			BinaryAccount upperSearch = null; // E define como o superior a seu nó pai como null

			if(leftNode == null && rightNode == null){
				search = null; // Caso não tenha nada adicionado, define search como null
			}else{
				if(leftNode != null && rightNode == null){
					if(leftNode.getRight() == null && leftNode.getLeft() == null){
						search = leftNode; // Se o nó esquerdo ao elemento a ser removido não tiver filhos, define search como o próprio nó esquerdo ao ser removido
					}
				}else if(leftNode == null && rightNode != null){
					if(rightNode.getRight() == null && rightNode.getLeft() == null){
						search = rightNode; // Se o nó direito ao elemento a ser removido não tiver filhos, define search como o próprio nó direito ao ser removido
					}
				}else{ // Caso os nós filhos adjacentes tenham outros filhos
					BinaryAccount auxSearch = rightNode; // Seta auxSearch como o nó filho a direita ao que será removido

					while(auxSearch.getLeft() != null){
						auxSearch = auxSearch.getLeft(); // Procura o ultimo filho a esquerda do nó direito filho que será removido
					}
					upperSearch = auxSearch.getFather(); //*****			REALOCA AS POSIÇÕES DOS NÓS
					upperSearch.setLeft(auxSearch.getRight()); //*****				DE FORMA QUE
					auxSearch.setLeft(search.getLeft());//*****				O NÓ DESEJADO SEJA REMOVIDO
					auxSearch.setRight(search.getRight());//*****		   E OS OUTROS MUDADOS DE POSIÇÃO
					if(search.getFather() == null){
						mainNode = auxSearch; // SE O NÓ PAI DO ATUAL FOR NULL, SIGNIFICA QUE ELE É O PRIMEIRO DA ÁRVORE
					}else if(auxSearch.getAccountNumber() < search.getFather().getAccountNumber()){
						search.getFather().setLeft(auxSearch); // CASO CONTRÁRIO REALOCA SETANDO NA ESQUERDA
					}else{
						search.getFather().setRight(auxSearch); // OU NA DIREITA
					}
				}
			}
		}
	}
	public BinaryAccount search(BinaryAccount currentNode, BinaryAccount account){
		BinaryAccount currentNodeRight = currentNode.getRight(); /**** Pega o nó esquerdo	****/
		BinaryAccount currentNodeLeft = currentNode.getLeft(); 	/**** E o direito do nó atual	****/

		if((account.getAccountNumber() > currentNode.getAccountNumber())){
			if(currentNodeRight != null){
				currentNode = search(currentNode.getRight(), account); //Se o nó a ser inserido for maior que o nó atual, e a direita do nó atual não estiver vazia, continua entrando em recursão
			}
		}else if((account.getAccountNumber() < currentNode.getAccountNumber())){
			if(currentNodeLeft != null){
				currentNode = search(currentNode.getLeft(), account);//Se o nó a ser inserido for menor que o nó atual, e a esquerda do nó atual não estiver vazia, continua entrando em recursão
			}
		}
	return currentNode; // Por fim, retorna o nó que será adicionado à sua direita ou esquerda o elemento desejado
	}
}
