package com.example.patterns.singleton;

/**
 * Simple approach. When serializing, only the name of enum is serialized, not values.
 */
enum EnumSingleton {
    instance,;  // this is it

    private String text;
    private int number;

    private EnumSingleton() {
        text = "Hello Enum!";
        number = -5;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return text + " & " + number;
    }
}

class Demo {

    public static void main(String[] args) {
        EnumSingleton singleton1 = EnumSingleton.instance;
        EnumSingleton singleton2 = EnumSingleton.instance;
        System.out.println(singleton1);
        System.out.println(singleton2);

        singleton1.setNumber(333);
        System.out.println(singleton1);
        System.out.println(singleton2);

    }

}