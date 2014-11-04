package assignment6;
/**
 * Course: CS 3401
 * Section: .....
 * Name: Thomas Hamilton
 * Professor: Alan Shaw
 * Assignment #: 7
 * */
public class TestLinkedList_v1 {
    public static void main(String[] args) {
        MyLinkedList_v1 list = new MyLinkedList_v1();
        list.add("Rain");
        list.add("Spain");
        list.add("Vain");
        list.add("Plain");

//        System.out.println(list);

        list.add(0,"The");
        list.add(2,"In");
        System.out.println("Removing element 4: " + list.remove(4));
        list.add(4, "Falls Mainly In The");
        System.out.println(list);
        System.out.println("The list size: " + list.size());
        System.out.println("The first element is: " + list.getFirst());
        System.out.println("The last element is : " + list.getLast());
        System.out.println("The linked list contains 'Spain': " + list.contains("In"));
        System.out.println("Get element 4: " + list.get(4));
        System.out.println("Get the index of Spain: " + list.indexOf("Spain"));
        System.out.println("Get the last index of Rain: " + list.lastIndexOf("Rain"));
        System.out.println("Remove the first occurrence of In: " + list.removeFirstOccurence("In"));
        System.out.println("Remove the last occurence of Rain: " + list.removeLastOccurence("Rain"));
        System.out.println("Removing element 5: " + list.remove(5));
        System.out.println(list);

        System.out.println();
        System.out.println();

        MyLinkedList_v1 list2 = new MyLinkedList_v1();
        list2.add(4);
        list2.add(3);
        list2.addFirst(6);
        list2.addLast(20);
        list2.add(0,30);
        print("##### List initialized #####");
        print(list2.toString());
        print("############################\n");
        print("list2.size(): " + list2.size());
        print("list2.getFirst(): " + list.getFirst());
        print("list2.getLast(): " + list.getLast());
        print("list2.contains(): " + list2.contains("30"));
        print("list2.get(): " + list2.get(2));
        print("list2.indexOf(): " + list.indexOf(6));
        print("list2.lastIndexOf(): " + list2.lastIndexOf(4));
        print("list2.removeFirstOccurence(): " + list2.removeFirstOccurence(2));
        print("list2.removeLastOccurence(): " + list2.removeLastOccurence(20));
        print(list2.toString());


    }

    private static void print(String message){
        System.out.println(message);
    }
}