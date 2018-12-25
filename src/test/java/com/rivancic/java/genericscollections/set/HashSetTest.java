package com.rivancic.java.genericscollections.set;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.Test;

/**
 * {@link HashSet} stores its elements in a hash table. It uses {@link Object#hashCode()} method to
 * retrieve them more efficiently. Adding and checking if elements are in the set takes constant
 * time. The down-side is that the order in which the elements are stored is lost. As most of the
 * times we are not concerned in which order items are saved in the {@link Set} collections its the
 * reason {@link HashSet} is the most used implementation.
 * 
 * @author rivancic
 *
 */
public class HashSetTest {

  /**
   * {@link HashSet} enables us to insert null values.
   */
  @Test
  public void insertNullIntoHashSetShouldFail() {
    Set<String> set = new HashSet<>();
    set.add(null);
    set.add(null);
    
    // hamcrest matcher can not check directly for the null value.
    // IsNull mathcer has to be used.
    assertThat(set, contains(nullValue()));
  }

  /**
   * HashSet stores only unique values so that the program will print
   * <ul>
   * <li>10</li>
   * <li>null</li>
   * <li>11</li>
   * <li>501</li>
   * </ul>
   * 
   * Number ten will be discarded when it will be added for the second time.
   * The order in which the elements will be printed can not be known in advance.
   * 
   * If {@link Set#add(Object)} successfully adds an item it returns true otherwise false.
   */
  @Test
  public void hashSetInsertions() {
    
    Set<Number> numbers = new HashSet<>();
    
    boolean add1 =  numbers.add(new Integer(10));
    boolean add2 =  numbers.add(null);
    boolean add3 =  numbers.add(11);
    boolean add4 =  numbers.add(501L);
    
    // The duplicate will not be inserted into the set.
    boolean add5 =  numbers.add(new Integer(10));
    
    assertEquals(true, add1);
    assertEquals(true, add2);
    assertEquals(true, add3);
    assertEquals(true, add4);
    assertEquals(false, add5);
    
    
    // hamcrest containsInAnyOrder matcher for testing the values in the set
    assertThat(numbers, containsInAnyOrder(10,null,11,501L));
    
    // Printing contained items in the set
    Iterator iterator = numbers.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
