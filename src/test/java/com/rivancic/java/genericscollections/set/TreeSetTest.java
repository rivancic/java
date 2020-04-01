package com.rivancic.java.genericscollections.set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
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
   * The elements in the TreeSet have to have compatible comparators. First element in the TreeSet
   * is String, as it is first value it will be successfully stored in the TreeSet collection. The
   * next element is boxed 3. Numeric value doesn't have a compatible comparator, for this reason
   * runtime exception will be thrown.
   */
  @Test(expected = ClassCastException.class)
  public void testNonGenericTreeSet() {
    Set set = new TreeSet();
    set.add("2");
    set.add(3); // To which type it will be autoboxed? Te expected type is Object input is int.
    set.add("1");
    Iterator it = set.iterator();
    while (it.hasNext())
      System.out.print(it.next() + " ");
  }

  /**
   * As {@link TreeSet} implements {@link NavigableSet} it contains all the methods form the
   * interface. {@link NavigableSet#ceiling(Object)} will return next element after the one passed
   * in as an argument. String natural sorting starts with Capital letters following by lowercase
   * letters.
   * 
   * 
   */
  @Test
  public void stringSortingTreeSet() {

    TreeSet<String> treeSet = new TreeSet<String>();
    treeSet.add("element");
    treeSet.add("ELEMENT");
    treeSet.add("123");
    treeSet.add("Element");

    /**
     * They are sorted in following order
     *
     * 123
     * ELEMENT
     * Element
     * element
     */

    // Lover - sorted lower
    String lowerElement = treeSet.lower("Element");
    assertEquals("ELEMENT", lowerElement);

    // Floor - sorted lower or equal
    String lowerOrTheSameElement = treeSet.floor("Element");
    assertEquals("Element", lowerOrTheSameElement);

    // Higher - sorted higher
    String higherElement = treeSet.higher("Element");
    assertEquals("element", higherElement);

    // Ceiling - sorted higher or equal
    String higherOrTheSameElement = treeSet.ceiling("Elem");
    assertEquals("Element", higherOrTheSameElement);

    assertEquals(4, treeSet.size());
    assertEquals("123", treeSet.pollFirst());
    assertEquals("ELEMENT", treeSet.pollFirst());
    assertEquals("Element", treeSet.pollFirst());
    assertEquals("element", treeSet.pollFirst());
  }

  /**
   * TreeSet requires that the elements implement {@link Comparable} interfaces if no
   * {@link Comparator} is provided. Otherwise the code will throw an {@link ClassCastException}
   */
  @Test(expected=ClassCastException.class)
  public void treeSetComparator() throws ClassCastException {
    Set<Dance> dances = new TreeSet<>();
    dances.add(new Dance("swing"));
    dances.add(new Dance("Charleston"));
    dances.add(new Dance("swing"));
    System.out.println(dances.iterator().next());
  }
  
  @Test
  public void treeSetWithProvidedComparator() {
    Set<Integer> treeSet = new TreeSet<>(Comparator.reverseOrder());
    treeSet.add(4);
    treeSet.add(2);
    treeSet.add(1);
    treeSet.add(8);
    assertThat(treeSet, contains(8,4,2,1));
    
  }
}
