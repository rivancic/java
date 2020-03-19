package com.rivancic.java.basic;

import org.junit.Test;

public class ShadowedVariableTest {

  /**
   * variable var in class Q in shadowing the one defined in class P. In order to access the
   * variable var of P one as to reference the outer instance of the class with P.this first.
   */
  class P {
    private int var = 100;
    class Q {
      String var = "Java";
      void print() {
        System.out.println("Q.var: " + var);
        System.out.println("Q.var: " + Q.this.var);
        System.out.println("P.var: " + P.this.var);
      }
    }
  }

  @Test
  public void shadowedVariableTest() {
    new P().new Q().print();
  }

}
