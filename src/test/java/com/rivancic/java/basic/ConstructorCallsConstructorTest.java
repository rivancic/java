package com.rivancic.java.basic;

import org.junit.Test;

public class ConstructorCallsConstructorTest {

  class Point {
    private int x;
    private int y;

    Point(){

      // This line is not invoking another constructor for this instance. It invokes another constructor and creates anoter instance of this class which is then not being used anywhere
      // Proper way of invoking a constructor is through this keyword passing appropriate parameters that will invoke required constructor.
      // Point(10, 20);
    }

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "Point{" + x + ", " + y + "}";
    }
  }

  @Test
    public void main() {
      Point p = new Point();
      System.out.println(p);
    }

}
