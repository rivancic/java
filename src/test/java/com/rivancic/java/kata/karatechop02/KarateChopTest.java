package com.rivancic.java.kata.karatechop02;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class KarateChopTest {

  private int chop(int numberX, int[] arrayToSearch) {

    // End if array is empty
    if(arrayToSearch.length==0){
      return -1;
    }

    int lowerIndex = 0;
    int upperIndex = arrayToSearch.length-1;

    // Search until we have only one element
    while (upperIndex- lowerIndex > 1) {
      int middle = (upperIndex- lowerIndex) / 2 + lowerIndex;
      int middleValue = arrayToSearch[middle];

      if(middleValue == numberX) {
        // Found exact value
        return middle;
      } else if (numberX < middleValue) {

        // Search lover
        upperIndex = middle;
      } else {

        // Search upper
        lowerIndex= middle;
      }
    }
    if(arrayToSearch[lowerIndex]== numberX) {
      return lowerIndex;
    } else  if (arrayToSearch[upperIndex] == numberX){
      return upperIndex;
    } else {
      return -1;
    }
  }

  @Test
  public void test() {
    assertEquals(-1, chop(3, new int[]{}));
    assertEquals(-1, chop(3, new int[]{1}));
    assertEquals(0, chop(1, new int[]{1}));
    //
    assertEquals(0, chop(1, new int[]{1, 3, 5}));
    assertEquals(1, chop(3, new int[]{1, 3, 5}));
    assertEquals(2, chop(5, new int[]{1, 3, 5}));
    assertEquals(-1, chop(0, new int[]{1, 3, 5}));
    assertEquals(-1, chop(2, new int[]{1, 3, 5}));
    assertEquals(-1, chop(4, new int[]{1, 3, 5}));
    assertEquals(-1, chop(6, new int[]{1, 3, 5}));
    //
    assertEquals(0, chop(1, new int[]{1, 3, 5, 7}));
    assertEquals(1, chop(3, new int[]{1, 3, 5, 7}));
    assertEquals(2, chop(5, new int[]{1, 3, 5, 7}));
    assertEquals(3, chop(7, new int[]{1, 3, 5, 7}));
    assertEquals(-1, chop(0, new int[]{1, 3, 5, 7}));
    assertEquals(-1, chop(2, new int[]{1, 3, 5, 7}));
    assertEquals(-1, chop(4, new int[]{1, 3, 5, 7}));
    assertEquals(-1, chop(6, new int[]{1, 3, 5, 7}));
    assertEquals(-1, chop(8, new int[]{1, 3, 5, 7}));
  }
}
