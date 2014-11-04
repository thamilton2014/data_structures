package assignment2;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by THamilton on 6/9/2014.
 */
public class practice {

    @Test(description = "This will test the fib method.")
    public static void testFib(){
        long result = fib(5);
        Assert.assertEquals(5, fib(5));
    }
    /** The method for finding the Fibonacci number */
    public static long fib(long index) {
        if (index == 0) // Base case
            return 0;
        else if (index == 1) // Base case
            return 1;
        else  // Reduction and recursive calls
            return fib(index - 1) + fib(index - 2);
    }

    @Test(description = "This will test the xMethod.")
    public static void testXMethod(){
        Assert.assertEquals(xMethod(4),10);
    }

    public static int xMethod(int n) {
        if (n == 1)
            return 1;
        else
            return n + xMethod(n - 1);
    }

    @Test(description = "This will test the palidrome method.")
    public static void testPalindrome(){
        Assert.assertEquals(isPalindrome("racecar"),true);
//        Assert.assertEquals(isPalindrome("notracecar"), true);
    }

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) // Base case
            return true;
        else if (s.charAt(0) != s.charAt(s.length() - 1)) // Base case
        return false;
        else
        return isPalindrome(s.substring(1, s.length() - 1));
    }

        @Test(description = "This will test another xMethod.", enabled = false)
        public static void testXMethod2(){
            int[] x = {1, 2, 3, 4, 5};
            xMethod(x, 5);
        }

        public static void xMethod(int[] x, int length) {
            System.out.print(" " + x[length - 1]);
            xMethod(x, length - 1);
        }

    @Test(description = "This will test isPalindrome1 method.")
    public static void testIsPalindrome1(){
        Assert.assertEquals(isPalindrome1("racecar"), true);
    }

    public static boolean isPalindrome1(String s) {
        return isPalindrome1(s, 0, s.length() - 1);
    }

    public static boolean isPalindrome1(String s, int low, int high) {
        if (high <= low) // Base case
            return true;
        else if (s.charAt(low) != s.charAt(high)) // Base case
            return false;
        else
            return isPalindrome1(s, low + 1, high - 1);
    }


    @Test(description = "Test the new xMethod.", enabled = false)
    public static void testXMethod3(){
    xMethod3(5);
    }
    public static void xMethod3(int length) {
        while (length > 1) {
            System.out.print((length - 1) + " ");
            xMethod(length - 1);
        }
    }

    @Test(description = "This will test f1 and f2.")
    public static void testF2(){
        Assert.assertEquals(f2(2,0),0);
    }

    public static int f2(int n, int result) {
        if (n == 0)
            return 0;
        else
            return f2(n - 1, n + result);
    }

    @Test(description = "Problem 1")
    public void testComplicatedSum(){
        Assert.assertEquals(complicatedSum(6), 6);
    }

    public int complicatedSum(int n) {
        if (n <= 3) {
            return n;
        }
        else if (n % 3 == 0)
            return n * 3 + complicatedSum(n-1);
        else if (n % 3 == 2)
            return n * 2 + complicatedSum(n-1);
        else
            return n + complicatedSum(n-1);
    }

    @Test(description = "Problem 2")
    public void testRecursiveString(){
        Assert.assertEquals(recursiveString("abcd"),"ab");
    }

    public String recursiveString(String str) {
        if (str.length() < 2)
            return str;
        return recursiveString(str.substring(1)) +
                str.substring(str.length()-1);
    }

//    @Test(description = "Problem 3")
//    public void testRecursiveEx2(){
//        Assert.assertEquals(recursiveEx2(0));
//    }
//
//    public int recursiveEx2(String a, char b, int i) {
//        if (i == a.length( ))
//        return 0;
//        if (b == a.charAt(i))
//        return recursiveEx2(a, b, i+1) + 1;
//        return recursiveEx2(a, b, i+1);
//    }

    @Test(description = "Problem 4",enabled = false)
    public void testDisplayArray(){
        Integer[] test = {3,4,5};
        displayArray(test);
    }

    public static <E extends Number> void displayArray(E[] array) {
        for (E element : array)
            System.out.println(element);
    }

}

