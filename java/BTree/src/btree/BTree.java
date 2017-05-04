package btree;

public class BTree{
    static int order; // Ordem da BTree
    Node root; //Nó Raiz

    public BTree(int order){
      this.order = order;
      root = new Node(order,null);
    }

    public Node search(Node root, int key){
      int i = 0;
      while(i < root.keyCount && key > root.key[i]){ // Enquanto i for menor que a quantidade de chaves no nó root
        i++;                                      // E o valor(Chave) a ser procurado é maior do que a chave atual do nó
      }                                           // Incrementa i;

      if(i <= root.keyCount && key == root.key[i]){ // Se a chave foi encontrada
        return root;                             // Retorna o nó em que existe a chave
      }

      if(root.leaf){ // Se é uma folha, não tem mais nada para checar
        return null;
      }else{ // Caso contrário, chama recursivamente e verifica em cada filho se existe aquela chave
        return search(root.getChild(i),key);
      }
    }

    public void split(Node x, int i , Node y){
      Node z = new Node(order, null);
      z.leaf = y.leaf;
      z.keyCount = order-1;

      for(int j = 0; j < order; j++){
        z.key[j] = y.key[j+order];
      }

      if(!y.leaf){
        for(int k = 0; k < order; k++){
          z.child[k] = y.child[k+order];
        }
      }
      y.keyCount = order - 1;

      for(int j = x.keyCount; j>1; j--){
        x.child[j+1] = x.child[j];
      }

      x.child[i+1] = z;

      for(int j = x.keyCount; j > 1; j--){
        x.key[j+1] = x.key[j];
      }

      x.key[i] = y.key[order-1];
      y.key[order-1] = 0;

      for(int j = 0; j < order - 1; j++){
        y.key[j + order] = 0;
      }

      x.keyCount++;
    }
    
    public void notFullInsert(Node node, int key){
        int i = node.keyCount;
        if(node.leaf){
            while(i >= 1 && key < node.key[i-1]){ // Encontra o lugar para colocar a chave
                node.key[i] = node.key[i-1];
                i--;
            }
            
            node.key[i] = key;
            node.keyCount++;
        }else{
            int j = 0;
            while(i < node.keyCount && key > node.key[j]){
                j++;
            }
            if(node.child[j].keyCount == order*2 - 1){
                split(node,j,node.child[j]);
                if(key > node.key[j]){
                    j++;
                }
            }
            notFullInsert(node.child[j],key);
        }
    }
    public void insert(int key){
          Node rootNode = root;
          if(root.keyCount == 2*order -1){ // Se o nó estiver cheio
              Node auxNode = new Node(order,null); // Cria um nó novo
              root = auxNode;
              auxNode.leaf = false;
              auxNode.child[0] = rootNode;
              split(auxNode,0,rootNode);
              notFullInsert(auxNode,key);
          }else{
              notFullInsert(rootNode,key);
          }
  }
}
