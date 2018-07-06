package com.rivancic.java.basic;

import org.junit.Test;

public class TryCatch {

  private static void m1() throws Exception {
    throw new Exception();
  }

  /**
   * A is printed to the console, but because the exception was not caught the program ends with
   * Error.
   * 
   * @throws Exception
   */
  @org.junit.Test
  public void tryCatch() throws Exception {
    try {
      m1();
    } finally {
      System.out.println("A");
    }
  }

  private static void m2() {
    System.out.println(1 / 0);
  }

  @Test
  public void handleZeroDivision() throws Exception {
    try {
      m2();
    } finally {
      System.out.println("A");
    }
  }
}
