
package arvore;
import java.io.*;
import java.util.*;
public class Node {
    
    public int keyData;    //Item de dado{chave}
    public String data;       //item de dado
    public Node leftChild;    //filho à esquerda deste nó
    public Node rightChild;   //filho à direita deste nó
    
    public void displayNode(){  //exibe-nos
        System.out.println("{");
        System.out.println(this.keyData);
        System.out.println(",  ");
        System.out.println(this.data);
        System.out.println("}  ");
    }
}
