package com.rivancic.java;

import org.junit.Test;

public class OneTest {

  @Test
  public void testName() throws Exception {
    StringBuilder sb = new StringBuilder("Java");
    String s1 = sb.toString();
    String s2 = "Java";

    System.out.println(s1 == s2);
  }
}
