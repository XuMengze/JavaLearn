package com.alg.on_java;

enum Note {
    MIDDLE_C,
    C_SHARP,
    B_FLAT;
}

public class Music {
    static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Instrument[] e) {
        for (var i : e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        System.out.println(Note.valueOf("ff"));
        Instrument[] orchestra = {new Wind(), new Percussion(), new Stringed(), new Brass(), new WoodWind()};
        tuneAll(orchestra);
    }
}

class Instrument {
    void play(Note n) {
        System.out.println("Instrument.play()" + n);
    }

    String what() {
        return "Instrument";
    }

    void adjust() {
        System.out.println("Adjusting Instrument");
    }
}

class Wind extends Instrument {
    @Override
    void play(Note n) {
        System.out.println("Wind.play()" + n);
    }

    @Override
    String what() {
        return "Wind";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Wind");
    }
}

class Percussion extends Instrument {
    @Override
    void play(Note n) {
        System.out.println("Percussion.play()" + n);
    }

    @Override
    String what() {
        return "Percussion";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Percussion");
    }
}

class Stringed extends Instrument {
    @Override
    void play(Note n) {
        System.out.println("Stringed.play()" + n);
    }

    @Override
    String what() {
        return "Stringed";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Stringed");
    }
}

class Brass extends Wind {
    @Override
    void play(Note n) {
        System.out.println("Brass.play()" + n);
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Brass");
    }
}

class WoodWind extends Wind {
    @Override
    void play(Note n) {
        System.out.println("WoodWind.play()" + n);
    }

    @Override
    String what() {
        return "WoodWind";
    }
}
