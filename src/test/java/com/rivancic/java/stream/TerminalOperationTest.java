package com.rivancic.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
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

  /**
   * Terminal operation on a stream can be executed only once. When terminal operation is executed
   * for the second time {@link IllegalStateException} will be thrown
   */
  @Test(expected = IllegalStateException.class)
  public void terminalOperationTwice() {

    Stream<String> stream = Stream.of("M", "R", "A", "P");
    stream.forEach(System.out::println);

    // At this point stream is marked as consumed and no other terminal operation can be executed.
    stream.forEach(System.out::println);
  }
}
