package assignment2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by THamilton on 6/4/2014.
 * Course: CS 3401
 * Section:
 * Name Thomas Hamilton
 * Professor: Allan Shaw
 * Assignment #: 2
 */
public class SortingDriver {


    public static void main(String[] args) {
        try {
            String[] friends = new String[4];

            friends[0] = "Fred Williams";
            friends[1] = "Sarah Barnes";
            friends[2] = "Mark Riley";
            friends[3] = "Laura Getz";
            Sorting.insertionSort(friends);

            for (int i = 0; i < friends.length; ++i) {
                System.out.println(friends[i]);
            }

            /**
             * @Condition: No null values.
             * @Expected: The Sorting class should traverse the arrays and place them
             *              in a particular order.
             * @Steps: Create String, Integer, Date arrays, then pass them to the Sorting class
             *              and it's methods that are used for sorting, then finally use some sort of
             *              error checking for the results.
             */
            Integer[] intArray = {4, 21, 9, 10};
            String[] strArray = {"Paris", "London", "New York", "Atlanta", "Oregon"};
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date[] dateArray =
                    {
                            df.parse("2014-02-23"),
                            df.parse("2012-05-18"),
                            df.parse("2013-04-2")
                    };
            /**
             * selectionSort
             */
            Sorting.selectionSort(intArray);
            Sorting.selectionSort(dateArray);
            Sorting.selectionSort(strArray);

            for(int i = 0; i < intArray.length; i++){
                System.out.println(intArray[i]);
            }

            for(int i = 0; i < dateArray.length; i++){
                System.out.println(dateArray[i]);
            }

            for(int i = 0; i < strArray.length; i++){
                System.out.println(strArray);
            }

            int intTest = intArray[3];
            assertEquals("The last value of intArray should be 21.", 21, intTest);

            String strTest = strArray[4];
            assertEquals("The last value of strArray should be Paris.", "Paris", strTest);

            Date dateArrayTest = dateArray[2];
            assertEquals("The last value of the dateArray should be 2013-04-2.", df.parse("2014-02-23"), dateArrayTest);

            Integer[] intArray2 = {4, 21, 9, 10};
            String[] strArray2 = {"Paris", "London", "New York", "Atlanta", "Oregon"};
            DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
            Date[] dateArray2 =
                    {
                            df2.parse("2014-02-23"),
                            df2.parse("2012-05-18"),
                            df2.parse("2013-04-2")
                    };
            /**
             * insertionSort
             */
            Sorting.insertionSort(intArray2);
            Sorting.insertionSort(dateArray2);
            Sorting.insertionSort(strArray2);

            for(int i = 0; i < intArray2.length; i++){
                System.out.println(intArray2[i]);
            }

            for(int i = 0; i < dateArray2.length; i++){
                System.out.println(dateArray2[i]);
            }

            for(int i = 0; i < strArray2.length; i++){
                System.out.println(strArray2);
            }

            int intTest2 = intArray2[3];
            assertEquals("The last value of intArray2 should be 21.", 21, intTest2);

            String strTest2 = strArray2[4];
            assertEquals("The last value of strArray2 should be Paris.", "Paris", strTest2);

            Date dateArrayTest2 = dateArray2[2];
            assertEquals("The last value of the dateArray2 should be 2013-04-2.", df.parse("2014-02-23"), dateArrayTest2);

        } catch (Exception e) {
            System.out.println("Something is wrong, take a closer look at " + e);
        }
    }
}