package assignment9;

/*
 * Course: CS 3401
 * Section:
 * Name: Thomas Hamilton
 * Professor: Alan Shaw
 * Assignment #: 9
 */

public class MyHashSet<E> implements MySet<E> {

    // Implement the MyHashMap
    private MyHashMap<E, E> map;

    public MyHashSet() {
        map = new MyHashMap();
    }

    public MyHashSet(int initialCapacity) {
        map = new MyHashMap(initialCapacity);
    }

    public MyHashSet(int initialCapacity, float loadFactorThreshold) {
        map = new MyHashMap<E, E>(initialCapacity, loadFactorThreshold);
    }

    @Override
    /** Remove all elements from this set */
    public void clear() {
        map.clear();
    }

    @Override
    /** Return true if the element is in the set */
    public boolean contains(E e) {
        return map.containsKey(e);
    }

    @Override
    /** Add an element to the set */
    public boolean add(E e) {
        return map.put(e, e) != null;
    }

    @Override
    /** Remove the element from the set */
    public boolean remove(E e) {
        if (!map.containsKey(e))
            return false;
        map.remove(e);
        return true;
    }

    @Override
    /** Return true if the set contains no elements */
    public boolean isEmpty() {
        return map.size() == 0;
    }

    @Override
    /** Return the number of elements in the set */
    public int size() {
        return map.size();
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new MyHashSetIterator(map);
    }


    private class MyHashSetIterator implements java.util.Iterator<E> {
        // Store the elements in a list
        private java.util.ArrayList<E> list;
        private int current = 0; // Point to the current element in list
        private MyHashMap<E, E> map;

        public MyHashSetIterator(MyHashMap<E, E> map) {
            this.map = map;
            list = setToList();
        }

        @Override
        public boolean hasNext() {
            return current < list.size();
        }

        @Override
        public E next() {
            return list.get(current++);
        }

        @Override
        public void remove() {
            // Delete the current element from the hash set
            map.remove(list.get(current));
            list.remove(current); // Remove current element from the list
        }
    }

    private void removeElements() {
        map.clear();
    }

    private java.util.ArrayList<E> setToList() {
        java.util.ArrayList<E> list = new java.util.ArrayList<E>();
        for (E e : map.keySet())
            list.add(e);

        return list;
    }

    @Override
    public String toString() {
        java.util.ArrayList<E> list = setToList();
        StringBuilder builder = new StringBuilder("[");

        // Add the elements except the last one to the string builder
        for (int i = 0; i < list.size() - 1; i++) {
            builder.append(list.get(i)).append(", ");
        }

        // Add the last element in the list to the string builder
        if (list.size() == 0)
            builder.append("]");
        else
            builder.append(list.get(list.size() - 1)).append("]");

        return builder.toString();
    }
}
