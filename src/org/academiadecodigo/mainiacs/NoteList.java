package org.academiadecodigo.mainiacs;

public class NoteList {

    private Node head;
    private int length = 0;

    public NoteList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param data the element to add
     */
    public void add(Object data) {

        Node node = new Node(data);
        Node iterator = head;

        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;
    }

    /**
     * Obtains an element by index
     *
     * @param index the index of the element
     * @return the element
     */
    public Object get(int index) {

        int counter = 0;

        if (index < 0 || index > length) {
            return null;
        }

        Node iterator = head.getNext();

        while (iterator != null && index != counter) {
            iterator = iterator.getNext();
            counter++;
        }

        if (iterator == null) {
            return null;
        }
        return iterator.getData();
    }

    /**
     * Returns the index of the element in the list
     *
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(Object data) {
        if (head.getNext() == null) {
            return -1;
        }
        int index = 0;
        Node iterator = head.getNext();
        while (iterator != null && iterator.getData() != data) {
            iterator = iterator.getNext();
            index++;
        }
        if (iterator == null) {
            return -1;
        }
        return index;
    }

    /**
     * Removes an element from the list
     *
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(Object data) {
        Node iterator = head;
        if (iterator.getNext() == null) {
            return false;
        }

        while (iterator.getNext() != null && iterator.getNext().getData() != data) {
            iterator = iterator.getNext();
        }

        if (iterator.getNext() == null) {
            return false;
        }

        Node next = iterator.getNext().getNext();

        iterator.setNext(next);
        length--;
        return true;
    }

    public void moveNotes() {
        Node iterator = head.getNext();
        while (iterator != null) {
            //((Note)iterator.getData()).move();
            iterator = iterator.getNext();
        }
    }

    public boolean noteInRange(Column col) {
        Node iterator = head.getNext();
        while (iterator != null) {
            Note note = (Note)iterator.getData();
            if (!note.isInTarget()) {
                iterator = iterator.getNext();
                continue;
            }
            note.delete();
            remove(note);
            return true;
        }
        return false;
    }

    private class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
