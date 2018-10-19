package com.rivancic.java.lambda;

import static org.junit.Assert.assertEquals;
import java.util.Optional;
import java.util.function.Predicate;
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

  Stream<String> getNamesStream() {
    return Stream.of("Luca", "Simon", "David", "Marco", "Joel", "Michael", "Lukas", "Fabian",
      "Pascal",
      "Kevin", "Nicolas", "Samuel", "Jan", "Patrick", "Daniel", "Robin", "Florian");
  }

  /**
   * The {@link Stream#findFirst()} method returns an {@link Optional} object that holds the first
   * element of the stream. If the stream is empty, empty Optional is returned. If the stream is not
   * ordered any element can be returned.
   */
  @Test
  public void findFirst() {

    Optional<String> firstElement = getNamesStream().findFirst();
    assertEquals(true, firstElement.isPresent());
    assertEquals(true, firstElement.get().length() > 0);
  }

  /**
   * The {@link Stream#findAny()} returns random element wrapped in an optional. If the sream is
   * empty the optional will be empty.
   */
  @Test
  public void findAny() {

    Optional<String> firstElement = getNamesStream().findAny();
    assertEquals(true, firstElement.isPresent());
    assertEquals(true, firstElement.get().length() > 0);
  }

  @Test
  public void findAnyOnEmptyStream() {

    Optional<String> firstElement = Stream.<String>empty().findAny();
    assertEquals(false, firstElement.isPresent());
  }

  /**
   * The {@link Stream#anyMatch(java.util.function.Predicate)} method returns a boolean value of
   * true if any elements of the stream match the predicate, and false otherwise. In the example
   * anyMatch is used to check if the stream of names includes a name beginning with P.
   */
  @Test
  public void anyMatch() {
    boolean doesAnyNameStartsWithP = getNamesStream().anyMatch(name -> name.startsWith("P"));
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
    boolean noNameIsStartingWIthMir = getNamesStream().noneMatch(name -> name.startsWith("Mir"));
    assertEquals(true, noNameIsStartingWIthMir);
  }

  /**
   * The {@link Stream#allMatch(java.util.function.Predicate)} method returns a boolean value if the
   * {@link Predicate} matches for all elements in the stream.
   */
  @Test
  public void allMatch() {
    boolean allNamesLongerThan5Characters = getNamesStream().allMatch(name -> name.length() > 4);
    assertEquals(false, allNamesLongerThan5Characters);
  }
}
