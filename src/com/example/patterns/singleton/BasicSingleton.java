package com.example.patterns.singleton;

import java.util.UUID;

class SimpleSingleton {

    private static final SimpleSingleton instance = new SimpleSingleton();
    private String uuid;

    private SimpleSingleton() {
        uuid = UUID.randomUUID().toString();
    }

    public String getUuid() {
        return uuid;
    }

    public static SimpleSingleton getInstance() {
        return instance;
    }
}

public class BasicSingleton {

    public static void main(String[] args) {
        SimpleSingleton singleton = SimpleSingleton.getInstance();
        SimpleSingleton singleton2 = SimpleSingleton.getInstance();

        System.out.println(singleton.getUuid());
        System.out.println(singleton2.getUuid());

    }
}