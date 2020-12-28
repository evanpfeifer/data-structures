public interface StackAPI<T> {
    /* Remove all elements from the stack */
    void clear();
    /* Returns true if the stack contains the specified element */
    boolean contains(T item);
    /* Return (but don't remove) the item at the top of the stack */
    T peek();
    /* Remove and return the item at the top of the stack */
    T pop();
    /* Add an element to the top of the stack */
    void push(T item);
    /* Return the size of the stack */
    int size();
}
