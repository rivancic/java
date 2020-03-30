package com.rivancic.java.genericscollections;

import com.rivancic.java.genericscollections.IterableTest.Team;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import org.junit.Test;

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
