package com.rivancic.java.genericscollections;

import static org.junit.Assert.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;
import org.junit.Test;
import com.rivancic.java.stream.Streams;

/**
 * Method references can be used to avoid redundancy in the lambda definitions. There are four
 * formats of method references
 * <ul>
 * <li>Static methods</li>
 * <li>Instance methods on a particular instance</li>
 * <li>Instance methods that will be defined at a runtime</li>
 * <li>Constructors</li>
 * </ul>
 * 
 * A constructor reference is a special type of reference that uses new instead of the method name
 * and it creates a new object.
 * 
 * In below example one method reference is used as a {@link Consumer} in the terminal
 * {@link Stream#forEach(java.util.function.Consumer)} method.
 *
 */
public class MethodReferenceTest {

  @Test
  public void sysoutMethodReferenceTest() throws Exception {
    Map<Integer, String> map = new TreeMap<>();
    map.put(3, "Script kiddie");
    map.put(2, "OCA");
    map.put(1, "OCP");
    map.put(4, "");
    map.entrySet().forEach(System.out::println);
  }

  /**
   * Method reference is used as a {@link Predicate} in the intermediate
   * {@link Stream#filter(java.util.function.Predicate)} method.
   */
  @Test
  public void filterAsMethodReference() {
    
    Streams.getNamesStream().filter(String::isEmpty).forEach(System.out::println);
    
    // No additional operators can be used upon the method reference when used directly as a parameter.
    // The following statement wont compile
    //Streams.getNamesStream().filter(!String::isEmpty).forEach(System.out::println);
  }
}
