class List<T> {

    private class Node {
        private T element = null;
        private Node next = null;

        private Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        private Node(T element) {
            this.element = element;
        }
    }
    
    private Node head = null;
    
    void prepend(T object) {
        head = new Node(object, head);
    }
    
    void append(T object) {
        if(head == null) {
            head = new Node(object);
            return;
        }
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = new Node(object);
    }
    
    T first() {
        return get(0);
    }
    
    T get(int index) {
        Node current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }
    
    int size() {
        Node current = head;
        int size = 0;
        for(; current != null; size++) {
            current = current.next;
        }
        return size;
    }
    
    boolean anyMatch(Predicate<T> p) {
        Node current = head;
        while(current != null) {
            if(p.fulfills(current.element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    @Override
    public String toString() {
        String string = "";
        Node current = head;
        while(current != null) {
            string += current.element + " -> ";
            current = current.next;
        }
        return string;
    }
}