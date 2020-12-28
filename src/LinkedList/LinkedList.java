package LinkedList;

public interface LinkedList<E> {
    /* Adds an element to the end of the list */
    void add(E e);
    /* Adds an element to a specified index position of the list */
    void add(int index, E e);
    /* Clear all elements from the list */
    void clear();
    /* Returns true if the list contains the element, otherwise false */
    boolean contains(E e);
    /* Returns the element at the specified index */
    E get(int index);
    /* Removes and returns the element at the head of the list */
    E remove();
    /* Removes and returns the element at the specified index */
    E remove(int index);
    /* Returns the size of the list */
    int size();
    /* Returns a new array containing all elements in the list */
}
