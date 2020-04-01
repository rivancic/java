package com.rivancic.java.genericscollections.iteration;

import java.util.Iterator;
import java.util.LinkedList;
import org.junit.Test;

/**
 * Two most important methods of {@link Iterator} interface are
 *
 * boolean hasNext()
 *
 * and
 *
 * T next()
 */
public class IteratorTest {

  @Test
  public void iterationTest() {

    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.add("One");
    linkedList.add("Two");

    // As linked list is a collection it can provide an Iterator
    Iterator<String> iterator = linkedList.iterator();
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    // One can get multiple iterators form a collection without violation like for example
    // Streams
    Iterator<String> iterator2 = linkedList.iterator();
    while(iterator2.hasNext()) {
      System.out.println(iterator2.next());
    }
  }
}
