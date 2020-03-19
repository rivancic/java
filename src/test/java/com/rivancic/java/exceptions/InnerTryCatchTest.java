package com.rivancic.java.exceptions;

import java.util.Optional;
import org.junit.Test;

public class InnerTryCatchTest {

  @Test
  public void test() {
    try {
      try {
        System.out.println(1 / 0);
      } catch (ArithmeticException e) {
        System.out.println("Inner");
        throw e;
      } finally {
        System.out.println("Finally 1");
      }
    } catch (ArithmeticException e) {
      System.out.println("Outer");

      Optional<Integer> optional = Optional.of(null); //Line 8
      System.out.println(optional.orElse(-1)); //Line 9
    }
  }
}
