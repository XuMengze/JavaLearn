package com.alg.effective_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EqualsMethod {
    public static void main(String[] args) {
        List<CaseInsensitiveString> list = new ArrayList<>();
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println(cis.equals(s));
        list.add(cis);
        System.out.println(list.contains(s));
    }
}

class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
        }
        if (obj instanceof String) {
            return s.equalsIgnoreCase((String) obj);
        }
        return false;
    }
}