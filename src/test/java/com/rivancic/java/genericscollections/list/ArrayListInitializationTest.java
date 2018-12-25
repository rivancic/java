package com.rivancic.java.genericscollections.list;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ArrayListInitializationTest {

  /**
   * Capacity is explicitly set to 4. But when adding or manipulating the elements the size of the
   * List is respected. And the size is member variable that has nothing to do with the capacity of
   * the internal array.
   * 
   * In case below the runtime exception {@link IndexOutOfBoundsException} will be thrown at line
   * where element is added to second position.
   * 
   * @throws Exception
   */
  @Test
  public void capacityConstructor() throws Exception {
    List<String> list = new ArrayList<>(4);
    list.add(0, "Array");
    list.add(2, "List"); // here the runtime exception will be thrown
    System.out.println(list);
  }

  /**
   * Nested List doesn't need to be declared as a concrete type. The actual List object that will be
   * inserted has to be of a specific concrete type.
   */
  public void initializeNestedArrayList() {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
  }
}
