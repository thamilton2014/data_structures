package assignment1;
/**
 * Course:      CS 3401
 * Section:
 * Name:        Thomas Hamilton
 * Professor:   Alan Shaw
 * Assignment#: Homework 1
 */

import java.io.*;
import java.util.*;

public class CountChars {
    /**
     * @param alphabet  A char[] of lower/uppercase letters.
     * @param length    An Integer that determines charList size.
     * @param result    an Integer that determines the total count of char.
     */

    static int length = 30;
    static int result = 0;

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try {
            /**
             * I use a forloop that traverses the charList and adds the character
             * where the index is produced.
             * @param random    Instantiate the random variable.
             * @param charList  A char[] that holds the randomly selected characters.
             * @param index     An integer that is used to index the char[] alphabet.
             */
            char[] alphabet =
                    "ABCDEFGHIJKLMNOPQRSTUVWRXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
            Random random = new Random();
            char[] charList = new char[length];
            for (int i = 0; i < charList.length - 1; i++) {
                int index = random.nextInt(alphabet.length);
                charList[i] = alphabet[index];
            }
            System.out.print("Here are 30 random characters:");
            /**
             *
             * @see The contents of the charList array.
             */
            for (char in : charList) {
                System.out.print(in + " ");
            }

            /**
             *
             * @param br       A BufferedReader instantiation.
             * @param answer   A string that is stored into the BufferedReader.
             * @param letter   A string that is converted to char.
             * @
             */
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nWhat character do you want to count?");
            String answer = br.readLine();
            char letter = answer.charAt(0);
            System.out.println("There are " + countTheChar(charList, letter) + " occurrences of: " + answer);
        } catch (Exception e) {
            System.out.println("The error: " + e);
        }
    }

    /**
     * This is a helper method.
     *
     * @param chars A char[] that contains the randomly chosen characters.
     * @param ch    A char that the user has chosen to count.
     * @return Either the initial result or a recursive method.
     */
    public static int countTheChar(char[] chars, char ch) {
        if (chars.length == 0) {
            return result;
        } else {
            return countTheChar(chars, ch, chars.length);
        }
    }

    /**
     * This is a recursive method that iterates through the char[] and matches any
     * characters that were input by the user. If the characters match, the results variables
     * adds 1. Once the base case is achieved, the result variable is returned.
     *
     * @param chars A char[] that contains the randomly chosen characters.
     * @param ch    A char that the user has chosen to count.
     * @param high  An integer that describes the size of the array.
     * @return
     */
    public static int countTheChar(char[] chars, char ch, int high) {
        if (high == 0) {
            return result;
        } else {
            if (ch == chars[high - 1]) {
                result += 1;
            }
            return countTheChar(chars, ch, high - 1);
        }
    }
}


