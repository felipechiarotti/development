package listas.binary;

public class BST {
	private BinaryAccount mainNode;
	
	public void insert(BinaryAccount account){
		if(mainNode!=null){
			BinaryAccount search = search(mainNode, account);
			if(search.getAccountNumber() < account.getAccountNumber()){
				search.setRight(account);
			}else{
				search.setLeft(account);
			}
			account.setFather(search);
		}else{
			mainNode = account;
		}
	}
	public void delete(BinaryAccount account){
		if(mainNode!=null){
			BinaryAccount search = search(mainNode, account);
			BinaryAccount leftNode = search.getLeft();
			BinaryAccount rightNode = search.getRight();
			BinaryAccount upperSearch = null;
			
			if(leftNode == null && rightNode == null){
				search = null;
			}else{
				if(leftNode != null && rightNode == null){
					if(leftNode.getRight() == null && leftNode.getLeft() == null){
						search = leftNode;
					}
				}else if(leftNode == null && rightNode != null){
					if(rightNode.getRight() == null && rightNode.getLeft() == null){
						search = rightNode;
					}					
				}else{
					BinaryAccount auxSearch = rightNode;	
					
					while(auxSearch.getLeft() != null){
						auxSearch = auxSearch.getLeft();
					}
					upperSearch = auxSearch.getFather();
					upperSearch.setLeft(auxSearch.getRight());
					auxSearch.setLeft(search.getLeft());
					auxSearch.setRight(search.getRight());
					if(search.getFather() == null){
						mainNode = auxSearch;
					}else if(auxSearch.getAccountNumber() < search.getFather().getAccountNumber()){
						search.getFather().setLeft(auxSearch);
					}else{
						search.getFather().setRight(auxSearch);
					}
				}
			}
		}
	}
	public BinaryAccount search(BinaryAccount currentNode, BinaryAccount account){
		BinaryAccount currentNodeRight = currentNode.getRight();
		BinaryAccount currentNodeLeft = currentNode.getLeft();
		
		if((account.getAccountNumber() > currentNode.getAccountNumber())){
			if(currentNodeRight != null){
				currentNode = search(currentNode.getRight(), account);
			}
		}else if((account.getAccountNumber() < currentNode.getAccountNumber())){
			if(currentNodeLeft != null){
				currentNode = search(currentNode.getLeft(), account);
			}
		}
	return currentNode;
	}
}
