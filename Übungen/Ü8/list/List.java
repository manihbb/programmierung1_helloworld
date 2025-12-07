class List {

    private class Node {
        private int value;
        private Node next;

        private Node(int element, Node next) {
            this.value = element;
            this.next = next;
        }
    }

    private Node head;

    List() {
        head = null;
    }

    List(int[] initialValues) {
        head = null;
        if (initialValues != null) {
            addAll(initialValues);
        }
    }

    void add(int value) {
        if (head == null) {
            head = new Node(value, null);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(value, null);
        }
    }

    int get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException();
            }
            current = current.next;
        }
        
        if (current == null) {
            throw new IndexOutOfBoundsException();
        }
        
        return current.value;
    }

    int length() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    void addAll(int[] values) {
        if (values == null) {
            return;
        }
        for (int val : values) {
            add(val);
        }
    }

    public String toString() {
        if (head == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(",");
            }
            current = current.next;
        }
        return sb.toString();
    }

    int find(int value) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.value == value) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    int findLast(int value) {
        Node current = head;
        int index = 0;
        int lastFoundIndex = -1;
        
        while (current != null) {
            if (current.value == value) {
                lastFoundIndex = index;
            }
            current = current.next;
            index++;
        }
        return lastFoundIndex;
    }

    MaybeInt findFirst(Int2BooleanFunction p) {
        Node current = head;
        while (current != null) {
            if (p.run(current.value)) {
                return MaybeInt.of(current.value);
            }
            current = current.next;
        }
        return MaybeInt.empty();
    }

    void remove(int index) {
        if (index < 0 || head == null) {
            return;
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current.next == null) {
                return;
            }
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    void removeFirstOccurrence(int value) {
        int index = find(value);
        if (index != -1) {
            remove(index);
        }
    }

    void removeLastOccurrence(int value) {
        int index = findLast(value);
        if (index != -1) {
            remove(index);
        }
    }

    List map(Int2IntFunction f) {
        List newList = new List();
        Node current = head;
        while (current != null) {
            newList.add(f.run(current.value));
            current = current.next;
        }
        return newList;
    }
}