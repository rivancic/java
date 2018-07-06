package com.rivancic.java.lambda;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * Topics: {@link Stream}, {@link Collectors}
 * 
 * @author Renato Ivancic <r.ivancic@dodax.com>
 *
 */
public class StreamTest {

  /**
   * Factory method {@link Stream#of(Object)} creates the Stream of Generic type with provided args
   * values.
   * 
   * Next aggregation function collect is used and as Collector Set accumulator is used. The result
   * is unordered. Because values like "java" and "python" gets duplicated they will be present in
   * the set only once.
   * 
   * The result will contain only following items in any order. "java", "python", "c", "c++". And
   * the size will be 4 instead of 6 that is the size of the original stream.
   * 
   * @throws Exception
   */
  @Test
  public void streamToSetTest() throws Exception {
    Stream<String> stream = Stream.of("java", "python", "c",
      "c++", "java", "python");
    Set<String> set = stream.collect(Collectors.toSet());
    System.out.println(set.size());
    assertEquals(4, set.size());
    assertEquals(true, set.contains("python"));
    assertEquals(true, set.contains("java"));
    assertEquals(true, set.contains("c"));
    assertEquals(true, set.contains("c++"));
  }

  /**
   * It will print cities in reverse alphabetical order. Result: Tokyo, Singapore, Seoul, Paris,
   * London, Hong Kong
   * 
   * 
   * 1. Array of cities is created from the array literal. 2. Stream is created out of the array
   * instance. Then in chained method it gets sorted. As comparator interface, lambda expression is
   * passed in as a parameter. Pay attention as the parameters in the comparator are then switched
   * in comparison itself. This causes the element to be sorted descending.
   * 
   * @throws Exception
   */
  @Test
  public void streamSorting() throws Exception {
    String[] cities = {"Seoul", "Tokyo", "Paris", "London",
        "Hong Kong", "Singapore"};
    List<String> sortedCities =
      Arrays.stream(cities).sorted((s1, s2) -> s2.compareTo(s1)).collect(Collectors.toList());
    assertEquals("Tokyo", sortedCities.get(0));
    assertEquals("Singapore", sortedCities.get(1));
    assertEquals("Seoul", sortedCities.get(2));
    assertEquals("Paris", sortedCities.get(3));
    assertEquals("London", sortedCities.get(4));
    assertEquals("Hong Kong", sortedCities.get(5));
  }
}
