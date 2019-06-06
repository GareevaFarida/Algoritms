package Lesson6;

public interface Tree<E> {

    enum TraverseMode {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER,
    }

    void add(E value);

    boolean contains(E value);

    boolean isEmpty();

    boolean remove(E value);

    int getSize();

    void display();

    void traverse(TraverseMode traverseMode);

    boolean isBalanced();
}
