package com.alg.effective_java;

public class Singleton {
    private static volatile Singleton singleton = null;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}


//public class Singleton {
//    private static class Holder {
//        private static Singleton singleton = new Singleton();
//    }
//    private Singleton(){}
//    public static Singleton getSingleton(){
//        return Holder.singleton;
//    }
//}

//public enum Singleton {
//    INSTANCE;
//    private String name;
//    public String getName(){
//        return name;
//    }
//    public void setName(String name){
//        this.name = name;
//    }
//}