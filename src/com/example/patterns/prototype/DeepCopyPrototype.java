package com.example.patterns.prototype;

class Engine {
    String type;
    int horsepower;

    public Engine(final String pType, final int pHorsepower) {
        this.type = pType;
        this.horsepower = pHorsepower;
    }

    // Copy constructor to do deep copy
    public Engine(final Engine pOther) {
        this(pOther.type, pOther.horsepower);
    }

    @Override
    public String toString() {
        return "Type " + type + " with " + horsepower + " hp.";
    }
}

class Car {
    String name;
    Engine engine;

    public Car(final String pName, final Engine pEngine) {
        this.name = pName;
        this.engine = pEngine;
    }

    public Car(final Car pOther) {

        this(pOther.name, new Engine(pOther.engine));
    }

    @Override
    public String toString() {
        return name + " with engine: " + engine;
    }
}

public class DeepCopyPrototype {

    public static void main(String[] args) {

        Car posche = new Car(
                "Porche",
                new Engine("V6", 250)
        );
        Car tesla = new Car(posche);
        tesla.name = "Tesla";
        tesla.engine.type = "Electric";

        System.out.println(posche);
        System.out.println(tesla);
    }
}
