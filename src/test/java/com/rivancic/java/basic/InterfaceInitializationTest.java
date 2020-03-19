package com.rivancic.java.basic;

import org.junit.Test;

interface Sellable {
  double getPrice();
}

public class InterfaceInitializationTest {

    private static void printPrice(Sellable sellable) {
      System.out.println(sellable.getPrice());
    }

  /**
   * There are no
   */
  @Test(expected = NullPointerException.class)
    public void testInitialization() {
      printPrice(null);
    }
}
