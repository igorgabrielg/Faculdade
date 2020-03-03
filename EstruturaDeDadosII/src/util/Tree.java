/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Lucas
 */
public interface Tree<E>{
    /**Retorna a quantidade de nodos da árvore **/
    public int size();
    /** Retorna se a árvore está vazia **/
    public boolean isEmpty();
    /** Retorna um iterador sobre os elementos armazenados na árvore **/
    public Iterable<Position<E>> positions();
    /** Substitui o elemento armazenado em um dado nodo **/
    public E replace(Position<E> v, E e);/**throws InvalidPositionException;**/
    /** Retorna a raíz de uma árvore **/
    public Position<E> root();/**throws EmptyTreeException;**/
    /** Retorna o pai de um dado nodo **/
    public Position<E> parent(Position<E> v);/**throws InvalidPositionException, BoundaryViolationException;**/
    /** Retorna os filhos  de um dado nodo **/
    public Iterable<Position<E>> children(Position<E> v);/**throws InvalidPositionException;**/
    /** Retorna se um dado nodo é interno **/
    public boolean isInternal(Position<E> v)/**throws InvalidPositionException;**/;
    /** Retorna se um dado nodo é externo **/
    public boolean isExternal(Position<E> v)/**throws InvalidPositionException;**/;
    /** Retorna se um dado nodo é a raíz da árvore **/
    public boolean isRoot(Position<E> v)/**throws InvalidPositionException;**/;
    
}   
