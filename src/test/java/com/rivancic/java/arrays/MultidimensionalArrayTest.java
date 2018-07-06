package com.rivancic.java.arrays;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class MultidimensionalArrayTest {


  /**
   * The double for loop is standard way of printing 2D arrays. It is a correct way to print out all
   * elements. But the break statement is a bit tricky there. When second element of the first group
   * is accessed, that is "2", the program will exit inner for loop and continue to print out
   * elements from next group in first dimension, 4, 5.
   * 
   * @throws Exception
   */
  @Test
  public void multidimensionalArrayTest() throws Exception {
    String[][] arr = {{"1", "2", "3"}, {"4", "5"}, {"6", "7"}};
    List<String> printedElements = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        String arrayElement = arr[i][j];
        System.out.print(arrayElement + " ");
        printedElements.add(arrayElement);
        if (arrayElement.equals("2")) {
          break;
        }
      }
    }
    assertEquals("1", printedElements.get(0));
    assertEquals("2", printedElements.get(1));
    assertEquals("4", printedElements.get(2));
    assertEquals("5", printedElements.get(3));
    assertEquals("6", printedElements.get(4));
    assertEquals("7", printedElements.get(5));
  }
}
