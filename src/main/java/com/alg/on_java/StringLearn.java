package com.alg.on_java;

import com.alg.java_core.Immutable;

import java.util.Formatter;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringLearn {
    public static void main(String[] args) {

    }
}

class ReceiptBuilder {
    public static void main(String[] args) {
        ReceiptBuilder rp = new ReceiptBuilder();
        rp.add("Jack's Magic Beans", 4, 4.25);
        rp.add("Princess Peas", 3, 5.1);
        rp.add("Three Bear Porridge", 1, 14.29);
        String receipt = rp.endReceipt();
        System.out.println(receipt);
    }

    private double total = 0;
    private Formatter f = new Formatter();

    public ReceiptBuilder() {
        f.format("%15s %5s %10s%n", "Item", "Qty", "Price");
        f.format("%15s %5s %10s%n", "----", "---", "-----");
    }

    public void add(String name, int qty, double price) {
        this.f.format("%15.15s %5d %10.2f%n", name, qty, price);
        this.total += qty * price;
    }

    public String endReceipt() {
        this.f.format("%15s %5s %10.2f%n", "Tax", "", this.total * 0.06);
        this.f.format("%15s %5s %10s%n", "", "", "-----");
        this.f.format("%15s %5s %10.2f%n", "Total", "", this.total * 1.06);
        return this.f.toString();
    }
}