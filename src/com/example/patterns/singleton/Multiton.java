package com.example.patterns.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Basically just a list of different types of instances.
 * Instead of Enum it could be Strings, ints...
 * For example Nuclear plants by their names (Loviisa, Olkiluoto... and so on)
 */

enum Source {
    SUN,
    WIND,
    NUCLEAR,
}

class PowerSource {

    private static final AtomicInteger instanceCount = new AtomicInteger(0);

    private PowerSource() {
        System.out.println("Created instance number: " + instanceCount.incrementAndGet());
    }

    private static Map<Source, PowerSource> instances = new HashMap<>();

    public static PowerSource getInstance(Source pSource) {
        if (!instances.containsKey(pSource)) {
            instances.put(pSource, new PowerSource());
        }
        return instances.get(pSource);
    }
}

public class Multiton {

    public static void main(String[] args) {

        PowerSource power1 = PowerSource.getInstance(Source.NUCLEAR);
        PowerSource power2 = PowerSource.getInstance(Source.NUCLEAR);
        PowerSource power3 = PowerSource.getInstance(Source.SUN);
    }
}
