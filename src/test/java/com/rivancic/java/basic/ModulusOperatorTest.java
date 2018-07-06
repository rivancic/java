package com.rivancic.java.basic;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ModulusOperatorTest {
  @Test
  public void modulusOperatorWorksFineWithDoubleOrFloat() throws Exception {
    System.out.println(23 / 2.0);
    System.out.println(23 % 2.0);
    assertEquals(new Double(11.5), new Double(23 / 2.0));
    assertEquals(new Double(1.0), new Double(23 % 2.0));

    int a = 7;
    boolean res = a++ == 7 && ++a == 9 || a++ == 9;
    System.out.println("a = " + a);
    System.out.println("res = " + res);
  }



}
