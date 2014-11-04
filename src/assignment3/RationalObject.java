package assignment3;

import java.math.BigInteger;

/**
* Created by THamilton on 6/15/2014.
*/
public class RationalObject {

    private BigInteger num;
    private BigInteger den;

    public RationalObject(BigInteger numerator, BigInteger denominator) {
        // BigInteger constructor takes a string, not an int
        num = new BigInteger(numerator + "");
        den = new BigInteger(denominator + "");
        BigInteger g = num.gcd(den);
        this.num = num.divide(g);
        this.den = den.divide(g);
    }

    // return a + b
    public RationalObject add(RationalObject b) {
        RationalObject a = this;
        BigInteger numerator    = a.num.multiply(b.den).add(a.den.multiply(b.num));
        BigInteger denominator = a.den.multiply(b.den);
        return new RationalObject(numerator, denominator);
    }

    public RationalObject subtract(RationalObject b) {
        RationalObject a = this;
        BigInteger numerator    = a.num.multiply(b.den).subtract(a.den.multiply(b.num));
        BigInteger denominator  = a.den.multiply(b.den);
        return new RationalObject(numerator, denominator);
    }

    public RationalObject multiply(RationalObject b){
        RationalObject a = this;
        BigInteger numerator    = a.num.multiply(b.num);
        BigInteger denominator  = a.den.multiply(b.den);
        return new RationalObject(numerator, denominator);
    }

    public RationalObject divide(RationalObject b){
        RationalObject a = this;
        return a.multiply(b.reciprocal());
    }
//    @Override // Override the equals method in the Object class
//    public boolean equals(Object other) {
//        if ((this.subtract((RationalObject)(other))).getNumerator() == 0)
//            return true;
//        else
//            return false;
//    }

    public RationalObject reciprocal(){ return new RationalObject(den, num); }

    @Override
    public String toString() {
            return num + "/" + den;
    }
}
