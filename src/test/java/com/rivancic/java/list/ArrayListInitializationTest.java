package com.rivancic.java.list;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ArrayListInitializationTest {

  /**
   * Capacity is explicitly set to 4. But when adding or manipulating the elements the size of the
   * List is respected. And the size is member variable that has nothing to do with the cappacity of
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
}
