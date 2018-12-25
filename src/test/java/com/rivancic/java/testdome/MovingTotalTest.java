package com.rivancic.java.testdome;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MovingTotalTest {

  private int[] movingTotal = new int[1000];
  int size = 0;

  /**
   * Adds/appends list of integers at the end of internal list.
   */
  public void append(int[] list) {
    for (int i = 0; i < list.length; i++) {
      movingTotal[size] = list[i];
      size += 1;
    }
  }

  /**
   * Returns boolean representing if any three consecutive integers in the internal list have given
   * total.
   */
  public boolean contains(int total) {
    for (int i = 2; i <= size; i++) {
      if ((movingTotal[i] + movingTotal[i - 1] + movingTotal[i - 2]) == total) {
        return true;
      }
    }
    return false;
  }

  /*  *//**
         * Adds/appends list of integers at the end of internal list.
         */

  /*
   * public void append(int[] list) { int[] concatenatedArray = Arrays.copyOf(movingTotal,
   * movingTotal.length + list.length); System.arraycopy(list, 0, concatenatedArray,
   * movingTotal.length, list.length); movingTotal = concatenatedArray; }
   * 
   *//**
     * Returns boolean representing if any three consecutive integers in the internal list have
     * given total.
     *//*
       * public boolean contains(int total) { for (int i = 2; i < movingTotal.length; i++) { if
       * ((movingTotal[i] + movingTotal[i - 1] + movingTotal[i - 2]) == total) { return true; } }
       * return false; }
       */

  public static void main(String[] args) {
    MovingTotalTest movingTotal = new MovingTotalTest();

    movingTotal.append(new int[] {1, 2, 3});

    System.out.println(movingTotal.contains(6));
    System.out.println(movingTotal.contains(9));

    movingTotal.append(new int[] {4});

    System.out.println(movingTotal.contains(9));
  }


  @Test
  public void testName() throws Exception {
    MovingTotalTest movingTotal = new MovingTotalTest();
    movingTotal.append(new int[] {1, 2, 3});
    assertTrue(movingTotal.contains(6));
    assertFalse(movingTotal.contains(9));
    movingTotal.append(new int[] {4});
    assertTrue(movingTotal.contains(9));
  }
}
