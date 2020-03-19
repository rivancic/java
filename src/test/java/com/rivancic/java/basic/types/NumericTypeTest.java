package com.rivancic.java.basic.types;

import static org.junit.Assert.*;
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
  
  /**
   * Primitive int to double, long to double are implicitly convertible.
   * 
   * But Wrapper classes can not be implicitly convertible. You can not implicitly cast int -> Double or long -> Double;
   * Or Integer -> Double.
   * @throws Exception
   */
  @Test
  public void testNumericConversion() throws Exception {
    
    
    long longValue = 1;
    int intValue = 1;
    double doubleValue = longValue;
    doubleValue = intValue;
    
    Double doubleWrapper;
    
    // Throws compilation error, type mismatch
    // doubleWrapper = intValue;
    
    // Throws compilation error, Integer can't be implicitly converted to Double.
    Integer integer = 1;
    //doubleWrapper = integer;
    
    
  }
}
