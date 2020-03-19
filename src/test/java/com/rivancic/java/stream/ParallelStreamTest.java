package com.rivancic.java.stream;

import java.util.stream.IntStream;
import org.junit.Test;

public class ParallelStreamTest {

  /**
   * Order of the printed numbers can not be predicted.
   * Ten numbers will be printed in the console in a random fashion.
   * Most likely as one can not say how parallelizem will be executed.
   * Substreams are created.
   */
  @Test
  public void parallelTest() {
    IntStream.rangeClosed(1, 10).parallel()
      .forEach(System.out::println);
  }
}
