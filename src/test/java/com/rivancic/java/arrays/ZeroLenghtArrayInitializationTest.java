package com.rivancic.java.arrays;

import org.junit.Test;

public class ZeroLenghtArrayInitializationTest {

  /**
   * Array is initialized with array declaration, and length is 0. It means it will not contain any
   * object. When trying to access the first object it will throw IOOBE.
   * 
   * @throws Exception
   */
  @Test(expected = IndexOutOfBoundsException.class)
  public void zeroLenghtArrayInitializationTest() throws Exception {
    byte[] arr = new byte[0];
    System.out.println(arr[0]);
  }


  /**
   * Array is initialized with array literal, it holds the same as for the array declaration.
   * 
   * @throws Exception
   */
  @Test(expected = IndexOutOfBoundsException.class)
  public void zeroLenghtArrayInitializationWithArrayLiteralTest() throws Exception {
    byte[] arr = {};
    System.out.println(arr[0]);
  }
}
