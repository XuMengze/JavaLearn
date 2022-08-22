package com.alg.on_java;

class Plate{
    Plate(int i){
        System.out.println("Plate constructor");
    }
}

class DinnerPlate extends Plate{
    public DinnerPlate(int i) {
        super(i);
        System.out.println("DinnerPlate constructor");
    }
}

class Utensil{
    public Utensil() {
        System.out.println("Utensil constructor");
    }
}

class Spoon extends Utensil{
    public Spoon() {
        System.out.println("Spoon constructor");
    }
}

class Knife extends Utensil{
    public Knife() {
        super();
        System.out.println("Knife constructor");
    }
}

class Fork extends Utensil{
    public Fork() {
        super();
        System.out.println("Fork constructor");
    }
}

class Customer {
    public Customer(int i) {
        System.out.println("Customer constructor");
    }
}
public class PlaceSetting extends Customer{
    private Spoon sp;
    private Fork frk;
    private Knife kn;
    private DinnerPlate dp;

    public PlaceSetting(int i) {
        super(i);
        sp = new Spoon();
        frk = new Fork();
        kn = new Knife();
        dp = new DinnerPlate(i);
        System.out.println("PlaceSetting constructor");
    }

    public static void main(String[] args) {
        PlaceSetting x = new PlaceSetting(1);
    }
}
