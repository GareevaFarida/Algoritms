package Lesson6;

public interface Tree<E> {
    void add(E value);

    boolean contains(E value);

    boolean isEmpty();

    boolean remove(E value);

    int getSize();

    void display();
}
