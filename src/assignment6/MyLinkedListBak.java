package assignment6;

import java.util.Iterator;

public class MyLinkedListBak<E> {
    private Node<E> head, tail;
    private int size = 0;

    public MyLinkedListBak(){

    }

    public E getFirst(){
        if ( size == 0 ){
            return null;
        }
        else {
            return head.element;
        }
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for(int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if ( current != null){
                result.append(", ");
            }
            else {
                result.append("]");
            }
        }
        return result.toString();
    }

    /**
     * Add a new element at the end of this list
     * @param e
     */
    public void add(E e){
        add(size, e);
    }

    /**
     *
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if ( index == 0 ) addFirst(e);
        else if ( index >= size ) addLast(e);
        else{
            Node<E> current = head;
            for ( int i = 1; i < index; i++ )
                current = current.next;
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size++;
        }
    }

    /**
     * Inserts the given element at the beginning of the list.
     * @param e
     */
    public void addFirst(E e){
        Node<E> newNode = new Node<E>(e);
        newNode.next = head;
        head = newNode;
        size++;

        if ( tail == null )
        tail = head;
    }

    /**
     * Inserts the given element at the beginning of the list.
     * @param e
     */
    public void addLast(E e){
        Node<E> newNode = new Node<E>(e);
        if ( tail == null ) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear(){
        size = 0;
        head = tail = null;
    }

    /**
     * Returns true if the given elmeents is in the list.
     * @param e
     * @return
     */
    public boolean contains(E e){
       Node<E> current = head;
        for ( int i = 0; i < size; i++ ){
            if ( current.element.equals(e))
                return true;
            current = current.next;
        }
        return false;
    }

    /**
     * Gets the element at the specified position in this list.
     * @param index
     * @return
     */
    public E get(int index){
        if ( index < 0 || index > size - 1 )
            return null;

        Node<E> current = head;
        for ( int i = 0; i < index; i++)
            current = current.next;

        return (E) current.element;
    }

    /**
     * Gets the last element in the list.
     * @return
     */
    private E getLast(){
        if ( size == 0 ) {
            return null;
        }
        else {
            return tail.element;
        }
    }

    /**
     * Returns the index of the first occurrence of the
     * given element, or -1 if not found
     * @param e
     * @return
     */
    public int lastIndexOf(E e){
        int lastIndex = -1;
        Node<E> current = head;
        for( int i = 0; i < size; i++){
            if ( current.element.equals( e ) )
                lastIndex = i;
            current = current.next;
        }
        return lastIndex;
    }

    /**
     * Removes the first occurrence of the given element
     * Returns true if found, false if not.
     * @param e
     * @return
     */
    public boolean removeFirstOccurence(E e){
        int index = 0;
        Node<E> current = head;
        for ( int i = 0; i < size; i ++ ){
            if ( current.element.equals(e))
                current = current.next;
            return true;
        }
        return false;
    }

    /**
     * Remove the last occurrence of the given element.
     * Returns true if found, false if not.
     * @param e
     * @return
     */
    public boolean removeLastOccurence(E e){
//        int lastIndex = -1;
//        Graph.Node<E> current = head;
//        for ( int i = 0; i < size; i++ ){
//            lastIndex = i;
//            current = current.next;
//            return true;
//        }
        msg("Not ready");
        return false;
    }
    public boolean remove(E e) {
//        if(indexOf(e) >= 0 ){
//            remove(indexOf(e));
//        }
//        else
        msg("Not ready");
            return false;
    }

    public int indexOf(E e){
        Node<E> current = head;
        for ( int i = 0; i < size; i++){
            if (current.element.equals(e))
                return i;
            current = current.next;
        }
        return -1;
    }
    private Iterator<E> iterator(){
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = head;
        public boolean hasNext(){
            return (current != null);
        }

        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }

        public void remove() {
            System.out.println("Implementation left as an exercise");
        }

    }

    //*****************************************************************
    //  An inner class that represents a node in the linked list.
    //  The public variables are accessed by the MyLinkedListBak class.
    //*****************************************************************
    private class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        /**
         * Sets up the node
         * @param element
         */
        public Node(E element) {
            this.element = element;
            next = null;
            prev = null;
        }
    }

    private void msg(String message)
    {
        System.out.println(message);
    }
}