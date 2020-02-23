package com.example.patterns.composite;

import java.util.ArrayList;
import java.util.List;


/**
 * Handling single object and group of objects happens similarly.
 *
 */


class CompositeDrawableObject {

    protected String name = "Drawable group";
    public String color;
    public List<CompositeDrawableObject> children = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        printWithIndents(sb, 0);
        return sb.toString();
    }

    private void printWithIndents(final StringBuilder sb ,final int pIndent) {
        for (int i = 0; i < pIndent; i++) {
            sb.append("-");
        }
        sb.append(color == null ? "" : color + " ")
                .append(getName())
                .append(System.lineSeparator());

        final int newIndent = pIndent + 1;
        for (CompositeDrawableObject child : children) {
            child.printWithIndents(sb, newIndent);
        }
    }
}

class Line extends CompositeDrawableObject {
    public Line(final String pColor) {
        color = pColor;
        name = "Line";
    }
}

class Rectangle extends CompositeDrawableObject {
    public Rectangle(final String pColor) {
        color = pColor;
        name = "Rectangle";
    }
}

class DrawableDemo {
    public static void main(String[] args) {
        CompositeDrawableObject drawable = new CompositeDrawableObject();
        drawable.setName("My own drawable");
        drawable.children.add(new Line("Black"));
        drawable.children.add(new Line("Blue"));

        CompositeDrawableObject subDrawable = new CompositeDrawableObject();
        subDrawable.setName("Cubic Drawables Group");
        subDrawable.children.add(new Rectangle("Red"));
        subDrawable.children.add(new Rectangle("Yellow"));
        subDrawable.children.add(new Line("Pink"));

        drawable.children.add(subDrawable);

        System.out.println(drawable.toString());
    }
}
