package com.rivancic.java.list;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

/**
 * {@link Iterator#remove()} method is the right approach to remove elements from the List while its
 * being iterated.<br>
 * With execution of {@link List#remove(int)} method during the iteration we will throw
 * {@link ConcurrentModificationException} from iterator.
 *
 */
public class IteratorRemoval {

  @Test
  public void removeItemsUsingIterator() {
    List<String> dryFruits = new ArrayList<>();
    dryFruits.add("Walnut");
    dryFruits.add("Apricot");
    dryFruits.add("Almond");
    dryFruits.add("Date");

    Iterator<String> iterator = dryFruits.iterator();
    while (iterator.hasNext()) {
      String dryFruit = iterator.next();
      if (dryFruit.startsWith("A")) {
        iterator.remove();
        // dryFruits.remove(dryFruit); // throws ConcurrentModificationException
      }
    }
    System.out.println(dryFruits);
    assertEquals(2, dryFruits.size());
    assertEquals("Walnut", dryFruits.get(0));
    assertEquals("Date", dryFruits.get(1));
  }
}
