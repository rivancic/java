package com.rivancic.java.genericscollections;

import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Comparator is implemented in java.util class.
 */
public class SortAndSearchTest {

  /**
   * If null comparator is passed as an argument Comparable implementation from the array type will be used. 
   * Inspect the code of {@link Arrays#sort(Object[], java.util.Comparator)}
   */
  @Test
  public void arraySertWithNullComparator() {
    Integer[] simpleArray = {2,3,1};
    Arrays.sort(simpleArray, null);
    assertEquals(new Integer(1), simpleArray[0]);
    assertEquals(new Integer(2), simpleArray[1]);
    assertEquals(new Integer(3), simpleArray[2]);
  }
  
  Comparator<Integer> integerComparator = (first, second) -> first - second;
  
  @Test
  public void arraysSortTest() throws Exception {
    Integer[] simpleArray = {2,3,1};
    Arrays.sort(simpleArray, integerComparator);
    assertThat(simpleArray, arrayContaining(1,2,3));
  }
  
  @Test
  public void binarySearchTest() throws Exception {
    Integer[] ascendingArray = {2,3,1,10,9,3,21,19,13,23};
    Arrays.sort(ascendingArray, integerComparator);
    int place = Arrays.binarySearch(ascendingArray, 21);
    int foundElement = ascendingArray[place];
    System.out.println(place);
    assertEquals(21, foundElement);
    Arrays.sort(ascendingArray, null);
    assertEquals(new Integer(1), ascendingArray[0]);
    assertEquals(new Integer(2), ascendingArray[1]);
    assertEquals(new Integer(3), ascendingArray[2]);
  }
}
