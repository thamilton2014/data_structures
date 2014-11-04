package assignment3;

import java.math.BigInteger;

public class Rational extends Number implements Comparable<Rational> {

    private BigInteger num;
    private BigInteger den;

    public Rational(BigInteger numerator, BigInteger denominator){
        // Big Integer constructor takes a string, not an int
        num = new BigInteger(numerator + "");
        den = new BigInteger(denominator + "");
        BigInteger g = num.gcd(den);
        this.num = num.divide(g);
        this.den = den.divide(g);
    }

    /** Return numerator */
    public BigInteger getNumerator() {
        return num;
    }

    /** Return denominator */
    public BigInteger getDenominator() {
        return den;
    }

    public Rational add(Rational b){
        Rational a = this;
        BigInteger numerator = a.num.multiply(b.den).add(a.den.multiply(b.num));
        BigInteger denominator = a.den.multiply(b.den);
        return new Rational(numerator, denominator);
    }

    public Rational subtract(Rational b){
        Rational a = this;
        BigInteger numerator = a.num.multiply(b.den).subtract(a.den.multiply(b.num));
        BigInteger denominator = a.den.multiply(b.den);
        return new Rational(numerator, denominator);
    }

    public Rational multiply(Rational b){
        Rational a = this;
        BigInteger numerator = a.num.multiply(b.num);
        BigInteger denominator = a.den.multiply(b.den);
        return new Rational(numerator, denominator);
    }

    public Rational reciprocal() { return new Rational(den, num); }

    public Rational divide(Rational b){
        Rational a = this;
        return a.multiply(b.reciprocal());
    }

    public String toString() {
            return num + "/" + den;
    }

    public boolean equals(Rational b) {
        Rational a = this;
        if (a.num.multiply(b.den).subtract(a.den.multiply(b.num)).intValue() == 0)
            return true;
        else
            return false;
    }

    public int intValue() {
        return (int)doubleValue();
    }

    public float floatValue() {
        return (float)doubleValue();
    }

    public double doubleValue() {
        Rational a = this;
        Rational b = this;
        double a1 = a.doubleValue();
        double b1 = b.doubleValue();
        return a1 / b1;
    }

    public long longValue() {
        return (long)doubleValue();
    }

    public int compareTo(Rational b) {
        Rational a = this;
        if (a.num.multiply(b.den).subtract(a.den.multiply(b.num)).intValue() == 0)
            return 1;
        else if (a.den.multiply(b.den).intValue() < 1)
            return -1;
        else
            return 0;
    }
}