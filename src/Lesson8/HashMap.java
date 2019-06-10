package Lesson8;

public interface HashMap<E,T> {
    void put(E key, T value);
    boolean delete(E key);
    boolean isEmpty();
    int size();
    void display();
}
