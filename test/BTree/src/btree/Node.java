package btree;

public final class Node{
  public Node parent; // Referência ao Nó Pai
  public Node child[]; // Array de Nós Filhos
  public static int order; // Determina a quantidade de filhos
  public int keyCount; // Maximo de Chaves por Nó
  public int key[]; // Array de Chaves
  public boolean leaf; // Se é folha ou não

  public Node(){}

  public Node(int order, Node parent){
    this.order = order;
    this.parent = parent;
    this.key = new int[2*order - 1];
    this.child = new Node[2*order];
    this.leaf = true;
    this.keyCount = 0;
  }

  public int getKey(int index){
    return key[index];
  }

  public Node getChild(int index){
    return child[index];
  }
  

}
