package com.rivancic.java.genericscollections;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;

/**
 * Contains method common to all collection implementations.
 * For example {@link Collection#add(Object)}, {@link Collection#remove(Object)};
 * 
 * @author rivancic
 *
 */
public class CollectionsTest {
  @Test
  public void basicMethods() throws Exception {
    Collection<String> collection = new ArrayList<>();
    boolean added = collection.add("test");
    boolean removed = collection.remove("test");
    
    assertEquals(true, added);
    assertEquals(true, removed);
    System.out.println(collection);
  }
}
