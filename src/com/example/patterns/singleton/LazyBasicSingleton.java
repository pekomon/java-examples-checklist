package com.example.patterns.singleton;

import java.util.UUID;

class LazyCreationSingleton {
    private static LazyCreationSingleton instance = null;
    private String uuid;

    private static Object LOCK = new Object();

    private LazyCreationSingleton() {
        uuid = UUID.randomUUID().toString();
    }

    public static LazyCreationSingleton getInstance() {
        // Use double check to not lock every time but still keep construction thread safe
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = new LazyCreationSingleton();
                    System.out.println("Created new instance");
                }
            }
        }
        return instance;
    }

    public String getUuid() {
        return uuid;
    }
}

public class LazyBasicSingleton {
    public static void main(String[] args) {
        LazyCreationSingleton lazy1 = LazyCreationSingleton.getInstance();
        LazyCreationSingleton lazy2 = LazyCreationSingleton.getInstance();
        System.out.println(lazy1.getUuid());
        System.out.println(lazy2.getUuid());
    }
}
