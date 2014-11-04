package assignment2;

/**
 * Created by THamilton on 6/4/2014.
 */
//********************************************************************
//  Demonstrates the selection sort and insertion sort algorithms with strings.
//********************************************************************

public class Sorting {
    //-----------------------------------------------------------------
    //  Sorts the specified array of objects using the selection
    //  sort algorithm.
    //-----------------------------------------------------------------

    public static <E extends Comparable<E>> void selectionSort(E[] list) {
        for (int index = 1; index < list.length; index++) {
            E key = list[index];
            int position = index;

            //  Shift larger values to the right
            while (position > 0 && key.compareTo(list[position - 1]) < 0) {
                list[position] = list[position - 1];
                position--;
            }

            list[position] = key;
        }
    }

    public static <E extends Comparable<E>> void insertionSort(E[] list) {
        for (int index = 1; index < list.length; index++) {
            E key = list[index];
            int position = index;

            //  Shift larger values to the right
            while (position > 0 && key.compareTo(list[position - 1]) < 0) {
                list[position] = list[position - 1];
                position--;
            }

            list[position] = key;
        }
    }
//    public static void selectionSort (String[] list)
//    {
//        int max;
//        String temp;
//
//        for (int index = 0; index < list.length-1; index++)
//        {
//            max = index;
//            for (int scan = index+1; scan < list.length; scan++)
//                if (list[scan].compareTo(list[max]) < 0)
//                    max = scan;
//
//            // Swap the values
//            temp = list[max];
//            list[max] = list[index];
//            list[index] = temp;
//        }
//    }

    //-----------------------------------------------------------------
    //  Sorts the specified array of objects using the insertion
    //  sort algorithm.
    //-----------------------------------------------------------------
//    public static void insertionSort (String[] list)
//    {
//        for (int index = 1; index < list.length; index++)
//        {
//            String key = list[index];
//            int position = index;
//
//            //  Shift larger values to the right
//            while (position > 0 && key.compareTo(list[position-1]) < 0)
//            {
//                list[position] = list[position-1];
//                position--;
//            }
//
//            list[position] = key;
//        }
//    }
}
