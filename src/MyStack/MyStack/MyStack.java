package MyStack;

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
        return false;
    }

    // RUNTIME: O(1)
    @Override
    public T peek() {
        return top.item;
    }

    // RUNTIME: O(1)
    @Override
    public T pop() {
        T returnVal = top.item;
        top.below.above = null;
        top = top.below;
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

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        HomemadeStack<Integer> myStack = new MyStack<Integer>();
        for (int i = 0; i < 100; i++) {
            myStack.push(i);
            myStack.size();
            myStack.peek();
        }
        for (int i = 0; i < 100; i++) {
            myStack.push(i);
        }
    }
}
