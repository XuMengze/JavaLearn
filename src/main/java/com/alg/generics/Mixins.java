package com.alg.generics;

import java.util.Date;

public class Mixins {
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered {
    private final TimeStampedImp tImp = new TimeStampedImp();
    private final SerialNumbered sImp = new SerialNumberedImp();

    @Override
    public long getTimeStamp() {
        return tImp.getTimeStamp();
    }


    @Override
    public long getSerialNumber() {
        return sImp.getSerialNumber();
    }
}

interface TimeStamped {
    long getTimeStamp();
}

interface SerialNumbered {
    long getSerialNumber();
}

class TimeStampedImp implements TimeStamped {
    private final long timestamp;

    public TimeStampedImp() {
        timestamp = new Date().getTime();
    }

    @Override
    public long getTimeStamp() {
        return timestamp;
    }
}

class SerialNumberedImp implements SerialNumbered {
    private static long count = 0;
    private long serialNumber = ++count;

    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}

interface Basic {
    void set(String val);

    String get();
}

class BasicImp implements Basic {
    private String val;

    @Override
    public void set(String val) {
        this.val = val;
    }

    @Override
    public String get() {
        return val;
    }
}
