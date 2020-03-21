package com.rivancic.java.basic;

import org.junit.Test;

class Outer {

  public void print(int x) {
    class Inner {

      public void getX() {
          // System.out.println(++x); // Would throw compilation exception because variable is not final
      }
    }
    Inner inner = new Inner();
    inner.getX();
  }
}

public class InnerLocalClassTest {

  @Test
  public void test() {
    new Outer().print(100);
  }
}
