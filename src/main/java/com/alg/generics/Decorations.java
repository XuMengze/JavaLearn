package com.alg.generics;

import java.util.Date;

public class Decorations {
    public static void main(String[] args) {
        TimeStamp t = new TimeStamp(new Basic1());
        t.getTimeStamp();
        TimeStamp t2 = new TimeStamp(new SerialNumber(new Basic1()));
        t2.getTimeStamp();
    }
}

class Basic1 {
    private String val;

    public String get() {
        return val;
    }

    public void set(String val) {
        this.val = val;
    }
}

class Decorator extends Basic1 {
    protected Basic1 basic;

    public Decorator(Basic1 basic) {
        this.basic = basic;
    }

    @Override
    public String get() {
        return basic.get();
    }

    @Override
    public void set(String val) {
        basic.set(val);
    }
}

class TimeStamp extends Decorator {
    private final long timeStamp;

    public TimeStamp(Basic1 basic) {
        super(basic);
        timeStamp = new Date().getTime();
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}

class SerialNumber extends Decorator {
    private static long count = 0;
    private long serialNumber = ++count;

    public SerialNumber(Basic1 basic) {
        super(basic);
    }

    public long getSerialNumber() {
        return serialNumber;
    }
}