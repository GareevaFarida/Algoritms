package Lesson6;

import java.util.Objects;

class Node<E extends Comparable<? super E>> {
    private final E value;
    private Node<E> rightChild;
    private Node<E> leftChild;
    private int deep;

    Node(E value, int deep) {
        this.value = value;
        this.deep = deep;
    }

    public E getValue() {
        return value;
    }

    public int getDeep() {
        return deep;
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

    boolean isLeftChildOf(Node<E> parent) {
        return this.equals(parent.leftChild);
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

    public boolean hasOneChild() {
        return getLeftChild() != null ^ getRightChild() != null;
    }

    public boolean hasTwoChildren() {
        return getLeftChild() != null && getRightChild() != null;
    }

    public boolean hasLeftChild() {
        return getLeftChild() != null;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
