package com.rivancic.java.basic.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.math.BigDecimal;
import org.junit.Test;

/**
 * They say use BigDecimal type to represent exact numbers when the variable type should represent
 * price, money.. The important fact is that if we pass in the constructor double value, the number
 * representation of BigDecimal will be the exact double representation. As we see in the test
 * below. Even if BigDecimal is created from 0.1 double value it will represent it as actual double
 * value. If we want to use exact decimal numbers we have to pass them into BigDecimal constructor
 * as Strings.
 * 
 * @author Renato Ivancic <r.ivancic@dodax.com>
 *
 */
public class BigDecimalTest {
  @Test
  public void testDecimalDoubleConstructor() throws Exception {
    BigDecimal approximateDecimal = new BigDecimal(0.1);
    assertNotEquals("0.1", approximateDecimal.toString());

    BigDecimal exactDecimal = new BigDecimal("0.1");
    assertEquals("0.1", exactDecimal.toString());
  }
}
