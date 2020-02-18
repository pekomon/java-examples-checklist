package com.example.patterns.prototype;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DeepCopyPrototypeTest {

    @Test
    public void TestDeepCopy() {

        final String origName = "Skoda";
        final String origType = "Diesel";
        final int origHp = 140;
        Car original = new Car(origName,
                new Engine(origType, origHp));
        Car other = new Car(original);

        assertEquals(origName, original.name);
        assertEquals(origType, original.engine.type);
        assertEquals(origHp, original.engine.horsepower);

        assertEquals(original.name, other.name);
        assertEquals(original.engine.type, other.engine.type);
        assertEquals(original.engine.horsepower, other.engine.horsepower);

        final String newName = "Volkswagen";
        final int newHp = 150;

        other.name = newName;
        other.engine.horsepower = newHp;

        assertEquals(origName, original.name);
        assertEquals(origType, original.engine.type);
        assertEquals(origHp, original.engine.horsepower);

        assertEquals(newName, other.name);
        assertEquals(origType, other.engine.type);
        assertEquals(newHp, other.engine.horsepower);
    }
}