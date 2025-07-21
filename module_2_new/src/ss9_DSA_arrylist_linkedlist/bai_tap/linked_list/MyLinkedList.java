package ss9_DSA_arrylist_linkedlist.bai_tap.linked_list;

public class MyLinkedList<E> {
    private Node<E> head;
    private int size = 0;

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        Node<E> newNode = new Node<>(element);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    public E get(int index) {
        checkIndex(index);
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public E remove(int index) {
        checkIndex(index);
        Node<E> removed;

        if (index == 0) {
            removed = head;
            head = head.next;
        } else {
            Node<E> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            removed = prev.next;
            prev.next = removed.next;
        }

        size--;
        return removed.data;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    public int indexOf(E element) {
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            if (element.equals(temp.data)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }
}
