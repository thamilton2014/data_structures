package assignment6;
/**
 * Course: CS 3401
 * Section: .....
 * Name: Thomas Hamilton
 * Professor: Alan Shaw
 * Assignment #: 7
 * */
public class MyLinkedList_v1<E> {
    private Node list;
    private Node tail;

    protected int size = 0;

    public MyLinkedList_v1() {
        list = null;
        tail = null;
    }

    public E getFirst() {
        return list.element;
    }

    public void add(E element) {
        Node newNode = new Node(element);

        if (list == null) {       // if the list is null then
            list = newNode;       //   newNode starts the list
            tail = newNode;       //   and it also ends the list
        } else {
            tail.next = newNode;  // newNode goes after current last
            newNode.prev = tail;  // current last goes before newNode
            tail = newNode;       // newNode becomes the current last
        }
    }

    public void add(int pos, E element) {
        Node newNode = new Node(element);

        if (list == null) {       // if the list is null then
            list = newNode;       //   newNode starts the list
            tail = newNode;       //   and it also ends the list
        } else if (pos == size()) {
            add(element);         // call other add to add at end

        } else if (pos == 0) {    // if pos is 0
            newNode.next = list;  //   newNode next points to list
            list.prev = newNode;  //   list prev points to newNode
            list = newNode;       //   newNode now starts the list
        } else if (pos < size()) {
            Node curr = list;     // find current node before pos
            for (int i = 0; i < pos - 1; ++i)
                curr = curr.next;
            newNode.next = curr.next;     // NewNode next is curr next
            newNode.prev = curr;          // NewNode prev is curr
            curr.next = newNode;          // curr's new next is NewNode
            newNode.next.prev = newNode;  // newNode's next points back
        }
    }

    public E remove(int pos) {
//        if ( pos == 0 ) return removeFirst();
//        else if ( pos == size - 1) return removeLast();
        Node prev = null;
        Node current = list;
        while ( pos > 0 ){
            prev = current;
            current = current.next;
            pos--;
        }
        prev.next = current.next;
        current.next = prev.next;
        return current.element;
    }

    public int size() {
        int count = 0;
        for (Node node = list; node != null; ++count)
            node = node.next;
        return count;
    }

    public String toString() {
        String result = "<";
        Node current = list;
        while (current != null) {
            result += current.element + ((current.next == null) ? ">" : ", ");
            current = current.next;
        }

        result += "\n";

        result += "<<";
        current = tail;
        while (current != null) {
            result += current.element + ((current.prev == null) ? ">>" : ", ");
            current = current.prev;
        }
        return result;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void clear() {
        size = 0;
        list = tail = null;
    }

    public boolean contains(E e) {
        Node current = list;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e))
                return true;
            current = current.next;
        }
        return false;
    }

    public E get(int index) {
        Node current = list;
        while (index > 0) {
            current = current.next;
            index--;
        }
        return current.element;
    }

    public E getLast() {
        return tail.element;
    }

    public int indexOf(E e) {
        int index = 0;
        if (e == null) {
            for (Node node = list; node != null; node = node.next) {
                if (node.element == null)
                    return index;
                index++;
            }
        } else {
            for (Node node = list; node != null; node = node.next) {
                if (e.equals(node.element))
                    return index;
                index++;
            }
        }
        return -1;
    }

    public int lastIndexOf(E e) {
        int index = size;
        if (e == null) {
            for (Node x = tail; x != null; x = x.prev) {
                index--;
                if (x.element == null)
                    return index * (-1);
            }
        } else {
            for (Node x = tail; x != null; x = x.prev) {
                index--;
                if (e.equals(x.element))
                    return index * (-1);
            }
        }
        return -1;
    }

    public boolean removeFirstOccurence(E e) {
        int index = 0;
        if (e == null) {
            for (Node node = list; node != null; node = node.next) {
                if (node.element == null)
                    remove(index);
                index++;
                return true;
            }
        } else {
            for (Node node = list; node != null; node = node.next) {
                if (e.equals(node.element))
                    remove(index);
                index++;
                return true;
            }
        }
        return false;
    }

    public boolean removeLastOccurence(E e) {
        int index = size;
        if (e == null) {
            for (Node node = list; node != null; node = node.prev) {
                if (node.element == null) {
                    remove(index);
                }
                index++;
                return true;
            }
        } else {
            for (Node node = list; node != null; node = node.prev) {
                if (e.equals(node.element)) {
                    remove(index);
                }
                index++;
                return true;
            }
        }
        return false;
    }

    private class Node {
        public E element;
        public Node next;
        public Node prev;

        public Node(E element) {
            this.element = element;
        }
    }
}