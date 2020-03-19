package com.rivancic.java.stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

public class StreamFactoryTest {

  /**
   * Create stream with the help of {@link Stream#iterate(Object, java.util.function.UnaryOperator)}
   * method and limit it to 3 elements. With map the values are modified and printed out with the
   * terminal operator {@link Stream#forEach(java.util.function.Consumer)}.
   * 
   * Remember, terminal operation has to be called on the stream otherwise the stream will not be
   * generated.
   */
  @Test
  public void streamIterateTest() {
    Stream<String> stream = Stream.iterate("", (s) -> s + "1");
    stream.limit(3).map(x -> x + "2").forEach(val -> System.out.println(val));
  }

  /**
   * User {@link Stream#of(Object)} method to create a stream of Lists<>. The generic type is
   * interfered form the objects passed in the of function.
   * 
   * The result Stream will be of type  Stream<List<? extends Number>>.
   */
  @Test
  public void generateStreamOfNumberLists() {
    Stream listStream = Stream.of(Arrays.asList(1), Arrays.asList(Double.valueOf(3)));
  }
  
  
  /**
   * User {@link Stream#of(Object)} method to create a stream of Lists<>. The generic type is
   * interfered form the objects passed in the of function.
   * 
   * The result Stream will be of type  Stream<List<Serializable>>.
   */
  @Test
  public void generateStreamOfSerializableLists() {
    Stream listStream = Stream.of(Arrays.asList("AAA"), Arrays.asList(Double.valueOf(3)));
  }
}
