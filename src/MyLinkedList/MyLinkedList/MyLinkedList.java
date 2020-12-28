package MyLinkedList;

public class MyLinkedList<E> implements HomemadeLinkedList<E> {
    private int size;
    private Node head;
    private Node tail;

    private class Node {
        E item;
        Node last;
        Node next;

        Node(E item, Node last, Node next) {
            this.item = item;
            this.last = last;
            this.next = next;
        }
    }

    public MyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    // RUNTIME: O(N)
    public void add(E e) {
        add(size, e);
    }

    @Override
    // RUNTIME: O(N)
    public void add(int index, E e) {
        if ((index > size) || (index < 0)) {
            throw new NullPointerException("index out of bounds");
        }
        if (head == null) {
            head = new Node(e, null, null);
            tail = head;
        } else {
            Node newNode;
            Node curr;
            if (index == size) {
                newNode = new Node(e, tail, null);
                tail.next = newNode;
                tail = newNode;
            } else {
                curr = findNode(index);
                newNode = new Node(e, curr.last, curr);
                curr.last.next = newNode;
                curr.last = newNode;
                if (curr == head) {
                    head = newNode;
                }
            }
        }
        size++;
    }

    // RUNTIME: O(N)
    /* Find and return a node at a certain index */
    private Node findNode(int index) {
        Node curr = head;
        while (index != 0) {
            curr = curr.next;
            index--;
        }
        return curr;
    }

    @Override
    // RUNTIME: O(1)
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    // RUNTIME: O(N)
    public boolean contains(E e) {
        if (size == 0) {
            return false;
        }
        Node curr = head;
        while(curr != null) {
            if (curr.item == e) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    // RUNTIME: O(N)
    public E get(int index) {
        if ((index > size) || (index < 0)) {
            throw new NullPointerException("index out of bounds");
        }
        return findNode(index).item;
    }

    @Override
    // RUNTIME: O(1)
    public E remove() {
        return remove(0);
    }

    @Override
    // RUNTIME: O(N)
    public E remove(int index) {
        if ((index > size) || (index < 0)) {
            throw new NullPointerException("index out of bounds");
        }
        Node nodeToRemove = findNode(index);
        E returnItem = nodeToRemove.item;
        if (nodeToRemove == head) {
            if (size != 1) {
                head.next.last = null;
            }
            head = head.next;
        } else if (nodeToRemove == tail) {
            tail.last.next = null;
            tail = tail.last;
        } else {
            nodeToRemove.last.next = nodeToRemove.next;
            nodeToRemove.next.last = nodeToRemove.last;
        }
        size--;
        return returnItem;
    }

    @Override
    // RUNTIME: O(1)
    public int size() {
        return size;
    }
}
