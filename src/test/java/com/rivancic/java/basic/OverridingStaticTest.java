package com.rivancic.java.basic;

import org.junit.Test;

public class OverridingStaticTest {

  interface Printer1 {
    default void print() {
      System.out.println("Printer1");
    }
  }

  interface Printer2 {
    public static void print() {
      System.out.println("Printer2");
    }
  }



  class Printer implements Printer1, Printer2 {

  }

  /**
   * The result will be Printer1 as the instance method will be invoked.
   * If we would like to invoke static method it has to be invoked on a specific interface class.
   * like Printer2.print().
   */
  @Test
  public void test() {

    // given
    Printer printer = new Printer();

    // when
    printer.print();

    // then

  }
}

