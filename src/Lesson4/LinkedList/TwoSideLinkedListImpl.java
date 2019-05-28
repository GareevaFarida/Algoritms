package Lesson4.LinkedList;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E> {

    private Entry<E> lastElement;

    @Override
    public void insertLast(E value) {
        if (isEmpty()) insertFirst(value);
        else {
            lastElement.next = new Entry<E>(value);
            lastElement = lastElement.next;
            size++;
        }
    }

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size == 1) {
            lastElement = firstElement;
        }
    }

    @Override
    public E deleteFirst() {
        E deletedElement = super.deleteFirst();
        if (isEmpty()) lastElement = null;
        return deletedElement;
    }

    @Override
    public boolean delete(E value) {
        if (isEmpty())
            return false;
        if (lastElement.value == value) {
            Object[] range = findPreviousAndCurrentEntriesOf(value);
            lastElement = (Entry<E>)range[0];
            lastElement.next = null;
            size--;
            Entry<E> deletedElement = (Entry<E>)range[1];
            deletedElement.value = null;
            deletedElement.next = null;
            return true;
        }
        return super.delete(value);
    }

    @Override
    public boolean insertAfterValue(E insertedValue, E findingValue) {
        boolean res = super.insertAfterValue(insertedValue, findingValue);
        if (!res)/* nothing changed */
            return false;

        /* we have to check, if the last element has been inserted */
        Object[] range = findPreviousAndCurrentEntriesOf(insertedValue);
        Entry<E> insertedElement = (Entry<E>)range[1];
        if (insertedElement.next == null) {
            lastElement = insertedElement;
        }
        return true;
    }

    @Override
    public int deleteAllEntriesOfValue(E value) {
        return super.deleteAllEntriesOfValue(value);
        //TODO надо доделать
    }

    @Override
    public void clear() {
        super.clear();
        lastElement = null;
    }
}
