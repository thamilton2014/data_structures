package assignment1;
/**
 * Course:      CS 3401
 * Section:
 * Name:        Thomas Hamilton
 * Professor:   Alan Shaw
 * Assignment#: Homework 1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DBConvert {

    /**
     * @param bin   A String that represents the binary form of an integer.
     */
    static String bin = "";

    /**
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        try {
            /**
             *
             * @param br       A BufferedReader instantiation.
             * @param answer   A string that is stored into the BufferedReader.
             * @param letter   A string that is converted to char.
             * @
             */
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Give me a positive number: ");
            int answer = Integer.parseInt(br.readLine());
            String value = decimalToBinary(answer);
            System.out.println(value);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * This method takes the integers value passed to it and then
     * takes the modulo of the value converts it to a string and
     * concatenate it to the current string. If the base case is
     * not achieved, the recursive method is called again but this time
     * the value is divided by 2.
     *
     * @param value An Integer that contains the user input.
     * @return The value of the user input in binary.
     */
    public static String decimalToBinary(int value) {
        if (value == 0) {
            return bin;
        } else {
            bin = String.valueOf(value % 2) + bin;
            return decimalToBinary(value / 2);
        }
    }
}
