package com.rivancic.java.string;

import org.junit.Test;

public class StringBuilderTest {


  @Test
  public void stringBuilderWithString() {
    String str = "java";
    StringBuilder sb = new StringBuilder("java");

    System.out.println(str.equals(sb) + ":" + sb.equals(str));
  }


  /**
   * The = = operator compares references not values of Stirng type.
   * 
   * @throws Exception
   */
  @Test
  public void stringTypeOperatorComparison() throws Exception {
    StringBuilder sb = new StringBuilder("Java");
    String s1 = sb.toString();
    String s2 = sb.toString();
    System.out.println(s1 == s2);
  }
}
