package com.rivancic.java.stream;

import java.util.stream.IntStream;
import org.junit.Test;

public class IntStreamRangeTest {

  /**
   * If starting index is larger than ending index then the generated stream will be empty.
   *
   * Note that the long count() is terminal method in IntStream.
   */
  @Test
    public void rangeTest() {
     System.out.println(IntStream.range(10,1).count());
  }
}
