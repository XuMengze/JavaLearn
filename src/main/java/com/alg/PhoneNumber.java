package com.alg;

import java.util.*;

public class PhoneNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        long[] phoneNumber = new long[count];

        for (int i = 0; i < count; i++) {
            phoneNumber[i] = sc.nextLong();
        }

        Map<Long, Integer> map = new HashMap<>();
        List<Long> res = new ArrayList<>();
        for (Long i : phoneNumber
        ) {
            long last = Integer.parseInt("6" + i % 100000);
            if (map.get(last) == null) {
                map.put(last, 0);
                res.add(last);
            }
        }
        for (Long i : res
        ) {
            System.out.println(i);
        }
    }

}
