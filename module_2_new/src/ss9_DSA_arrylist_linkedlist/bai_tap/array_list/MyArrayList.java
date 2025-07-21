package ss9_DSA_arrylist_linkedlist.bai_tap.array_list;

import java.util.Arrays;

public class MyArrayList<E> {
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Capacity must be >= 0: " + capacity);
        }
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public boolean add(E element) {
        if (size == elements.length) {
            ensureCapacity(5);
        }
        elements[size] = element;
        size++;
        return true;
    }

    public boolean add(E element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (size == elements.length) {
            ensureCapacity(5);
        }

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = element;
        size++;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new IllegalArgumentException("minCapacity must be >= 0: " + minCapacity);
        }
        int newSize = elements.length + minCapacity;
        elements = Arrays.copyOf(elements, newSize);
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return (E) elements[index];
    }

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    public MyArrayList<E> clone() {
        MyArrayList<E> clonedList = new MyArrayList<>(this.elements.length);
        for (int i = 0; i < this.size; i++) {
            clonedList.elements[i] = this.elements[i];
        }
        clonedList.size = this.size;
        return clonedList;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Error index: " + index);
        }

        E removedElement = (E) elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[size - 1] = null;
        size--;
        return removedElement;
    }
}
