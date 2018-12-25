package com.rivancic.java.stream;

import java.util.stream.Stream;
import org.junit.Test;

public class StreamFactoryTest {

  /**
   * Create stream with the help of {@link Stream#iterate(Object, java.util.function.UnaryOperator)}
   * method and limit it to 3 elements. With map the values are modified and printed out with the terminal operator {@link Stream#forEach(java.util.function.Consumer)}.
   * 
   * Remember, terminal operation has to be called on the stream otherwise the stream will not be generated.
   */
  @Test
  public void streamIterateTest() {
    Stream<String> stream = Stream.iterate("", (s) -> s + "1");
    stream.limit(3).map(x -> x + "2").forEach(val -> System.out.println(val));
  }
}
