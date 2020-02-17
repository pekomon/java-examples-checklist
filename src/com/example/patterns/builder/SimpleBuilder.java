package com.example.patterns.builder;

import java.util.ArrayList;
import java.util.List;

class JavaElement {

    public String type, name;

    JavaElement() {
    }

    JavaElement(final String pType, final String pName) {
        this.type = pType;
        this.name = pName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("    ")
                .append("public")
                .append(" ")
                .append(type)
                .append(" ")
                .append(name)
                .append(";")
                .append(System.lineSeparator());

        return sb.toString();
    }
}

class JavaClassBuilder {

    private String name;
    private List<JavaElement> elements = new ArrayList<>();

    public JavaClassBuilder(final String pName) {
        this.name = pName;
    }

    public void addElement(final String pType, final String pName) {
        elements.add(new JavaElement(pType, pName));
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder();
        sb.append("public class ")
                .append(name)
                .append(" {")
                .append(System.lineSeparator());

        for (JavaElement element : elements) {
            sb.append(element);
        }

        sb.append("}");
        return sb.toString();
    }
}

public class SimpleBuilder {

    public static void main(String[] args) {

        JavaClassBuilder builder = new JavaClassBuilder("Person");
        builder.addElement("String", "name");
        builder.addElement("int", "age");

        System.out.println(builder);
    }
}
