package com.alg.effective_java;


import java.util.HashMap;
import java.util.Map;

public class TypeTokenTest {
    public static void main(String[] args) {
        Favorites ff = new Favorites();

        ff.putFavorite(Integer.class, Integer.valueOf("20"));
        ff.putFavorite(String.class, "LOL");

        System.out.println(ff.getFavorite(String.class));
    }
}

class Favorites {
    public Map<Class<?>, Object> favorites = new HashMap<>();

    <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(type, instance);
    }

    <T> T getFavorite(Class<T> type) {
        return (T) favorites.get(type);
    }
}