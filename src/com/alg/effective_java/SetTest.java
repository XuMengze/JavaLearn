package com.alg.effective_java;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class SetTest {
    public static void main(String[] args) {
        InstrumentalHashSet<String> set = new InstrumentalHashSet<>();
        set.addAll(Arrays.asList("Snap", "Cracker", "Pop"));
        System.out.println(set.getAddCount());
    }


}

class InstrumentalHashSet<E> extends HashSet<E> {
    private int addCount = 0;

    InstrumentalHashSet() {
        super();
    }

    public InstrumentalHashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {

        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}