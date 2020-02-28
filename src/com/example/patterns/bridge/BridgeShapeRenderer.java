package com.example.patterns.bridge;


import org.w3c.dom.UserDataHandler;

interface Renderer {
    public String render();
}

class VectorRenderer implements Renderer {
    public String render() {
        return "VectorRenderer very smoothly";
    }
}

class RasterRenderer implements Renderer {
    public String render() {
        return "pixels via RasterRenderer";
    }

}


abstract class Shape {
    protected Renderer renderer;

    public abstract String Draw();
}

class Triangle extends Shape {

    public Triangle(Renderer pRenderer) {
        this.renderer = pRenderer;
    }

    @Override
    public String Draw() {
        return "Drawing a triangle using " + renderer.render();
    }
}


public class BridgeShapeRenderer {

    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(new RasterRenderer());
        Triangle triangle2 = new Triangle(new VectorRenderer());

        System.out.println(triangle1.Draw());
        System.out.println(triangle2.Draw());
    }

}
