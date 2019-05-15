package com.alg.effective_java;

import java.time.Instant;

public class ExtendsTest {
    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.over();
    }
}

class Super {
    Super() {
        over();
    }

    public void over() {
        System.out.println("super");
    }
}

class Sub extends Super {
    private final Instant instant;

    Sub() {
        instant = Instant.now();
    }

    @Override
    public void over() {
        System.out.println("sub" + instant);
    }
}