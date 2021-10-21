public class DoublyLinkedList<E> {
    Node<E> head;
    Node<E> tail;
    int size=0;

    public void insert(E data) {
        Node<E> node = new Node<>(data);

        if (head == null) {
            head = node;
        }
        else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        size++;
    }


    public void insert(E data, int index) {
        Node<E> node = head;

        // Step to find node in previous index
        for (int i = 0; i < index-1; i++) {
            node=node.next;
        }

        Node<E> newNode = new Node<>(data);
        newNode.next = node.next;
        newNode.prev = node;
        node.next.prev = newNode;
        node.next = newNode;
        size++;

    }

    public void delete(int index) {
        Node<E> node = head;

        if (index<0 || index>=size)
            throw new RuntimeException();

        if (index == 0) {
            node = node.next;
            node.prev = null;
            head.next = null;
            head = node;
        }
        else if (index == size-1) {
            node = tail.prev;
            tail.prev = null;
            node.next = null;
            tail = node;
        }
        else {
            // Step to find node in previous index
            for (int i = 0; i < index-1; i++) {
                node=node.next;
            }
            node.next.prev = null;
            node.next = node.next.next;
            node.next.prev.next = null;
            node.next.prev = node;
        }
        size--;
    }

    public String toString() {
        if (head == null)
            return "[]";
        Node<E> node = head;

        StringBuilder elements = new StringBuilder("[");
        elements.append(node.data).append(node.next != null ? "," : "");
        while (node.next != null) {
            node = node.next;
            elements.append(node.data).append(node.next != null ? "," : "");
        }
        elements.append("]");

        return elements.toString();
    }
}
