package com.rivancic.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;

public class FlatMapTest {

  /**
   * {@link Stream#flatMap(java.util.function.Function)} is accepting a function that is executed on
   * every element of this stream and returning the stream of objects as a result.
   * 
   * In the test method below we want to merge a stream of multiple lists of Strings into one stream
   * of Strings. We can execute the flatMap function upon a stream of lists pass in a function that
   * converts every list into the stream. The streams will be then appended and returned as a single
   * stream.
   * 
   * This is not working with {@link Stream#map(java.util.function.Function)} function. Map function
   * in the case below is applying the passed in function upon lists in the stream, but they are not
   * used to build the result.
   */
  @Test
  public void mergeTwoLists() {
    List<String> positiveFeelings = Arrays.asList("Joy", "Interest", "Gratitude");
    List<String> negativeFeelings = Arrays.asList("Shame", "Grief", "Frustration");


    /**
     * Returns Stream of String elements.
     */
    Stream.of(positiveFeelings, negativeFeelings).flatMap(list -> list.stream())
      .forEach(feeling -> System.out.println(feeling));


    /**
     * Returns the original Stream of String lists.
     */
    Stream.of(positiveFeelings, negativeFeelings).map(list -> list.stream())
      .forEach(feeling -> System.out.println(feeling));
  }

}
