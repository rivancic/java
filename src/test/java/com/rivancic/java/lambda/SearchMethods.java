package com.rivancic.java.lambda;

import static org.junit.Assert.assertEquals;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * Java has numerous different methods to search for data in a stream. They are all short-circuiting
 * terminal operations.
 * 
 * <h1>Short-circuiting</h1>
 * <p>
 * Short-circuiting operations are those that produce finite results even after being given an
 * infinite stream as input. A short-circuiting operation is required to ensure the stream
 * processing terminates in finite time.
 * </p>
 * 
 * <h1>Terminal</h1>
 * <p>
 * After the terminal operation is performed, the stream pipeline is considered consumed, and can no
 * longer be used. In almost all cases, terminal operations are eager, completing their traversal of
 * the data source and processing of the pipeline before returning. These operations will trigger
 * execution of all intermediate operations.
 * </p>
 * 
 * The following ones belong to search methods:
 * 
 * With Optional result:
 * <ul>
 * <li>findFirst</li>
 * <li>findAny</li>
 * </ul>
 * 
 * With boolean result:
 * <ul>
 * <li>anyMatch</li>
 * <li>allMatch</li>
 * <li>noneMatch</li>
 * </ul>
 * 
 * @author Renato Ivancic <r.ivancic@dodax.com>
 *
 */
public class SearchMethods {

  /**
   * The {@link Stream#anyMatch(java.util.function.Predicate)} method returns a boolean value of
   * true if any elements of the stream match the predicate, and false otherwise. In the example
   * anyMatch is used to check if the stream of names includes a name beginning with P.
   */
  @Test
  public void anyMatch() {
    Stream<String> names =
      Stream.of("Luca", "Simon", "David", "Marco", "Joel", "Michael", "Lukas", "Fabian", "Pascal",
        "Kevin", "Nicolas", "Samuel", "Jan", "Patrick", "Daniel", "Robin", "Florian");
    boolean doesAnyNameStartsWithP = names.anyMatch(name -> name.startsWith("P"));
    assertEquals(true, doesAnyNameStartsWithP);
  }

  /**
   * The {@link Stream#noneMatch(java.util.function.Predicate)} method returns a boolean value based
   * on matching none of the elements of the stream to the predicate passed to it. It returns true
   * if no elements of the stream successfully match the predicate, and false if even a single
   * element does. Below example will return true because none of the names is starting with "Mir"
   * prefix.
   */
  @Test
  public void nonMatch() {
    Stream<String> names =
      Stream.of("Luca", "Simon", "David", "Marco", "Joel", "Michael", "Lukas", "Fabian", "Pascal",
        "Kevin", "Nicolas", "Samuel", "Jan", "Patrick", "Daniel", "Robin", "Florian");
    boolean noNameIsStartingWIthMir = names.noneMatch(name -> name.startsWith("Mir"));
    assertEquals(true, noNameIsStartingWIthMir);
  }
}
