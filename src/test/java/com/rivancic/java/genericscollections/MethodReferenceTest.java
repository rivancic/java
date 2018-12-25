package com.rivancic.java.genericscollections;

import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;

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
 *
 */
public class MethodReferenceTest {

  @Test
  public void sysoutMethodReferenceTest() throws Exception {
    Map<Integer, String> map = new TreeMap<>();
    map.put(3, "Script kiddie");
    map.put(2, "OCA");
    map.put(1, "OCP");
    map.entrySet().forEach(System.out::println);
    
  }
}
