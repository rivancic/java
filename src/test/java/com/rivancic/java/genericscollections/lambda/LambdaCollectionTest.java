package com.rivancic.java.genericscollections.lambda;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

  /**
   * Map interface now contains {@link Map#merge(Object, Object, java.util.function.BiFunction)}
   * function that modifies an value of a key. It can be used for example for the word count.
   * 
   * 1. If key does not exists yet add it to the map
   * 2. If value is null replace it with the new value
   * 3. If value is not null apply BiFunction on new (first parameter) and old (second parameter) value
   */
  @Test
  public void mergeFunctionWithMap() throws Exception {
    Map<Character, Integer> charCount = new HashMap<>();
    String text =
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    
    text.chars().forEach(i -> {
      charCount.merge((char)i, 1, Integer::sum);
      
    });
    System.out.println(charCount);
    
  }
}
