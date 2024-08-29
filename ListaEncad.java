public class ListaEncad<T> {
    private Node<T> base;
    private Node<T> top;
    private int size;

    public ListaEncad() {
        this.base = null;
        this.top = null;
        this.size = 0;
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return false;
    }

    public int getSize() {
        return size;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            base = newNode;
            top = newNode;
        } else {
            newNode.prev = top;
            top.next = newNode;
            top = newNode;
        }
        size++;
    }

    public T remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        Node<T> nodeToRemove = getNode(pos);
        return remove(nodeToRemove);
    }

    public T remove(Node<T> node) {
        if (node == null) {
            return null;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            base = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            top = node.prev;
        }
        size--;
        return node.value;
    }

    public Node<T> getNode(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        Node<T> current = base;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }
        return current;
    }

    public T get(int pos) {
        return getNode(pos).value;
    }

    public void set(int pos, T value) {
        Node<T> node = getNode(pos);
        node.value = value;
    }

    public void printList() {
        Node<T> current = base;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}