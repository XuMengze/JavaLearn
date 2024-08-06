package com.alg.generics;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Wildcards {
    static void rawArgs(@NotNull Holder holder, Object arg) {
        holder.setItem(arg);
        Object o = holder.getItem();
    }

    static void unboundedArg(Holder<?> holder, Object arg) {
//        holder.setItem(arg);
        Object o = holder.getItem();
    }

    static <T> T exact1(Holder<T> holder) {
        return holder.getItem();
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.setItem(arg);
        return holder.getItem();
    }

    static <T> T wildSubType(Holder<? extends T> holder, T arg) {
//        holder.setItem(arg);
        return holder.getItem();
    }

    static <T> void wildSuperType(Holder<? super T> holder, T arg) {
        holder.setItem(arg);
//        T t = holder.getItem();
        Object o = holder.getItem();
    }

    public static void main(String[] args) {

        Long lng = 1L;

        Holder raw = new Holder<>();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<>();
        Holder<? extends Long> bounded = new Holder<>();

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);

        Object r1 = exact1(raw);
        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded);
        Long r4 = exact1(bounded);

        Long r5 = exact2(raw, lng);
        Long r6 = exact2(qualified, lng);
//        Object r7 = exact2(unbounded, lng);
//        Object r8 = exact2(bounded, lng);

        Long r9 = wildSubType(raw, lng);
        Long r10 = wildSubType(qualified, lng);
        Object r11 = wildSubType(unbounded, lng);
        Long r12 = wildSubType(bounded, lng);

        wildSuperType(raw, lng);
        wildSuperType(qualified, lng);
//        wildSuperType(unbounded, lng);
//        wildSuperType(bounded, lng);
    }
}

class Holder<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Holder() {
    }

    public Holder(T item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Holder && Objects.equals(item, (Holder) ((Holder<?>) obj).item);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(item);
    }
}

class Solution {
    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new ArrayList<>());
                index.get(c).add(-1);
            }
            index.get(c).add(i);
        }
        int res = 0;
        for (Map.Entry<Character, List<Integer>> entry : index.entrySet()) {
            List<Integer> arr = entry.getValue();
            arr.add(s.length());
            for (int i = 1; i < arr.size() - 1; i++) {
                res += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i));
            }
        }
        return res;
    }
}