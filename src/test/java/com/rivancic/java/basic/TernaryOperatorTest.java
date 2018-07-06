package com.rivancic.java.basic;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TernaryOperatorTest {
  @Test
  public void ternaryOperatorTest() throws Exception {
    int $ = 80000;
    String msg = ($ >= 50000) ? "Good bonus" : "Average bonus";
    System.out.println(msg);
    assertEquals("Good bonus", msg);
  }
}
