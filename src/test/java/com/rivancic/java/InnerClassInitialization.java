package com.rivancic.java;


/**
 * To instantiate new inner class one needs instance of outer class.
 */
public class InnerClassInitialization {
  class A {
    void m() {
      System.out.println("INNER");
    }
  }

  public static void main(String [] args) {
   InnerClassInitialization.A a1 = new InnerClassInitialization().new A();
   // A a1 = new InnerClassInitialization().new A();

   a1.m();
  }
}