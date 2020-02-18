package com.example.patterns.singleton;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LazyCreationSingletonTest {

    @Test
    public void testCreation() {
        LazyCreationSingleton lazy1 = LazyCreationSingleton.getInstance();
        LazyCreationSingleton lazy2 = LazyCreationSingleton.getInstance();
        assertEquals(lazy1, lazy2);
    }
}