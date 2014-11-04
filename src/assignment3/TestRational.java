package assignment3;

import java.math.BigInteger;
import java.util.Random;


/**
 * Created by THamilton on 6/16/2014.
 * Course: CS 3401
 * Section:
 * Name Thomas Hamilton
 * Professor: Allan Shaw
 * Assignment #: 3
 */

public class TestRational {

    /**
     *
     * @param args
     * @Step 1: Create a random BigInteger value.
     * @Step 2: Pass variable to Rational class.
     * @Step 3: Adjust the Rational class constructor and methods
     *          to allow BigInteger values.
     * @Step 4: Return all the results to validate entry.
     *
     */
    public static void main(String[] args){
        BigInteger a = RandomBigInteger();
        BigInteger b = RandomBigInteger();
        BigInteger c = RandomBigInteger();
        BigInteger d = RandomBigInteger();
        Rational obj1 = new Rational(a,b);
        Rational obj2 = new Rational(c,d);
        System.out.println("Object 1: " + obj1);
        System.out.println("Object 2: " + obj2);
        System.out.println(obj1 + " + " + obj2 + " = " + obj1.add(obj2));
        System.out.println(obj1 + " - " + obj2 + " = " + obj1.subtract(obj2));
        System.out.println(obj1 + " * " + obj2 + " = " + obj1.multiply(obj2));
        System.out.println(obj1 + " / " + obj2 + " = " + obj1.divide(obj2));
        System.out.println(obj1 + " == " + obj2 + " = " + obj1.equals(obj2));
    }

    public static BigInteger RandomBigInteger(){
        Random random = new Random();
        String result = String.valueOf(random.nextInt(1000));
        BigInteger bigInteger = new BigInteger(result);
        return bigInteger;
    }
}
