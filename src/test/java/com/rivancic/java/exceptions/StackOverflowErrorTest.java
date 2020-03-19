package com.rivancic.java.exceptions;

import org.junit.Test;

public class StackOverflowErrorTest {

  @Test
  public void main() {
    try {
      main();
    } catch (Exception ex) {
      System.out.println("CATCH-");
    }
    System.out.println("OUT");
  }
}
