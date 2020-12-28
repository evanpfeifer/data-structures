package MyStack;

import java.util.EmptyStackException;

public class MyStack<T> implements HomemadeStack<T> {
    private Node top;
    private int size;

    private class Node {
        T item;
        Node above;
        Node below;

        Node(T item, Node above, Node below) {
            this.item = item;
            this.above = above;
            this.below = below;
        }
    }

    // RUNTIME: O(1)
    public MyStack() {
        top = null;
        size = 0;
    }

    // RUNTIME: O(1)
    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    // RUNTIME: O(N)
    @Override
    public boolean contains(T item) {
        Node curr = top;
        while (curr != null) {
            if (curr.item == item) {
                return true;
            }
            curr = curr.below;
        }
        return false;
    }

    // RUNTIME: O(1)
    @Override
    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.item;
    }

    // RUNTIME: O(1)
    @Override
    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T returnVal = top.item;
        if (size == 1) {
            top = null;
        } else {
            top.below.above = null;
            top = top.below;
        }
        size--;
        return returnVal;
    }

    // RUNTIME: O(1)
    @Override
    public void push(T item) {
        if (top == null) {
            top = new Node(item, null, null);
        } else {
            Node newNode = new Node(item, null, top);
            top.above = newNode;
            top = newNode;
        }
        size++;
    }

    // RUNTIME: O(1)
    @Override
    public int size() {
        return size;
    }
}
