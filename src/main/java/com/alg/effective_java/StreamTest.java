package com.alg.effective_java;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        ColoredInteger ci1 = new ColoredInteger(15, COLOR.RED);
        ColoredInteger ci2 = new ColoredInteger(16, COLOR.RED);
        ColoredInteger ci3 = new ColoredInteger(17, COLOR.GREEN);
        ColoredInteger ci4 = new ColoredInteger(18, COLOR.GREEN);
        ColoredInteger ci5 = new ColoredInteger(19, COLOR.BLUE);
        ColoredInteger ci6 = new ColoredInteger(20, COLOR.BLUE);

        int num = Stream.of(ci1, ci2, ci3, ci4, ci5, ci6)
                .filter(w -> w.getColor() == COLOR.RED)
                .mapToInt(w -> w.getNum())
                .sum();
        System.out.println(num);
    }

}

class ColoredInteger {
    private int num;
    private COLOR color;

    public ColoredInteger(int num, COLOR color) {
        this.num = num;
        this.color = color;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public COLOR getColor() {
        return color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }
}

enum COLOR {
    RED, GREEN, BLUE
}
