package com.rivancic.java.string;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringEqualityTest {

  /**
   * Test will evaluate false as {@link String#equals(Object)} method is case sensitive. If you want
   * to compare methods ignoring casing, use {@link String#equalsIgnoreCase(String)}. And yes in
   * both cases its comparing characters that Strings contains it is not just type or reference
   * comparison.
   * 
   * @throws Exception
   */
  @Test
  public void testingSeringEqualsMethod() throws Exception {
    String s1 = "OcA";
    String s2 = "oCa";
    assertEquals(false, s1.equals(s2));
  }
}
