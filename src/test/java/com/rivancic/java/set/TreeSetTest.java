package com.rivancic.java.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;

/**
 * TreeSet implements the Set interface. It provides a tree that stores objects in ascending order.
 * It is useful for storing large volumes of data that may need to be searched through quickly.
 *
 */
public class TreeSetTest {

  /**
   * Because the underlying data structure of a TreeSet is a Red-Black tree, which is a binary
   * search tree and thus is sorted. For it to be sorted there must be a Comparator that determines
   * whether a value is equal, lower or greater than another value. The default Comparator is not
   * null-safe, if you'd however write your own Comparator that has support for null it would be no
   * problem to use null as a key.
   */
  @Test(expected = NullPointerException.class)
  public void insertNullIntoTreeSetShouldFail() {
    Set<String> set = new TreeSet<>();
    set.add(null);
  }

  /**
   * HashSet enables us to insert null values.
   */
  @Test
  public void insertNullIntoHashSetShouldFail() {
    Set<String> set = new HashSet<>();
    set.add(null);
    set.add(null);
  }
}
