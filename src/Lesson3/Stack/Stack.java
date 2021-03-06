package Lesson3.Stack;

public interface Stack<E> {
    void push(E value);
    E pop();
    E peek();
    boolean isEmpty();
    boolean isFull();
    int getSize();
    void clear();
}
