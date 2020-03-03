package util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
public interface Position<E> {
    /** Retorna o elemento armazenado nessa posição **/
    E element();
    public Position<E> getLeft();
    public Position<E> getRight();
    public Position<E> getParent();
    public void setLeft(Position<E> p);
    public void setRigth(Position<E> p);
    public void setParent(Position<E> p);
}
