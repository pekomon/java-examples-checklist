package com.example.patterns.singleton;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SimpleSingletonTest {

    @Test
    public void testCreation() {
        SimpleSingleton singleton1 = SimpleSingleton.getInstance();
        SimpleSingleton singleton2 = SimpleSingleton.getInstance();

        assertEquals(singleton1, singleton2);
    }

}