package Lesson4.LinkedList;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected Entry<E> firstElement;
    protected int size;


    protected class Entry<E> {
        E value;
        Entry<E> next;

        Entry(E value) {
            this.value = value;
        }

        public Entry(E value, Entry<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public void insertFirst(E value) {
        if (isEmpty()) {
            this.firstElement = new Entry<>(value);
        } else {
            Entry<E> newEntry = new Entry<>(value);
            newEntry.next = firstElement;
            firstElement = newEntry;
        }
        size++;
    }

    @Override
    public E deleteFirst() {
        if (isEmpty()) {
            return null;
        }
        E temp = firstElement.value;
        firstElement = firstElement.next;
        size--;
        return temp;
    }

    @Override
    public boolean contains(E value) {
        Object[] result = findPreviousAndCurrentEntriesOf(value);
        return result != null;
    }

    /**
     * finds Entry of value in the list and returns null or array of Entries.
     *
     * @param value for search in the list
     * @return null, if list doesn't contain the value, or
     * array of two Entry:
     * array[0] = previous Entry of found value
     * array[1] = Entry of found value
     */
    protected Object[] findPreviousAndCurrentEntriesOf(E value) {
        if (isEmpty())
            return null;
        Entry<E> previousEntry = null;
        Entry<E> currentEntry = firstElement;

        while (currentEntry != null) {
            if (currentEntry.value == value) {
                return new Object[]{previousEntry, currentEntry};
            }
            previousEntry = currentEntry;
            currentEntry = currentEntry.next;
        }

        return null;
    }

    @Override
    public boolean delete(E value) {
        if (isEmpty())
            return false;
        Object[] result = findPreviousAndCurrentEntriesOf(value);
        if (result == null)
            return false;

        Entry<E> previous = (Entry<E>) result[0];
        Entry<E> current = (Entry<E>) result[1];
        if (current == firstElement)
            deleteFirst();
        else {
            previous.next = current.next;
            current.value = null;
            current.next = null;
        }
        size--;
        return true;
    }

    @Override
    public boolean insertAfterValue(E insertedValue, E findingValue) {
        if (isEmpty())
            return false;
        Object[] result = findPreviousAndCurrentEntriesOf(findingValue);
        if (result == null)
            return false;
        Entry<E> foundValue = (Entry<E>) result[1];
        Entry<E> current = new Entry<>(insertedValue, foundValue.next);
        foundValue.next = current;
        size++;
        return true;
    }

    @Override
    public int deleteAllEntriesOfValue(E value) {
        if (isEmpty()) return 0;
        int count = 0;
        Entry<E> previous = null;
        Entry<E> current = firstElement;
        while (current != null) {
            if (current.value == value) {
                count++;
                if (current == firstElement) {
                    firstElement = current.next;
                    previous = null;
                } else
                    previous.next = current.next;
            }
            previous = current;
            current = current.next;
        }
        return count;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void clear() {
        if (isEmpty()) return;
        for (Entry<E> current = firstElement; current.next != null; ) {
            Entry<E> temp = current.next;
            current.value = null;
            current.next = null;
            current = temp;
        }
        firstElement = null;
        size = 0;
    }

    @Override
    public E valueOfFirst() {
        if (isEmpty())
            return null;
        return firstElement.value;
    }

    @Override
    public void display() {
        if (isEmpty())
            System.out.println(getClass().getSimpleName() + " is empty.");
        else {
            Entry<E> current = firstElement;
            while (current != null) {
                System.out.println(current.value);
                current = current.next;
            }
        }
    }
}
