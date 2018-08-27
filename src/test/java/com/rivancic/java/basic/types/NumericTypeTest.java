package com.rivancic.java.basic.types;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NumericTypeTest {

  /**
   * When the narrowing primitive conversion occurec the decimal places are truncated.
   * 
   * @throws Exception
   */
  @Test
  public void doubleToInteConversion() throws Exception {
    Double doubleVariable = 2.7;
    System.out.println(doubleVariable.intValue());
    assertEquals(2, doubleVariable.intValue());
  }
}
