package com.example.patterns.factory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class AnimalFactoryTest {

    // For testing System.out
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpSystemOut() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreSystemOut() {
        System.setOut(originalOut);
    }

    @Test
    public void testCat() {
        for (int i = 0; i < 5; i++) {
            AnimalFactory.getAnimal(i).saySomething();
            assertEquals("Meow\n", outContent.toString());
            outContent.reset();
        }
    }

    @Test
    public void testDog() {

        for (int i = 5; i < 30; i++) {
            AnimalFactory.getAnimal(i).saySomething();
            assertEquals("Woof woof\n", outContent.toString());
            outContent.reset();
        }
    }

    @Test
    public void testCow() {
        for (int i = 30; i < 150; i++) {
            AnimalFactory.getAnimal(i).saySomething();
            assertEquals("Moooooo\n", outContent.toString());
            outContent.reset();
        }
    }

    @Test
    public void testnegatives() {
        for (int i = 0; i < 10; i++) {
            final int weight = i * (-8);
            AnimalFactory.getAnimal(weight).saySomething();
            assertEquals("Meow\n", outContent.toString());
            outContent.reset();
        }
    }

}