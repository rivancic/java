package com.rivancic.java.exceptions;

import org.junit.Test;

/**
 * Exception e is still type of ArithmeticException it was just cast to Exception but this still
 * means it is an instance of ArithmeticException
 */
public class ExceptionCastingTest {

  private static void div(int i, int j) {
    try {
      System.out.println(i / j);
    } catch(ArithmeticException e) {
      throw (RuntimeException)e;
    }
  }

  @Test
  public void main() {
    try {
      div(5, 0);
    } catch(ArithmeticException e) {
      System.out.println("AE");
    } catch(RuntimeException e) {
      System.out.println("RE");
    }
  }
}
