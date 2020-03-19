package com.rivancic.java;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class ListReplaceAllTest {


  /**
   * Replaces each element of this list with the result of applying the operator to that element.
   * As a parameter it expects unary operator.
   *
   * The result will be [1, 3, 5, 7, 9]
   */
  @Test
    public void replaceAllTest() {
    List<Integer> list = Arrays.asList(0,2,4,6,8);
    list.replaceAll(i -> i + 1);
    System.out.println(list);
  }
}
