package com.alg.generics;

public class ErasedInterface {

}

interface Payable<T> {
    void f();
}

class Employee implements Payable<Employee> {
    @Override
    public void f() {

    }
}

class Hourly extends Employee implements Payable<Employee> {
    @Override
    public void f() {

    }
};