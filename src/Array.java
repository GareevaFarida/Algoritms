public interface Array<E> {
    void add(E value);
    boolean remove(E value);
    int indexOf(E value);
    int getSize();
    E get(int index);
    boolean contains(E value);
    boolean isEmpty();
    void sortBubbles();
    void sortSelection();
    void sortInsert();
    void setValueByIndex(E value, int index);
    //void arraycopy(Array src, int indexSrc, Array dest, int indexDesc, int lenght);
}
