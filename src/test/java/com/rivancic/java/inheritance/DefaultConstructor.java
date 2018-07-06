package com.rivancic.java.inheritance;

import org.junit.Test;

public class DefaultConstructor {
  class A {
    A() {
      this(1);
      System.out.println("M");
    }

    A(int i) {
      System.out.println("N");
    }
  }

  class B extends A {

    // when compiled class B will contain
    /*
     * public B() { super(); }
     */
  }

  /**
   * Calling new B(); will call default constructor, which will call default constructor of parent
   * class. Constructor can be default. So constructor of child has to have higher accessibility.
   * 
   * @throws Exception
   */
  @Test
  public void defaultConstructorExample() throws Exception {
    new B();
    int a = 3;
    System.out.println(a++ == 3 || --a == 3 && --a == 3);
  }

  private static void add(Double d1, Double d2) {
    System.out.println("Double version: " + (d1 + d2));
  }


}
