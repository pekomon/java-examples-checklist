package com.example.patterns.singleton;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;

public class MultitonTest {

    @Test
    public void testCreation() {
        PowerSource nuclear1 = PowerSource.getInstance(Source.NUCLEAR);
        PowerSource nuclear2 = PowerSource.getInstance(Source.NUCLEAR);
        assertEquals(nuclear1, nuclear2);

        PowerSource wind1 = PowerSource.getInstance(Source.WIND);
        PowerSource wind2 = PowerSource.getInstance(Source.WIND);
        assertEquals(wind1, wind2);

        PowerSource sun1 = PowerSource.getInstance(Source.SUN);
        PowerSource sun2 = PowerSource.getInstance(Source.SUN);
        assertEquals(nuclear1, nuclear2);

        assertNotSame(nuclear1, wind1);
        assertNotSame(nuclear1, sun1);
        assertNotSame(sun1, wind1);
    }
}