package com.example.patterns.decorator;

interface Shape {
    public String info();
}

class Circle implements Shape {
    private int radius;

    public Circle() {
    }

    public Circle(final int pRadius) {
        radius = pRadius;
    }

    public String info() {
        return "Circle with radius: " + radius;
    }
}

class Square implements Shape {
    private int sideLength;

    public Square() {
    }

    public Square(final int pSideLength) {
        sideLength = pSideLength;
    }

    @Override
    public String info() {
        return "Square with side length of " + sideLength;
    }
}

class ColoredShape implements Shape {
    private Shape shape;
    private String color;

    public ColoredShape(final Shape pShape, final String pColor) {
        shape = pShape;
        color = pColor;
    }

    @Override
    public String info() {
        return shape.info() + " and color " + color;
    }
}


class TransparentShape implements Shape {
    private Shape shape;
    private int transparency;

    public TransparentShape(final Shape pShape, final int pTransparency) {
        shape = pShape;
        transparency = pTransparency;
    }

    @Override
    public String info() {
        return shape.info() + " using transparency value " + transparency;
    }
}

public class DynamicDecorator {

    public static void main(String[] args) {
        Square square = new Square(4);
        TransparentShape transparentCircle = new TransparentShape(
                new Circle(5),
                33
        );
        ColoredShape coloredShape = new ColoredShape(square, "Yellow");

        System.out.println(square.info());
        System.out.println(transparentCircle);
        System.out.println(coloredShape);

    }
}
