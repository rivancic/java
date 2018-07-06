package com.rivancic.java.basic;

import org.junit.Test;

public class ReturnStatement {
  @Test
  public void returnNull() throws Exception {
    int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println(process(arr, 3, 8)); // Line 5
  }

  /**
   * If return type is array it can be null. But for primitive types null is not valid return type.
   * 
   * @param arr
   * @param one
   * @param two
   * @return
   */
  private static String[] process(int[] arr, int one, int two) {
    return null;
  }
}
