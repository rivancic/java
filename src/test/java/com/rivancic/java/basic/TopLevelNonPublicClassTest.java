package com.rivancic.java.basic;

/**
 * First of all static main method in an abstract class is totally valid.
 * And method from parent class is executed without any issues.
 */
public abstract class TopLevelNonPublicClassTest extends Parent {

  public static void main(String [] args) {
    new Parent().m();
  }
}

class Parent {
  public void m() {
    System.out.println("Parent");
  }
}