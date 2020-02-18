package com.example.patterns.singleton;

import java.io.*;
import java.util.UUID;

/**
 * In case there's a need for serialization, use trick in readResolve() to make sure
 * singleton is singleton even after serialization
 */
public class SerializableSingleton implements Serializable{

    private static final SerializableSingleton instance = new SerializableSingleton();
    private final String uuid;
    private int value;

    private SerializableSingleton() {
        uuid = UUID.randomUUID().toString();
    }

    public String getUuid() {
        return uuid;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static SerializableSingleton getInstance() {
        return instance;
    }

    // This is needed to prevent new instance creation when deserialized
    protected Object readResolve() {
        return instance;
    }
}

class SerializationSingletonDemo {

    public static void main(String[] args) {

        SerializableSingleton singleton1 = SerializableSingleton.getInstance();
        singleton1.setValue(11);
        SerializableSingleton singleton2 = SerializableSingleton.getInstance();

        writeToFile(singleton1);
        singleton2.setValue(7);
        SerializableSingleton singleton3 = readFromFile();

        System.out.println(singleton1.getUuid() + " : " + singleton1.getValue());
        System.out.println(singleton2.getUuid() + " : " + singleton2.getValue());
        System.out.println(singleton3.getUuid() + " : " + singleton3.getValue());

    }

    static void writeToFile(SerializableSingleton singleton) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(singleton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static SerializableSingleton readFromFile() {
        try (FileInputStream fileInputStream = new FileInputStream("file.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            return (SerializableSingleton) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}