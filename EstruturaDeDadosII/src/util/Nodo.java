/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author 20181080080296
 * @param <E>
 */
public class Nodo<E> implements Position<E> {

    private E element;
    private Nodo right;
    private Nodo left;
    private Nodo parent;

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    @Override
    public Nodo getRight() {
        return right;
    }

    @Override
    public Nodo getLeft() {
        return left;
    }

    @Override
    public Nodo getParent() {
        return parent;
    }

    @Override
    public E element() {
        return element;
    }

    @Override
    public void setLeft(Position<E> p) {
        this.left = (Nodo) p;
    }

    @Override
    public void setRigth(Position<E> p) {
        this.right = (Nodo) p;
    }

    @Override
    public void setParent(Position<E> p) {
        this.parent = (Nodo) p;
    }

}
