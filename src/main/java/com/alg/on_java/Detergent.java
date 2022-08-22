package com.alg.on_java;
class Cleanser{
    private String s = "Cleanser";
    public void append(String s){this.s += s;}
    public void dilute(){append(" dilute()");}
    public void apply(){append(" apply()");}
    public void scrub(){append(" scrub()");}

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleanser s = new Cleanser();
        s.dilute();s.apply();s.scrub();
        System.out.println(s);
    }
}

public class Detergent extends Cleanser {
    @Override
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub();
    }
    public void foam(){
        append(" foam()");
    }

    public Detergent(String s) {
    }

    public static void main(String[] args) {
        Detergent x = new Detergent("");
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
    }
}

class SpaceShipControl{
    void up(int velocity){}
}

class DerivedSpaceShip extends SpaceShipControl{
    private String name;
    public DerivedSpaceShip(String name) {
        this.name = name;
    }
}

class SpaceShipDelegation{
    private String name;
    private SpaceShipControl control = new SpaceShipControl();

    public SpaceShipDelegation(String name) {
        this.name = name;
    }

    public void up(int velocity) {
        control.up(velocity);
    }
}
