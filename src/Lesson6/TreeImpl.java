package Lesson6;

import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private class CurrentAndPreviousNode<E> {
        Node current;
        Node previous;

        public CurrentAndPreviousNode(Node current, Node previous) {
            this.current = current;
            this.previous = previous;
        }
    }

    private Node root;
    private int size;

    @Override
    public void add(E value) {
        if (isEmpty()) {
            root = new Node(value);
            size++;
        } else insertNode(value, root);
    }

    private void insertNode(E insertedValue, Node<E> parent) {
        CurrentAndPreviousNode<E> currentAndPreviousNode = findCurrentAndPreviousNode(insertedValue, root, null);
        if (currentAndPreviousNode.current == null)
            insertLeaf(insertedValue, currentAndPreviousNode.previous);
    }

    private void insertLeaf(E insertedValue, Node<E> parent) {
        int valueOfComparison = parent.getValue().compareTo(insertedValue);
        Node<E> newNode = new Node<E>(insertedValue);
        if (valueOfComparison > 0) {
            parent.setLeftChild(newNode);
        } else parent.setRightChild(newNode);
        size++;
    }

    @Override
    public boolean contains(E value) {
        CurrentAndPreviousNode<E> currentAndPreviousNode = findCurrentAndPreviousNode(value, root, null);
        return currentAndPreviousNode.current != null;
    }

    private CurrentAndPreviousNode<E> findCurrentAndPreviousNode(E value, Node<E> current, Node<E> parent) {
        if (current == null) {
            return new CurrentAndPreviousNode<>(null, parent);
        }
        int valueOfComparison = current.getValue().compareTo(value);
        if (valueOfComparison == 0) {
            /**
             *  nothing have to do, values in structure must be unique*/
            return new CurrentAndPreviousNode<>(current, parent);
        }
        if (valueOfComparison > 0)
            return findCurrentAndPreviousNode(value, current.getLeftChild(), current);
        else
            return findCurrentAndPreviousNode(value, current.getRightChild(), current);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean remove(E value) {
        CurrentAndPreviousNode<E> currentAndPreviousNode = findCurrentAndPreviousNode(value, root, null);
        Node<E> removingNode = currentAndPreviousNode.current;
        /**
         * value not found - nothing to remove*/
        if (removingNode == null)
            return false;

        if (removingNode.isLeaf()) {
            removeLeaf(currentAndPreviousNode);
        }

        return true;
    }

    private void removeLeaf(CurrentAndPreviousNode<E> nodes) {
        Node<E> removingNode = nodes.current;
        Node<E> parent = nodes.previous;
        if (removingNode.isLeftChild(parent))
            parent.setLeftChild(null);
        else
            parent.setRightChild(null);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void display() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }
}
