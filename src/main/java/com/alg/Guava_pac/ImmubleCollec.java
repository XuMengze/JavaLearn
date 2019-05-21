package com.alg.Guava_pac;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.*;

public class ImmubleCollec {
    public static void main(String[] args) {
        ImmutableMap<String, Integer> imap = ImmutableMap.of("key1", 10, "key2", 20);
        System.out.println(Strings.commonPrefix("com.coco.com", "com.bibi.com"));
        System.out.println(Strings.padStart("123", 4, '0'));
        System.out.println(Joiner.on(',').join(ImmutableList.of("1", "2", "3", "4", "5")));
        System.out.println(Lists.cartesianProduct(ImmutableList.of("1", "2"), ImmutableList.of("3", "4")));
        Multimap<String, String> mmap = HashMultimap.create();
        mmap.put("1", "hello");
        mmap.put("1", "world");
        mmap.put("2", "hello");
        System.out.println(mmap.get("1"));
    }
}
