package com.rivancic.java.lambda;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Check which functional interface definition is correct for the following code in test method.
 * 
 * @author Renato Ivancic <r.ivancic@dodax.com>
 *
 */
public class FunctionalInterfaceTest {

  /**
   * Works. It is only complaining that the generic type should be defined for the o1 variable.
   */
  interface Operation1<T extends Integer> {
    T operate(T x, T y);
  }

  /**
   * Does not work as parameters will be expected be te type of object. And plus operator is not
   * defined upon the object type.
   */
  interface Operation2<T> {
    T operate(T x, T y);
  }

  /**
   * Works.
   */
  interface Operation3 {
    int operate(int x, int y);
  }

  /**
   * Works.
   */
  interface Operation4 {
    long operate(long x, long y);
  }

  @Test
  public void functionalInterfaceDefinitionTest() throws Exception {
    Operation1 o1 = (x, y) -> x + y;
    assertEquals(15, (int) o1.operate(5, 10));
  }

  interface Flyable {
    void fly();
  }
}
