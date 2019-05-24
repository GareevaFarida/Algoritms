package Lesson3.Queue;

public interface Queue<E> {
    void insert(E value);
    E remove();
    E peek();
    int getSize();
    boolean isEmpty();
    boolean isFull();
    void clear();
}
