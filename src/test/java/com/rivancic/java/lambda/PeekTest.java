package com.rivancic.java.lambda;

import java.util.stream.Stream;
import org.junit.Test;

/**
 * <p>
 * Java Stream API
 * </p>
 * <p>
 * Develop code to extract data from an object using peek() and map() methods including primitive
 * versions of the map() method
 * </p>
 * 
 * {@link Stream#peek(java.util.function.Consumer)} method is intended to debug stream operations.
 * It is only method which alows to consume elements and it is only an intermediate operation (does
 * not end processing of the stream) and it is not interfering (It will not modify the content of
 * the stream).
 * 
 * https://www.javabrahman.com/java-8/java-8-how-to-peek-into-a-running-stream-peek-method-tutorial-with-examples/
 * 
 * @author Renato Ivancic <r.ivancic@dodax.com>
 *
 */
public class PeekTest {

  Stream<String> getNamesStream() {
    return Stream.of("Luca", "Simon", "David", "Marco", "Joel", "Michael", "Lukas", "Fabian",
      "Pascal",
      "Kevin", "Nicolas", "Samuel", "Jan", "Patrick", "Daniel", "Robin", "Florian");
  }

  /**
   * The result will be
   * 
   * <pre>
   * Luca
   * Simon
   * ...
   * Robin
   * Florian
   * 17
   * </pre>
   * 
   * @throws Exception
   */
  @Test
  public void peekTestWithTerminalOperator() throws Exception {

    System.out.println(getNamesStream().peek(name -> System.out.println(name)).count());
  }

  /**
   * As there is no final operator executed on the stream the peek() method will not be invoked.
   * This shows the properties of lazy evaluation in Stream API.
   * 
   * The result will be
   * 
   * <pre>
   * java.util.stream.ReferencePipeline$11@XXXXXX
   * </pre>
   * 
   * @throws Exception
   */
  @Test
  public void peekTestWithoutTerminalOperator() throws Exception {

    System.out.println(getNamesStream().peek(name -> System.out.println(name)));
  }

}
