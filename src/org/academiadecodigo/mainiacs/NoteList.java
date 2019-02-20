package org.academiadecodigo.mainiacs;

public class NoteList {

    private Node head;
    private int length = 0;
    private Note lastAdded;

    public NoteList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    public void add(Note data) {

        Node node = new Node(data);
        Node iterator = head;

        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;
        lastAdded = data;
    }

    public Note get(int index) {

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

    public int indexOf(Note data) {
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

    public boolean remove(Note data) {
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
            Note note = iterator.getData();
            note.move();
            if (note.reachedEnd()) {
                remove(note);
            }
            iterator = iterator.getNext();
        }
    }

    public boolean noteInRange(Column col) {
        Node iterator = head.getNext();
        while (iterator != null) {
            Note note = iterator.getData();

            if (note.getColumn() != col || !note.isInTarget()) {
                iterator = iterator.getNext();
                continue;
            }
            note.hide();
            remove(note);
            return true;
        }
        return false;
    }

    public Note getLastAdded() {
        return lastAdded;
    }

    private class Node {

        private Note data;
        private Node next;

        public Node(Note data) {
            this.data = data;
            next = null;
        }

        public Note getData() {
            return data;
        }

        public void setData(Note data) {
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
