package com.rivancic.java.inheritance;

enum ShapeType {
  CIRCLE, SQUARE, RECTANGLE;
}

abstract class Shape {

  private ShapeType type = ShapeType.SQUARE; //default ShapeType

 /* Shape(){};

  Shape(ShapeType type) {
    this.type = type;
  }*/

  public ShapeType getType() {
    return type;
  }

  abstract void draw();
}

public class AbstractConstructorTest {

  public static void main(String[] args) {
    Shape shape = new Shape() {
      @Override
      void draw() {
        System.out.println("Drawing a " + getType());
      }
    };
    shape.draw();
  }
}


