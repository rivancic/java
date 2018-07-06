package com.rivancic.java.basic;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ForLoopTest {

  /**
   * In the enhanced for loop its not meant to then get elements by index from array because the i
   * variable in the loop is actually that element.
   * 
   * Program will throw {@link ArrayIndexOutOfBoundsException} because first element is 3, array
   * length is 3 and max index is therefore 2.
   * 
   * @throws Exception
   */
  @Test
  public void forLoop() throws Exception {
    int[] arr = {3, 2, 1};
    for (int i : arr) {
      System.out.println(arr[i]);
    }
  }

  /**
   * for: is not valid statement. Also after break there is only a semicolon and no other keyword.
   * 
   * @throws Exception
   */
  @Test
  public void strangeForLoop() throws Exception {
    // for:
    for (int i = 2; i <= 100; i = i + 2) {
      for (int j = 1; j <= 10; j++) {
        System.out.print(i * j + "\t");
      }
      System.out.println();
      if (i == 10) {
        // break for;
      }
    }
  }

  /**
   * i will be tree, for loop still executes when i is 2, and the last expression in for loop will
   * increment 2. The variable i will then hold value 3.
   * 
   * @throws Exception
   */
  @Test
  public void forLoopIncrement() throws Exception {
    int i;
    for (i = 0; i <= 2; i++) {
    }
    System.out.println(i);
    assertEquals(3, i);
  }
}
