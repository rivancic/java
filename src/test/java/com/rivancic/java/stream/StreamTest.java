package com.rivancic.java.stream;

import static org.junit.Assert.assertEquals;
import com.rivancic.java.model.Gender;
import com.rivancic.java.model.Person;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * Topics: {@link Stream}, {@link Collectors}
 * 
 * Save results to a collection using the collect method and group/partition data using the
 * Collectors class
 * 
 * A stream in Java is a sequence of information. A stream can consist of anything from bytes and
 * primitive data to objects.
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
    Set<String> set = Streams.getLanguagesStream().collect(Collectors.toSet());
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
    List<String> sortedCities =
      Streams.getCitiesStream().sorted((s1, s2) -> s2.compareTo(s1)).collect(Collectors.toList());
    assertEquals("Tokyo", sortedCities.get(0));
    assertEquals("Singapore", sortedCities.get(1));
    assertEquals("Seoul", sortedCities.get(2));
    assertEquals("Paris", sortedCities.get(3));
    assertEquals("London", sortedCities.get(4));
    assertEquals("Hong Kong", sortedCities.get(5));
  }


  /**
   * The Collectors class provides many useful functions that can help you group or partition data.
   * For example, to group users by location, you use the groupingBy method as illustrated below:
   */
  @Test
  public void groupBySexTest() throws Exception {
    Map<Gender, List<Person>> personsBySex =
      Streams.getPersons().collect(Collectors.groupingBy(person -> person.sex));
    assertEquals(2, personsBySex.size());
    assertEquals(true, personsBySex.get(Gender.MALE).contains(new Person("Luca", Gender.MALE, 16)));
  }


  /**
   * You can also calculate the total data usage for each region using a combination of the
   * groupingBy and summingInt methods as illustrated below:
   */
  @Test
  public void groupBySexAndSumAgeTest() throws Exception {
    Map<Gender, Integer> personsBySexAndSumAge = Streams.getPersons()
      .collect(Collectors.groupingBy(person -> person.sex,
        Collectors.summingInt(person -> person.age)));

    assertEquals(2, personsBySexAndSumAge.size());
    assertEquals(new Integer(72), personsBySexAndSumAge.get(Gender.MALE));
    assertEquals(new Integer(74), personsBySexAndSumAge.get(Gender.FEMALE));
  }


  /**
   * You can partition users by young and old age using the partitioningBy method, as illustrated
   * below:
   */
  @Test
  public void getYoungPersons() throws Exception {
    int youngPersonLimit = 25;

    Map<Boolean, List<Person>> youngPersons =
      Streams.getPersons()
        .collect(Collectors.partitioningBy(
          person -> person.age <= youngPersonLimit));
    assertEquals(2, youngPersons.get(true).size());
    assertEquals(new Person("Luca", Gender.MALE, 16), youngPersons.get(true).get(0));
  }
}
