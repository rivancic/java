package com.rivancic.java.genericscollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;


public class ExtendsCollectionAddTest {

  /**
   * Cant add items to the list as items in the list can be any subclass of String.
   * Compiler does not know which tipes are compatible
   */
  @Test
  public void main() {
    List<? extends String> list = new ArrayList<>(Arrays.asList("A", "E", "I", "O")); //Line 8
    //list.add("U"); //Line 9
    list.forEach(System.out::print);
  }
}