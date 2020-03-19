package com.rivancic.java.stream;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class TerminalOperationTest {

  /**
   * Because there is no terminal operation used on stream nothing will be printed out in peek method.
   * Because streams are lazy evaluated terminal method has to be applied in order to run all the
   * intermediate functions.
   */
  @Test
    public void testStreamPeekWithout() {

    List<String> list = Arrays.asList("M", "R", "A", "P");
    list.stream().peek(System.out::print);
  }
}
