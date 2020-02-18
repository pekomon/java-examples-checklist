package com.example.patterns.factory;

interface Animal {
    public void saySomething();
}

class Cat implements Animal {
    @Override
    public void saySomething() {
        System.out.println("Meow");
    }
}

class Dog implements Animal {
    @Override
    public void saySomething() {
        System.out.println("Woof woof");
    }
}

class Cow implements Animal {
    @Override
    public void saySomething() {
        System.out.println("Moooooo");
    }
}


class AnimalFactory {
    public static Animal getAnimal(final int weight) {
        if (weight < 5) {
            return new Cat();
        } else if (weight < 30) {
            return new Dog();
        } else {
            return new Cow();
        }
    }
}

public class Factory {

    public static void main(String[] args) {

        Animal animal1 = AnimalFactory.getAnimal(4);
        Animal animal2 = AnimalFactory.getAnimal(18);
        Animal animal3 = AnimalFactory.getAnimal(220);

        animal1.saySomething();
        animal2.saySomething();
        animal3.saySomething();
    }
}
