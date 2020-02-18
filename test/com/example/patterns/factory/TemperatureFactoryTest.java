package com.example.patterns.factory;

import org.junit.Test;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

public class TemperatureFactoryTest {

    private final static int TEST_ROUNDS = 10;

    @Test
    public void TestCelsius() {
        for (int i = 0; i < TEST_ROUNDS; i++) {
            final double original = getNumber();
            assertEquals("It is " + original + " Celsius degrees",
                    Temperature.Factory.getTemperatureFromCelsius(original).toString());
        }
    }

    @Test
    public void TestFahrenheit() {
        for (int i = 0; i < TEST_ROUNDS; i++) {
            final double original = getNumber();
            final double expected = (original - 32d) / 1.8;
            assertEquals("It is " + expected + " Celsius degrees",
                    Temperature.Factory.getTemperatureFromFahrenheit(original).toString());
        }
    }

    @Test
    public void TestKelvin() {
        for (int i = 0; i < TEST_ROUNDS; i++) {
            final double original = getNumber();
            final double expected = original - 273.15;
            assertEquals("It is " + expected + " Celsius degrees",
                    Temperature.Factory.getTemperatureFromKelvin(original).toString());
        }
    }

    private double getNumber() {
        return ThreadLocalRandom.current().nextDouble(-100, 100);
    }
}