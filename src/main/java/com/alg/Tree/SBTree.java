package com.alg.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class SBTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        boolean trueFraction = true;
        if (p == q) {
            System.out.println(1 + " " + 1);
            return;
        }

        if (p > q) {
            trueFraction = false;
            p = p ^ q;
            q = p ^ q;
            p = p ^ q;
        }

        Fraction target = new Fraction(p, q);
        List<Fraction> rows = new ArrayList<>() {{
            add(new Fraction(0, 1));
            add(new Fraction(1, 1));
        }};
        int index = 1;
        while (true) {
            index++;
            List<Fraction> rows2 = new ArrayList<>();
            for (Fraction f : rows
            ) {
                rows2.add(f);
            }
            for (int i = 1, j = 0; i < rows.size() * 2 - 1; i += 2, j++) {
                rows2.add(i, fractionAdd2(rows.get(j), rows.get(j + 1)));
            }
            if (rows2.contains(target)) {
                rows2.removeAll(rows);
                if (trueFraction == true) {
                    System.out.println(index + " " + (rows2.indexOf(target) + 1));
                } else {
                    System.out.println(index + " " + Math.round(Math.pow(2, index - 1) - rows2.indexOf(target)));
                }
                break;
            } else {
                rows = rows2;
            }
        }
    }

    static Fraction fractionAdd2(Fraction ff1, Fraction ff2) {
        return getDivideCommon(new Fraction(ff1.numerator + ff2.numerator, ff1.denominator + ff2.denominator));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator &&
                denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
