package arvore;

public class Tree {

    private Node root;      // primeiro nó da arvore

    /**
     * Contrutor sem nós na árvore ainda
     */
    public Tree() {
        this.root = null;
    }

    /**
     * Localiza nó com chave dada (assume que a árvore não vazia)
     *
     * @param key
     * @return A localização do nó buscado.
     */
    public Node find(int key) {
        Node current = this.root;   //começa na raiz

        while (current.keyData != key) {  //enquanto o dado chave não for o valor procurado ele vai percorrer os nós ate achar.
            if (key < current.keyData) {  //vai para esquerda
                current = current.leftChild;
            } else {                      // se não achar vai para direita.
                current = current.rightChild;
            }
            if (current == null) {        // se não há filho.
                return null;            // não localizado.
            }
        }
        return current;                //Localidado.
    }

    public void insert(int keyValue, double value) {
        Node node = new Node();     // Cria um novo nó
        node.keyData = keyValue;    //insere os dados
        node.data = value;          
        if (this.root == null) {    //verifica se a raiz e nula
            this.root = node;
        } else {                    //raiz ocupada
            Node current = this.root;// começa na raiz
            Node parent;
            while (true) {          //sai internamente
                parent = current;
                if (keyValue < current.keyData) {
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }    
                }
            }
        }
    }
    
    public boolean delete(int key){
        Node current = this.root;
        Node parent = this.root;
        boolean isLeftChild = true;
        
        while(current.keyData != key){
             parent = current;
             if(key < current.keyData){
                 isLeftChild = true; 
                 current =  current.leftChild;
             }else{
                 isLeftChild = false;
                 current = current.rightChild;
             }
             if(current == null){
                 return false;
             }
        }
        
        if(current.leftChild == null && current.rightChild == null){
            if(current == root) root = null;
            else if(isLeftChild)parent.leftChild = null;
            else parent.rightChild = null;
        }else if(current.rightChild == null){
            if(current == root)root = current.leftChild;
            else if(isLeftChild)parent.leftChild = current.leftChild;
            else parent.rightChild = current.leftChild;            
        }else if(current.leftChild == null){
            if(current == root)root = current.rightChild;
            else if(isLeftChild)parent.leftChild = current.rightChild;
            else parent.rightChild = current.rightChild; 
        }else{
        Node sucessor = getSucessor(current);
        if(current ==  root)this.root = sucessor;
        else if(isLeftChild)parent.leftChild = sucessor;
        else parent.rightChild = sucessor;
        
        sucessor.leftChild = current.leftChild;
        }
        return true;
    }
    
    private Node getSucessor(Node delNode){
        Node sucessorParent = delNode;
        Node sucessor = delNode;
        Node current = delNode.rightChild;
        
        while(current != null){
            sucessorParent = sucessor;
            sucessor = current;
            current = current.leftChild;
        }
        if(sucessor != delNode.rightChild){
            sucessorParent.leftChild = sucessor.rightChild;
            sucessor.rightChild = delNode.rightChild;
        }
        return sucessor;
    }

}
