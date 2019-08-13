package com.alg.simulation;

import java.util.LinkedHashMap;


public class LruSimulation {
    public static void main(String[] args) {
        LRUCache<String, String> lru = new LRUCache<>(5);
        lru.get("4");
        lru.get("7");
        lru.get("0");
        lru.get("7");
        lru.get("1");
        lru.get("0");
        lru.get("1");
        lru.get("2");
        lru.get("1");
        lru.get("2");
        lru.get("6");
        lru.get("7");
        lru.get("10");
    }
}

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int initialCapacity;

    public LRUCache(int initialCapacity) {
        super(initialCapacity);
        this.initialCapacity = initialCapacity;
    }

    public V get(Object k) {
        if (super.get(k) != null) {
            V value = super.get(k);
            this.remove(k);
            this.put((K) k, value);
            System.out.println("读缓存\t" + k);
        } else {
            if (this.size() == initialCapacity) {
                K removeK = this.entrySet().iterator().next().getKey();
                this.remove(removeK);
                this.put((K) k, (V) new Object());
                System.out.println("替换\t\t" + removeK);
            } else {
                this.put((K) k, (V) new Object());
                System.out.println("直接写入\t" + k);
            }
        }
        return null;
    }
}