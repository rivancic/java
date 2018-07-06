package com.rivancic.java.basic;

import org.junit.Test;

public class BasicsTest {

  class SpecialString {
    String str;

    SpecialString(String str) {
      this.str = str;
    }
  }

  /**
   * <ol>
   * <li>It prints actual value of the string String</li>
   * <li>It prints String representing data - "Java</li>
   * <li>It prints default Ojbect#toString method [Some text @ hash value]
   * https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html#toString()</li>
   * </ol>
   */
  @Test
  public void toStringObjects() {
    System.out.println(new String("Java"));
    System.out.println(new StringBuilder("Java"));
    System.out.println(new SpecialString("Java"));
  }
}
