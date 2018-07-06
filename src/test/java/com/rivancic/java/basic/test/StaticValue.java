package com.rivancic.java.basic.test;

import static org.junit.Assert.assertEquals;

public class StaticValue {

  /**
   * Because x variable in Point class is static it will be always overriden wen it will be assigned
   * for all of the instances.
   * 
   * @throws Exception
   */
  @org.junit.Test
  public void staticVariable() throws Exception {
    Point p1 = new Point();
    Point p2 = new Point();
    p1.x = 17;
    p1.y = 35;
    p2.x = 19;
    p2.y = 40;

    System.out.println(p1.x + ":" + p1.y + ":" + p2.x + ":" + p2.y);
    assertEquals(19, p1.x);
    assertEquals(35, p1.y);
    assertEquals(19, p2.x);
    assertEquals(40, p2.y);
  }
}


class Point {
  static int x;
  int y;
}
