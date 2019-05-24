package Lesson3.HomeWork.Deque;

public interface Degue<E> {
    void insertLeft(E value);
    void insertRight(E value);
    E removeLeft();
    E removeRight();
    boolean isEmpty();
    boolean isFull();
    void clear();
    int getSize();
    E peekLeft();
    E peekRight();
}
