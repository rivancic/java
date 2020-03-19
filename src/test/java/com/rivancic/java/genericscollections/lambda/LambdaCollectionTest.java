package com.rivancic.java.genericscollections.lambda;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * New Java8 features that can be used on collections.
 * 
 * @author rivancic
 *
 */
public class LambdaCollectionTest {

  /**
   * With {@link Collection#removeIf(java.util.function.Predicate)} now we can filter which elements
   * have to be removed from the collection with a lambda expression implementing {@link Predicate}.
   */
  @Test
  public void removeIfTest() {
    Collection<Integer> collection =
      Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).collect(Collectors.toList());
    boolean didRemoveAnyElements = collection.removeIf(number -> number % 2 == 0);
    assertEquals(true, didRemoveAnyElements);
    assertEquals(5, collection.size());
    assertEquals(true, collection.contains(1));
    assertEquals(false, collection.contains(2));
    assertEquals(true, collection.contains(9));
    assertEquals(false, collection.contains(8));
  }

  /**
   * Looping through collection with lambda expression of Consumer type or even simpler with a
   * method reference instead of using iterators or for loops.
   */
  @Test
  public void forEachTest() {
    List<String> regions = Arrays.asList("Prlekija", "Prekmurje", "Podravska");
    regions.forEach(System.out::println);
  }
}
