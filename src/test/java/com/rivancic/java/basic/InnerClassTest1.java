package com.rivancic.java.basic;

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

public class InnerClassTest1 {


  public static void main(String[] args) {
    new Outer().print(100);
  }
}
