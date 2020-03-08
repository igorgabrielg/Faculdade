package arvore;

import java.util.Stack;

public class Tree {

    private Node root;      // primeiro nó da arvore(Nó raiz)

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

    /**
     * Insert cria um novo nó na arvore e insere dados nela.
     *
     * @param keyValue
     * @param value
     */
    public void insert(int keyValue, String value) {
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
                if (keyValue < current.keyData) { //vai para esquerda?
                    current = current.leftChild;
                    if (current == null) {      // se for o fim da linha,
                        parent.leftChild = node;    //insere a esquerda.
                        return;
                    }
                } else {                          //ou para direita?
                    current = current.rightChild;
                    if (current == null) {      // se for o fim da linha,
                        parent.rightChild = node;//insere a direita.
                        return;
                    }
                }
            }
        }
    }

    /**
     * Elimina um nó da arvore com a chave passada por parametro.
     *
     * @param key
     * @return True quando eleiminar op nó passado por parametro
     */
    public boolean delete(int key) {
        Node current = this.root;
        Node parent = this.root;
        boolean isLeftChild = true;

        while (current.keyData != key) { //busca o nó
            parent = current;
            if (key < current.keyData) {//vai para esquerda?
                isLeftChild = true;
                current = current.leftChild;
            } else {                    //ou para a direita?
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {//nó não encontrado return falso
                return false;
            }
        }
        //se o nó desejado não possuir filhos(ou seja for folha), simplesmente o elimine

        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null; //se a raiz for vazia
            } else if (isLeftChild) {
                parent.leftChild = null;// desconecta do pai
            } else {
                parent.rightChild = null;
            }

            //se não e filho à direita, substitui pela subárvore à esquerda
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }

            //se não e filho à esquerda, substitui pela subárvore à direita.
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {// se os dois são filhos, subistituia o sucessor em ordem
            //obter o sucessor do nó para exclusão
            Node sucessor = getSucessor(current);
            // conecta o parente atual com o sucessor
            if (current == root) {
                this.root = sucessor;
            } else if (isLeftChild) {
                parent.leftChild = sucessor;
            } else {
                parent.rightChild = sucessor;
            }
            //conecte o sucessor ao filho à esquerda de current
            sucessor.leftChild = current.leftChild;
        }
        //sucessor não pode ter filhos a esquerda
        return true;
    }

    /**
     * Retorna nó com próximo valor mais alto depois de delNode, vai para o
     * filho a direita, depois para o filho a esquerda
     *
     * @param delNode
     * @return
     */
    private Node getSucessor(Node delNode) {
        Node sucessorParent = delNode;
        Node sucessor = delNode;
        Node current = delNode.rightChild; //vai para filho a direita ate não haver mais

        while (current != null) {// filhos a esquerda vai para filho a esquerda
            sucessorParent = sucessor;
            sucessor = current;
            current = current.leftChild;
        }
        if (sucessor != delNode.rightChild) {// se o sucessor não e filho a direita, faz conexão
            sucessorParent.leftChild = sucessor.rightChild;
            sucessor.rightChild = delNode.rightChild;
        }
        return sucessor;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.println("\n Travessia preOrder: ");
                preOrder(this.root);
                break;
            case 2:
                System.out.println("\n Travessia inOrder: ");
                inOrder(this.root);
                break;
            case 3:
                System.out.println("\n Travessia postOrder: ");
                postOrder(this.root);
                break;
        }
        System.out.println();
    }

    private void preOrder(Node localRoot) {

        if (localRoot != null) {
            System.out.println(localRoot.data + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(Node localRoot) {

        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.println(localRoot.data + " ");
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot) {

        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            inOrder(localRoot.rightChild);
            System.out.println(localRoot.data + " ");
        }
    }

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(this.root);
        int nBlanks = 32;
        boolean isRowEmpty = false;

        System.out.println("--------------------------------------------------");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int i = 0; i < nBlanks; i++) {
                System.out.println(' ');
            }

            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.data);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.println("- -");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int i = 0; i < nBlanks * 2 - 2; i++) {
                    System.out.println(' ');
                }
            }
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }
        System.out.println("--------------------------------------------------");
    }
}
