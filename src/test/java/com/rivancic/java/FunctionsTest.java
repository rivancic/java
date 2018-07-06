package com.rivancic.java;

import org.junit.Test;

public class FunctionsTest {

  @Test
  public void primaryValueParameter() {
    int x = 1;
    while (checkAndIncrement(x)) {
      System.out.println(x);
    }
  }

  private static boolean checkAndIncrement(int x) {
    if (x < 5) {
      x++;
      return true;
    } else {
      return false;
    }
  }
}
