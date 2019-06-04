package Lesson6;

import java.util.Objects;

class Node<E extends Comparable<? super E>> {
    private final E value;
    private Node<E> rightChild;
    private Node<E> leftChild;

    Node(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }


    Node<E> getRightChild() {
        return rightChild;
    }

    Node<E> getLeftChild() {
        return leftChild;
    }

    boolean isLeaf() {
        return getLeftChild() == null && getRightChild() == null;
    }

    void setRightChild(Node<E> rightChild) {
        this.rightChild = rightChild;
    }

    void setLeftChild(Node<E> leftChild) {
        this.leftChild = leftChild;
    }

    boolean isLeftChild(Node<E> parent){
        return  this.value.compareTo(parent.getValue())<0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return value.equals(node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
