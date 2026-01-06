class LinkedList<T extends Comparable<T>> {

    private class Node {
        private T value;
        private Node next;

        private Node(T element, Node next) {
            this.value = element;
            this.next = next;
        }
    }

    private Node head;

    LinkedList() {
    }

    void add(T element) {
        Node newElement = new Node(element, null);

        if (head == null) {
            head = newElement;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newElement;
        }
    }

    private Node findNodeAt(int index) {
        Node current = head;

        for(int i = 0; i < index && current.next != null; i++) {
            current = current.next;
        }

        return current;
    }

    T get(int index) {
        return findNodeAt(index).value;
    }

    int length() {
        int length = 0;
        Node current = head;
        while(current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    void remove(int index) {
        if(head == null || index < 0 || index >= length()) {
            return;
        }
    
        if(index == 0) {
            head = head.next;
            return;
        }

        Node current = head;

        for(int i = 0; i < index - 1 && current.next != null; i++) {
            current = current.next;
        }

        current.next = current.next.next;
    }

    void sort() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Node current = head;

            while (current.next != null) {
                if (current.value.compareTo(current.next.value) > 0) {
                    T temp = current.value;
                    current.value = current.next.value;
                    current.next.value = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    @Override
    public String toString() {
        String output = "";

        Node current = head;
        while(current != null) {
            if(current.next == null) {
                output += current.value;
            } else {
                output += current.value + ",";
            }
            current = current.next;
        }

        return output;
    }
}