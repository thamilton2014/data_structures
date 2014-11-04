package assignment2;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by THamilton on 6/4/2014.
 * Course: CS 3401
 * Section:
 * Name Thomas Hamilton
 * Professor: Allan Shaw
 * Assignment #: 2
 */

public class MaxRandomNumber {

    public static void main(String[] args) {
        testMax();
        Integer[][] testList = new Integer[5][5];
        Random random = new Random();
        for (int i = 0; i < testList.length; i++) {
            for (int j = 0; j < testList[i].length; j++) {
                int index = random.nextInt(1000);
                testList[i][j] = index;
                System.out.print(testList[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("The max is: " + max(testList));
    }

    public static <E extends Comparable<E>> E max(E[][] list) {
        E max = list[0][0];
        for (int i = 1; i < list.length; i++) {
            for (int j = 1; j < list[i].length; j++) {
                if (max.compareTo(list[i][j]) < 0) {
                    max = list[i][j];
                }
            }
        }
        return max;
    }

    public static void testMax(){
        Integer[][] numbers = {
                {1, 2, 3, 13, 9},
                {6, 8, 23, 99, 10},
                {11, 9, 19, 12, 11},
                {16, 14, 16, 20, 40},
                {3, 7, 6, 12, 13}};
        int result = max(numbers);
        assertEquals("The answer should be 99.", 99, result);
    }
}

