package com.alg.generics;

import com.alg.model.Tuple;

import javax.swing.*;
import java.util.stream.Stream;

public class GenericGolder<T> {
    private T a;
    public GenericGolder(){}
    public void set(T a){
        this.a = a;
    }
    public T get(){
        return a;
    }

    public static void main(String[] args) {
        GenericGolder<Integer> holeder = new GenericGolder<>();
        holeder.set(1);
    }

}
