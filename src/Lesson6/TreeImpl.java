package Lesson6;

import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private class CurrentAndPreviousNodes<E> {
        Node current;
        Node previous;

        public CurrentAndPreviousNodes(Node current, Node previous) {
            this.current = current;
            this.previous = previous;
        }
    }

    private Node root;
    private int size;

    @Override
    public void add(E value) {
        if (isEmpty()) {
            root = new Node(value, 0);
            size++;
        } else insertNode(value, root);
    }

    private void insertNode(E insertedValue, Node<E> parent) {
        CurrentAndPreviousNodes<E> currentAndPreviousNodes = findCurrentAndPreviousNodes(insertedValue, root, null);
        if (currentAndPreviousNodes.current == null)
            insertLeaf(insertedValue, currentAndPreviousNodes.previous);
    }

    private void insertLeaf(E insertedValue, Node<E> parent) {
        int valueOfComparison = parent.getValue().compareTo(insertedValue);
        Node<E> newNode = new Node<E>(insertedValue, parent.getDeep() + 1);
        if (valueOfComparison > 0) {
            parent.setLeftChild(newNode);
        } else parent.setRightChild(newNode);
        size++;
    }

    @Override
    public boolean contains(E value) {
        CurrentAndPreviousNodes<E> currentAndPreviousNodes = findCurrentAndPreviousNodes(value, root, null);
        return currentAndPreviousNodes.current != null;
    }

    public int deepOfValue(E value) {
        int deep = -1;
        CurrentAndPreviousNodes<E> nodes = findCurrentAndPreviousNodes(value, root, null);
        if (nodes.current != null)
            deep = nodes.current.getDeep();
        return deep;
    }

    /**
     * finds node, which containes the value, and node, which is a parent of found node.
     * Search starts from root of tree: findCurrentAndPreviousNode(value, root, null).
     *
     * @param value   - E finding value
     * @param current - current Node
     * @param parent  - parent of current Node
     * @return CurrentAndPreviousNode<E> - element of class,  which contains two fields:
     * current - Node, which contains finding value
     * parent - Node, which is a parent of current node
     * if current is null, the structure doesn't contain the value
     */
    private CurrentAndPreviousNodes<E> findCurrentAndPreviousNodes(E value, Node<E> current, Node<E> parent) {
        if (current == null) {
            return new CurrentAndPreviousNodes<>(null, parent);
        }
        int valueOfComparison = current.getValue().compareTo(value);
        if (valueOfComparison == 0) {
            return new CurrentAndPreviousNodes<>(current, parent);
        }
        if (valueOfComparison > 0)
            return findCurrentAndPreviousNodes(value, current.getLeftChild(), current);
        else
            return findCurrentAndPreviousNodes(value, current.getRightChild(), current);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean remove(E value) {
        CurrentAndPreviousNodes<E> currentAndPreviousNodes = findCurrentAndPreviousNodes(value, root, null);
        Node<E> removingNode = currentAndPreviousNodes.current;
        /**
         * value not found - nothing to remove*/
        if (removingNode == null)
            return false;

        if (removingNode.isLeaf()) {
            removeLeaf(currentAndPreviousNodes);
        }

        if (removingNode.hasOneChild())
            removeParentOfOneChild(currentAndPreviousNodes);

        if (removingNode.hasTwoChildren())
            removeParentOfTwoChildren(currentAndPreviousNodes);

        size--;
        return true;
    }

    private void removeParentOfTwoChildren(CurrentAndPreviousNodes<E> currentAndPreviousNodes) {
        Node<E> removingElement = currentAndPreviousNodes.current;
        Node<E> parentOfRemovingElement = currentAndPreviousNodes.previous;

        //find successor for removing element
        CurrentAndPreviousNodes<E> successorNodes = getSuccessor(currentAndPreviousNodes.current);
        Node<E> successor = successorNodes.current;

        //set new deep for successor - it's a deep of removing element
        successor.setDeep(removingElement.getDeep());

        //set successor instead of removing element:
        //1.parent of removing element gets new child - successor - instead of removing element
        if (removingElement.equals(root))
            root = successor;
        else {
            if (removingElement.isLeftChildOf(parentOfRemovingElement))
                parentOfRemovingElement.setLeftChild(successor);
            else
                parentOfRemovingElement.setRightChild(successor);
        }

        //2.successor gets children of removing element
        successor.setLeftChild(removingElement.getLeftChild());
        if (successor != removingElement.getRightChild())
            successor.setRightChild(removingElement.getRightChild());


        //3.Ex-parent of successor forgets about his child
        Node<E> exParentOfSuccessor = successorNodes.previous;
        if (successor.isLeftChildOf(exParentOfSuccessor))
            exParentOfSuccessor.setLeftChild(null);
        else
            exParentOfSuccessor.setRightChild(null);

        //clear links: removing element forgets about its children
        removingElement.setLeftChild(null);
        removingElement.setRightChild(null);
    }

    /**
     * finds more appropriate element to become a parent for two children instead of removing node
     * To find successor, get right child and find the last left generation
     *
     * @param current - removing Node
     * @return CurrentAndPreviousNodes - successor for removing node and it's parent
     */
    private CurrentAndPreviousNodes<E> getSuccessor(Node current) {
        // if (current == null) throw new AssertionError("Internal error: removing node can't be null.");
        Node<E> parentOfSuccessor = current;
        Node<E> leftOffspring = current.getRightChild();
        while (leftOffspring.hasLeftChild()) {
            parentOfSuccessor = leftOffspring;
            leftOffspring = leftOffspring.getLeftChild();
        }
        return new CurrentAndPreviousNodes<>(leftOffspring, parentOfSuccessor);
    }

    private void removeParentOfOneChild(CurrentAndPreviousNodes<E> currentAndPreviousNodes) {
        Node<E> removingNode = currentAndPreviousNodes.current;
        Node<E> leftChild = removingNode.getLeftChild();
        Node<E> rightChild = removingNode.getRightChild();
        if (leftChild != null) {
            currentAndPreviousNodes.previous.setLeftChild(leftChild);
        } else if (rightChild != null) {
            currentAndPreviousNodes.previous.setRightChild(rightChild);
        }
    }

    private void removeLeaf(CurrentAndPreviousNodes<E> nodes) {
        Node<E> removingNode = nodes.current;
        Node<E> parent = nodes.previous;
        if (removingNode == root) {
            root = null;
            return;
        }
        if (removingNode.isLeftChildOf(parent))
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
