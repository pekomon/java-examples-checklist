package com.example.patterns.prototype;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

/**
 * Pretty much simpler way when compared to DeepCopyPrototype
 */
class SerializableEngine implements Serializable {
    String type;
    int horsepower;

    public SerializableEngine(final String pType, final int pHorsepower) {
        this.type = pType;
        this.horsepower = pHorsepower;
    }

    @Override
    public String toString() {
        return "Type " + type + " with " + horsepower + " hp.";
    }
}

class SerializableCar implements Serializable {
    String name;
    SerializableEngine engine;

    public SerializableCar(final String pName, final SerializableEngine pEngine) {
        this.name = pName;
        this.engine = pEngine;
    }

    @Override
    public String toString() {
        return name + " with engine: " + engine;
    }
}

public class SerializableCopyPrototype {

    public static void main(String[] args) {

        SerializableCar toyota = new SerializableCar("Corolla",
                new SerializableEngine("Petrol R4", 115));

        SerializableCar lexus = SerializationUtils.roundtrip(toyota);
        lexus.engine.type = "Hybrid";
        lexus.name = "Lexus";

        System.out.println(toyota);
        System.out.println(lexus);
    }
}
