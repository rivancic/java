package com.rivancic.java.basic;

import org.junit.Test;

public class FinalVariableTest {
  /**
   * One can initialize local final variable after it has been declared. What we have to be aware of
   * is that this variable can not be reassigned.
   * 
   * @throws Exception
   */
  @Test
  public void finalVariableTest() throws Exception {
    final boolean flag;
    flag = false;
    while (flag) {
      System.out.println("Good Morning!");
    }
  }
}
