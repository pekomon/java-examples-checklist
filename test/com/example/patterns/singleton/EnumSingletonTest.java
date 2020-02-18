package com.example.patterns.singleton;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class EnumSingletonTest {

    @Test
    public void testCreation() {
        EnumSingleton enumSingleton1 = EnumSingleton.instance;
        EnumSingleton enumSingleton2 = EnumSingleton.instance;

        assertEquals(enumSingleton1, enumSingleton2);
    }
}