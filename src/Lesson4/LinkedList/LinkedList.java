package Lesson4.LinkedList;

public interface LinkedList<E> {
    void insertFirst(E value);
    E deleteFirst();
    boolean contains(E value);
    boolean delete(E value);
    E valueOfFirst();
    boolean insertAfterValue(E value,E previousValue);

    /**
     * Returns the number of deleted elements from this list
     *
     * @return the number of deleted elements from this list.
     */
    int deleteAllEntriesOfValue(E value);
    int getSize();
    boolean isEmpty();
    boolean isFull();
    void clear();
    void display();
}
