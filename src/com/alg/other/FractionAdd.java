package com.alg.other;

public class FractionAdd {

    public static void main(String[] args) {
        Fraction res = fractionAdd(new Fraction(1, 3), new Fraction(1, 2));

        System.out.println(res.numerator);
        System.out.println(res.denominator);
    }

    static Fraction fractionAdd(Fraction ff1, Fraction ff2) {
        return getDivideCommon(new Fraction(ff1.numerator * ff2.denominator + ff2.numerator * ff1.denominator, ff1.denominator * ff2.denominator));
    }

    static Fraction getDivideCommon(Fraction ff) {
        while (true) {
            int index = gcd(ff.numerator, ff.denominator);
            if (index == 1)
                break;
            ff.numerator /= index;
            ff.denominator /= index;
        }
        return new Fraction(ff.numerator, ff.denominator);
    }


    static int gcd(int x, int y) {
        int z = y;
        while (x % y != 0) {
            z = x % y;
            x = y;
            y = z;
        }
        return z;
    }

}

class Fraction {
    int numerator;
    int denominator;

    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
}

